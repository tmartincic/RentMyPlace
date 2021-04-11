package edu.rit.iste330.team7.RentMyPlace.controller;

import edu.rit.iste330.team7.RentMyPlace.model.User;
import edu.rit.iste330.team7.RentMyPlace.view.GUI;
import edu.rit.iste330.team7.RentMyPlace.model.Model;
import edu.rit.iste330.team7.RentMyPlace.view.LoginGUI;
import java.awt.event.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RentMyPlaceController {
    LoginGUI gui;
    Model model;
    GUI mainGui = new GUI();
    public RentMyPlaceController(LoginGUI gui, Model model){
        this.gui = gui;
        this.model = model;

        gui.setVisible(true);
        gui.addLoginListener(new LoginListener());
        gui.addGuestListener(new GuestUserListener());
    }

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
        if(user.getUserType().equals("u")){
            System.out.println("User");
        }
        else if(user.getUserType().equals("a")){
            System.out.println("Admin");
        }

        return true;
    }

    class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean authenticated = false;
            authenticated = checkUser(gui.getjTextField1().getText(), gui.getjPasswordField1().getText());
            if(authenticated){
                JOptionPane jopMessage = new JOptionPane();
                jopMessage.showMessageDialog(gui, "Log in successful.");
                gui.dispose();
                mainGui.setVisible(true);
            }
            else{
                JOptionPane jopMessage = new JOptionPane();
                jopMessage.showMessageDialog(gui, "Try again.");
            }
        }
    }

    class GuestUserListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
        System.out.println("Guest");
        gui.dispose();
        mainGui.setVisible(true);

        mainGui.getjTabbedPane2().setEnabledAt(2,false);
        mainGui.getjTabbedPane2().setEnabledAt(3,false);
        mainGui.getjTabbedPane2().setEnabledAt(4,false);
        }
    }
}
