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
import pt.uc.dei.ipj.grupoa.entities.Playlist;


/**
 *
 * @author Aires
 */
public class PlaylistFacadeTest {
    static EJBContainer container;
    static PlaylistFacade plf;

    
    
    public PlaylistFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        plf = (PlaylistFacade)container.getContext().lookup("java:global/classes/PlaylistFacade");
    }
    
    @AfterClass
    public static void tearDownClass() {
          container.close();
    }

     @Test
    public void testCreatePlayList() throws Exception {
        System.out.println("createPlayList");
        String name = "Test";
        long id = 0L;
        plf.createPlayList(name, id);
        
    }

    /**
     * Test of removePlaylist method, of class PlaylistFacade.
     */
    @Test
    public void testRemovePlaylist() throws Exception {
        System.out.println("removePlaylist");
        Playlist pl = null;
        long id = 0L;
        plf.removePlaylist(pl, id);
        container.close();
    }
    
    
    /**
     * Test of create method, of class PlaylistFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        long id = 0L;
        Playlist entity = new Playlist(id);
        plf.create(entity);
      
    }

    /**
     * Test of edit method, of class PlaylistFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Playlist entity = null;
        plf.edit(entity);
    }

    /**
     * Test of remove method, of class PlaylistFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
         long id = 0L;
        Playlist entity = new Playlist(id);
        plf.remove(entity);
    }

 
    /**
     * Test of removePlaylistv2 method, of class PlaylistFacade.
     */
    @Test
    public void testRemovePlaylistv2() throws Exception {
        System.out.println("removePlaylistv2");
        long idPL = 0L;
        long idUser = 0L;
        plf.removePlaylistv2(idPL, idUser);
    }


    /**
     * Test of changeNamePlaylist method, of class PlaylistFacade.
     */
    @Test
    public void testChangeNamePlaylist() throws Exception {
        System.out.println("changeNamePlaylist");
        long idUser = 0L;
        long idPlaylist = 0L;
        String name = "Teste";
        boolean expResult = false;
        boolean result = plf.changeNamePlaylist(idUser, idPlaylist, name);
        assertEquals(expResult, result);
    }


}
