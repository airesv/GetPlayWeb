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

    /**
     *
     * @return
     */
    public int getYearOfRelease() {
        return yearOfRelease;
    }

    /**
     *
     * @param yearOfRelease
     */
    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     */
    public String getAlbum() {
        return album;
    }

    /**
     *
     * @param album
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     *
     * @return
     */
    public MusicFacade getMusicFacade() {
        return musicFacade;
    }

    /**
     *
     * @param musicFacade
     */
    public void setMusicFacade(MusicFacade musicFacade) {
        this.musicFacade = musicFacade;
    }

    /**
     *
     * @return
     */
    public String getPathSound() {
        return pathSound;
    }

    /**
     *
     * @param pathSound
     */
    public void setPathSound(String pathSound) {
        this.pathSound = pathSound;
    }
    
    /**
     *
     * @return
     */
    public String createMusic(){
        musicFacade.createMusic(getYearOfRelease(), getName(), getAuthor(), getAlbum(),getPathSound());
        return "main";
    }

}
