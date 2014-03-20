/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import com.oracle.webservices.api.databinding.DatabindingMode;
import static com.sun.faces.facelets.util.Path.context;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import pt.uc.dei.ipj.grupoa.EJB.UserData;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;
import pt.uc.dei.uc.grupoa.utils.MyException;

/**
 *
 * @author alvaro
 */
@Named
@RequestScoped
public class EditMusic implements Serializable {

    @Inject
    private UserData ud;

    private List<Music> lstMusic;
    private static final long serialVersionUID = 1L;
    private int yearOfRelease=1920;
    private String nameMusic;
    private String author;
    private String album;
    private String pathSound;
    private Part file;
    private Music music;
    private Long id;
    @EJB
    private UserPlayFacade upf;
    @EJB
    private MusicFacade musicFacade;
    DataModel<Music> musicsLoggedInUser;
    private Music selectedMusic;

    /**
     *
     * @return
     * @throws IOException
     * @throws pt.uc.dei.uc.grupoa.utils.MyException
     */
    public String createNewMusic() throws IOException,MyException {
        musicFacade.createMusic(getYearOfRelease(), getNameMusic(), getAuthor(), getAlbum(), getPathSound(), ud.getIdUser(), getFile());
        ud.refreshMusicsUser();
        ud.refreshMusics();
        return "allmusic";
    }

    /**
     *
     * @return
     */
    public String editMusic() {
        musicFacade.editMusic(ud.getIdMusic(),ud.getIdUser());
        ud.refreshMusicsUser();
        ud.refreshMusics();
        return "editmusic";
    }

    /**
     *
     * @return
     */
    public String removeMusic() {  
        musicFacade.removeMusic(ud.getIdMusic(), ud.getIdUser());
        ud.refreshMusicsUser();
        ud.refreshMusics();
        return "editmusic";
    }

    /**
     *
     * @return
     */
    public String toEdit() {
        music = (Music) musicsLoggedInUser.getRowData();
        ud.setIdMusic(music.getId());
        this.setNameMusic(music.getName());
        this.setAlbum(music.getAlbum());
        this.setYearOfRelease(music.getYearOfRelease());
        this.setAuthor(music.getAuthor());
        return "editthatmusic";
    }

    /**
     *
     * @return
     */
    public DataModel<Music> getMusicsLoggedInUser() {
        musicsLoggedInUser = new CollectionDataModel<>(ud.getListUserMusic());
        return musicsLoggedInUser;
    }

    public MusicFacade getMusicFacade() {
        return musicFacade;
    }


    public Music getSelectedMusic() {
        return selectedMusic;
    }

    public UserPlayFacade getUp() {
        return upf;
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
        this.upf = up;
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

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public UserData getUd() {
        return ud;
    }

    public void setUd(UserData ud) {
        this.ud = ud;
    }

    public List<Music> getLstMusic() {
        return musicFacade.listOfAllMusics();
    }

 
    public void setLstMusic(List<Music> lstMusic) {
        this.lstMusic = lstMusic;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
    
    

}
