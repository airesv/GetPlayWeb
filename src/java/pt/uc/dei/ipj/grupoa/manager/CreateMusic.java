/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.IOException;
import java.io.Serializable;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "CreateMusic")
@RequestScoped
public class CreateMusic implements Serializable {

    @EJB
    private UserPlayFacade up;
    @EJB
    private MusicFacade musicFacade;
    //@ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;
    


    private int yearOfRelease=1920;
    private String nameMusic;
    private String author;
    private String album;
    private String pathSound;
    private Part file;

    public CreateMusic() {
    }

    public String createNewMusic() throws IOException {
       musicFacade.createMusic(getYearOfRelease(), getNameMusic(), getAuthor(), getAlbum(), getPathSound(), userlogin.getLoggedUser(), getFile());
       //  musicFacade.createMusic(getYearOfRelease(), getNameMusic(), getAuthor(), getAlbum(), getPathSound(), userlogged.getNameUserLogged(), getFile());
        return "allmusic";
    }

    public UserPlayFacade getUp() {
        return up;
    }

    public void setUp(UserPlayFacade up) {
        this.up = up;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public UserLogin getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(UserLogin userlogin) {
        this.userlogin = userlogin;
    }

   

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

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

}
