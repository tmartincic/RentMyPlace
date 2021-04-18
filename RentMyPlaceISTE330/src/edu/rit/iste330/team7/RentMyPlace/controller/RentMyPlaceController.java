package edu.rit.iste330.team7.RentMyPlace.controller;

import edu.rit.iste330.team7.RentMyPlace.model.*;
import edu.rit.iste330.team7.RentMyPlace.view.GUI;
import edu.rit.iste330.team7.RentMyPlace.view.LoginGUI;
import edu.rit.iste330.team7.RentMyPlace.view.RegisterGUI;
import edu.rit.iste330.team7.RentMyPlace.view.ReserveGUI;

import java.awt.event.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Map;

public class RentMyPlaceController {
    User currentUser = null;
    int currentIndex = 0;
    ArrayList<Property> properties = null;
    ArrayList<Location> locations = null;
    ArrayList<Feature> features = null;
    ArrayList<FeatureProperty> featureProperty = null;
    ArrayList<PropertyType> propertyTypes = null;
    LoginGUI gui;
    Model model;
    GUI mainGui = new GUI();
    RegisterGUI registerGUI = new RegisterGUI();

    boolean guest = false;

    public RentMyPlaceController(LoginGUI gui, Model model) {
        this.gui = gui;
        if (Auth.getUser() != null) {
            JOptionPane jopMessage = new JOptionPane();
            jopMessage.showMessageDialog(gui, "Token was recognized from last login!");
            mainGui.setVisible(true);
        } else gui.setVisible(true);
        this.model = model;

        gui.addLoginListener(new LoginListener());
        gui.addRegisterListener(new RegisterListener());
        gui.addGuestListener(new GuestUserListener());

        mainGui.addjButton2EventListener(new NextPropertyActionListener());
        mainGui.addjButton1EventListener(new PreviousPropertyActionListener());
        mainGui.addjButton3EventListener(new MorePropertyDetailsActionListener());
        mainGui.addjButton15EventListener(new ReserveListener());
        mainGui.addjButton6EventListener(new SaveSettingsListener());

        registerGUI.addRegisterListener(new AddUserListener());
        registerGUI.addReturnToLoginListener(new ReturnLoginListener());
        registerGUI.addGuestListener(new GuestUserListener());

        mainGui.addLogOutButtonEventListener(new LogOutListener());

        this.getProperty(currentIndex);

        //set user if token exists
        if (Auth.tokenExists()) {
            currentUser = Auth.getUser();
            try {
                mainGui.getjLabelUsername().setText(currentUser.getUsername());
            } catch (NullPointerException npe) {
                mainGui.getjLabelUsername().setText("");
            }
        }
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
//                gui.setVisible(false);
//                registerGUI.setVisible(false);
                mainGui.setVisible(true);
                //reset user
                currentUser = Auth.getUser();
                mainGui.getjLabelUsername().setText(currentUser.getUsername());

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

                    currentUser = Auth.getUser();
                    mainGui.getjLabelUsername().setText(currentUser.getUsername());
                }
            }
        }
    }

    class LogOutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (!Auth.checkPermission(ae.getActionCommand())) return;

            gui.setVisible(true);
            mainGui.dispose();

            mainGui.getjTabbedPane2().setSelectedComponent(mainGui.getjPanelRent());

            gui.getjPasswordField1().setText("");
            gui.getjTextField1().setText("");

            currentUser = Auth.getUser();
            mainGui.getjLabelUsername().setText(currentUser.getUsername());
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
            guest = true;
            Auth.logToken("");
            System.out.println("Guest" + guest);
            registerGUI.dispose();
            gui.dispose();
            mainGui.setVisible(true);

            mainGui.getjTabbedPane2().setEnabledAt(2, false);
            mainGui.getjTabbedPane2().setEnabledAt(3, false);
            mainGui.getjTabbedPane2().setEnabledAt(4, false);
            mainGui.getjTabbedPane2().setEnabledAt(5, false);
        }
    }

    class NextPropertyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {

            if (!Auth.checkPermission(ae.getActionCommand()) && guest == false) return;

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

            if (!Auth.checkPermission(ae.getActionCommand()) && guest == false) return;

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

            if (!Auth.checkPermission(ae.getActionCommand()) && guest == false) return;

            getProperty(currentIndex);

            String propertyFeatures = "";
            for (Feature feature : features) {
                propertyFeatures += "<li>" + feature.getFeature() + "</li>";
            }

            JOptionPane jopMessage = new JOptionPane();
            jopMessage.showMessageDialog(mainGui,
                    "<html><body>" +
                            "<p>Name: " + "<b>" + properties.get(currentIndex).getPropertyName() + "</b></p><br><br>" +
                            "<p>Street: " + locations.get(properties.get(currentIndex).getLocationId() - 1).getStreet() + "</p><br>" +
                            "<p>Location: " + locations.get(properties.get(currentIndex).getLocationId() - 1).getCity() + ", " + locations.get(properties.get(currentIndex).getLocationId() - 1).getZip() + "</p><br>" +
                            "<p>PropertyType: " + propertyTypes.get(properties.get(currentIndex).getPropertyTypeId() - 1).getType() + "</p><br>" +
                            "<p>Description: " + properties.get(currentIndex).getDescription() + "</p><br>" +
                            "<p>Bedrooms: " + properties.get(currentIndex).getBedrooms() + "</p><br>" +
                            "<p>Size: " + properties.get(currentIndex).getSize() + "</p>" +
                            "<p>Features: <ul>" + propertyFeatures + "</ul></p>" +
                            "</body></html>",
                    "Property information", JOptionPane.INFORMATION_MESSAGE, mainGui.bufferImageIcon(mainGui.createURL(properties.get(currentIndex).getImagePath()), 500, 350));
        }
    }

    public Property getProperty(int currentIndex) {
        properties = new Property()
                .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId", "propertyTypeId", "bedrooms", "size"})
                .get();

        propertyTypes = new PropertyType()
                .select(new String[]{"id", "type"})
                .get();

        locations = new Location()
                .select(new String[]{"id", "city", "zip", "street"})
                .get();

        featureProperty = new FeatureProperty()
                .select(new String[]{"propertyId", "featureId"})
                .where("propertyId", "=", String.valueOf(properties.get(currentIndex).getId()))
                .get();

        ArrayList<Feature> tempFeatures = new ArrayList<>();
        features = new ArrayList<>();
        for (FeatureProperty fProperty : featureProperty) {
            tempFeatures = new Feature()
                    .select(new String[]{"id", "feature"})
                    .where("id", "=", String.valueOf(fProperty.getFeatureId()))
                    .get();

            features.add(tempFeatures.get(0));
            tempFeatures.clear();
        }

        mainGui.getjLabel2().setText(properties.get(currentIndex).getPropertyName());

        mainGui.getjLabel9().setText(locations.get(properties.get(currentIndex).getLocationId() - 1).getCity());

        mainGui.getjLabel11().setText(String.valueOf(properties.get(currentIndex).getPricePerNight()));

        mainGui.getjLabel12().setIcon(mainGui.bufferImageIcon(mainGui.createURL(properties.get(currentIndex).getImagePath()), 600, 450));

        return properties.get(currentIndex);
    }

    class SaveSettingsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae){
            ArrayList<Contact> contacts = new Contact()
                    .select(new String[]{"id", "fullName", "email", "phone", "locationId"})
                    .get();

            /**
             * FINISH
             */

        }
    }

    class ReserveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {

            if(!Auth.checkPermission(ae.getActionCommand())) return;

            ReserveGUI reserveGui = new ReserveGUI();
            reserveGui.setVisible(true);
        }
    }
}
