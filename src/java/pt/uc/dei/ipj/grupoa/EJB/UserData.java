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
import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;
import pt.uc.dei.uc.grupoa.utils.OrderPL;

/**
 *
 * @author Aires
 */
@Stateful
@SessionScoped

public class UserData {

    private long idUser;
    private String nameUser;
    private String emailUser;
    private long idPlaylist;
    private long idMusic;
    private List<Music> lstMusic;
    private List<Playlist> lstPlaylist;

    @EJB
    private UserPlayFacade userplayFacade;

    @EJB
    private PlaylistFacade playlistFacade;

    private OrderPL orderPL;
    private boolean asc = Boolean.FALSE;

    public void loadPlaylist() {
        setLstPlaylist(userplayFacade.lstPlaylist(getIdUser()));
    }

    public void loadMusic() {
        setLstMusic(userplayFacade.lstMusicList(getIdUser()));
    }

    public List<Playlist> orderPlaylist() {
        orderPL = new OrderPL();
        setLstPlaylist(orderPL.order(getLstPlaylist(), isAsc()));
        setAsc(!asc);
        return lstPlaylist;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

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

    public List<Music> getLstMusic() {

        return lstMusic;
    }

    public void setLstMusic(List<Music> lstMusic) {
        this.lstMusic = lstMusic;
    }

    public List<Playlist> getLstPlaylist() {

        return lstPlaylist;
    }

    public void setLstPlaylist(List<Playlist> lstPlaylist) {
        this.lstPlaylist = lstPlaylist;
    }

}
