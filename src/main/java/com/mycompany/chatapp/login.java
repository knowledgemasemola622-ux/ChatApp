/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.util.regex.Pattern;

public class login {

    private String userName;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Password must have:
    // At least 8 characters
    // One capital letter
    // One number
    // One special character
    private static final String PASSWORD_REGEX =
            "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$";

    // South African cell number:
    // Must start with +27 and contain 9 digits after +27
    private static final String CELL_PHONE_REGEX =
            "^\\+27[0-9]{9}$";

    /**
     * Checks whether the username is correctly formatted.
     * Username must contain an underscore and be no more than 5 characters.
     */
    public boolean checkuserName(String username) {

        if (username == null) {
            return false;
        }

        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Checks whether the password meets the complexity requirements.
     */
    public Boolean checkPasswordComplexity(String password) {

        if (password == null) {
            return false;
        }

        return Pattern.matches(PASSWORD_REGEX, password);
    }

    /**
     * Checks whether the South African cell phone number
     * is correctly formatted.
     */
    public Boolean checkcellPhoneNumber(String cellPhoneNumber) {

        if (cellPhoneNumber == null) {
            return false;
        }

        return Pattern.matches(CELL_PHONE_REGEX, cellPhoneNumber);
    }

    /**
     * Registers a new user.
     */
    public String registerUser(String username,
                               String password,
                               String cellPhoneNumber,
                               String firstName,
                               String lastName) {

        if (!checkuserName(username)) {

            return "Username is not correctly formatted; please ensure that your username "
                    + "contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {

            return "Password is not correctly formatted; please ensure that the "
                    + "password contains at least eight characters, a capital letter, "
                    + "a number, and a special character.";
        }

        if (!checkcellPhoneNumber(cellPhoneNumber)) {

            return "Cell phone number is incorrectly formatted or does not contain "
                    + "the correct country code.";
        }

        // Store the user's information
        this.userName = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;

        return "Username successfully captured. Password successfully captured. "
                + "Cell number successfully captured.";
    }

    /**
     * Checks whether the entered username and password
     * match the registered user's details.
     */
    public Boolean loginUser(String enteredUsername,
                             String enteredPassword) {

        if (userName == null || password == null) {
            return false;
        }

        return userName.equals(enteredUsername)
                && password.equals(enteredPassword);
    }

    /**
     * Returns the appropriate login status message.
     */
    public String returnLoginStatus(Boolean loginSuccessful) {

        if (Boolean.TRUE.equals(loginSuccessful)) {

            return "Welcome " + firstName + " " + lastName
                    + " it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";
        }
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