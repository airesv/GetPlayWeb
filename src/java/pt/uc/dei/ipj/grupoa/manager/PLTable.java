/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author Aires
 */
@ManagedBean(name = "PLTable")
@RequestScoped
public class PLTable {
    
    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;
    private long id;
    private String name;
    private String email;
    private String password;
    
    @EJB
    private UserPlayFacade userplayFacade;
    
    private List<Playlist> lstplay;
    
    private boolean sortAscending;

    /**
     * Creates a new instance of PLTable
     */
    public PLTable() {
    }
    
    public boolean isSortAscending() {
        return sortAscending;
    }
    
    public void setSortAscending(boolean sortAscending) {
        this.sortAscending = sortAscending;
    }
    
    @PostConstruct
    public void init() {
        setSortAscending(false);
        setId((long) getUserlogin().getLoggedUser().getId());
        setName(getUserlogin().getLoggedUser().getName());
        setEmail(getUserlogin().getLoggedUser().getEmail());
        
        setLstplay(userplayFacade.lstPlaylist(userlogin.getLoggedUser()));
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
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
    
    private final Comparator NAME_SORT_ASC = new Comparator<Playlist>() {
        @Override
        public int compare(Playlist o1, Playlist o2) {
            return o1.getNamePlaylist().compareTo(o2.getNamePlaylist());
        }
    };
    
    private final Comparator NAME_SORT_DESC = new Comparator<Playlist>() {
        @Override
        public int compare(Playlist o1, Playlist o2) {
            return o2.getNamePlaylist().compareTo(o1.getNamePlaylist());
        }
    };
    
    public String sort() {
        if (isSortAscending()) {
            Collections.sort(lstplay, NAME_SORT_ASC);            
            
            setSortAscending(false);
        } else {
            Collections.sort(lstplay, NAME_SORT_DESC);
            setSortAscending(false);
        }        
        return null;
    }
    
}
