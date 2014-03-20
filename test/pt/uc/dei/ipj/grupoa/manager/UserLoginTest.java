/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;



import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;


public class UserLoginTest {
/**
 *
 * @author Alvaro/Vitor
 */
    public UserLoginTest() {
    }

    static EJBContainer container;
    static UserPlayFacade facade;

    @BeforeClass
    public static void setUpClass() throws Exception {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        facade = (UserPlayFacade) container.getContext().lookup("java:global/classes/UserPlayFacade");
    }

    @AfterClass
    public static void tearDownClass() {
        container.close();
    }

    @Test
    public void testUserCreate()  {
        System.out.println("testUserCreate");

        UserPlay u = new UserPlay("teste", "teste@teste.com", "testeste");

        facade.create(u);
        UserPlay result = facade.getUser(u.getEmail());

        assertEquals(u.getEmail(), result.getEmail());
        assertEquals(u.getName(), result.getName());

        facade.remove(u);
    }

    @Test
    public void testGetUserByEmail() {
        System.out.println("testGetUserByEmail");

        String expectedEmail = "teste@teste.com";
        UserPlay u = new UserPlay("teste", expectedEmail, "testeste");

        facade.create(u);

        UserPlay result = facade.getUser(expectedEmail);
        assertEquals(u, result);

        facade.remove(u);
    }

   // @Test(expected = UserNotFoundException.class)
    public void testGetNonExistantUserByEmail() {
        System.out.println("testGetNonExistantUserByEmail");

        String email = "testesssssss@teste.com";

        UserPlay result = facade.getUser(email);
        assertNull(result);
    }

    @Test
    public void testValidUserPassword() {
        System.out.println("validUserPassword");

        String email = "teste@teste.com";
        UserPlay u = new UserPlay("teste", email, "testeste");

        facade.create(u);
        UserPlay result = facade.authValidation(email, "testeste");
        assertNotNull(result);
        facade.remove(u);
    }

   // @Test(expected = InvalidAuthException.class)
    public void testInvalidUserPassword() {
        System.out.println("invalidUserPassword");

        String email = "teste@teste.com";
        UserPlay u = new UserPlay("teste", email, "testeste");

        facade.create(u);
        UserPlay result = facade.authValidation(email, "teste2");
        assertNull(result);
        facade.remove(u);
    }

    @Test
    public void testValidEmail() {
        System.out.println("validEmail");

        String email = "teste@teste.com";
        UserPlay u = new UserPlay("teste", email, "testeste");

        facade.create(u);
        boolean result = facade.(email);
        assertEquals(false, result);

        result = facade.emailExists("1231231232131232@gmail.com");
        assertEquals(true, result);
        facade.remove(u);
    }

}
