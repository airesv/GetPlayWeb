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
import javax.enterprise.context.RequestScoped;

import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;
import pt.uc.dei.ipj.grupoa.EJB.OrderPL;
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
    private UserLogin ul;
    
    @EJB
    private UserPlayFacade userplayFacade;
    
    @EJB
    private OrderPL orderPL;
    
    @EJB
    private PlaylistFacade plfacade;
    
    
    
    private List<Playlist> lstplay;
    private DataModel<Playlist> table;
    private Playlist pl;
    private String namePL;
    private boolean asc;
    private long idPlaylist;

    /**
     * Creates a new instance of PLTable
     */
    public PLTable() {
    }

    @PostConstruct
    public void init() {
        setAsc(false);
        setLstplay(userplayFacade.lstPlaylist(ul.getIdUser()));
        table = new CollectionDataModel<>(lstplay);
    }

///////////////////////////////////////////////////////////////
    public String editPlaylist() {
        pl = (Playlist) table.getRowData();
        setIdPlaylist(pl.getId());
        setNamePL(pl.getNamePlaylist());
        return pl.getNamePlaylist();
    }
//
//    public void removePl() {
//        pl = (Playlist) table.getRowData();
//        plfacade.removePlaylist(pl, ul.getIdUser());
//        
//        //init();//recomeça
//    }

    public String orderByName() {
        setLstplay(orderPL.order(lstplay, isAsc()));
        table = new CollectionDataModel<>(lstplay);
        setAsc(!asc);
        return null;
    }

    ////Get and Setters////////////
    public UserLogin getUl() {
        return ul;
    }

    public void setUl(UserLogin ul) {
        this.ul = ul;
    }

    public UserPlayFacade getUserplayFacade() {
        return userplayFacade;
    }

    public void setUserplayFacade(UserPlayFacade userplayFacade) {
        this.userplayFacade = userplayFacade;
    }

    public OrderPL getOrderPL() {
        return orderPL;
    }

    public void setOrderPL(OrderPL orderPL) {
        this.orderPL = orderPL;
    }

    public PlaylistFacade getPlfacade() {
        return plfacade;
    }

    public void setPlfacade(PlaylistFacade plfacade) {
        this.plfacade = plfacade;
    }

    public List<Playlist> getLstplay() {
        return lstplay;
    }

    public void setLstplay(List<Playlist> lstplay) {
        this.lstplay = lstplay;
    }

    public DataModel<Playlist> getTable() {
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

    public String getNamePL() {
        return namePL;
    }

    public void setNamePL(String namePL) {
        this.namePL = namePL;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public long getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(long idPlaylist) {
        this.idPlaylist = idPlaylist;
    }
    
    
}
