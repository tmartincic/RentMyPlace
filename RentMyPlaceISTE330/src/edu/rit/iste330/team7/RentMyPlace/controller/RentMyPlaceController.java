package edu.rit.iste330.team7.RentMyPlace.controller;

import edu.rit.iste330.team7.RentMyPlace.model.*;
import edu.rit.iste330.team7.RentMyPlace.view.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RentMyPlaceController {
    User currentUser = null;
    int currentIndex = 0;
    int currentIndexRent = 0;
    ArrayList<Property> properties = null;
    ArrayList<Location> locations = null;
    ArrayList<Feature> features = null;
    ArrayList<FeatureProperty> featureProperty = null;
    ArrayList<PropertyType> propertyTypes = null;
    ArrayList<Contact> contacts = null;
    ArrayList<Billing> billings = null;
    ArrayList<User> users = null;
    ArrayList<Favorite> favorites = null;
    ReserveGUI reserveGui = null;
    LoginGUI gui;
    Model model;
    GUI mainGui = new GUI();
    AdminGUI adminGUI = null;
    RegisterGUI registerGUI = new RegisterGUI();
    ConfirmationGUI confirmationGUI = new ConfirmationGUI();

    boolean guest = false;

    /**
     * Constructor
     * @param gui - starting login gui
     * @param model
     */
    public RentMyPlaceController(LoginGUI gui, Model model) {
        this.gui = gui;
        if (Auth.getUser() != null) {
            JOptionPane jopMessage = new JOptionPane();
            jopMessage.showMessageDialog(gui, "Token was recognized from last login!");
            mainGui.setVisible(true);
        } else gui.setVisible(true);
        this.model = model;

        /**
         * Button listeners for the LoginGUI
         */
        gui.addLoginListener(new LoginListener());
        gui.addRegisterListener(new RegisterListener());
        gui.addGuestListener(new GuestUserListener());

        /**
         * Button listeners for the main GUI
         */
        mainGui.addjButton2EventListener(new NextPropertyActionListener());
        mainGui.addjButton1EventListener(new PreviousPropertyActionListener());
        mainGui.addjButton3EventListener(new MorePropertyDetailsActionListener());
        mainGui.addjButton15EventListener(new ReserveListener());
        mainGui.addjButton6EventListener(new SaveSettingsListener());
        mainGui.addjButton5EventListener(new SearchListener());
        mainGui.addAddFavoritesEventListener(new AddToFavoritesListener());
        mainGui.addDeletePropertyFromMyRentalsListener(new DeleteMyRentalsListener());
        mainGui.addAddPropertyEventListener(new AddPropertyListener());
        mainGui.addLogOutButtonEventListener(new LogOutListener());


        /**
         * Change listeners for changing tabs
         */
        mainGui.getjTabbedPane2().addChangeListener(new FavoritesListener());
        mainGui.getjTabbedPane2().addChangeListener(new MyRentalsListener());
        mainGui.getjTabbedPane2().addChangeListener(new SettingListener());

        /**
         * Combo box item listeners
         */
        mainGui.getjComboBox3().addItemListener(new SelectChangeListener());
        mainGui.getjComboBox2().addItemListener(new MyRentalsChangeListener());

        /**
         * RegisterGUI button listeners
         */
        registerGUI.addRegisterListener(new AddUserListener());
        registerGUI.addReturnToLoginListener(new ReturnLoginListener());
        registerGUI.addGuestListener(new GuestUserListener());

        /**
         * ConfirmationGUI button listener
         */
        confirmationGUI.addExportButtonListener(new ExportListener());

        // Initial getProperty
        this.getProperty(currentIndex);


        //set user if token exists
        if (Auth.tokenExists()) {
            currentUser = Auth.getUser();
            if (currentUser != null) {

                if (currentUser.getUserType().equals("admin")) {
                    showAdminGUI();
                }

                try {
                    mainGui.getjLabelUsername().setText(currentUser.getUsername());
                } catch (NullPointerException npe) {
                    mainGui.getjLabelUsername().setText("");
                }
            }
        }
    }

    /**
     * Method for showing the AdminGUI and attaching listeners to it
     */
    public void showAdminGUI(){
        adminGUI = new AdminGUI();
        adminGUI.addUsers(getUsers());
        adminGUI.setName(currentUser.getUsername());
        adminGUI.getjListUsersInfo().setSelectedIndex(0);
        adminGUI.addRemoveUserListener(new RemoveUserListener());
        adminGUI.addPromoteUserListener(new PromoteUserListener());
        adminGUI.addDemoteUserListener(new DemoteUserListener());

    }

    /**
     * Method which selects all users into the temp Array using select method
     * and adds them into the ArrayList<String> users
     * @return ArrayList<String>
     */
    public ArrayList<String> getUsers(){
        ArrayList<User> temp = new User()
                .select(new String[]{"id", "username", "userType"})
                .get();
        ArrayList<String> users = new ArrayList<>();
        for(User user : temp){
            String userInfo = String.valueOf(user.getId()) + "   " + user.getUserType() + "   " + user.getUsername();
            users.add(userInfo);
        }
        return users;
    }

    /**
     * Method for checking if a user with the provided username exists
     * @param userName
     * @return boolean
     */
    public boolean usernameExists(String userName) {
        ArrayList<User> user = new User()
                .where("username", "LIKE", userName)
                .get();
        if (user.isEmpty()) return false;
        return true;
    }

    /**
     * Inner class which implements the login listener and communicates with the
     * presentation layer to gather information from the LoginGUI gui
     */
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
                //reset user
                currentUser = Auth.getUser();

                if(currentUser.getUserType().equals("admin")) {
                    showAdminGUI();
                }

                mainGui.getjLabelUsername().setText(currentUser.getUsername());

            } else {
                JOptionPane jopMessage = new JOptionPane();
                jopMessage.showMessageDialog(gui, "Try again.");
            }
        }
    }

    /**
     * Inner class responsible for removing a user and their properties, communicates both with the
     * presentation layer and the data layer. Updates the user list using the adminGUI provide method addUsers
     */
    class RemoveUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae){
            if(getSelectedUser().isBlank()) return;
            String currentUser = Auth.getUser().getUsername();
            if(getSelectedUser().equals(currentUser)) {

                if (JOptionPane.showConfirmDialog(gui, "Are you sure you want to delete yourself?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        User user = (User) new User()
                                .select(new String[]{"id", "username", "password", "userType", "contactId", "billingId", "token"})
                                .where("username", "LIKE", getSelectedUser())
                                .get().get(0);
                        user.delete();
                } else {
                    return;
                }
            }
            else {
                User user = (User) new User()
                        .select(new String[]{"id", "username", "password", "userType", "contactId", "billingId", "token"})
                        .where("username", "LIKE", getSelectedUser())
                        .get().get(0);
                user.delete();
            }

            properties = new Property()
                    .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId", "propertyTypeId", "bedrooms", "size"})
                    .get();

            adminGUI.addUsers(getUsers());
        }
    }

    /**
     * Method for getting the selected user, communicates with the presentation
     * layer to get the currently selected value from the jList
     * @return String
     */
    public String getSelectedUser(){
        String temp, username;
        try{
            temp = adminGUI.getjListUsersInfo().getSelectedValue().toString();
            String[] splitArray = temp.split("   ");
            username = splitArray[2];
        }
        catch (NullPointerException npe) {
            username = "";
        }
        return username;
    }

    /**
     * Inner class responsible for handling promotion of a normal user to admin
     * in the AdminGUI
     */
    class PromoteUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae){
            if(getSelectedUser().isBlank()) return;
            User user = (User) new User()
                    .select(new String[]{"id", "username", "password", "userType", "contactId", "billingId", "token"})
                    .where("username", "LIKE", getSelectedUser())
                    .get().get(0);

            user.update(Map.ofEntries(
                            Map.entry("userType", "admin")
                        ));

            adminGUI.addUsers(getUsers());
        }
    }

    /**
     * Inner class responsible for handling demotion of an admin to user
     * in the AdminGUI
     */
    class DemoteUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae){
            if(getSelectedUser().isBlank()) return;
            User user = (User) new User()
                    .select(new String[]{"id", "username", "password", "userType", "contactId", "billingId", "token"})
                    .where("username", "LIKE", getSelectedUser())
                    .get().get(0);

            user.update(Map.ofEntries(
                    Map.entry("userType", "user")
            ));

            adminGUI.addUsers(getUsers());
        }
    }

    /**
     * RegisterListener inner class which responds to the register button being clicked on the LoginGUI,
     * when clicked LoginGUI is changed to setVisible(false) while registerGUI appears
     */
    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.setVisible(false); //dispose only if guest or user signed/logged in
            registerGUI.setVisible(true);
        }
    }

    /**
     * Method for adding a user to the database and hashing their password using the method provided in the
     * Authentication class, communicates with the registerGUI to gather information entered into the text fields and
     * finally creates a user into the database with the converted hashed password being stored
     */
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


                    // Generating the token for the newly created user so they can access
                    // all the functionality
                    Auth.logToken(newUser.generateToken());
                    gui.dispose();
                    registerGUI.dispose();
                    mainGui.setVisible(true);
                    mainGui.getjLabelUsername().setText(newUser.getUsername());

                    currentUser = Auth.getUser();
                } else {
                    JOptionPane jopMessage = new JOptionPane();
                    jopMessage.showMessageDialog(gui, "This username already exists!\nTry something else.");
                }
            }
        }
    }

    /**
     * LogOut listener inner class which communicates with the main GUI and responds to the log out button being clicked
     * sets the authentication log token an empty string, forcing the user to enter their password the next time they
     * enter the application
     */
    class LogOutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            gui.setVisible(true);
            mainGui.dispose();
            confirmationGUI.dispose();

            if(adminGUI!=null){
                adminGUI.dispose();
            }

            mainGui.getjTabbedPane2().setSelectedComponent(mainGui.getjPanelRent());

            gui.getjPasswordField1().setText("");
            gui.getjTextField1().setText("");

            Auth.logToken("");
            currentIndex = 0;
        }
    }

    /**
     * Inner class implementing an action listener which is connected to the return to login button once the user is in the
     * registerGUI
     */
    class ReturnLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            registerGUI.setVisible(false);
            gui.setVisible(true);
        }
    }

    /**
     * Guest user action listener, which communicates with the LoginGUI, sets the presentation layer tabs to
     * to be disabled as well as set the Authentication token to be an empty string
     */
    class GuestUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            guest = true;
            Auth.logToken("");
            registerGUI.dispose();
            gui.dispose();
            mainGui.setVisible(true);

            mainGui.getjTabbedPane2().setEnabledAt(2, false);
            mainGui.getjTabbedPane2().setEnabledAt(3, false);
            mainGui.getjTabbedPane2().setEnabledAt(4, false);
            mainGui.getjTabbedPane2().setEnabledAt(5, false);
        }
    }

    /**
     * Inner class which implements an action listener for the next button on the RENT tab,
     * increments the currentIndexRent and gets the property at the new index
     */
    class NextPropertyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {

            if (!Auth.checkPermission(ae.getActionCommand()) && guest == false) return;

            currentIndexRent++;
            if (currentIndexRent >= properties.size()) {
                currentIndexRent = 0;
            }
            getProperty(currentIndexRent);

        }
    }

    /**
     * Inner listener for the previous button on the RENT tab, decrements the currentIndexRent and gets
     * the property at the new currentIndexRent
     */
    class PreviousPropertyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {

            if (!Auth.checkPermission(ae.getActionCommand()) && guest == false) return;

            currentIndexRent--;
            if (currentIndexRent < 0) {
                currentIndexRent = properties.size() - 1;
            }
            getProperty(currentIndexRent);
        }
    }

    /**
     * Inner class listening for the add to favorites icon button, communicates with the main GUI and the data layer,
     * adds the favorite to the database
     */
    class AddToFavoritesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!Auth.checkPermission(e.getActionCommand())) return;

            getProperty(currentIndexRent);

            int userId = Auth.getUser().getId();
            Property property = properties.get(currentIndexRent);
            int propertyId = property.getId();
            if (!(favorites == null)) {
                favorites.clear();
            }
            favorites = new Favorite().select(new String[]{"id", "userId", "propertyId"})
                    .where("userId", "=", String.valueOf(userId))
                    .where("propertyId", "=", String.valueOf(propertyId))
                    .get();

            if (!favorites.isEmpty()) {
                JOptionPane pane = new JOptionPane();
                pane.showMessageDialog(mainGui, "Already exists as favorite");
                return;
            }

            new Favorite().create(Map.ofEntries(
                    Map.entry("userId", String.valueOf(userId)),
                    Map.entry("propertyId", String.valueOf(propertyId))
                    )
            );
        }
    }

    /**
     * More property details inner class action listener, opens an jOptionPane dialog
     * with the information regarding the property, including features, bedrooms etc.
     * in HTML format
     */
    class MorePropertyDetailsActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {

            if (!Auth.checkPermission(ae.getActionCommand()) && guest == false) return;

            int index = currentIndexRent;

            getProperty(index);

            String propertyFeatures = "";
            for (Feature feature : features) {
                propertyFeatures += "<li>" + feature.getFeature() + "</li>";
            }

            JOptionPane jopMessage = new JOptionPane();
            jopMessage.showMessageDialog(mainGui,
                    "<html><body>" +
                            "<p>Name: " + "<b>" + properties.get(index).getPropertyName() + "</b></p><br><br>" +
                            "<p>Street: " + locations.get(properties.get(index).getLocationId() - 1).getStreet() + "</p><br>" +
                            "<p>Location: " + locations.get(properties.get(index).getLocationId() - 1).getCity() + ", " + locations.get(properties.get(index).getLocationId() - 1).getZip() + "</p><br>" +
                            "<p>PropertyType: " + propertyTypes.get(properties.get(index).getPropertyTypeId() - 1).getType() + "</p><br>" +
                            "<p>Description: " + properties.get(index).getDescription() + "</p><br>" +
                            "<p>Bedrooms: " + properties.get(index).getBedrooms() + "</p><br>" +
                            "<p>Size: " + properties.get(index).getSize() + "</p>" +
                            "<p>Features: <ul>" + propertyFeatures + "</ul></p>" +
                            "</body></html>",
                    "Property information", JOptionPane.INFORMATION_MESSAGE, mainGui.bufferImageIcon(mainGui.createURL(properties.get(index).getImagePath()), 500, 350));
        }
    }

    /**
     * Method which takes a paramater of an integer, and gathers information from the data layer and adds them
     * into array lists of their model class. Finally sets the texts and images of the property on to the main GUI RENT
     * tab
     * @param currentIndex
     * @return Property
     */
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

    /**
     * Settings inner class which gets the user contact and billing information to the GUI if they exist in the database,
     * if not the user sees the generic information
     */
    class SettingListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            if (!Auth.checkPermission(String.valueOf(mainGui.getjTabbedPane2().getSelectedIndex()))) return;

            if (mainGui.getjTabbedPane2().getSelectedIndex() == 4) {
                int userId = Auth.getUser().getId();

                int contactId = Auth.getUser().getContactId();
                Contact contact = null;
                try{
                    contact = (Contact) new Contact()
                            .select(new String[]{"id", "fullName", "email", "phone", "locationId"})
                            .where("id", "=", String.valueOf(contactId))
                            .get().get(0);
                }
                catch (IndexOutOfBoundsException ee) {
                    System.out.println("No contact information found for " + Auth.getUser().getUsername());
                }

                int billingId = Auth.getUser().getBillingId();
                Location location = null;
                try{
                    if(contact != null && contact.getLocationId() != -1) {
                        location = (Location) new Location()
                                .select(new String[]{"id", "city", "zip", "street"})
                                .where("id", "=", String.valueOf(contact.getLocationId()))
                                .get().get(0);
                    }
                }
                catch (IndexOutOfBoundsException eee) {
                    System.out.println("No location information found for " + Auth.getUser().getUsername());
                }
                Billing billing = null;
                try{
                    billing = (Billing) new Billing()
                            .select(new String[]{"id", "billingAddress", "creditCardNum", "CVC", "expireDate", "ownerName"})
                            .where("id", "=", String.valueOf(billingId))
                            .get().get(0);
                }
                catch (IndexOutOfBoundsException eeeee) {
                    System.out.println("No billing information found for " + Auth.getUser().getUsername());
                }

                if(contactId != -1) {
                    mainGui.getjTextFieldContactFullName().setText(contact.getFullName());
                    mainGui.getjTextFieldContactEmail().setText(contact.getEmail());
                    mainGui.getjTextFieldContactStreet().setText(location.getStreet());
                    mainGui.getjTextFieldContactCity().setText(location.getCity());
                    mainGui.getjTextFieldContactZip().setText(String.valueOf(location.getZip()));
                }
                if(billingId != -1) {
                    mainGui.getjTextFieldBillingOwnerName().setText(billing.getOwnerName());
                    mainGui.getjTextFieldBillingCardNumber().setText(billing.getCreditCardNum());
                    mainGui.getjTextFieldBillingAddress().setText(billing.getBillingAddress());
                    mainGui.getjTextFieldBillingCVC().setText(billing.getCVC());
                    mainGui.getjDateChooserExpirationDate().setDate(billing.getExpireDate());
                }
            }
        }
    }

    /**
     * Inner class implementing an action listener, responsible for getting the information user entered into the presentation
     * layer and updates the entered information to the database
     */
    class SaveSettingsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {

            if(Auth.getUser() == null) return;
            int contactId = Auth.getUser().getContactId();
            int billingId = Auth.getUser().getBillingId();

            Contact newContact;
            Billing newBilling;
            Location newLocation;

            // if contact and billing info already exists
            if(contactId != -1 && billingId != -1) {
                newContact = (Contact) new Contact()
                        .where("id", "=", String.valueOf(contactId))
                        .get()
                        .get(0);

                newBilling = (Billing) new Billing()
                        .where("id", "=", String.valueOf(billingId))
                        .get()
                        .get(0);

                newLocation = (Location) new Location()
                        .where("id", "=", String.valueOf(billingId))
                        .get()
                        .get(0);

                try{
                    newContact.update(Map.ofEntries(
                            Map.entry("fullName", mainGui.getjTextFieldContactFullName().getText()),
                            Map.entry("email", mainGui.getjTextFieldContactEmail().getText())
                    ));

                    newBilling.update(Map.ofEntries(
                            Map.entry("ownerName", mainGui.getjTextFieldBillingOwnerName().getText()),
                            Map.entry("creditCardNum", mainGui.getjTextFieldBillingCardNumber().getText()),
                            Map.entry("billingAddress", mainGui.getjTextFieldBillingAddress().getText()),
                            Map.entry("CVC", mainGui.getjTextFieldBillingCVC().getText()),
                            Map.entry("expireDate", String.valueOf(mainGui.getjDateChooserExpirationDate().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
                    ));

                    newLocation.update(Map.ofEntries(
                            Map.entry("city", mainGui.getjTextFieldContactCity().getText()),
                            Map.entry("street", mainGui.getjTextFieldContactStreet().getText()),
                            Map.entry("zip", String.valueOf(mainGui.getjTextFieldContactZip().getText())
                    )));
                }
                catch (NumberFormatException nfe) {
                    JOptionPane jopMessage = new JOptionPane();
                    jopMessage.showMessageDialog(jopMessage, "Information incorrectly formed at: "+nfe.getLocalizedMessage());
                }

            // if contact and billing info doesn't exist
            // create new
            }else{
                newContact = new Contact();
                newBilling = new Billing();
                newLocation = new Location();
                boolean save = true;

                try{
                    newLocation.create(Map.ofEntries(
                            Map.entry("city", mainGui.getjTextFieldContactCity().getText()),
                            Map.entry("street", mainGui.getjTextFieldContactStreet().getText()),
                            Map.entry("zip", String.valueOf(mainGui.getjTextFieldContactZip().getText())
                            )));
                }
                catch (NumberFormatException nfe) {
                    JOptionPane jopMessage = new JOptionPane();
                    jopMessage.showMessageDialog(jopMessage, "Location information incorrectly formed at: "+nfe.getLocalizedMessage());
                    save = false;
                }

                try{
                    newContact.create(Map.ofEntries(
                            Map.entry("locationId", String.valueOf(newLocation.getId())),
                            Map.entry("fullName", mainGui.getjTextFieldContactFullName().getText()),
                            Map.entry("phone", "123455667"),
                            Map.entry("email", mainGui.getjTextFieldContactEmail().getText())
                    ));
                }
                catch (NumberFormatException nfe) {
                    JOptionPane jopMessage = new JOptionPane();
                    jopMessage.showMessageDialog(jopMessage, "Contact information incorrectly formed at: "+nfe.getLocalizedMessage());
                    save = false;
                }
                catch(Exception e) {
                    JOptionPane jopMessage = new JOptionPane();
                    jopMessage.showMessageDialog(jopMessage, "Contact information incorrectly formed.");
                    save = false;
                }
                try {
                    newBilling.create(Map.ofEntries(
                            Map.entry("ownerName", mainGui.getjTextFieldBillingOwnerName().getText()),
                            Map.entry("creditCardNum", mainGui.getjTextFieldBillingCardNumber().getText()),
                            Map.entry("billingAddress", mainGui.getjTextFieldBillingAddress().getText()),
                            Map.entry("CVC", mainGui.getjTextFieldBillingCVC().getText()),
                            Map.entry("expireDate", String.valueOf(mainGui.getjDateChooserExpirationDate().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
                    ));
                }
                catch (NumberFormatException nfe) {
                    JOptionPane jopMessage = new JOptionPane();
                    jopMessage.showMessageDialog(jopMessage, "Billing information incorrectly formed at: "+nfe.getLocalizedMessage());
                    save = false;
                }
                catch (NullPointerException npe) {
                    JOptionPane jopMessage = new JOptionPane();
                    jopMessage.showMessageDialog(jopMessage, "Please choose the correct expiry date of credit card.");
                    save = false;
                }

                if(save) currentUser.update((Map.ofEntries(
                        Map.entry("contactId", String.valueOf(newContact.getId())),
                        Map.entry("billingId", String.valueOf(newBilling.getId()))
                )));
            }
        }
    }

    /**
     * Inner class listener for the reserve button on the main GUI for the Reserve button,
     * splits the full name into a first name and last name and set the text from the database
     * into the ReserveGUI components, as well as confirm the reservation by sending it to the database,
     * also checks if a reservation already exists and sends the reservation to the database
     */
    class ReserveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {

            if (!Auth.checkPermission(ae.getActionCommand())) return;

            if(currentUser.getContactId() != -1) {

                reserveGui = new ReserveGUI();
                reserveGui.setVisible(true);

                currentUser = Auth.getUser();

                Contact contact = (Contact) new Contact()
                        .select(new String[]{"fullName", "email"})
                        .where("id", "=", String.valueOf(currentUser.getContactId()))
                        .get().get(0);

                String[] name = contact.getFullName().split(" ");
                String firstName = "";
                String lastName = "";
                if(name.length > 1) {
                     firstName = name[0];
                     lastName = name[1];
                }
                else{
                    firstName = name[0];
                }

                reserveGui.getJlFistName().setText(firstName);
                reserveGui.getJlLastName().setText(lastName);
                reserveGui.getJlEmail().setText(contact.getEmail());

                reserveGui.getJlPropertyName().setText(reserveGui.getJlPropertyName().getText() + getProperty(currentIndexRent).getPropertyName());
                reserveGui.getJlLocation().setText(reserveGui.getJlLocation().getText() + locations.get(properties.get(currentIndexRent).getLocationId() - 1).getCity());
                reserveGui.getJlPropertyType().setText(reserveGui.getJlPropertyType().getText() + propertyTypes.get(properties.get(currentIndexRent).getPropertyTypeId() - 1).getType());
                reserveGui.getJlPricePerNight().setText(reserveGui.getJlPricePerNight().getText() + getProperty(currentIndexRent).getPricePerNight());


                reserveGui.getjButtonConfirmReservation().addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(reserveGui.getjDateChooserArrival().getDate() == null || reserveGui.getjDateChooserDeparture().getDate() == null){
                                    JOptionPane jopMessage = new JOptionPane();
                                    jopMessage.showMessageDialog(reserveGui, "Please select the dates.");
                                    return;
                                }

                                ArrayList<Reservations> checkReservation = new Reservations()
                                        .select(new String[]{"userId", "propertyId", "arrivalDate", "price"})
                                        .where("userId", "=", String.valueOf(currentUser.getId()))
                                        .where("propertyId", "=", String.valueOf(properties.get(currentIndexRent).getId()))
                                        .where("arrivalDate", "=",String.valueOf(reserveGui.getjDateChooserArrival().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
                                        .where("departureDate", "=", String.valueOf(reserveGui.getjDateChooserDeparture().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
                                        .get();

                                if(!checkReservation.isEmpty()){
                                    JOptionPane jopMessage = new JOptionPane();
                                    jopMessage.showMessageDialog(reserveGui, "Reservation already exists.");
                                    return;
                                }


                                Reservations reservation = new Reservations().create(Map.ofEntries(
                                        Map.entry("userId", String.valueOf(currentUser.getId())),
                                        Map.entry("propertyId", String.valueOf(properties.get(currentIndexRent).getId())),
                                        Map.entry("arrivalDate", String.valueOf(reserveGui.getjDateChooserArrival().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())),
                                        Map.entry("departureDate", String.valueOf(reserveGui.getjDateChooserDeparture().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())),
                                        Map.entry("price", Double.toString(properties.get(currentIndexRent).getPricePerNight()))));

                               confirmationGUI.setVisible(true);
                            }
                        });
            }else{
                JOptionPane jopMessage = new JOptionPane();
                jopMessage.showMessageDialog(mainGui, "Your contact and billing information are not defined. Please go to 'Settings' and set your information in order to make a reservation.");
            }
        }
    }


    /**
     * Inner class export listener which communicates with the ConfirmationGUI and its' button,
     * generates a new pdf documents with the provided information and disposes the ReserveGUI
     */
    class ExportListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Auth.checkPermission(confirmationGUI.getExportButton().getActionCommand())) return;

                SimpleDateFormat sdFormat = new SimpleDateFormat("YYYY-MM-dd");
                String fName = reserveGui.getJlFistName().getText();
                String lName = reserveGui.getJlLastName().getText();
                String email = reserveGui.getJlEmail().getText();
                String propertyName = reserveGui.getJlPropertyName().getText();
                String location = reserveGui.getJlLocation().getText();
                String arrivalDate = sdFormat.format(reserveGui.getjDateChooserArrival().getDate());
                String departureDate = sdFormat.format(reserveGui.getjDateChooserDeparture().getDate());

                reserveGui.dispose();

                 confirmationGUI.generatePDFConfirmation(fName + " " + lName, email, propertyName, location, arrivalDate, departureDate);
            }

    }

    /**
     * Inner class for the search button listener, dynamically creates properties into the GUI withing a for loop
     * through all properties, creates panels using methods provided by the GUI class createSearchResultPanel, and getters
     */
        class SearchListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Auth.checkPermission(e.getActionCommand()) && guest == false) return;

                //store prev size to remove for next search results
                int prevSize = 0;
                if (mainGui.getSearchResultPanels() != null) {
                    prevSize = mainGui.getSearchResultPanels().size();
                }

                String givenPropertyLocation = mainGui.getjTextField2().getText();

                String priceAscDesc = mainGui.getjComboBox1().getSelectedItem().toString();
                String orderBy = "";

                if (priceAscDesc.equals("Price (ascending)")) {
                    orderBy = "ASC";
                } else {
                    orderBy = "DESC";
                }

                locations.clear();
                locations = new Location()
                        .select(new String[]{"id", "city", "zip", "street"})
                        .where("city", "=", givenPropertyLocation)
                        .get();

                if (locations.isEmpty()) {
                    JOptionPane jopMessage = new JOptionPane();
                    jopMessage.showMessageDialog(mainGui, "No properties found on location: " + givenPropertyLocation + ".");
                }

                properties.clear();

                ArrayList<Property> tempProperty = new ArrayList<>();
                for (Location location : locations) {
                    tempProperty = new Property()
                            .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId", "propertyTypeId", "bedrooms", "size"})
                            .where("locationId", "=", String.valueOf(location.getId()))
                            //.orderBy(new String[]{"pricePerNight"}, orderBy)
                            .get();

                    if(tempProperty.isEmpty()){
                        break;
                    }

                    properties.add((Property) tempProperty.get(0));
                    tempProperty.clear();
                }

                if (properties.isEmpty() && !locations.isEmpty()) {
                    JOptionPane jopMessage = new JOptionPane();
                    jopMessage.showMessageDialog(mainGui, "No properties found on location: " + givenPropertyLocation + ".");
                }

                //Order by doesn't work here due to multiple queries combined to single list
                if (orderBy.equals("ASC")) Collections.sort(properties);
                else Collections.sort(properties, Collections.reverseOrder());

                // DYNAMIC RESULT PANELS
                for (int i = 0; i < properties.size(); i++) {
                    //generate panels based on results
                    mainGui.createSearchResultPanel(i);

                    //make visible
                    mainGui.resetSearchResultPanels(i, true);

                    //set text and image
                    mainGui.getSearchResultNameLabel().get(i).setText(properties.get(i).getPropertyName());
                    //mainGui.getSearchResultLocationLabel().get(i).setText(locations.get(properties.get(i).getLocationId() - 1).getCity());
                    mainGui.getSearchResultLocationLabel().get(i).setText(locations.get(i).getCity());
                    mainGui.getSearchResultPriceLabel().get(i).setText(String.valueOf(properties.get(i).getPricePerNight()));
                    mainGui.getSearchResultImageLabel().get(i).setText("");
                    mainGui.getSearchResultImageLabel().get(i).setIcon(mainGui.bufferImageIcon(mainGui.createURL(properties.get(i).getImagePath()), 500, 450));
                }
                //size with new and previous elements
                int currentSize = 0;
                if(mainGui.getSearchResultPanels() !=null) {
                    currentSize = mainGui.getSearchResultPanels().size();
                }
                //remove previous elements if there are results
                if (!properties.isEmpty()) {
                    for (int i = mainGui.getSearchResultPanels().size() - 1; i > currentSize - prevSize - 1; i--) {
                        mainGui.removeSearchResultPanels(i);
                    }
                } else {
                    for (int i = currentSize - 1; i > -1; i--) {
                        //toggle invisible
                        mainGui.resetSearchResultPanels(i, false);
                    }
                }

                //group and attach generated panels to main search panel
                mainGui.attachSearchResultPanels();

            }
        }

    /**
     * Communicates with the main GUI presentation layer, mainly the MyRentals tab,
     * checks the authentication and the permission, indicating if the user can add a new property
     * to the database, gather information entered by the user and with proper validation adds
     * the property to the database
     */
    class AddPropertyListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Auth.checkPermission(e.getActionCommand())) return;

                ArrayList<JRadioButton> radioButtons = mainGui.getJRadioButtons();
                String propertyType = "";
                for (JRadioButton btn : radioButtons) {
                    if (btn.isSelected()) {
                        propertyType = btn.getText().toLowerCase();
                    }
                }
                if(propertyType.isBlank()) {
                    JOptionPane panel = new JOptionPane();
                    panel.showMessageDialog(mainGui, "Please select property type.");
                    return;
                }

                PropertyType type = (PropertyType) new PropertyType()
                        .select(new String[]{"id"})
                        .where("type", "like", propertyType)
                        .get().get(0);

                String propertyTypeId = String.valueOf(type.getId());

                String propertyName = mainGui.getjTextField13().getText();
                String street = mainGui.getjTextField14().getText();
                String numOfBedrooms = mainGui.getjTextField15().getText();
                String cityName = mainGui.getjTextField16().getText();
                String zip = mainGui.getjTextField17().getText();
                String pricePerNight = mainGui.getjTextField18().getText();
                String size = mainGui.getjTextField19().getText();
                String description = mainGui.getjTextField20().getText();
                String imageUrl = mainGui.getjTextField21().getText();

                String regex = "https?:/(?:/[^/]+)+\\.(?:jpg|gif|png)";

                Pattern pattern_name = Pattern.compile(regex);
                Matcher matcher_name = pattern_name.matcher(imageUrl);

                if(!matcher_name.find() || !mainGui.checkURL(imageUrl)) {
                    JOptionPane panel = new JOptionPane();
                    panel.showMessageDialog(mainGui, "Please enter valid image URL. \nSupported files are: .jpg, .gif & .png");
                    return;
                }

                Location location = null;
                try{
                    location = new Location().create(Map.ofEntries(
                            Map.entry("street", street),
                            Map.entry("city", cityName),
                            Map.entry("zip", zip)
                    ));
                }
                catch (NumberFormatException nfe) {
                    JOptionPane panel = new JOptionPane();
                    panel.showMessageDialog(mainGui, "Number incorrectly formed: " + nfe.getMessage());
                    return;
                }

                String id = String.valueOf(Auth.getUser().getId());

                Property property = null;
                try {
                    property = new Property().create(Map.ofEntries(
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
                }catch (NumberFormatException nfe) {
                    JOptionPane panel = new JOptionPane();
                    panel.showMessageDialog(mainGui, "Number incorrectly formed: " + nfe.getMessage());
                    return;
                }
                ArrayList<JCheckBox> checkBoxes = mainGui.getCheckBoxes();
                ArrayList<String> checkedFeatures = new ArrayList<>();
                for (JCheckBox box : checkBoxes) {
                    if (box.isSelected()) {
                        checkedFeatures.add(box.getText());
                    }
                }

                ArrayList<Feature> features = new ArrayList<>();

                for (String feature : checkedFeatures) {
                    Feature f = (Feature) new Feature().select(new String[]{"id"}).where("feature", "LIKE", feature).get().get(0);
                    features.add(f);
                }

                for (Feature feature : features) {
                    new FeatureProperty().create(Map.ofEntries(
                            Map.entry("propertyId", String.valueOf(property.getId())),
                            Map.entry("featureId", String.valueOf(feature.getId()))
                    ));
                }
                JOptionPane panel = new JOptionPane();
                panel.showMessageDialog(mainGui, "Property created succesfully!");

                properties = new Property()
                        .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId"})
                        .where("userId", "=", String.valueOf(id))
                        .get();

                mainGui.getjComboBox2().removeAllItems();
                for (Property prop : properties) {
                    mainGui.getjComboBox2().addItem(prop.getPropertyName());
                }
            }
        }

    /**
     * On change inner class listener which fills the jComboBox in the MyRentals tab once the user clicks on the tab,
     * once the user changes the jComboBox selected item, the displayMyRentalsSelect() method is called which sets the
     * properties owned by the user
     */
        class MyRentalsListener implements ChangeListener {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (!Auth.checkPermission(String.valueOf(mainGui.getjTabbedPane2().getSelectedIndex()))) return;
                if (mainGui.getjTabbedPane2().getSelectedIndex() == 2) {
                    int userId = Auth.getUser().getId();
                    if (!properties.isEmpty()) {
                        properties.clear();
                    }
                    properties = new Property()
                            .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId"})
                            .where("userId", "=", String.valueOf(userId))
                            .get();

                    mainGui.getjComboBox2().removeAllItems();
                    for (Property property : properties) {
                        mainGui.getjComboBox2().addItem(property.getPropertyName());
                    }
                    displayMyRentalsSelect();
                }
            }
        }

    /**
     * Inner item listener which displays rentals
     */
        class MyRentalsChangeListener implements ItemListener {
            @Override
            public void itemStateChanged(ItemEvent e) {
                displayMyRentalsSelect();
            }
        }

    /**
     * Method for fetching and creating a new object of the Property model using selectedItem property names
     */
        public void displayMyRentalsSelect() {
            if (mainGui.getjComboBox2().getSelectedItem() != null) {
                int userId = Auth.getUser().getId();
                Property property = (Property) new Property()
                        .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId"})
                        .where("userId", "=", String.valueOf(userId))
                        .where("propertyName", "LIKE", mainGui.getjComboBox2().getSelectedItem().toString())
                        .get().get(0);
                Location location = (Location) new Location()
                        .select(new String[]{"city"})
                        .where("id", "=", String.valueOf(property.getLocationId()))
                        .get().get(0);

                mainGui.getjLabelSearchInputName2().setText(property.getPropertyName());
                mainGui.getjLabelSearchLocation2().setText(location.getCity());
                mainGui.getjLabelSearchPrice2().setText(String.valueOf(property.getPricePerNight()));
                mainGui.getjLabel42().setText("");
                mainGui.getjLabel42().setIcon(mainGui.bufferImageIcon(mainGui.createURL(property.getImagePath()), 500, 450));
            } else return;
        }

    /**
     * Inner class which implements an action listener waiting for the Delete button on the MyRentals tab to be clicked.
     * Deletes the property with the currently selectedItem propertyName updates
     */
        class DeleteMyRentalsListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Auth.checkPermission(e.getActionCommand())) return;
                if (mainGui.getjComboBox2().getSelectedItem() != null) {

                    int userId = Auth.getUser().getId();
                    Property property = (Property) new Property()
                            .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId"})
                            .where("userId", "=", String.valueOf(userId))
                            .where("propertyName", "LIKE", mainGui.getjComboBox2().getSelectedItem().toString())
                            .get().get(0);
                    property.delete();

                    getProperty(currentIndex);

                    if (!properties.isEmpty()) {
                        properties.clear();
                    }
                    properties = new Property()
                            .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId"})
                            .where("userId", "=", String.valueOf(userId))
                            .get();

                    mainGui.getjComboBox2().removeAllItems();
                    for (Property prop : properties) {
                        mainGui.getjComboBox2().addItem(prop.getPropertyName());
                    }

                    displayFavorites();

                } else return;
            }
        }

    /**
     * Inner class implementing a change listener, once the FAVORITES tab is clicked,
     * calls the method displayFavorites() which fill the GUI
     */
        class FavoritesListener implements ChangeListener {
            @Override
            public void stateChanged(ChangeEvent e) {
                displayFavorites();
            }
        }

    /**
     * Inner class implementing an item listener, and displaying favorites depending on the
     * item selected in the jComboBox
     */
        class SelectChangeListener implements ItemListener {
            @Override
            public void itemStateChanged(ItemEvent e) {
                displayFavorites();
            }
        }

    /**
     * Inner class implementing an action listener and responsible for removing a favorite from the FAVORITES tab
     */
        class RemoveFavoriteListener implements ActionListener {
            private Favorite favorite = null;
            public RemoveFavoriteListener(Favorite _favorite) {
                this.favorite = _favorite;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                favorite.delete();
                displayFavorites();
            }
        }

    /**
     * Method responsible for displaying favorite properties of the user if the tab selected is FAVORITES
     * creates panels dynamically by calling methods from the main GUI class
     */
        public void displayFavorites() {
            if (!Auth.checkPermission(String.valueOf(mainGui.getjTabbedPane2().getSelectedIndex()))) return;
            //store prev size to remove for next search results
            int prevSize = 0;
            if (mainGui.getFavoritesResultPanels() != null) {
                prevSize = mainGui.getFavoritesResultPanels().size();
            }

            int id = Auth.getUser().getId();

            if (mainGui.getjTabbedPane2().getSelectedIndex() == 3) {
                favorites = new Favorite()
                        .select(new String[]{"id", "userId", "propertyId"})
                        .where("userId", "=", String.valueOf(id))
                        .get();

                if (favorites.isEmpty()) {
                    JOptionPane jopMessage = new JOptionPane();
                    jopMessage.showMessageDialog(mainGui, "No favorites found.");
                }

                ArrayList<Property> tempProperties = new ArrayList<>();
                properties.clear();
                for (Favorite favorite : favorites) {
                    tempProperties = new Property()
                            .select(new String[]{"id", "propertyName", "description", "pricePerNight", "imagePath", "locationId", "propertyTypeId", "bedrooms", "size"})
                            .where("id", "=", String.valueOf(favorite.getPropertyId()))
                            .get();
                    properties.add(tempProperties.get(0));
                    tempProperties.clear();
                }

                if (properties.isEmpty() && !favorites.isEmpty()) {
                    JOptionPane jopMessage = new JOptionPane();
                    jopMessage.showMessageDialog(mainGui, "No favorites found.");
                    return;
                }

                String priceAscDesc = mainGui.getjComboBox3().getSelectedItem().toString();
                String orderBy = "";

                if (priceAscDesc.equals("Price (ascending)")) {
                    orderBy = "ASC";
                } else {
                    orderBy = "DESC";
                }

                //Order by doesn't work here due to multiple queries combined to single list
                if (orderBy.equals("ASC")) Collections.sort(properties);
                else Collections.sort(properties, Collections.reverseOrder());

                locations.clear();
                for (Property property : properties) {
                    locations.add((Location) new Location()
                            .select(new String[]{"id", "city"})
                            .where("id", "=", String.valueOf(property.getLocationId()))
                            .get().get(0));
                }

                for (int i = 0; i < properties.size(); i++) {
                    //generate panels based on results
                    mainGui.createFavoritesResultPanel(i);

                    //make visible
                    mainGui.resetFavoritesResultPanels(i, true);

                    //set text and image
                    mainGui.getFavoritesResultNameLabel().get(i).setText(properties.get(i).getPropertyName());
                    //mainGui.getSearchResultLocationLabel().get(i).setText(locations.get(properties.get(i).getLocationId() - 1).getCity());
                    mainGui.getFavoritesResultLocationLabel().get(i).setText(locations.get(i).getCity());
                    mainGui.getFavoritesResultPriceLabel().get(i).setText(String.valueOf(properties.get(i).getPricePerNight()));
                    mainGui.getFavoritesResultImageLabel().get(i).setText("");
                    mainGui.getFavoritesResultImageLabel().get(i).setIcon(mainGui.bufferImageIcon(mainGui.createURL(properties.get(i).getImagePath()), 500, 450));
                    mainGui.getFavoritesRemoveFavoritesButton().get(i).addActionListener(new RemoveFavoriteListener((Favorite) new Favorite().select(new String[]{"id"}).where("propertyId", "=", String.valueOf(properties.get(i).getId())).get().get(0)));
                }
                if(mainGui.getFavoritesResultPanels() != null) {
                    //size with new and previous elements
                    int currentSize = mainGui.getFavoritesResultPanels().size();

                    //remove previous elements if there are results
                    if (!properties.isEmpty()) {
                        for (int i = mainGui.getFavoritesResultPanels().size() - 1; i > currentSize - prevSize - 1; i--) {
                            mainGui.removeFavoritesResultPanels(i);
                        }
                    } else {
                        for (int i = currentSize - 1; i > -1; i--) {
                            //toggle invisible
                            mainGui.resetFavoritesResultPanels(i, false);
                        }
                    }

                    //group and attach generated panels to main search panel
                    mainGui.attachFavoritesResultPanels();

                }
            }
        }
    }
