/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Knoweldge
 */
public class loginTest {
    
    public loginTest() {
    }
     /**
     * Test of checkuserName method, of class Login.
     */
    @Test
    public void testCheckuserName_CorrectFormatted() {
        System.out.println("checkuserName - correctlyFormatted");
        String username = "no_15";
        login instance = new login();
        boolean expResult = true;
        boolean result = instance.checkuserName(username);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkuserName method, of class Login.
     */
    @Test
    public void testCheckuserName_incorrectlyformatted() {
        System.out.println("testCheckuserName_incorrectlyformatted");
        String username = "knox!!!!!";
        login instance = new login();
        Boolean expResult = false;
        Boolean result = instance.checkuserName(username);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity_Meets() {
        System.out.println("checkPasswordComplexity - meets requirements");
        String password = "Aa&&cc@ak100!";
        login instance = new login();
        Boolean expResult = true;
        Boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheckPasswordComplexity_DoesNotMeet() {
          System.out.println("checkPasswordComplexity - does not meets requirements");
        String password = "password";
        login instance = new login();
        Boolean expResult = false;
        Boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }
     /**
     * Test of checkCellPhoneNumber method, of class Login.
     */
    @Test
    public void testCheckCellPhoneNumber_CorrectlyFormatted() {
        System.out.println("checkCellPhoneNumber - correctly formatted");
        String cellPhoneNumber = "+27838968976";
        login instance = new login();
        Boolean expResult = false;
        Boolean result = instance.checkcellPhoneNumber(cellPhoneNumber);
        assertEquals(expResult, result);
    }
 
    @Test
    public void testCheckCellPhoneNumber_IncorrectlyFormatted() {
        System.out.println("checkCellPhoneNumber - incorrectly formatted");
        String cellPhoneNumber = "08966553";
        login instance = new login();
        Boolean expResult = false;
        Boolean result = instance.checkcellPhoneNumber(cellPhoneNumber);
        assertEquals(expResult, result);
    }
    
    @Test       
  public void testCheckRegisterUser_PasswordDoesNotMeetComplexity() {
        System.out.println("registerUse - password does not meet complexity");
        String username = "no_15";
        String password = "password";
        String cellPhoneNumber = "+27838968976";
        String firstName = "Knox";
        String lastName = "Veg";
        login instance = new login();
        String expResult = "Password is not correctly formatted; please ensure that the"
                + "password  contains at least eight characters, a capital letter,a number,"
                + "and a special character.";
        String result = instance.registerUser(username, password, cellPhoneNumber, firstName, lastName);
        assertEquals(expResult, result);
      
    }

    
    @Test
    public void testRegisterUser_CellPhoneNumberSuccesfullyCaptured() {
        System.out.println("registerUser - cell phone correctly formatted");
        String enteredUsername = "no_15";
        String enteredPassword = "Aa&&cc@ak100!";
        String CellPhoneNumber = "+27838968976";
        String firstName = "Knox";
        String lastName = "Veg";
        login instance = new login();
        String  expResult = "Password succesfully captured.";        
        String result = instance.registerUser("no_15", "Aa&&cc@ak100!", "+27838968976", "Knox", "Veg");
        assertEquals(expResult, result);
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testLoginUser_Successful() {
        System.out.println("login - succesful login");
        login instance = new login();
        instance.registerUser("no_15", "Aa&&cc@ak100!", "+27838968976", "Knox", "Veg");
        String enteredUsername = "no_15";
        String enteredPassword = "Aa&&cc@ak100!";  
        Boolean expResult = true;
        Boolean result = instance.loginUser(enteredUsername, enteredPassword);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testLoginUser_Failed() {
        System.out.println("login - unsuccesful login");
        login instance = new login();
        instance.registerUser("no_195", "Aa&&cc@ak10o0!", "+278389068976", "Knox", "Veg");
        String enteredusername = "no_15";
        String enteredpassword = "WrongPassword1!";
        Boolean expResult = true;
        Boolean result = instance.loginUser(enteredusername, enteredpassword);
        assertEquals(expResult, result);
        
    }

    
/**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus_Success() {
        System.out.println("returnLoginStatus - successful login");
        login instance = new login();
        instance.registerUser("no_15", "Aa&&cc@ak100!", "+27838968976", "Knox", "Veg");
        Boolean loginSuccesful = true;
        String expResult = "Welcome null, null it is great to see you.";
        String result = instance.returnLoginStatus(loginSuccesful);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testReturnLoginStatus_Failure() {
        System.out.println("returnLoginStatus - failed login");
        Boolean loginSuccesful = false;
        login instance = new login();
        String expResult = "Username or password incorrect, please try again.";
        String result = instance.returnLoginStatus(loginSuccesful);
        assertEquals(expResult, result);
    }
    
}
