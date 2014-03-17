/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.Serializable;
import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "CreatePlaylist")
@SessionScoped
public class CreatePlaylist implements Serializable {

    @EJB
    private PlaylistFacade playlistFacade; 
    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;
    private String namePlayL;

    /**
     *
     */
    public CreatePlaylist() {
    }


     public void createNewPlaylist() {
        playlistFacade.createPlayList(getNamePlayL(), userlogin.getLoggedUser());
        
    }

    public UserLogin getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(UserLogin userlogin) {
        this.userlogin = userlogin;
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
