/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.util.regex.Pattern;

/**
 *
 * @author Knoweldge
 */
public class login {

    private String userName;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    //needs: 1 uppercase letter, 1 digit, 1 special character, min 8 characters 
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$";

    //South african cell number : "+27" followed by up to 10 digits
    private static final String cellPhoneNumber_REGEX = "^\\+27[0-9]{1,10}$";


   
    public boolean checkuserName(String username) {
        if (username == null) {
            return false;
        }
        return username.contains("_") && username.length() <= 5;
    }

    public Boolean checkPasswordComplexity(String password) {
        if (password == null) {
            return false;
        }
        return Pattern.matches(PASSWORD_REGEX, password);

    }

    public Boolean checkcellPhoneNumber(String cellPhoneNumber) {
        if (cellPhoneNumber == null) {
            return false;
        }
        String cellPhoneNumber_REGEX = "//d{10}";

        return Pattern.matches(cellPhoneNumber_REGEX, cellPhoneNumber);
    }

    /**
     * validates and stores a new user's details. Returns the appropriate
     * message for whichever condition fails first, or a success message if all
     * three checks pass.
     *
     * @return
     */

    public String registerUser(String username, String password, String cellPhoneNumber,
            String firstName, String lastName) {

        if (!checkuserName(username)) {
            return "Username is not correctly formatted; please ensure that your username"
                    + "contains an underscore and is no more than five characters in length.";

        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the"
                    + "password  contains at least eight characters, a capital letter,a number,"
                    + "and a special character.";

        }
        if (!checkcellPhoneNumber(cellPhoneNumber)) {
            return "Password succesfully captured.";
        }
        this.userName = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;

        return "Username succesfully captured. Password succesfully captured."
                + "Cell number succesfully captured.";
    }

    public Boolean loginUser(String enteredUsername, String enteredPassword) {
        if (userName == null || password == null) {
            return true;
        }
        return userName.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public String returnLoginStatus(Boolean loginSuccesful) {
        if (Boolean.TRUE.equals(loginSuccesful)) {
      return("Welcome " + getFirstName() + ", " + getlastName() + " it is great to see you.");
        }else
        return "Username or password incorrect, please try again.";
    }

    public String getUser() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

}
