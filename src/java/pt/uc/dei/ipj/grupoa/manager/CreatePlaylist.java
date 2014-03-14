/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "CreatePlaylist")
@SessionScoped
public class CreatePlaylist implements Serializable {

    @EJB
    private PlaylistFacade playlistFacade;

    @EJB
    private UserPlayFacade up;
    
    
 
//    @EJB
//    private Playlist pl;

    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;
    private long id;
    private String name;
    private String email;

    private String namePlayL;

    /**
     *
     */
    public CreatePlaylist() {
    }

    @PostConstruct
    public void init() {

        setId((long) userlogin.getLoggedUser().getId());
        setName(userlogin.getLoggedUser().getName());
        setEmail(userlogin.getLoggedUser().getEmail());

    }

    public UserLogin getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(UserLogin userlogin) {
        this.userlogin = userlogin;
    }

    /**
     * Creates a new instance of CreatePlaylist
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
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the namePlayL
     */
    public String getNamePlayL() {
        return namePlayL;
    }

    /**
     * @param namePlayL the namePlayL to set
     */
    public void setNamePlayL(String namePlayL) {
        this.namePlayL = namePlayL;
    }

    public void createNewPlaylist() {
        playlistFacade.createPlayList(getNamePlayL(), userlogin.getLoggedUser());
        
    }

}
