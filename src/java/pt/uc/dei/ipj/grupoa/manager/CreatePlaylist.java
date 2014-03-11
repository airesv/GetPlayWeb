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

    public UserLogin getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(UserLogin userlogin) {
        this.userlogin = userlogin;
    }

    private String name;

    /**
     * Creates a new instance of CreatePlaylist
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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    public CreatePlaylist() {
    }
    
    /**
     *
     * @return
     */
    public String createPlaylist(){       
        playlistFacade.createPlayList1(getName());
        return "main";
    }    
}
