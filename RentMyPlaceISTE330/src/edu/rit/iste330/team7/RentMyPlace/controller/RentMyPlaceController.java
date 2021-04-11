package edu.rit.iste330.team7.RentMyPlace.controller;

import edu.rit.iste330.team7.RentMyPlace.model.Location;
import edu.rit.iste330.team7.RentMyPlace.model.Property;
import edu.rit.iste330.team7.RentMyPlace.model.User;
import edu.rit.iste330.team7.RentMyPlace.view.GUI;
import edu.rit.iste330.team7.RentMyPlace.model.Model;
import edu.rit.iste330.team7.RentMyPlace.view.LoginGUI;
import edu.rit.iste330.team7.RentMyPlace.view.RegisterGUI;

import java.awt.event.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Map;

public class RentMyPlaceController {
    User currentUser = null;
    int currentIndex = 0;
    ArrayList<Property> properties = null;
    LoginGUI gui;
    Model model;
    GUI mainGui = new GUI();
    RegisterGUI registerGUI = new RegisterGUI();

    public RentMyPlaceController(LoginGUI gui, Model model) {
        this.gui = gui;
        this.model = model;

        gui.setVisible(true);
        gui.addLoginListener(new LoginListener());
        gui.addRegisterListener(new RegisterListener());
        gui.addGuestListener(new GuestUserListener());

        mainGui.addjButton2EventListener(new NextPropertyActionListener());
        mainGui.addjButton1EventListener(new PreviousPropertyActionListener());

        registerGUI.addRegisterListener(new AddUserListener());
        registerGUI.addReturnToLoginListener(new ReturnLoginListener());
        registerGUI.addGuestListener(new GuestUserListener());

        this.getProperty(currentIndex);
    }

    public RentMyPlaceController() {
    }

    public boolean checkUser(String userName, String password) {
        boolean authenticated = false;
        ArrayList<User> user = new User()
                .select(new String[]{"id", "username", "password", "userType"})
                .where("username", "LIKE", userName)
                .get();
        if(user.isEmpty()){
            authenticated = false;
        }
        else if(user != null) {
            currentUser = user.get(0);
            if (currentUser.authenticate(userName, password)) {
                System.out.println("User found: " + currentUser.toString());
                authenticated = true;
                this.autorization(currentUser);
            }
        }
        return authenticated;
    }

    public boolean checkUsername(String userName) {
        ArrayList<User> user = new User()
                .where("username", "LIKE", userName)
                .get();
        if(user.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean autorization(User user) {
        if (user.getUserType().equals("u")) {
            System.out.println("User");
        } else if (user.getUserType().equals("a")) {
            System.out.println("Admin");
        }

        return true;
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean authenticated = false;
            authenticated = checkUser(gui.getjTextField1().getText(), gui.getjPasswordField1().getText());
            if (authenticated) {
                JOptionPane jopMessage = new JOptionPane();
                jopMessage.showMessageDialog(gui, "Log in successful.");
                gui.dispose();
                registerGUI.dispose();
                mainGui.setVisible(true);
            } else {
                JOptionPane jopMessage = new JOptionPane();
                jopMessage.showMessageDialog(gui, "Try again.");
            }
        }
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.setVisible(false); //dispose only if guest or user signed/logged in
            registerGUI.setVisible(true);
        }
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            boolean authenticated = false;

            if(!registerGUI.getPassField().getText().equals("") && !registerGUI.getUsernameField().getText().equals("")){
                authenticated = checkUsername(registerGUI.getUsernameField().getText());
                if(authenticated){
                    //create default user object
                    User newUser = new User();

                    //convert pass
                    String convPass = Authentication.convert(registerGUI.getPassField().getText());

                    //set user attributes
                    newUser.setUsername(registerGUI.getUsernameField().getText());
                    newUser.setPassword(convPass);
                    newUser.setUserType("u");

                    //add to DB
                    newUser.create(Map.ofEntries(
                            Map.entry("username", newUser.getUsername()),
                            Map.entry("password", newUser.getPassword()),
                            Map.entry("userType", newUser.getUserType())
                    ));

                    gui.dispose();
                    registerGUI.dispose();
                    mainGui.setVisible(true);
                }
            }
        }
    }

    class ReturnLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            registerGUI.setVisible(false); //dispose only if guest or user signed/logged in
            gui.setVisible(true);
        }
    }

    class GuestUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("Guest");
            registerGUI.dispose();
            gui.dispose();
            mainGui.setVisible(true);

            mainGui.getjTabbedPane2().setEnabledAt(2, false);
            mainGui.getjTabbedPane2().setEnabledAt(3, false);
            mainGui.getjTabbedPane2().setEnabledAt(4, false);
        }
    }

    class NextPropertyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            currentIndex++;
            if (currentIndex >= properties.size()) {
                currentIndex = 0;
            }
            getProperty(currentIndex);

        }
    }

    class PreviousPropertyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            currentIndex--;
            if (currentIndex < 0) {
                currentIndex = properties.size() - 1;
            }
            getProperty(currentIndex);
        }
    }

    public Property getProperty(int currentIndex) {
        properties = new Property()
                .select(new String[]{"id", "description", "pricePerNight", "imagePath", "locationId"})
                .get();

        ArrayList<Location> locations = new Location()
                .select(new String[]{"id", "city"})
                .get();

        mainGui.getjLabel2().setText(properties.get(currentIndex).getDescription());

        mainGui.getjLabel9().setText(locations.get(properties.get(currentIndex).getLocationId() - 1).getCity());

        mainGui.getjLabel11().setText(String.valueOf(properties.get(currentIndex).getPricePerNight()));

        mainGui.getjLabel12().setIcon(mainGui.bufferImageIcon(mainGui.createURL(properties.get(currentIndex).getImagePath()), 600, 450));

        return properties.get(currentIndex);
    }
}
