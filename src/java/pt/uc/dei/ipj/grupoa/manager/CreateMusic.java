/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.Serializable;
import java.util.List;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "CreateMusic")
@SessionScoped
public class CreateMusic implements Serializable {

    @EJB
    private UserPlayFacade up;

    @EJB
    private MusicFacade musicFacade;

    public UploadBean getUploadBean() {
        return uploadBean;
    }

    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;

    public void setUploadBean(UploadBean uploadBean) {
        this.uploadBean = uploadBean;
    }

    @ManagedProperty(value = "#{UploadBean}")
    private UploadBean uploadBean;

    private boolean editable;

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    private int yearOfRelease;
    private String nameMusic;
    private String author;
    private String album;
    private String pathSound;
    /**
     * Creates a new instance of CreateMusic
     */
  
    private long id;
    private String name;
    private String email;



    public CreateMusic() {
    }
//   @PostConstruct
//    public void init() {
////        yearOfRelease=Integer.parseInt(null);
//        setId((long) userlogin.getLoggedUser().getId());
//        setName(userlogin.getLoggedUser().getName());
//        setEmail(userlogin.getLoggedUser().getEmail());
//
//    }



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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    /**
     *
     * @return
     */
    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    /**
     *
     * @param yearOfRelease
     */
    public void setYearOfRelease(Integer yearOfRelease) {
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
    public String createNewMusic() {
        musicFacade.createMusic(getYearOfRelease(), getNameMusic(), getAuthor(), getAlbum(), uploadBean.getPath(), userlogin.getLoggedUser());
        return "main";
    }

}
