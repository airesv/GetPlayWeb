/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.EJB;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;
import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;
import pt.uc.dei.uc.grupoa.utils.OrderPL;

/**
 *
 * @author Alvaro/Vitor
 */
@Stateful
@SessionScoped

public class UserData {

    private long idUser;
    private String nameUser;
    private String emailUser;
    private long idPlaylist;
    private long idMusic;
    private String namePlay;
    private List<Music> lstAllMusic;
    private List<Playlist> lstPlaylist;
    private List<Music> listUserMusic;

    @EJB
    private UserPlayFacade userplayFacade;

    @EJB
    private PlaylistFacade playlistFacade;

    @EJB
    private MusicFacade musicfacade;

    private OrderPL orderPL;
    private boolean asc = Boolean.FALSE;
    private boolean ascSize = Boolean.FALSE;

    /**
     * Update the list of playlists on user
     */
    public void refreshPlaylist() {
        setLstPlaylist(userplayFacade.lstPlaylist(getIdUser()));
    }

    /**
     * Update the list of musics on application
     */
    public void refreshMusics() {
        setLstAllMusic(musicfacade.listOfAllMusics());
    }

    /**
     * Update the list of musics on user
     */
    public void refreshMusicsUser() {
        setListUserMusic(userplayFacade.lstMusicList(getIdUser()));
    }

    /**
     *
     * @return Playlist ordered
     */
    public List<Playlist> orderPlaylist() {
        orderPL = new OrderPL();
        setLstPlaylist(orderPL.order(getLstPlaylist(), isAsc()));
        setAsc(!asc);
        return lstPlaylist;
    }

    public List<Playlist> orderPlaylistSize() {
        orderPL = new OrderPL();
        setLstPlaylist(orderPL.orderSize(getLstPlaylist(), isAscSize()));
        setAscSize(!isAscSize());
        return lstPlaylist;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    ////Getters and Setters///
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public long getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(long idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public long getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(long idMusic) {
        this.idMusic = idMusic;
    }

    public List<Music> getLstAllMusic() {
        return lstAllMusic;
    }

    public void setLstAllMusic(List<Music> lstAllMusic) {
        this.lstAllMusic = lstAllMusic;
    }

    public List<Playlist> getLstPlaylist() {

        return lstPlaylist;
    }

    public void setLstPlaylist(List<Playlist> lstPlaylist) {
        this.lstPlaylist = lstPlaylist;
    }

    public List<Music> getListUserMusic() {
        return listUserMusic;
    }

    public void setListUserMusic(List<Music> listUserMusic) {
        this.listUserMusic = listUserMusic;
    }

    /**
     * @return the ascSize
     */
    public boolean isAscSize() {
        return ascSize;
    }

    /**
     * @param ascSize the ascSize to set
     */
    public void setAscSize(boolean ascSize) {
        this.ascSize = ascSize;
    }

    /**
     * @return the namePlay
     */
    public String getNamePlay() {
        return namePlay;
    }

    /**
     * @param namePlay the namePlay to set
     */
    public void setNamePlay(String namePlay) {
        this.namePlay = namePlay;
    }

}
