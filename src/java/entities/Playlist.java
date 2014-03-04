/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Aires
 */
@Entity
public class Playlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min =1,max=20 , message = "Name is mandatory and cannot contain more "
            + "than 20 characters")
    private String namePlaylist;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @OneToOne
    private UserPlay userPlay;
    @ManyToMany
    private Collection<Music> musicList;

    public Playlist() {
    }

    public Playlist(Long id) {
        this.id = id;
    }

    public Playlist(Long id, String namePlaylist, Date dateCreation, UserPlay 
            userPlay, Collection<Music> musicList) {
        this.id = id;
        this.namePlaylist = namePlaylist;
        this.dateCreation = dateCreation;
        this.userPlay = userPlay;
        this.musicList = musicList;
    }
    
    public Long getId() {
        return id;
    }
    
    

    public void setId(Long id) {
        this.id = id;
    }

     public String getNamePlaylist() {
        return namePlaylist;
    }

    /**
     * @param namePlaylist the namePlaylist to set
     */
    public void setNamePlaylist(String namePlaylist) {
        this.namePlaylist = namePlaylist;
    }

    /**
     * @return the dateCreation
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * @param dateCreation the dateCreation to set
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }


    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields 
       // are not set
        if (!(object instanceof Playlist)) {
            return false;
        }
        Playlist other = (Playlist) object;
        if ((this.id == null && other.id != null) || (this.id != null && 
                !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Playlist[ id=" + id + " ]";
    }

    /**
     * @return the namePlaylist
     */
    
}
