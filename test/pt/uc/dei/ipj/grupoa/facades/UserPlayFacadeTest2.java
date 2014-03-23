/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.facades;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;

/**
 *
 * @author Aires
 */
public class UserPlayFacadeTest2 {
    
    public UserPlayFacadeTest2() {
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
     * Test of createUser method, of class UserPlayFacade.
     */
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("createUser");
        String name = "";
        String email = "";
        String Password = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        instance.createUser(name, email, Password);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of authValidation method, of class UserPlayFacade.
     */
    @Test
    public void testAuthValidation() throws Exception {
        System.out.println("authValidation");
        String attempt = "";
        UserPlay up = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        boolean expResult = false;
        boolean result = instance.authValidation(attempt, up);
        assertEquals(expResult, result);
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

    /**
     * Test of editUser method, of class UserPlayFacade.
     */
    @Test
    public void testEditUser() throws Exception {
        System.out.println("editUser");
        long id = 0L;
        String name = "";
        String email = "";
        String Password = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        instance.editUser(id, name, email, Password);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editnewUser method, of class UserPlayFacade.
     */
    @Test
    public void testEditnewUser() throws Exception {
        System.out.println("editnewUser");
        long id = 0L;
        String name = "";
        String email = "";
        String Password = "";
        String oldEmail = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        String expResult = "";
        String result = instance.editnewUser(id, name, email, Password, oldEmail);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewPlayList method, of class UserPlayFacade.
     */
    @Test
    public void testSetNewPlayList() throws Exception {
        System.out.println("setNewPlayList");
        long id = 0L;
        Playlist pl = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        instance.setNewPlayList(id, pl);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class UserPlayFacade.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        String email = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        UserPlay expResult = null;
        UserPlay result = instance.getUser(email);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class UserPlayFacade.
     */
    @Test
    public void testRemoveUser() throws Exception {
        System.out.println("removeUser");
        Long idUser = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        instance.removeUser(idUser);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lstPlaylist method, of class UserPlayFacade.
     */
    @Test
    public void testLstPlaylist() throws Exception {
        System.out.println("lstPlaylist");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        List<Playlist> expResult = null;
        List<Playlist> result = instance.lstPlaylist(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lstMusicList method, of class UserPlayFacade.
     */
    @Test
    public void testLstMusicList() throws Exception {
        System.out.println("lstMusicList");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserPlayFacade instance = (UserPlayFacade)container.getContext().lookup("java:global/classes/UserPlayFacade");
        List<Music> expResult = null;
        List<Music> result = instance.lstMusicList(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
