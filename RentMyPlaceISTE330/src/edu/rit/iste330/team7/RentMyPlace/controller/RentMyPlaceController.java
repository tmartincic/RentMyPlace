package edu.rit.iste330.team7.RentMyPlace.controller;

import edu.rit.iste330.team7.RentMyPlace.model.*;
import edu.rit.iste330.team7.RentMyPlace.view.GUI;
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
    ArrayList<PropertyType> propertyTypes = null;
    LoginGUI gui;
    Model model;
    GUI mainGui = new GUI();
    RegisterGUI registerGUI = new RegisterGUI();

    public RentMyPlaceController(LoginGUI gui, Model model) {
        this.gui = gui;
        if(Auth.userFromToken()) {
            JOptionPane jopMessage = new JOptionPane();
            jopMessage.showMessageDialog(gui, "Token was recognized from last login!");
            mainGui.setVisible(true);
        }
        else gui.setVisible(true);
        this.model = model;

        gui.addLoginListener(new LoginListener());
        gui.addRegisterListener(new RegisterListener());
        gui.addGuestListener(new GuestUserListener());

        mainGui.addjButton2EventListener(new NextPropertyActionListener());
        mainGui.addjButton1EventListener(new PreviousPropertyActionListener());
        mainGui.addjButton3EventListener(new MorePropertyDetailsActionListener());

        registerGUI.addRegisterListener(new AddUserListener());
        registerGUI.addReturnToLoginListener(new ReturnLoginListener());
        registerGUI.addGuestListener(new GuestUserListener());

        this.getProperty(currentIndex);
    }

    public RentMyPlaceController() {
    }

    public boolean checkUsername(String userName) {
        ArrayList<User> user = new User()
                .where("username", "LIKE", userName)
                .get();
        if (user.isEmpty()) {
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
            String username = gui.getjTextField1().getText();
            String password = gui.getjPasswordField1().getText();

            boolean authenticated = Auth.checkUser(username, password);

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

            if (!registerGUI.getPassField().getText().equals("") && !registerGUI.getUsernameField().getText().equals("")) {
                authenticated = checkUsername(registerGUI.getUsernameField().getText());
                if (authenticated) {
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

    class MorePropertyDetailsActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            getProperty(currentIndex);
            JOptionPane jopMessage = new JOptionPane();
            jopMessage.showMessageDialog(mainGui,
                    "Property type: " + propertyTypes.get(properties.get(currentIndex).getPropertyTypeId() - 1).getType()
                            + "\nDescription: " + properties.get(currentIndex).getDescription()
                            + "\nBedrooms: " + properties.get(currentIndex).getBedrooms()
                            + "\nSize: " + properties.get(currentIndex).getSize(),
                    "Property information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Property getProperty(int currentIndex) {
        properties = new Property()
                .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId", "propertyTypeId", "bedrooms", "size"})
                .get();

        propertyTypes = new PropertyType()
                .select(new String[]{"id", "type"})
                .get();

        ArrayList<Location> locations = new Location()
                .select(new String[]{"id", "city"})
                .get();

        mainGui.getjLabel2().setText(properties.get(currentIndex).getPropertyName());

        mainGui.getjLabel9().setText(locations.get(properties.get(currentIndex).getLocationId() - 1).getCity());

        mainGui.getjLabel11().setText(String.valueOf(properties.get(currentIndex).getPricePerNight()));

        mainGui.getjLabel12().setIcon(mainGui.bufferImageIcon(mainGui.createURL(properties.get(currentIndex).getImagePath()), 600, 450));

        return properties.get(currentIndex);
    }
}
