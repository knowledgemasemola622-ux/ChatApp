/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import java.util.Scanner;


/**
 *
 * @author Knoweldge
 */
public class ChatApp {

    public static void main(String[] args) {
     
        /*Oracle. (2026). Java Documentation. Available at: https://docs.oracle.com/en/java/ (Accessed: 17 September 2026).
        Oracle. (2026). Pattern Class – Java API Documentation. Available at: https://docs.oracle.com/en/java/javase/ (Accessed: 17 September 2026).
        JUnit. (2026). JUnit 5 User Guide. Available at: https://docs.junit.org/current/user-guide/ (Accessed: 17 September 2026).
        */
        
        Scanner scanner = new Scanner(System.in);
        login login = new login();
 
        // ---------- Registration ----------
        System.out.println("=== Registration ===");
 
        System.out.print("Enter a username (must contain an underscore, max 5 characters): ");
        String username = scanner.nextLine();
 
        System.out.print("Enter a password (min 8 chars, 1 capital, 1 number, 1 special char): ");
        String password = scanner.nextLine();
 
        System.out.print("Enter your South African cell number (e.g. +27838968976): ");
        String cellPhoneNumber = scanner.nextLine();
 
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
 
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
 
        String registrationMessage = login.registerUser(username, password, cellPhoneNumber, firstName, lastName);
        System.out.println(registrationMessage);
 
        // ---------- Login ----------
        System.out.println();
        System.out.println("=== Login ===");
 
        System.out.print("Enter your username: ");
        String enteredUsername = scanner.nextLine();
 
        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();
 
        Boolean loginSuccessful = login.loginUser(enteredUsername, enteredPassword);
        String loginStatusMessage = login.returnLoginStatus(loginSuccessful);
        System.out.println(loginStatusMessage);
 
        scanner.close();
    }
}
 
    
