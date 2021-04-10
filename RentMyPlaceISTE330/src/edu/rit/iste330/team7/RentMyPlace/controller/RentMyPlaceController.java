package edu.rit.iste330.team7.RentMyPlace.controller;

import edu.rit.iste330.team7.RentMyPlace.model.User;
import edu.rit.iste330.team7.RentMyPlace.view.GUI;

import javax.swing.*;
import java.util.ArrayList;

public class RentMyPlaceController {
    /*edu.rit.iste330.team7.RentMyPlace.view.LoginGUI gui;
    edu.rit.iste330.team7.RentMyPlace.model.Model model;
    public edu.rit.iste330.team7.RentMyPlace.controller.RentMyPlaceController(edu.rit.iste330.team7.RentMyPlace.view.LoginGUI gui, edu.rit.iste330.team7.RentMyPlace.model.Model model){
        this.gui = gui;
        this.model = model;
    }*/

    public RentMyPlaceController(){}

    public boolean checkUser(String userName, String password){
        boolean authenticated = false;
        ArrayList<User> all_users = new User()
                .select(new String[]{"id", "username", "password", "userType", "contactId", "billingId"})
                .get();
        for (User user : all_users) {
            if(user.authenticate(userName, password)) {
                System.out.println("edu.rit.iste330.team7.RentMyPlace.model.User found: " + user.toString());
                authenticated = true;
                this.autorization(user);
                break;
            }
        }
        return authenticated;
    }

    public boolean autorization(User user){
        if(user.getUserType().equals("g")){
            System.out.println("Guest");
            GUI gui = new GUI();
            gui.setVisible(true);

            gui.getjTabbedPane2().setEnabledAt(2,false);
            gui.getjTabbedPane2().setEnabledAt(3,false);
            gui.getjTabbedPane2().setEnabledAt(4,false);
        }
        else if(user.getUserType().equals("u")){
            System.out.println("User");
            GUI gui = new GUI();
            gui.setVisible(true);
        }
        else if(user.getUserType().equals("a")){
            System.out.println("Admin");
            GUI gui = new GUI();
            gui.setVisible(true);
        }

        return true;
    }
}
