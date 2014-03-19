/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pt.uc.dei.ipj.grupoa.EJB.UserData;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;

/**
 *
 * @author Aires
 */
@Named("plManagement")
@RequestScoped
public class PLManagement {

    @Inject
    private UserData ud;

    @EJB
    private PlaylistFacade playlistfacade;
    
    private Playlist selectedPlaylist;
    
    
    private String namePL;

    private String message;

    /**
     * Creates a new instance of PLGestao
     */
    public PLManagement() {

    }

    public String showPL() {
        //setNamePL(pltable.editPlaylist());
        return "viewpl";
    }

    @PostConstruct
    public void init() {
       // setNamePL(pltable.editPlaylist());
       // message = "";
        //setPlaylist(pltable.getPl());
        //setNamePL(playlist.getNamePlaylist());
        //setLstMusic(pltable.getPlfacade().createListMusic(playlist));
    }

    public void renamePlaylist() {
//        //mandar para o face 
//       // boolean renamed = playlistfacade.changeNamePlaylist(ul.getIdUser(), pltable.getIdPlaylist(), getNamePL());
//        if (renamed) {
//            setMessage("Successfully changed");
//        } else {
//            setMessage("There is a Playlist with that name!");
//        }
//        pltable.init();
   }

    public String insertMusPL() {
        return "musicinplay";
    }

///////////////////Getters & Setter
   

    public UserData getUd() {
        return ud;
    }

    public void setUd(UserData ud) {
        this.ud = ud;
    }

    public Playlist getSelectedPlaylist() {
        return selectedPlaylist;
    }

    public void setSelectedPlaylist(Playlist selectedPlaylist) {
        this.selectedPlaylist = selectedPlaylist;
    }

    
   

//    public List<Music> getLstmusic() {
//        return lstmusic;
//    }
//
//    public void setLstmusic(List<Music> lstmusic) {
//        this.lstmusic = lstmusic;
//    }
    public PlaylistFacade getPlaylistfacade() {
        return playlistfacade;
    }

    public void setPlaylistfacade(PlaylistFacade playlistfacade) {
        this.playlistfacade = playlistfacade;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNamePL() {
        return namePL;
    }

    public void setNamePL(String namePL) {
        this.namePL = namePL;
    }

}
