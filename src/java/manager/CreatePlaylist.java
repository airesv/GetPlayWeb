/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import facades.PlaylistFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alvaro
 */
@ManagedBean
@SessionScoped
public class CreatePlaylist {
    
    @EJB
    private PlaylistFacade playlistFacade;


    private String name;

    /**
     * Creates a new instance of CreatePlaylist
     */
    public PlaylistFacade getPlaylistFacade() {
        return playlistFacade;
    }

    public void setPlaylistFacade(PlaylistFacade playlistFacade) {
        this.playlistFacade = playlistFacade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
    public CreatePlaylist() {
    }
    
    private String createPlaylist(){
        playlistFacade.createPlayList(getName());
        return "main";
    }    
}
