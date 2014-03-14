package pt.uc.dei.ipj.grupoa.manager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;

/**
 *
 * @author Aires
 */
@ManagedBean(name = "InsertMusicPL")
@RequestScoped
public class insertMusicPL {

    @ManagedProperty(value = "#{PLTable}")
    private PLTable pltable;

    @ManagedProperty(value = "#{Userlogin}")
    private UserLogin userlogin;

    @EJB
    private MusicFacade musicFacade;

    private List<Music> lstMusic;
    private DataModel<Music> tabelaM;
    private Playlist playlist;
    private String namePL;
    private String  message;

    /**
     * Creates a new instance of insertMusicPL
     */

    public insertMusicPL() {

    }

    @PostConstruct
    public void init() {
        setPlaylist(pltable.getPl());
        setLstMusic(musicFacade.listOfAllMusics());
        setTabelaM(new CollectionDataModel<>(lstMusic));
        setNamePL(playlist.getNamePlaylist());
        setMessage(getNamePL());
    }
    
    
    
    public void addMusicToPlaylist(){
    
        
        
        
    }

    //////getters e Setters
    
    
    
    
    
    /**
     * @return the lstMusic
     */
    public List<Music> getLstMusic() {
        return lstMusic;
    }

    /**
     * @param lstMusic the lstMusic to set
     */
    public void setLstMusic(List<Music> lstMusic) {
        this.lstMusic = lstMusic;
    }

    /**
     * @return the tabelaM
     */
    public DataModel<Music> getTabelaM() {
        return tabelaM;
    }

    /**
     * @param tabelaM the tabelaM to set
     */
    public void setTabelaM(DataModel<Music> tabelaM) {
        this.tabelaM = tabelaM;
    }

    /**
     * @return the pltable
     */
    public PLTable getPltable() {
        return pltable;
    }

    /**
     * @param pltable the pltable to set
     */
    public void setPltable(PLTable pltable) {
        this.pltable = pltable;
    }

    /**
     * @return the userlogin
     */
    public UserLogin getUserlogin() {
        return userlogin;
    }

    /**
     * @param userlogin the userlogin to set
     */
    public void setUserlogin(UserLogin userlogin) {
        this.userlogin = userlogin;
    }

    /**
     * @return the namePL
     */
    public String getNamePL() {
        return namePL;
    }

    /**
     * @param namePL the namePL to set
     */
    public void setNamePL(String namePL) {
        this.namePL = namePL;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = "Add music to the playlist:"+ message;
    }

    /**
     * @return the pl
     */
    public Playlist getPlaylist() {
        return playlist;
    }

    /**
     * @param playlist the playlist to set
     */
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

}
