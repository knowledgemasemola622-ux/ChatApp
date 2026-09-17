/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class loginTest {

    /**
     * Test username with correct formatting.
     */
    @Test
    public void testCheckuserName_CorrectFormatted() {

        System.out.println("checkuserName - correctly formatted");

        String username = "no_15";

        login instance = new login();

        boolean expResult = true;

        boolean result = instance.checkuserName(username);

        assertEquals(expResult, result);
    }

    /**
     * Test username with incorrect formatting.
     */
    @Test
    public void testCheckuserName_incorrectlyformatted() {

        System.out.println("checkuserName - incorrectly formatted");

        String username = "knox!!!!!";

        login instance = new login();

        boolean expResult = false;

        boolean result = instance.checkuserName(username);

        assertEquals(expResult, result);
    }

    /**
     * Test password that meets complexity requirements.
     */
    @Test
    public void testCheckPasswordComplexity_Meets() {

        System.out.println(
                "checkPasswordComplexity - meets requirements");

        String password = "Aa&&cc@ak100!";

        login instance = new login();

        boolean expResult = true;

        boolean result =
                instance.checkPasswordComplexity(password);

        assertEquals(expResult, result);
    }

    /**
     * Test password that does not meet complexity requirements.
     */
    @Test
    public void testCheckPasswordComplexity_DoesNotMeet() {

        System.out.println(
                "checkPasswordComplexity - does not meet requirements");

        String password = "password";

        login instance = new login();

        boolean expResult = false;

        boolean result =
                instance.checkPasswordComplexity(password);

        assertEquals(expResult, result);
    }

    /**
     * Test correctly formatted South African cell number.
     */
    @Test
    public void testCheckCellPhoneNumber_CorrectlyFormatted() {

        System.out.println(
                "checkCellPhoneNumber - correctly formatted");

        String cellPhoneNumber = "+27838968976";

        login instance = new login();

        boolean expResult = true;

        boolean result =
                instance.checkcellPhoneNumber(cellPhoneNumber);

        assertEquals(expResult, result);
    }

    /**
     * Test incorrectly formatted cell number.
     */
    @Test
    public void testCheckCellPhoneNumber_IncorrectlyFormatted() {

        System.out.println(
                "checkCellPhoneNumber - incorrectly formatted");

        String cellPhoneNumber = "08966553";

        login instance = new login();

        boolean expResult = false;

        boolean result =
                instance.checkcellPhoneNumber(cellPhoneNumber);

        assertEquals(expResult, result);
    }

    /**
     * Test registration with an invalid password.
     */
    @Test
    public void testCheckRegisterUser_PasswordDoesNotMeetComplexity() {

        System.out.println(
                "registerUser - password does not meet complexity");

        String username = "no_15";
        String password = "password";
        String cellPhoneNumber = "+27838968976";
        String firstName = "Knox";
        String lastName = "Veg";

        login instance = new login();

        String expResult =
                "Password is not correctly formatted; please ensure that the "
                + "password contains at least eight characters, a capital letter, "
                + "a number, and a special character.";

        String result = instance.registerUser(
                username,
                password,
                cellPhoneNumber,
                firstName,
                lastName
        );

        assertEquals(expResult, result);
    }

    /**
     * Test successful registration.
     */
    @Test
    public void testRegisterUser_CellPhoneNumberSuccessfullyCaptured() {

        System.out.println(
                "registerUser - cell phone correctly formatted");

        String username = "no_15";
        String password = "Aa&&cc@ak100!";
        String cellPhoneNumber = "+27838968976";
        String firstName = "Knox";
        String lastName = "Veg";

        login instance = new login();

        String expResult =
                "Username successfully captured. Password successfully captured. "
                + "Cell number successfully captured.";

        String result = instance.registerUser(
                username,
                password,
                cellPhoneNumber,
                firstName,
                lastName
        );

        assertEquals(expResult, result);
    }

    /**
     * Test successful login.
     */
    @Test
    public void testLoginUser_Successful() {

        System.out.println("login - successful login");

        login instance = new login();

        instance.registerUser(
                "no_15",
                "Aa&&cc@ak100!",
                "+27838968976",
                "Knox",
                "Veg"
        );

        String enteredUsername = "no_15";
        String enteredPassword = "Aa&&cc@ak100!";

        boolean expResult = true;

        boolean result =
                instance.loginUser(
                        enteredUsername,
                        enteredPassword
                );

        assertEquals(expResult, result);
    }

    /**
     * Test failed login.
     */
    @Test
    public void testLoginUser_Failed() {

        System.out.println("login - unsuccessful login");

        login instance = new login();

        instance.registerUser(
                "no_195",
                "Aak",
                "083890686",
                "Knox",
                "Veg"
        );

        String enteredUsername = "no_15";
        String enteredPassword = "WrongPassword1!";

        boolean expResult = false;

        boolean result =
                instance.loginUser(
                        enteredUsername,
                        enteredPassword
                );

        assertEquals(expResult, result);
    }

    /**
     * Test successful login status.
     */
    @Test
    public void testReturnLoginStatus_Success() {

        System.out.println(
                "returnLoginStatus - successful login");

        login instance = new login();

        instance.registerUser(
                "no_15",
                "Aa&&cc@ak100!",
                "+27838968976",
                "Knox",
                "Veg"
        );

        boolean loginSuccessful = true;

        String expResult =
                "Welcome Knox Veg it is great to see you again.";

        String result =
                instance.returnLoginStatus(loginSuccessful);

        assertEquals(expResult, result);
    }

    /**
     * Test failed login status.
     */
    @Test
    public void testReturnLoginStatus_Failure() {

        System.out.println(
                "returnLoginStatus - failed login");

        boolean loginSuccessful = false;

        login instance = new login();

        String expResult =
                "Username or password incorrect, please try again.";

        String result =
                instance.returnLoginStatus(loginSuccessful);

        assertEquals(expResult, result);
    }
}