/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.facades;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import javax.servlet.http.Part;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pt.uc.dei.ipj.grupoa.entities.Music;

/**
 *
 * @author Aires
 */
public class MusicFacadeTest {
    
    static EJBContainer container;
    static MusicFacade mf;
    
    public MusicFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        mf = (MusicFacade)container.getContext().lookup("java:global/classes/MusicFacade");
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        container.close();
    }

    /**
     * Test of create method, of class MusicFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Music entity = new Music();
        mf.create(entity);
    }

    /**
     * Test of edit method, of class MusicFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Music entity = new Music();
        mf.edit(entity);
    }

    /**
     * Test of remove method, of class MusicFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Music entity = new Music();
        mf.remove(entity);
    }

    /**
     * Test of editMusic method, of class MusicFacade.
     */
    @Test
    public void testEditMusic() throws Exception {
        System.out.println("editMusic");
        Long idMusic = 0L;
        String album = "albumteste";
        String author = "testeauthor";
        int YearOfRelease = 2000;
        String name = "testename";
        mf.editMusic(idMusic, album, author, YearOfRelease, name);
    }

    /**
     * Test of createMusic method, of class MusicFacade.
     */
    @Test
    public void testCreateMusic() throws Exception {
        System.out.println("createMusic");
        int yearOfRelease = 2000;
        String name = "testename";
        String author = "testeauthor";
        String album = "albumteste";
        String path = "pathteste";
        Long id = 0L;
        Part file = null;   
        mf.createMusic(yearOfRelease, name, author, album, path, id, file);
    }

  
 
 
}
