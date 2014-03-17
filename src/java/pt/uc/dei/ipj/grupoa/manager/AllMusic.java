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
import javax.faces.bean.RequestScoped;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "AllMusic")
@RequestScoped
public class AllMusic {

    @EJB
    private MusicFacade musicFacade;

    private List<Music> lstMusic;

    /**
     * Creates a new instance of AllMusic
     */
    public AllMusic() {

    }

    @PostConstruct
    public void init() {
        setLstMusic(musicFacade.listOfAllMusics());
    }

    public List<Music> getLstMusic() {
        return lstMusic;
    }

    public void setLstMusic(List<Music> lstMusic) {
        this.lstMusic = lstMusic;
    }

    public MusicFacade getMusicFacade() {
        return musicFacade;
    }

}
