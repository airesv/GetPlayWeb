/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.facades;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import pt.uc.dei.uc.grupoa.utils.EncryptPassword;

/**
 *
 * @author Aires
 */
public class UserPlayFacadeTest {

    static EJBContainer container;
    static UserPlayFacade upf;

    public UserPlayFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws NamingException {

        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        upf = (UserPlayFacade) container.getContext().lookup("java:global/classes/UserPlayFacade");
    }

    @AfterClass
    public static void tearDownClass() {
        container.close();
    }

    @Test
    public void testCreateUser() throws Exception {
        EncryptPassword encrypt = new EncryptPassword();
        System.out.println("createUser");
        String name = "test";
        String email = "test@test.com";
        String password = encrypt.cryptWithMD5("test");
        upf.createUser(name, email, password);
        
        
        
    }

    @Test
    public void testAuthValidation() throws Exception {
        EncryptPassword encrypt = new EncryptPassword();
        System.out.println("authValidation");
        String attempt = encrypt.cryptWithMD5("teste");
        UserPlay up = new UserPlay("test", "test@test.com", encrypt.cryptWithMD5("test"));
        boolean expResult = false;
        boolean result = upf.authValidation(attempt, up);
        assertEquals(expResult, result);
    }
   
    @Test
    public void testEditnewUser() throws Exception {
        System.out.println("editnewUser");
        long id = 0L;
        String name = "test";
        String email = "test@test.com";
        String Password = "test@test.edu";
        String oldEmail =  "test@test.com";
        String expResult = "Sucessefully inserted";
        String result = upf.editnewUser(id, name, email, Password, oldEmail);
        assertEquals(expResult, result);
    }

      @Test
    public void testRemoveUser() throws Exception {
        System.out.println("removeUser");
        Long idUser = null;
        upf.removeUser(idUser);
    }  
    
    
    
}
