/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import entities.UserPlay;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aires
 */
public class UserPlayFacadeTest {
    
    public UserPlayFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of create method, of class UserPlayFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        UserPlay entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class UserPlayFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        UserPlay entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class UserPlayFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        UserPlay entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class UserPlayFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        UserPlay expResult = null;
        UserPlay result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class UserPlayFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        List<UserPlay> expResult = null;
        List<UserPlay> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class UserPlayFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        List<UserPlay> expResult = null;
        List<UserPlay> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class UserPlayFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userIsDataBase method, of class UserPlayFacade.
     */
    @Test
    public void testUserIsDataBase() throws Exception {
        System.out.println("userIsDataBase");
        String email = "";
        String pass = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        boolean expResult = false;
        boolean result = instance.userIsDataBase(email, pass);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class UserPlayFacade.
     */
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("createUser");
        String nome = "";
        String email = "";
        String password = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        instance.createUser(nome, email, password);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existsUser method, of class UserPlayFacade.
     */
    @Test
    public void testExistsUser() throws Exception {
        System.out.println("existsUser");
        String email = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        boolean expResult = false;
        boolean result = instance.existsUser(email);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
