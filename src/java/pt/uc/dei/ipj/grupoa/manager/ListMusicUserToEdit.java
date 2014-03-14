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
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author alvaro
 */
@ManagedBean (name = "ListMusicUser")
@RequestScoped
public class ListMusicUserToEdit {
 @EJB
    private UserPlayFacade up;

    @EJB
    private MusicFacade musicFacade;

    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;

    private static final long serialVersionUID = 1L;

    DataModel<Music> musicsLoggedInUser;

    @PostConstruct
    public void init() {
        List<Music> musicList = userlogin.getLoggedUser().getMusic();
        musicsLoggedInUser = new CollectionDataModel<>(musicList);
    }

    public DataModel<Music> getMusicsLoggedInUser() {
        return musicsLoggedInUser;
    }

    private Music selectedMusic;

    public String saveAction() {
        musicFacade.edit(selectedMusic);
        return "editmusic";
    }


    public MusicFacade getMusicFacade() {
        return musicFacade;
    }

    public Music getSelectedMusic() {
        return selectedMusic;
    }

    public UserLogin getUserlogin() {
        return userlogin;
    }

    public UserPlayFacade getUp() {
        return up;
    }

    public void setMusicFacade(MusicFacade musicFacade) {
        this.musicFacade = musicFacade;
    }

    public void setMusicsLoggedInUser(DataModel<Music> musicsLoggedInUser) {
        this.musicsLoggedInUser = musicsLoggedInUser;
    }

    public void setSelectedMusic(Music selectedMusic) {
        this.selectedMusic = selectedMusic;
    }

    public void setUp(UserPlayFacade up) {
        this.up = up;
    }

    public void setUserlogin(UserLogin userlogin) {
        this.userlogin = userlogin;
    }

}

    
    
    
    
    
    

