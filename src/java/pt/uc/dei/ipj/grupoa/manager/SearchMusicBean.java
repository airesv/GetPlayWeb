/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import pt.uc.dei.ipj.grupoa.entities.Music;

import pt.uc.dei.ipj.grupoa.facades.MusicFacade;

/**
 *
 * @author Alvaro/Vitor
 */
@Named("SearchMusicBean")
@RequestScoped
public class SearchMusicBean implements Serializable {

    @EJB
    private MusicFacade musicFacade;
    private String introducedText;
    private List<Music> lstMusic;

    public SearchMusicBean() {
    }

    /**
     *
     */
    @PostConstruct
    public void init() {
        setLstMusic(musicFacade.searchedMusic(introducedText));
        setLstMusic(musicFacade.searchedAuthor(introducedText));
    }

    ////Getters and Setters////
    public String getIntroducedText() {
        return introducedText;
    }

    public void setIntroducedText(String introducedText) {
        this.introducedText = introducedText;
    }

    public MusicFacade getMusicFacade() {
        return musicFacade;
    }

    public void setMusicFacade(MusicFacade musicFacade) {
        this.musicFacade = musicFacade;
    }

    public List<Music> getLstMusic() {
        lstMusic = musicFacade.searchedMusic(introducedText);
        return lstMusic;
    }

    public List<Music> getLstMusicByAuthor() {
        lstMusic = musicFacade.searchedAuthor(introducedText);
        return lstMusic;
    }

    public void setLstMusic(List<Music> lstMusic) {
        this.lstMusic = lstMusic;
    }

}
