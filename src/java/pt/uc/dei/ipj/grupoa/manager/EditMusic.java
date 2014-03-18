/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author alvaro
 */
@Named
@RequestScoped
public class EditMusic implements Serializable {

    
    private List<Music> lstMusic;
    private static final long serialVersionUID = 1L;
    private int yearOfRelease;
    private String nameMusic;
    private String author;
    private String album;
    private String pathSound;
    private Part file;
    @EJB
    private UserPlayFacade upf;
    @EJB
    private MusicFacade musicFacade;
    @Inject
    private UserLogin userLogin;
    DataModel<Music> musicsLoggedInUser;
    private Music selectedMusic;
    @Inject
    private Conversation conversation;

    @PostConstruct
    public void init() {
        List<Music> musicList = upf.getUser(userLogin.getLoggedUser().getEmail()).getMusic();
        musicsLoggedInUser = new CollectionDataModel<>(musicList);
        setLstMusic(musicFacade.listOfAllMusics());
        setSelectedMusic(selectedMusic);
    }

    public void initConversation() {
        if (!FacesContext.getCurrentInstance().isPostback()
                && conversation.isTransient()) {

            conversation.begin();
        }
    }

   

    public String createNewMusic() throws IOException {
        musicFacade.createMusic(getYearOfRelease(), getNameMusic(), getAuthor(), getAlbum(), getPathSound(), upf.getUser(userLogin.getUserlogged().getEmailUserLogged()), getFile());
        return "allmusic";
    }

    public String endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return "step1?faces-redirect=true";
    }

    public String editMusic() {
        musicFacade.edit(selectedMusic);
        return "editmusic";
    }

    public String removeMusic() {
        endConversation();
        musicFacade.remove(selectedMusic);
        return "editmusic";
    }

    public DataModel<Music> getMusicsLoggedInUser() {
        return musicsLoggedInUser;
    }

    public MusicFacade getMusicFacade() {
        return musicFacade;
    }

    public Music getSelectedMusic() {
        initConversation();
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

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public List<Music> getLstMusic() {
        return lstMusic;
    }

    public void setLstMusic(List<Music> lstMusic) {
        this.lstMusic = lstMusic;
    }
    

}
