/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.manager;

import javax.faces.model.DataModel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt.uc.dei.ipj.grupoa.EJB.UserData;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author Aires
 */
public class PLTableTest {
    
    public PLTableTest() {
    }
    

    /**
     * Test of editPlaylist method, of class PLTable.
     */
    @Test
    public void testEditPlaylist() {
        System.out.println("editPlaylist");
        PLTable instance = new PLTable();
        String expResult = "";
        String result = instance.editPlaylist();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewPlaylist method, of class PLTable.
     */
    @Test
    public void testCreateNewPlaylist() {
        System.out.println("createNewPlaylist");
        PLTable instance = new PLTable();
        String expResult = "";
        String result = instance.createNewPlaylist();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
    /**
     * Test of setTableM method, of class PLTable.
     */
   
}
