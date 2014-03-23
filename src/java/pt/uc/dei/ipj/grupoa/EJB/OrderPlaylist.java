/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.EJB;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.inject.Inject;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;
import pt.uc.dei.ipj.grupoa.manager.UserManager;
import pt.uc.dei.uc.grupoa.utils.OrderPL;

/**
 *
 * @author Aires
 */
@Stateful
public class OrderPlaylist {

    @Inject
    private UserManager ul;
    @EJB
    private PlaylistFacade playlistfacade;

    private List<Playlist> lstPlaylist;
    private boolean asc;
    
    private OrderPL orderPL;
    private boolean ascSize;

    /**
     *
     */
    public void orderList() {
        if (asc) {
            setLstPlaylist(playlistfacade.orderPLbyNameASC(ul.getIdUser()));
            asc = false;
        } else {
            setLstPlaylist(playlistfacade.orderPLbyNameDESC(ul.getIdUser()));
            asc = true;
        }

    }
    
   
    

    /**
     *
     * @return
     */
    public List<Playlist> getLstPlaylist() {
        return lstPlaylist;
    }

    /**
     *
     * @param lstPlaylist
     */
    public void setLstPlaylist(List<Playlist> lstPlaylist) {
        this.lstPlaylist = lstPlaylist;
    }

    /**
     *
     * @return
     */
    public boolean isAsc() {
        return asc;
    }

    /**
     *
     * @param asc
     */
    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    /**
     *
     * @return
     */
    public PlaylistFacade getPlaylistfacade() {
        return playlistfacade;
    }

    /**
     *
     * @param playlistfacade
     */
    public void setPlaylistfacade(PlaylistFacade playlistfacade) {
        this.playlistfacade = playlistfacade;
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

}
