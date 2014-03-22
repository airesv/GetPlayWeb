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
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;

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
    
    @EJB
    private MusicFacade musicafacade;

    private Music mus;
    private List<Music> lstMusic;
    private DataModel<Music> tabelaM;

            
     /**
     * Creates a new instance of insertMusicPL
     */
    public InsertMusicPL() {

    }

    public String insertMusic() {
        mus = (Music) tabelaM.getRowData();
        mp.insertMusic(mus.getId(), ud.getIdPlaylist());
        ud.refreshPlaylist();
        return "viewpl";
    }

    
    
    
    
    public DataModel<Music> getTabelaM() {
        //setLstMusic(musicafacade.listOfAllMusics());
        //tabelaM = new CollectionDataModel<>(musicafacade.listOfAllMusics());
        setLstMusic(mp.allMusicNOTINPLaylist(ud.getIdPlaylist()));
       tabelaM = new CollectionDataModel<>(getLstMusic());
       
        return tabelaM;
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

    public MusicFacade getMusicafacade() {
        return musicafacade;
    }

    public void setMusicafacade(MusicFacade musicafacade) {
        this.musicafacade = musicafacade;
    }


    public void setTabelaM(DataModel<Music> tabelaM) {
        this.tabelaM = tabelaM;
    }

    
}
