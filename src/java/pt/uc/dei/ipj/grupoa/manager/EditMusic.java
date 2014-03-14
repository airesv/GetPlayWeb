/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.IOException;
import java.io.Serializable;
import static java.lang.StrictMath.E;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "EditMusic")
@SessionScoped
public class EditMusic implements Serializable {

    @EJB
    private UserPlayFacade up;

    @EJB
    private MusicFacade musicFacade;

    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;

    private List<Music> lstMusic;

    private boolean display;

    public boolean isDisplay() {
        return display;
    }
    private String message;
    private int yearOfRelease;
    private String nameMusic;
    private String author;
    private String album;
    private String pathSound;
    /**
     * Creates a new instance of CreateMusic
     */
    private static final long serialVersionUID = 1L;

    //private static final Music[] musicList = new Music[];

   /* private final DataModel<Music> musicsLoggedInUser = new ArrayDataModel<>(musicList);

    public DataModel<Music> getMusicsLoggedInUser() {
        return musicsLoggedInUser;
    }*/

    private long id;
    private String name;
    private String email;

    /**
     * Creates a new instance of EditMusic
     *
     * @return
     */
    private HtmlDataTable dataMusic = new HtmlDataTable();

    public HtmlDataTable getDataMusic() {
        return dataMusic;
    }

    public void setDataMusic(HtmlDataTable dataMusic) {
        this.dataMusic = dataMusic;
    }

    public String saveAction() {
        musicFacade.editMusic(getId(), getName(), getAlbum(), getAuthor(), getYearOfRelease(), (Music) dataMusic.getRowData());
        return "editmusic";
    }


    /* public String rowSelected() {

     Music music = musicsLoggedInUser.getRowData();
     return "editthatmusic";

     }*/
    public Music rowSelectedMusic() {
        return (Music) dataMusic.getRowData();
    }

    public String editAction() throws IOException {
        musicFacade.setEditable(true);
        return "edit";
    }

//    public void delete() {
//  service.getList().remove(table.getRowData());
//}
    public List<Music> listOfMusicsOfLoggedInUser() {
        return userlogin.getLoggedUser().getMusic();
    }

    public UserPlayFacade getUp() {
        return up;
    }

    public void setUp(UserPlayFacade up) {
        this.up = up;
    }

    public MusicFacade getMusicFacade() {
        return musicFacade;
    }

    public void setMusicFacade(MusicFacade musicFacade) {
        this.musicFacade = musicFacade;
    }

    public UserLogin getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(UserLogin userlogin) {
        this.userlogin = userlogin;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
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

    public String getPathSound() {
        return pathSound;
    }

    public void setPathSound(String pathSound) {
        this.pathSound = pathSound;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
