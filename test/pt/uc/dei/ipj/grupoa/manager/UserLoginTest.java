/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.manager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.uc.dei.ipj.grupoa.EJB.UserData;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author Aires
 */
public class UserLoginTest {
    
    private String name;
    private String useremail="test@test.com";
    private String password="test";
    private String errorMessage;

    private String message;
    private String confirmPassword="test";;
    private String email="test@test.com";
    private String newName;
    private String newUserEmail;
    
    
    
    
    
    
    public UserLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of init method, of class UserLogin.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        UserLogin instance = new UserLogin();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verification method, of class UserLogin.
     */
    @Test
    public void testVerification() {
        System.out.println("verification");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.verification();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertNewUser method, of class UserLogin.
     */
    @Test
    public void testInsertNewUser() {
        System.out.println("insertNewUser");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.insertNewUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserLogin.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.deleteUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class UserLogin.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.logout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertEditUser method, of class UserLogin.
     */
    @Test
    public void testInsertEditUser() {
        System.out.println("insertEditUser");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.insertEditUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNewUserEmail method, of class UserLogin.
     */
    @Test
    public void testGetNewUserEmail() {
        System.out.println("getNewUserEmail");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getNewUserEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewUserEmail method, of class UserLogin.
     */
    @Test
    public void testSetNewUserEmail() {
        System.out.println("setNewUserEmail");
        String newUserEmail = "";
        UserLogin instance = new UserLogin();
        instance.setNewUserEmail(newUserEmail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdUser method, of class UserLogin.
     */
    @Test
    public void testGetIdUser() {
        System.out.println("getIdUser");
        UserLogin instance = new UserLogin();
        Long expResult = null;
        Long result = instance.getIdUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdUser method, of class UserLogin.
     */
    @Test
    public void testSetIdUser() {
        System.out.println("setIdUser");
        Long idUser = null;
        UserLogin instance = new UserLogin();
        instance.setIdUser(idUser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class UserLogin.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class UserLogin.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        UserLogin instance = new UserLogin();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserPlayFacade method, of class UserLogin.
     */
    @Test
    public void testGetUserPlayFacade() {
        System.out.println("getUserPlayFacade");
        UserLogin instance = new UserLogin();
        UserPlayFacade expResult = null;
        UserPlayFacade result = instance.getUserPlayFacade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserPlayFacade method, of class UserLogin.
     */
    @Test
    public void testSetUserPlayFacade() {
        System.out.println("setUserPlayFacade");
        UserPlayFacade userPlayFacade = null;
        UserLogin instance = new UserLogin();
        instance.setUserPlayFacade(userPlayFacade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUseremail method, of class UserLogin.
     */
    @Test
    public void testGetUseremail() {
        System.out.println("getUseremail");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getUseremail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUseremail method, of class UserLogin.
     */
    @Test
    public void testSetUseremail() {
        System.out.println("setUseremail");
        String useremail = "";
        UserLogin instance = new UserLogin();
        instance.setUseremail(useremail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class UserLogin.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class UserLogin.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        UserLogin instance = new UserLogin();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getErrorMessage method, of class UserLogin.
     */
    @Test
    public void testGetErrorMessage() {
        System.out.println("getErrorMessage");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getErrorMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setErrorMessage method, of class UserLogin.
     */
    @Test
    public void testSetErrorMessage() {
        System.out.println("setErrorMessage");
        String errorMessage = "";
        UserLogin instance = new UserLogin();
        instance.setErrorMessage(errorMessage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class UserLogin.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessage method, of class UserLogin.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        UserLogin instance = new UserLogin();
        instance.setMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConfirmPassword method, of class UserLogin.
     */
    @Test
    public void testGetConfirmPassword() {
        System.out.println("getConfirmPassword");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getConfirmPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConfirmPassword method, of class UserLogin.
     */
    @Test
    public void testSetConfirmPassword() {
        System.out.println("setConfirmPassword");
        String confirmPassword = "";
        UserLogin instance = new UserLogin();
        instance.setConfirmPassword(confirmPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class UserLogin.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class UserLogin.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        UserLogin instance = new UserLogin();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUd method, of class UserLogin.
     */
    @Test
    public void testGetUd() {
        System.out.println("getUd");
        UserLogin instance = new UserLogin();
        UserData expResult = null;
        UserData result = instance.getUd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUd method, of class UserLogin.
     */
    @Test
    public void testSetUd() {
        System.out.println("setUd");
        UserData ud = null;
        UserLogin instance = new UserLogin();
        instance.setUd(ud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNewName method, of class UserLogin.
     */
    @Test
    public void testGetNewName() {
        System.out.println("getNewName");
        UserLogin instance = new UserLogin();
        String expResult = "";
        String result = instance.getNewName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewName method, of class UserLogin.
     */
    @Test
    public void testSetNewName() {
        System.out.println("setNewName");
        String newName = "";
        UserLogin instance = new UserLogin();
        instance.setNewName(newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
