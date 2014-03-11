/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.manager;

import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.entities.Playlist;

/**
 *
 * @author alvaro
 */
@ManagedBean
@SessionScoped
public class CreatePlaylist {
    
    @EJB
    private PlaylistFacade playlistFacade;

    @EJB
    private UserManagerBean userManagedBean;
    
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
//        Playlist pl=new Playlist(getName());
//        userManagedBean.getLoggedUser().getPlaylists().add(pl);
        playlistFacade.createPlayList(getName());
        return "createplaylist";
    }    
}
