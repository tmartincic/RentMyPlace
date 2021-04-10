package edu.rit.iste330.team7.RentMyPlace.controller;

import edu.rit.iste330.team7.RentMyPlace.model.User;

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
                .select(new String[]{"id", "username", "password"})
                .get();
        for (User user : all_users) {
            if(user.authenticate(userName, password)) {
                System.out.println("edu.rit.iste330.team7.RentMyPlace.model.User found: " + user.toString());
                authenticated = true;
                break;
            }
        }
        return authenticated;
    }
}
