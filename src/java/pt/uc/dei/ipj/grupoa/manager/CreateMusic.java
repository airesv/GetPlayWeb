/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import pt.uc.dei.ipj.grupoa.facades.MusicFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author alvaro
 */
@ManagedBean
@SessionScoped
public class CreateMusic {
    
    @EJB
    private MusicFacade musicFacade;     
    
    private int yearOfRelease;
    private String name;
    private String author;
    private String album;
    private String pathSound;
    /**
     * Creates a new instance of CreateMusic
     */
    public CreateMusic() {
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public MusicFacade getMusicFacade() {
        return musicFacade;
    }

    public void setMusicFacade(MusicFacade musicFacade) {
        this.musicFacade = musicFacade;
    }

    public String getPathSound() {
        return pathSound;
    }

    public void setPathSound(String pathSound) {
        this.pathSound = pathSound;
    }
    
    public String createMusic(){
        musicFacade.createMusic(getYearOfRelease(), getName(), getAuthor(), getAlbum(),getPathSound());
        return "main";
    }

}
