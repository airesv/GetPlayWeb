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
    private UserLogin ul;
    
    private String namePlayL;

    /**
     *
     */
    public CreatePlaylist() {
    }


     public void createNewPlaylist() {
        playlistFacade.createPlayList(getNamePlayL(),ul.getIdUser());
        
    }

    public UserLogin getUserlogin() {
        return ul;
    }

    public void setUserlogin(UserLogin ul) {
        this.ul = ul;
    }

    public PlaylistFacade getPlaylistFacade() {
        return playlistFacade;
    }

  
    public void setPlaylistFacade(PlaylistFacade playlistFacade) {
        this.playlistFacade = playlistFacade;
    }

  
    public String getNamePlayL() {
        return namePlayL;
    }

   
    public void setNamePlayL(String namePlayL) {
        this.namePlayL = namePlayL;
    }

   

}
