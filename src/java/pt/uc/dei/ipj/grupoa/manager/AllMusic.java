/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "AllMusic")
@SessionScoped
public class AllMusic {

    @EJB
    private MusicFacade musicFacade;

    /**
     * Creates a new instance of AllMusic
     */
    public AllMusic() {

    }

    public MusicFacade getMusicFacade() {
        return musicFacade;
    }

    public void setMusicFacade(MusicFacade musicFacade) {
        this.musicFacade = musicFacade;
    }

    public List<Music> showAllMusics() {
        return musicFacade.listOfAllMusics();   
    }

}
