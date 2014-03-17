/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import pt.uc.dei.ipj.grupoa.EJB.OrderPL;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author Aires
 */
@ManagedBean(name = "PLTable")
@SessionScoped
public class PLTable implements Serializable {

    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;
    @EJB
    private UserPlayFacade userplayFacade;
    @EJB
    private OrderPL orderPL;
    @EJB
    private PlaylistFacade plfacade;
    private List<Playlist> lstplay;
    DataModel<Playlist> table;
    private Playlist pl;
    private String namePL;
    private boolean asc;

    /**
     * Creates a new instance of PLTable
     */
    public PLTable() {
    }

    @PostConstruct
    public void init() {
        setAsc(false);
        setLstplay(userplayFacade.lstPlaylist(userlogin.getLoggedUser()));
        table = new CollectionDataModel<>(lstplay);
    }

///////////////////////////////////////////////////////////////
    public String editPlaylist() {
        pl = (Playlist) table.getRowData();
        //   System.out.println("Playlist é do " + pl.getUserOwner().getName() + " e chama-se " + pl.getNamePlaylist());
        setNamePL(pl.getNamePlaylist());
        return pl.getNamePlaylist();
    }

    public void removePl() {
        pl = (Playlist) table.getRowData();
        plfacade.removePlaylist(pl, userlogin.getLoggedUser());
        init();//recomeça
    }

    public void orderByName() {
        setLstplay(orderPL.order(lstplay, isAsc()));
        table = new CollectionDataModel<>(lstplay);
        setAsc(!asc);
    }

        ////Get and Setters////////////

    /**
     * @return the asc
     */
    public boolean isAsc() {
        return asc;
    }

    /**
     * @param asc the asc to set
     */
    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public PlaylistFacade getPlfacade() {
        return plfacade;
    }

    public void setPlfacade(PlaylistFacade plfacade) {
        this.plfacade = plfacade;
    }

    ///////////////////////////Getter & Setters/////////////////////
    public Playlist getPl() {
        return pl;
    }

    public void setPl(Playlist pl) {
        this.pl = pl;
    }

    public String getNamePL() {
        return namePL;
    }

    public void setNamePL(String namePL) {
        this.namePL = namePL;
    }

    public DataModel<Playlist> getTable() {
        return table;
    }

    public void setTable(DataModel<Playlist> table) {
        this.table = table;
    }

    /**
     * @return the userlogin
     */
    public UserLogin getUserlogin() {
        return userlogin;
    }

    /**
     * @param userlogin the userlogin to set
     */
    public void setUserlogin(UserLogin userlogin) {
        this.userlogin = userlogin;
    }

    /**
     * @return the userplayFacade
     */
    public UserPlayFacade getUserplayFacade() {
        return userplayFacade;
    }

    /**
     * @param userplayFacade the userplayFacade to set
     */
    public void setUserplayFacade(UserPlayFacade userplayFacade) {
        this.userplayFacade = userplayFacade;
    }

    /**
     * @return the lstplay
     */
    public List<Playlist> getLstplay() {
        return lstplay;
    }

    /**
     * @param lstplay the lstplay to set
     */
    public void setLstplay(List<Playlist> lstplay) {
        this.lstplay = lstplay;
    }

}
