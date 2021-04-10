package edu.rit.iste330.team7.RentMyPlace.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Authentication {
    public static String convert(String password){
        byte[] data = password.getBytes();
        byte[] digest = null;
        StringBuilder sb = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            digest = messageDigest.digest(data);
            //https://stackoverflow.com/questions/39809924/how-do-i-use-md5-to-convert-passwords-and-check-a-users-credentials-against-val
            sb = new StringBuilder(32);
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
