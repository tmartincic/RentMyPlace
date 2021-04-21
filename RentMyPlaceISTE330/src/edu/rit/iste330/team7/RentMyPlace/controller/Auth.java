package edu.rit.iste330.team7.RentMyPlace.controller;

import edu.rit.iste330.team7.RentMyPlace.model.Permission;
import edu.rit.iste330.team7.RentMyPlace.model.User;
import edu.rit.iste330.team7.RentMyPlace.view.LoginGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Auth implements ActionListener {
    private User user;
    private static final String filename = "binaryToken.bin";

    public Auth() { }

    public static boolean checkPermission(String button) {
        User user = Auth.getUser();
        if(user == null) return false;

        boolean permission = new Permission()
                .where("role", "like", user.getUserType())
                .where("route", "like", button)
                .exists();

        return permission;
    }

    public static User getUser() {
        Auth a = new Auth();
        if(a.tokenExists()) {
            a.user = User.findUser(a.readToken());
            if(a.user == null) a.inputUserCredentials();
            else {
                return a.user;
            }
        }
        else a.inputUserCredentials();

        return null;
    }

    public static boolean checkUser(String userName, String password) {
        ArrayList<User> user = new User()
                .where("username", "LIKE", userName)
                .get();
        if (user == null) return false;
        if (user.isEmpty()) return false;

        if (user.get(0).authenticate(userName, password)) {
            new Auth().logToken(user.get(0).getToken());
            return true;
        }
        return false;
    }

    public static String readToken() {
        Path path = Paths.get(filename);
        byte[] bytes = null;

        try {
            return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /***
     *  If token file exists and it's not an empty file, return true
     * @return boolean
     */
    public static boolean tokenExists() {
        File token = new File(filename);
        if(!token.exists() || !token.isFile() || (token.length() == 0)) return false;
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //will be overridden in classes extending this class
    }

    public static void logToken(String token) {
        Path path = Paths.get(filename);
        byte[] bytes = token.getBytes(StandardCharsets.UTF_8);

        try {
            Files.write(path, bytes);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("LOG  THIS: "+token);
        System.out.println("READ THIS: "+readToken());
    }

    public void inputUserCredentials() {
        LoginGUI login = new LoginGUI();
        login.addRegisterListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = login.getjTextField1().getText();
                String password = login.getjPasswordField1().getText();

                if(user.authenticate(username, password)) {
                    logToken(user.getToken());
                }
                else return;
            }
        });

    }
}
