/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import pt.uc.dei.ipj.grupoa.EJB.OrdenaPL;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.facades.PlaylistFacade;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author Aires
 */
@ManagedBean(name = "PLTable")
@ViewScoped
public class PLTable {

    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;
//    private long id;
//    private String name;
//    private String email;
//    private String password;

    @EJB
    private UserPlayFacade userplayFacade;

    @EJB
    private OrdenaPL ordenaPL;

    @EJB
    private PlaylistFacade plfacade;

    private List<Playlist> lstplay;
    private HtmlDataTable tabela;
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
        asc = false;
        setLstplay(userplayFacade.lstPlaylist(userlogin.getLoggedUser()));
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

    public HtmlDataTable getTabela() {
        return tabela;
    }

    /**
     * @param tabela the tabela to set
     */
    public void setTabela(HtmlDataTable tabela) {
        this.tabela = tabela;
    }

///////////////////////////////////////////////////////////////
    public String editPlaylist() {
        pl = (Playlist) tabela.getRowData();
        //   System.out.println("Playlist é do " + pl.getUserOwner().getName() + " e chama-se " + pl.getNamePlaylist());
        setNamePL(pl.getNamePlaylist());
        return pl.getNamePlaylist();
    }

    public void removePl() {
        pl = (Playlist) tabela.getRowData();
        plfacade.removePlaylist(pl, userlogin.getLoggedUser());
        init();//recomeça

    }

    public void ordenaBYName() {
        setLstplay(ordenaPL.ordena(lstplay, asc));
        asc = !asc;
    }

}
