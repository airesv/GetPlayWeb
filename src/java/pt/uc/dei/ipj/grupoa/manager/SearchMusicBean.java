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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pt.uc.dei.ipj.grupoa.entities.Music;
//import org.josql.QueryExecutionException;
//import org.josql.QueryParseException;
//import static pt.uc.dei.ipj.grupoa.entities.UserPlay_.music;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "SearchMusicBean")
@RequestScoped
public class SearchMusicBean implements Serializable {

    /**
     * Creates a new instance of SearchMusic
     */
    @EJB
    private MusicFacade musicFacade;

    private String introducedText;
    private List<Music> lstMusic;

    public SearchMusicBean() {
    }

    public String showMusicsAuthor() {
        //    musicFacade.searchedAuthor();
        return "searchMusic";
    }

    @PostConstruct
    public void init() {
        setLstMusic(musicFacade.searchedMusic(introducedText));
        setLstMusic(musicFacade.searchedAuthor(introducedText));
    }

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
