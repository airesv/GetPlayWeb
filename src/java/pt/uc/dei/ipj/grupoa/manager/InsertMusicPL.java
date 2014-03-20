package pt.uc.dei.ipj.grupoa.manager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;
import pt.uc.dei.ipj.grupoa.EJB.Musicinplaylist;
import pt.uc.dei.ipj.grupoa.EJB.UserData;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.entities.Playlist;


/**
 *
 * @author Aires
 */
@Named("insertMusicPL")
@RequestScoped
public class InsertMusicPL {

   
   @Inject
    private UserData ud;

    @EJB
    private Musicinplaylist mp;
    
   
    private Music mus;
    private List<Music> lstMusic;
    private DataModel<Music> tabelaM;
    private Playlist playlist;
    private String namePL;
    private String  message;
    

    /**
     * Creates a new instance of insertMusicPL
     */

    public InsertMusicPL() {

    }
    
    
    
    

    public UserData getUd() {
        return ud;
    }

    public void setUd(UserData ud) {
        this.ud = ud;
    }

    public Musicinplaylist getMp() {
        return mp;
    }

    public void setMp(Musicinplaylist mp) {
        this.mp = mp;
    }

    

    public Music getMus() {
        return mus;
    }

    public void setMus(Music mus) {
        this.mus = mus;
    }

    public List<Music> getLstMusic() {
        return lstMusic;
    }

    public void setLstMusic(List<Music> lstMusic) {
        this.lstMusic = lstMusic;
    }

    public DataModel<Music> getTabelaM() {
        long teste=ud.getIdPlaylist();
        setLstMusic(mp.allMusicNOTINPLaylistlist(teste));
        tabelaM = new CollectionDataModel<>(getLstMusic());
        return tabelaM;
    }

    public void setTabelaM(DataModel<Music> tabelaM) {
        this.tabelaM = tabelaM;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public String getNamePL() {
        return namePL;
    }

    public void setNamePL(String namePL) {
        this.namePL = namePL;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
    

}
