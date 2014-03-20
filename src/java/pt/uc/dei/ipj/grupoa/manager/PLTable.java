/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;
import pt.uc.dei.ipj.grupoa.EJB.UserData;
import pt.uc.dei.ipj.grupoa.entities.Music;

import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author Aires
 */
@Named("plTable")
@RequestScoped
public class PLTable implements Serializable {

    @Inject
    private UserData ud;

    @EJB
    private UserPlayFacade userplayFacade;

    @EJB
    private PlaylistFacade plfacade;

    private DataModel<Playlist> table;
    private String namePlaylist;
    private Playlist pl;
    private String message;
    private DataModel<Music> tableM;
    

    /**
     * Creates a new instance of PLTable
     */
    public PLTable() {
    }

    @PostConstruct
    public void init() {
        //      table = new CollectionDataModel<>(ud.getLstPlaylist());
    }

///////////////////////////////////////////////////////////////
    public String editPlaylist() {
        pl = (Playlist) table.getRowData();
        ud.setIdPlaylist(pl.getId());
        this.setNamePlaylist(pl.getNamePlaylist());
        return "viewpl";
    }

    public void removePl() {
        pl = (Playlist) table.getRowData();
        plfacade.removePlaylist(pl, ud.getIdUser());
        //init()
    }

    public String orderByName() {
        table = new CollectionDataModel<>(ud.orderPlaylist());
        return null;
    }

    public String renamePlaylist() {
        //mandar para o face 
        boolean renamed = plfacade.changeNamePlaylist(ud.getIdUser(), ud.getIdPlaylist(), getNamePlaylist());
        if (renamed) {
            setMessage("Successfully changed");
        } else {
            setMessage("There is a Playlist with that name!");
        }
        ud.loadPlaylist();//recarrega a lista de playlist
        return null;
    }

    public String createNewPlaylist() {
        plfacade.createPlayList(getNamePlaylist(), ud.getIdUser());
        ud.loadPlaylist();//recarrega a lista de playlist
        return null;
    }

    public String insertMusPL() {
        return "musicinplay";
    }
    
    

    ////Get and Setters////////////
    public UserData getUd() {
        return ud;
    }

    public void setUd(UserData ud) {
        this.ud = ud;
    }

    public UserPlayFacade getUserplayFacade() {
        return userplayFacade;
    }

    public void setUserplayFacade(UserPlayFacade userplayFacade) {
        this.userplayFacade = userplayFacade;
    }

    public PlaylistFacade getPlfacade() {
        return plfacade;
    }

    public void setPlfacade(PlaylistFacade plfacade) {
        this.plfacade = plfacade;
    }

    public DataModel<Playlist> getTable() {
        table = new CollectionDataModel<>(ud.getLstPlaylist());
        return table;
    }

    public void setTable(DataModel<Playlist> table) {

        this.table = table;
    }

    public Playlist getPl() {
        return pl;
    }

    public void setPl(Playlist pl) {
        this.pl = pl;
    }

    public String getNamePlaylist() {
        return namePlaylist;
    }

    public void setNamePlaylist(String namePlaylist) {
        this.namePlaylist = namePlaylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataModel<Music> getTableM() {
        table = new CollectionDataModel<>(ud.getLstPlaylist());
        return tableM;
    }

    public void setTableM(DataModel<Music> tableM) {
        this.tableM = tableM;
    }

}
