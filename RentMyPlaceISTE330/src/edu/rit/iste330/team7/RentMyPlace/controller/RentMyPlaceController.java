package edu.rit.iste330.team7.RentMyPlace.controller;

import edu.rit.iste330.team7.RentMyPlace.model.*;
import edu.rit.iste330.team7.RentMyPlace.view.GUI;
import edu.rit.iste330.team7.RentMyPlace.view.LoginGUI;
import edu.rit.iste330.team7.RentMyPlace.view.RegisterGUI;
import edu.rit.iste330.team7.RentMyPlace.view.ReserveGUI;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class RentMyPlaceController {
    User currentUser = null;
    int currentIndex = 0;
    ArrayList<Property> properties = null;
    ArrayList<Location> locations = null;
    ArrayList<Feature> features = null;
    ArrayList<FeatureProperty> featureProperty = null;
    ArrayList<PropertyType> propertyTypes = null;
    ArrayList<Contact> contacts = null;
    ArrayList<User> users = null;
    ArrayList<Favorite> favorites = null;
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
        mainGui.addjButton5EventListener(new SearchListener());

        mainGui.getjTabbedPane2().addChangeListener(new FavoritesListener());
        mainGui.getjTabbedPane2().addChangeListener(new MyRentalsListener());

        mainGui.addAddPropertyEventListener(new AddPropertyListener());

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

        // NOT WORKING, WILL BE USED TO UPDATE TEXTFIELD
        int userId = Auth.getUser().getId();


        contacts = new Contact()
                .select(new String[]{"id", "fullName", "email", "phone", "locationId"})
                .where("id", "=", String.valueOf(userId))
                .get();

        mainGui.getjTextFieldContactFullName().setText(contacts.get(0).getFullName());
        mainGui.getjTextFieldContactEmail().setText(contacts.get(0).getEmail());
        mainGui.getjTextFieldContactStreet().setText(locations.get(0).getStreet());
        mainGui.getjTextFieldContactCity().setText(locations.get(0).getCity());
        mainGui.getjTextFieldContactZip().setText(String.valueOf(locations.get(0).getZip()));

    }

    public RentMyPlaceController() {
    }

    public boolean usernameExists(String userName) {
        ArrayList<User> user = new User()
                .where("username", "LIKE", userName)
                .get();
        if (user.isEmpty()) return false;
        return true;
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

            if (!registerGUI.getPassField().getText().equals("") && !registerGUI.getUsernameField().getText().equals("")) {
                String username = registerGUI.getUsernameField().getText();
                if (!usernameExists(username)) {

                    //convert pass
                    String convPass = Authentication.convert(registerGUI.getPassField().getText());
                    String userType = "user";

                    //add to DB
                    User newUser = new User().create(Map.ofEntries(
                            Map.entry("username", username),
                            Map.entry("password", convPass),
                            Map.entry("userType", userType)
                    ));

                    Auth.checkUser(username, convPass);
                    gui.dispose();
                    registerGUI.dispose();
                    mainGui.setVisible(true);

                    mainGui.getjLabelUsername().setText(newUser.getUsername());
                }
                else {
                    JOptionPane jopMessage = new JOptionPane();
                    jopMessage.showMessageDialog(gui, "This username already exists!\nTry something else.");
                }
            }
        }
    }

    class LogOutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            gui.setVisible(true);
            mainGui.dispose();

            mainGui.getjTabbedPane2().setSelectedComponent(mainGui.getjPanelRent());

            gui.getjPasswordField1().setText("");
            gui.getjTextField1().setText("");

            Auth.logToken("");
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

           int contactId = Auth.getUser().getContactId();
           int billingId = Auth.getUser().getBillingId();

            Contact newContact = (Contact) new Contact()
                    .where("id", "=", String.valueOf(contactId))
                    .get()
                    .get(0);
            Location newLocation = (Location) new Location()
                    .where("id", "=", String.valueOf(billingId))
                    .get()
                    .get(0);


//            //set contact attributes
            newContact.setFullName(mainGui.getjTextFieldContactFullName().getText());
            newContact.setEmail(mainGui.getjTextFieldContactEmail().getText());

            newLocation.setCity(mainGui.getjTextFieldContactCity().getText());
            newLocation.setStreet(mainGui.getjTextFieldContactStreet().getText());
            newLocation.setZip(Integer.parseInt(mainGui.getjTextFieldContactZip().getText()));

            newLocation.update(Map.ofEntries(
                    Map.entry("city", mainGui.getjTextFieldContactCity().getText()),
                    Map.entry("street", mainGui.getjTextFieldContactStreet().getText()),
                    Map.entry("zip", String.valueOf(mainGui.getjTextFieldContactZip().getText())
                    )));

            newContact.update(Map.ofEntries(
                    Map.entry("fullName", mainGui.getjTextFieldContactFullName().getText()),
                    Map.entry("email", mainGui.getjTextFieldContactEmail().getText())
            ));
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

    class SearchListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!Auth.checkPermission(e.getActionCommand()) && guest==false) return;

            String givenPropertyLocation = mainGui.getjTextField2().getText();
            System.out.println(givenPropertyLocation);

            String priceAscDesc = mainGui.getjComboBox1().getSelectedItem().toString();
            String orderBy = "";

            if(priceAscDesc.equals("Price (ascending)")){
                orderBy = "ASC";
            }else{
                orderBy = "DESC";
            }
            System.out.println(priceAscDesc);

            locations = new Location()
                    .select(new String[]{"id", "city", "zip", "street"})
                    .where("city", "=", givenPropertyLocation)
                    .get();

            if(locations.isEmpty()){
                System.out.println("No such property");
            }

            properties.clear();
            ArrayList<Property> tempProperty = new ArrayList<>();
            for(Location location : locations) {
                tempProperty = new Property()
                        .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId", "propertyTypeId", "bedrooms", "size"})
                        .where("locationId", "=", String.valueOf(location.getId()))
                        //.orderBy(new String[]{"pricePerNight"}, orderBy)
                        .get();

                properties.add((Property) tempProperty.get(0));
                tempProperty.clear();
            }

            if(properties.isEmpty()){
                System.out.println("No such property");
            }

            //Order by doesn't work here due to multiple queries combined to single list
            if(orderBy.equals("ASC"))Collections.sort(properties);
            else Collections.sort(properties, Collections.reverseOrder());

            for(Property property:properties){
                System.out.println(property.getPricePerNight());
            }

        }
    }

    class AddPropertyListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!Auth.checkPermission(e.getActionCommand())) return;

            ArrayList<JRadioButton> radioButtons = mainGui.getJRadioButtons();
            String propertyType = "";
            for(JRadioButton btn : radioButtons){
                if(btn.isSelected()){
                    propertyType = btn.getText().toLowerCase();
                }
            }

            ArrayList<PropertyType> propertyTypes = new PropertyType()
                    .select(new String[]{"id"})
                    .where("type","=", propertyType)
                    .get();

            String propertyTypeId = String.valueOf(propertyTypes.get(0).getId());

            String propertyName = mainGui.getjTextField13().getText();
            String street = mainGui.getjTextField14().getText();
            String numOfBedrooms = mainGui.getjTextField15().getText();
            String cityName = mainGui.getjTextField16().getText();
            String zip = mainGui.getjTextField17().getText();
            String pricePerNight = mainGui.getjTextField18().getText();
            String size = mainGui.getjTextField19().getText();
            String description = mainGui.getjTextField20().getText();
            String imageUrl = mainGui.getjTextField21().getText();

             Location location = new Location().create(Map.ofEntries(
                    Map.entry("street", street),
                    Map.entry("city", cityName),
                    Map.entry("zip", zip)
            ));

             String id = String.valueOf(Auth.getUser().getId());
            Property property = new Property().create(Map.ofEntries(
                  Map.entry("userId", id),
                  Map.entry("locationId", String.valueOf(location.getId())),
                    Map.entry("propertyName", propertyName),
                  Map.entry("propertyTypeId", propertyTypeId),
                  Map.entry("description", description),
                  Map.entry("imagePath", imageUrl),
                  Map.entry("bedrooms", numOfBedrooms),
                  Map.entry("size", size),
                  Map.entry("pricePerNight", pricePerNight)
            ));

            ArrayList<JCheckBox> checkBoxes = mainGui.getCheckBoxes();
            ArrayList<String> checkedFeatures = new ArrayList<>();
            for(JCheckBox box : checkBoxes){
                if(box.isSelected()){
                    checkedFeatures.add(box.getText());
                }
            }

            ArrayList<Feature> features = new ArrayList<>();

            for(String feature : checkedFeatures) {
                features.add((Feature) new Feature().select(new String[]{"id"}).where("feature", "LIKE", feature).get().get(0));
            }

            for(Feature feature : features) {
                new FeatureProperty().create(Map.ofEntries(
                        Map.entry("propertyId", String.valueOf(property.getId())),
                        Map.entry("featureId", String.valueOf(feature.getId()))
                ));
            }

        }
    }

    class MyRentalsListener implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            if(!Auth.checkPermission(String.valueOf(mainGui.getjTabbedPane2().getSelectedIndex()))) return;

            if(mainGui.getjTabbedPane2().getSelectedIndex() == 2) {
                int userId = Auth.getUser().getId();
                properties.clear();
                properties = new Property()
                        .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId", "propertyTypeId", "bedrooms", "size"})
                        .where("userId", "=", String.valueOf(userId))
                        .get();

                for (Property property : properties) {
                    System.out.println(property.toString());
                }
            }
        }
    }

    class FavoritesListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (!Auth.checkPermission(String.valueOf(mainGui.getjTabbedPane2().getSelectedIndex())))  return;

            int id = Auth.getUser().getId();

            if (mainGui.getjTabbedPane2().getSelectedIndex() == 3) {
                favorites = new Favorite()
                        .select(new String[]{"id", "userId", "propertyId"})
                        .where("userId", "=", String.valueOf(id))
                        .get();

                ArrayList<Property> tempProperties = new ArrayList<>();
                properties.clear();
                for(Favorite favorite : favorites) {
                    tempProperties = new Property()
                            .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId", "propertyTypeId", "bedrooms", "size"})
                            .where("id", "=", String.valueOf(favorite.getPropertyId()))
                            .get();
                    properties.add(tempProperties.get(0));
                    tempProperties.clear();
                }

                for(Property property : properties){
                    System.out.println(property.toString());
                }
            }
        }
    }
}
