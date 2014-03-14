/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;
import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;


/**
 *
 * @author Aires
 */
@ManagedBean(name = "PLGestao")
@SessionScoped
public class PLGestao {

    @ManagedProperty(value = "#{PLTable}")
    private PLTable pltable;
    
    @ManagedProperty(value = "#{Userlogin}")
    private UserLogin userlogin;
    
    @EJB
    private UserPlayFacade userfacade;
    
    @EJB
    private PlaylistFacade plfacade;

    private List<Music> lstmusic;

    private Playlist playlist;
    private String namePL;
    
    
     @EJB
    private MusicFacade musicFacade;



    

    /**
     * Creates a new instance of PLGestao
     */
    public PLGestao() {

    }

    public String showPL() {
        setNamePL(pltable.editPlaylist());
        return "viewpl";
    }

    @PostConstruct
    public void init() {
        setPlaylist(pltable.getPl());
        //setNamePL(playlist.getNamePlaylist());
        //setLstMusic(pltable.getPlfacade().createListMusic(playlist));
    }
    
    public void renamePlaylist(){
       //mudar o user
       // userfacade.
             
        //mudar o nomer na playlist
    }

    public String insereMusPL(){
    return "musicainplay";
    }
    
    

///////////////////Getters & Setter
    
    
    
    
    public UserLogin getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(UserLogin userlogin) {
        this.userlogin = userlogin;
    }
    
    
    
    
    public String getNamePL() {
        return namePL;
    }

    public void setNamePL(String namePL) {
        this.namePL = namePL;
    }
    
    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
    
    
    
    public PLTable getPltable() {
        return pltable;
    }

    public void setPltable(PLTable pltable) {
        this.pltable = pltable;
    }


    public List<Music> getLstMusic() {
        return getLstmusic();
    }

    public void setLstMusic(List<Music> lstMusic) {
        this.setLstmusic(lstMusic);
    }

    /**
     * @return the lstmusic
     */
    public List<Music> getLstmusic() {
        return lstmusic;
    }

    /**
     * @param lstmusic the lstmusic to set
     */
    public void setLstmusic(List<Music> lstmusic) {
        this.lstmusic = lstmusic;
    }

}
