/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.Serializable;
import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pt.uc.dei.ipj.grupoa.EJB.UserData;

/**
 *
 * @author alvaro
 */
@Named("createPlaylist")
@RequestScoped
public class CreatePlaylist implements Serializable {

    @EJB
    private PlaylistFacade playlistFacade; 
   
    @Inject
    private UserData ud;
    
    @Inject
    private UserLogin ul;
    
    private String namePlayL;

    /**
     *
     */
    public CreatePlaylist() {
    }

    /**
     *
     */
    public void createNewPlaylist() {
        playlistFacade.createPlayList(getNamePlayL(),ul.getIdUser());
        
    }

    /**
     *
     * @return
     */
    public UserLogin getUserlogin() {
        return ul;
    }

    /**
     *
     * @param ul
     */
    public void setUserlogin(UserLogin ul) {
        this.ul = ul;
    }

    /**
     *
     * @return
     */
    public PlaylistFacade getPlaylistFacade() {
        return playlistFacade;
    }

    /**
     *
     * @param playlistFacade
     */
    public void setPlaylistFacade(PlaylistFacade playlistFacade) {
        this.playlistFacade = playlistFacade;
    }

    /**
     *
     * @return
     */
    public String getNamePlayL() {
        return namePlayL;
    }

    /**
     *
     * @param namePlayL
     */
    public void setNamePlayL(String namePlayL) {
        this.namePlayL = namePlayL;
    }

    /**
     *
     * @return
     */
    public UserData getUd() {
        return ud;
    }

    /**
     *
     * @param ud
     */
    public void setUd(UserData ud) {
        this.ud = ud;
    }

   

}
