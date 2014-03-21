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
import pt.uc.dei.ipj.grupoa.EJB.Musicinplaylist;
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

    @EJB
    private Musicinplaylist mp;

    private DataModel<Playlist> table;
    private String namePlaylist;
    private Playlist pl;
    private Music mus;
    private String message;
    private DataModel<Music> tableM;

    /**
     * Creates a new instance of PLTable
     */
    public PLTable() {
    }

    /**
     *
     */
    @PostConstruct
    public void init() {
        //      table = new CollectionDataModel<>(ud.getLstPlaylist());
    }

///////////////////////////////////////////////////////////////
    /**
     *
     * @return
     */
    public String editPlaylist() {
        pl = (Playlist) table.getRowData();
        ud.setIdPlaylist(pl.getId());
        this.setNamePlaylist(pl.getNamePlaylist());
        return "viewpl";
    }

    /**
     *
     */
    public void removePl() {
        pl = (Playlist) table.getRowData();
        plfacade.removePlaylist(pl, ud.getIdUser());
        ud.refreshPlaylist();
        //init()
    }

    /**
     *
     * @return
     */
    public String orderByName() {
        table = new CollectionDataModel<>(ud.orderPlaylist());
        return null;
    }

    public String orderBySize() {
        table = new CollectionDataModel<>(ud.orderPlaylistSize());
        return null;
    }

    /**
     *
     * @return
     */
    public String renamePlaylist() {
        //mandar para o face 
        boolean renamed = plfacade.changeNamePlaylist(ud.getIdUser(), ud.getIdPlaylist(), getNamePlaylist());
        if (renamed) {
            setMessage("Successfully changed");
        } else {
            setMessage("There is a Playlist with that name!");
        }
        ud.refreshPlaylist();//recarrega a lista de playlist
        return null;
    }

    /**
     *
     * @return
     */
    public String createNewPlaylist() {
        plfacade.createPlayList(getNamePlaylist(), ud.getIdUser());
        ud.refreshPlaylist();//recarrega a lista de playlist
        return null;
    }

    public String removeMusic() {
        mus = (Music) tableM.getRowData();
        mp.removeMusicPlayList(mus.getId(), ud.getIdPlaylist());
        ud.refreshPlaylist();
        return null;
    }

    /**
     *
     * @return
     */
    public String insertMusPL() {
        return "musicinplay";
    }

    ////Get and Setters////////////
    /**
     *
     * @return
     */
    public UserData getUd() {
        return ud;
    }

    /**
     *
     * @param ud
     */
    public void setUd(UserData ud) {
        this.ud = ud;
    }

    /**
     *
     * @return
     */
    public UserPlayFacade getUserplayFacade() {
        return userplayFacade;
    }

    /**
     *
     * @param userplayFacade
     */
    public void setUserplayFacade(UserPlayFacade userplayFacade) {
        this.userplayFacade = userplayFacade;
    }

    /**
     *
     * @return
     */
    public PlaylistFacade getPlfacade() {
        return plfacade;
    }

    /**
     *
     * @param plfacade
     */
    public void setPlfacade(PlaylistFacade plfacade) {
        this.plfacade = plfacade;
    }

    /**
     *
     * @return
     */
    public DataModel<Playlist> getTable() {
        table = new CollectionDataModel<>(ud.getLstPlaylist());
        return table;
    }

    /**
     *
     * @param table
     */
    public void setTable(DataModel<Playlist> table) {

        this.table = table;
    }

    /**
     *
     * @return
     */
    public Playlist getPl() {
        return pl;
    }

    /**
     *
     * @param pl
     */
    public void setPl(Playlist pl) {
        this.pl = pl;
    }

    /**
     *
     * @return
     */
    public String getNamePlaylist() {
        return namePlaylist;
    }

    /**
     *
     * @param namePlaylist
     */
    public void setNamePlaylist(String namePlaylist) {
        this.namePlaylist = namePlaylist;
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public DataModel<Music> getTableM() {
        tableM = new CollectionDataModel<>(mp.allMusicinPLaylistlist(ud.getIdPlaylist()));
        return tableM;
    }

    /**
     *
     * @param tableM
     */
    public void setTableM(DataModel<Music> tableM) {
        this.tableM = tableM;
    }

}
