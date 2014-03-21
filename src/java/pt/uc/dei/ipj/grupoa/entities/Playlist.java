/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alvaro/Vitor
 */
@Entity

@NamedQueries({ //@NamedQuery(name = "Playlist.findByNameUser", query = "SELECT p FROM Playlist p where p.nameplaylist=:name and p.userCreatorPlaylist ")
// @NamedQuery(name = "Playlist.findByNameUser", query = "SELECT p FROM Playlist where p.nameplaylist=:name and p.userCreatorPlaylist=:id")
//    @NamedQuery(name = "Playlist.findAllOrderByDateAsc", query = "SELECT p FROM Playlist p ORDER by p.dateCreation ASC"),
//    @NamedQuery(name = "Playlist.findAllOrderByDateDesc", query = "SELECT p FROM Playlist p ORDER by p.dateCreation DESC"),
//    @NamedQuery(name = "Playlist.findAllOrderBySizeDesc", query = "SELECT count(p.musicList.id)  FROM Playlist p ORDER by p.dateCreation DESC"),
//    @NamedQuery(name = "Playlist.findAllOrderByNameAsc", query = "SELECT p FROM Playlist p ORDER by p.namePlaylist ASC"),
//    @NamedQuery(name = "Playlist.findAllOrderByNameDesc", query = "SELECT p FROM Playlist p ORDER by p.namePlaylist DESC"),
//
//    @NamedQuery(name = "Playlist.findAllByUser", query = "SELECT p FROM Playlist p WHERE p.userPlay.email=:email"),
  //  @NamedQuery(name = "Playlist.findAllByAuthor", query = "SELECT p FROM Playlist p WHERE p.author = :author"),

})
public class Playlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 1, max = 20, message = "Name is mandatory and cannot contain more "
            + "than 20 characters")
    private String namePlaylist;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = UserPlay.class)
    @JoinColumn(name = "userID")
    private UserPlay userOwner;

    @ManyToMany
    @JoinTable(name = "hasMusic", joinColumns = {
        @JoinColumn(name = "playlistFK")},
            inverseJoinColumns = @JoinColumn(name = "musicFK"))
    private List<Music> musicList;

    /**
     *
     */
    public Playlist() {
    }

    /**
     *
     * @param id
     */
    public Playlist(Long id) {
        this.id = id;
    }

    /**
     *
     * @param namePlaylist
     * @param hoje
     */
    public Playlist(String namePlaylist, Date hoje) {

        this.namePlaylist = namePlaylist;

    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return
     */
    public List<Music> getMusicList() {
        return musicList;
    }

    /**
     *
     * @param musicList
     */
    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    /**
     * @param namePlaylist the namePlaylist to set
     */
    public void setNamePlaylist(String namePlaylist) {
        this.namePlaylist = namePlaylist;
    }

    /**
     * @return the dateCreation
     * 
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

    /**
     *
     * @return
     */
    public UserPlay getUserOwner() {
        return userOwner;
    }

    /**
     *
     * @param userOwner
     */
    public void setUserOwner(UserPlay userOwner) {
        this.userOwner = userOwner;
    }

    /**
     *
     * @return
     */
    public int playlistSize() {
        return this.musicList.size();

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
        if ((this.id == null && other.id != null) || (this.id != null
                && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Playlist[ id=" + id + " ]";
    }

    /**
     *
     * @param mus
     */
    public void setPlaylistItem(Music mus){
       musicList.add(mus);
   }

}
