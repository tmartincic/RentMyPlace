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
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RentMyPlaceController {
    User currentUser = null;
    int currentIndex = 0;
    ArrayList<Property> properties = null;
    ArrayList<Location> locations = null;
    ArrayList<Feature> features = null;
    ArrayList<FeatureProperty> featureProperty = null;
    ArrayList<PropertyType> propertyTypes = null;
    ArrayList<Contact> contacts = null;
    ArrayList<Billing> billings = null;
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
        mainGui.addAddFavoritesEventListener(new AddToFavoritesListener());
        mainGui.addDeletePropertyFromMyRentalsListener(new DeleteMyRentalsListener());

        mainGui.getjTabbedPane2().addChangeListener(new FavoritesListener());
        mainGui.getjTabbedPane2().addChangeListener(new MyRentalsListener());
        mainGui.getjTabbedPane2().addChangeListener(new SettingListener());

        mainGui.getjComboBox3().addItemListener(new SelectChangeListener());
        mainGui.getjComboBox2().addItemListener(new MyRentalsChangeListener());

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

    class LogOutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            gui.setVisible(true);
            mainGui.dispose();

            mainGui.getjTabbedPane2().setSelectedComponent(mainGui.getjPanelRent());

            gui.getjPasswordField1().setText("");
            gui.getjTextField1().setText("");

            Auth.logToken("");
            currentIndex = 0;
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

    class AddToFavoritesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!Auth.checkPermission(e.getActionCommand())) return;

            getProperty(currentIndex);

            int userId = Auth.getUser().getId();
            Property property = properties.get(currentIndex);
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

            System.out.println("User id = " + userId + " propertyId = " + propertyId);
            System.out.println(new Favorite().create(Map.ofEntries(
                    Map.entry("userId", String.valueOf(userId)),
                    Map.entry("propertyId", String.valueOf(propertyId))
                    )
            ));
        }
    }

    class MorePropertyDetailsActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {

            if (!Auth.checkPermission(ae.getActionCommand()) && guest == false) return;

            int index = currentIndex;

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

    class SettingListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            if (!Auth.checkPermission(String.valueOf(mainGui.getjTabbedPane2().getSelectedIndex()))) return;

            if (mainGui.getjTabbedPane2().getSelectedIndex() == 4) {
                int userId = Auth.getUser().getId();

                int contactId = Auth.getUser().getContactId();

                contacts = new Contact()
                        .select(new String[]{"id", "fullName", "email", "phone", "locationId"})
                        .where("id", "=", String.valueOf(contactId))
                        .get();

                int billingId = Auth.getUser().getBillingId();

                billings = new Billing()
                        .select(new String[]{"id", "billingAddress", "creditCardNum", "CVC", "expireDate", "ownerName"})
                        .where("id", "=", String.valueOf(billingId))
                        .get();
                if(contactId != -1) {
                    mainGui.getjTextFieldContactFullName().setText(contacts.get(0).getFullName());
                    mainGui.getjTextFieldContactEmail().setText(contacts.get(0).getEmail());
                    mainGui.getjTextFieldContactStreet().setText(locations.get(0).getStreet());
                    mainGui.getjTextFieldContactCity().setText(locations.get(0).getCity());
                    mainGui.getjTextFieldContactZip().setText(String.valueOf(locations.get(0).getZip()));
                }
                if(billingId != -1) {
                    mainGui.getjTextFieldBillingOwnerName().setText(billings.get(0).getOwnerName());
                    mainGui.getjTextFieldBillingCardNumber().setText(billings.get(0).getCreditCardNum());
                    mainGui.getjTextFieldBillingAddress().setText(billings.get(0).getBillingAddress());
                    mainGui.getjTextFieldBillingCVC().setText(billings.get(0).getCVC());
                    mainGui.getjDateChooserExpirationDate().setDate(billings.get(0).getExpireDate());
                }
            }
        }
    }

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


            // if contact and billing info doesn't exist
            // create new
            }else{
                newContact = new Contact();
                newBilling = new Billing();
                newLocation = new Location();


                newLocation.create(Map.ofEntries(
                        Map.entry("city", mainGui.getjTextFieldContactCity().getText()),
                        Map.entry("street", mainGui.getjTextFieldContactStreet().getText()),
                        Map.entry("zip", String.valueOf(mainGui.getjTextFieldContactZip().getText())
                        )));


                newContact.create(Map.ofEntries(
                        Map.entry("locationId", String.valueOf(newLocation.getId())),
                        Map.entry("fullName", mainGui.getjTextFieldContactFullName().getText()),
                        Map.entry("phone", "123455667"),
                        Map.entry("email", mainGui.getjTextFieldContactEmail().getText())
                ));

                newBilling.create(Map.ofEntries(
                        Map.entry("ownerName", mainGui.getjTextFieldBillingOwnerName().getText()),
                        Map.entry("creditCardNum", mainGui.getjTextFieldBillingCardNumber().getText()),
                        Map.entry("billingAddress", mainGui.getjTextFieldBillingAddress().getText()),
                        Map.entry("CVC", mainGui.getjTextFieldBillingCVC().getText()),
                        Map.entry("expireDate", String.valueOf(mainGui.getjDateChooserExpirationDate().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
                ));

                currentUser.update((Map.ofEntries(
                        Map.entry("contactId", String.valueOf(newContact.getId())),
                        Map.entry("billingId", String.valueOf(newBilling.getId()))
                )));
            }
        }
    }

    class ReserveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {

            if (!Auth.checkPermission(ae.getActionCommand())) return;

            if(currentUser.getContactId() != -1) {

                ReserveGUI reserveGui = new ReserveGUI();
                reserveGui.setVisible(true);

                User currentUser = Auth.getUser();

                Contact contact = (Contact) new Contact()
                        .select(new String[]{"fullName", "email"})
                        .where("id", "=", String.valueOf(currentUser.getContactId()))
                        .get().get(0);

                String[] name = contact.getFullName().split(" ");
                String firstName = name[0];
                String lastName = name[1];

                reserveGui.getJlFistName().setText(firstName);
                reserveGui.getJlLastName().setText(lastName);
                reserveGui.getJlEmail().setText(contact.getEmail());

                reserveGui.getJlPropertyName().setText(reserveGui.getJlPropertyName().getText() + getProperty(currentIndex).getPropertyName());
                reserveGui.getJlLocation().setText(reserveGui.getJlLocation().getText() + locations.get(properties.get(currentIndex).getLocationId() - 1).getCity());
                reserveGui.getJlPropertyType().setText(reserveGui.getJlPropertyType().getText() + propertyTypes.get(properties.get(currentIndex).getPropertyTypeId() - 1).getType());
                reserveGui.getJlPricePerNight().setText(reserveGui.getJlPricePerNight().getText() + getProperty(currentIndex).getPricePerNight());


                reserveGui.getjButtonConfirmReservation().addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Reservations reservation = new Reservations().create(Map.ofEntries(
                                        Map.entry("userId", String.valueOf(currentUser.getId())),
                                        Map.entry("propertyId", String.valueOf(properties.get(currentIndex).getId())),
                                        Map.entry("arrivalDate", String.valueOf(reserveGui.getjDateChooserArrival().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())),
                                        Map.entry("departureDate", String.valueOf(reserveGui.getjDateChooserDeparture().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())),
                                        Map.entry("price", Double.toString(properties.get(currentIndex).getPricePerNight()))));
                            }
                        });
            }else{

            }
        }
    }

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
                //System.out.println(givenPropertyLocation);

                String priceAscDesc = mainGui.getjComboBox1().getSelectedItem().toString();
                String orderBy = "";

                if (priceAscDesc.equals("Price (ascending)")) {
                    orderBy = "ASC";
                } else {
                    orderBy = "DESC";
                }
                //System.out.println(priceAscDesc);

                locations.clear();
                locations = new Location()
                        .select(new String[]{"id", "city", "zip", "street"})
                        .where("city", "=", givenPropertyLocation)
                        .get();

                if (locations.isEmpty()) {
                    // System.out.println("No such property");
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

/////////////////////////////////////////////////////////////////  DYNAMIC RESULT PANELS
                for (int i = 0; i < properties.size(); i++) {
                    //generate panels based on results
                    mainGui.createSearchResultPanel(i);

                    //make visible
                    mainGui.resetSearchResultPanels(i, true);

                    //System.out.println(properties.get(i).getPropertyName());

                    //set text and image
                    mainGui.getSearchResultNameLabel().get(i).setText(properties.get(i).getPropertyName());
                    //mainGui.getSearchResultLocationLabel().get(i).setText(locations.get(properties.get(i).getLocationId() - 1).getCity());
                    mainGui.getSearchResultLocationLabel().get(i).setText(locations.get(i).getCity());
                    mainGui.getSearchResultPriceLabel().get(i).setText(String.valueOf(properties.get(i).getPricePerNight()));
                    mainGui.getSearchResultImageLabel().get(i).setText("");
                    mainGui.getSearchResultImageLabel().get(i).setIcon(mainGui.bufferImageIcon(mainGui.createURL(properties.get(i).getImagePath()), 500, 450));
                }
                //size with new and previous elements
                int currentSize = mainGui.getSearchResultPanels().size();

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

//////////////////////////////////////////////////////////////// END DYNAMIC PANELS

            }
        }

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
                    System.out.println("Please select property type.");
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
                    System.out.println("Please enter valid image URL. \nSupported files are: .jpg, .gif & .png");
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
                    System.out.println("Number incorrectly formed: " + nfe.getMessage());
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
                    System.out.println("Number incorrectly formed: " + nfe.getMessage());
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
            }
        }

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

        class MyRentalsChangeListener implements ItemListener {
            @Override
            public void itemStateChanged(ItemEvent e) {
                displayMyRentalsSelect();
            }
        }

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
                    displayFavorites();
                } else return;
            }
        }

        class FavoritesListener implements ChangeListener {
            @Override
            public void stateChanged(ChangeEvent e) {
                displayFavorites();
            }
        }

        class SelectChangeListener implements ItemListener {
            @Override
            public void itemStateChanged(ItemEvent e) {
                displayFavorites();
            }
        }

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
                    System.out.println(property.toString());
                    locations.add((Location) new Location()
                            .select(new String[]{"id", "city"})
                            .where("id", "=", String.valueOf(property.getLocationId()))
                            .get().get(0));
                }

//////////////////////////////////////////////////////////////////////
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
