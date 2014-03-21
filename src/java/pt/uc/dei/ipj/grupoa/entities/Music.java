 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Alvaro/Vitor
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Music.findAll", query = "SELECT m FROM Music m order by m asc"),
    @NamedQuery(name = "Music.findById", query = "SELECT m FROM Music m, UserPlay u WHERE u.id = :id"),
    @NamedQuery(name = "Music.findByAlbumAsc", query = "SELECT m FROM Music m WHERE m.album = :album order by m.album asc"),
    @NamedQuery(name = "Music.findByAlbumDesc", query = "SELECT m FROM Music m WHERE m.album = :album order by m.album desc"),
    @NamedQuery(name = "Music.findByName", query = "SELECT m FROM Music m WHERE m.name like :name"),
    @NamedQuery(name = "Music.findByNameDesc", query = "SELECT m FROM Music m WHERE m.name = :name order by m.name desc"),
    @NamedQuery(name = "Music.findByAuthorAsc", query = "SELECT m FROM Music m WHERE m.author =:author order by m.author asc"),
    @NamedQuery(name = "Music.findByAuthor", query = "SELECT m FROM Music m WHERE m.author like :author"),
    @NamedQuery(name = "Music.findByOwner", query = "SELECT m FROM Music m,UserPlay u WHERE m.userOwner = :userOwner"),
    @NamedQuery(name = "Music.findByAuthorDesc", query = "SELECT m FROM Music m WHERE m.author = :author order by m.author desc"),
    @NamedQuery(name = "Music.findByYearOfReleaseAsc", query = "SELECT m FROM Music m WHERE m.yearOfRelease = :yearOfRelease order by m.yearOfRelease asc"),
    @NamedQuery(name = "Music.findByYearOfReleaseDesc", query = "SELECT m FROM Music m WHERE m.yearOfRelease = :yearOfRelease order by m.yearOfRelease desc")
})
public class Music implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull

    private Long id;
//    @Pattern(regexp = "(19|20)\\d\\d",
//            message = "{invalid.yearOfRelease}")
    @Column(name = "YEAR_OF_RELEASE")
    @NotNull
    private Integer yearOfRelease;
    @Size(min = 1, max = 20, message = "Name is mandatory and cannot contain "
            + "more than 20 characters")
    @Column(name = "NAME")
    private String name;
    @Size(min = 1, max = 20, message = "Author is mandatory and cannot contain "
            + "more than 20 characters")
    @Column(name = "AUTHOR")
    private String author;
    @Basic(optional = true)
    @Size(max = 20, message = "Album cannot contain more than 20 characters")
    @Column(name = "ALBUM")
    private String album;
    @NotNull
    @Column(name = "PathSound")
    private String pathSound;

    @ManyToMany(mappedBy = "musicList")
    private List<Playlist> lstPlaylist;

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    //
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = UserPlay.class)
    @JoinColumn(name = "userID")
    private UserPlay userOwner;

    /**
     *
     */
    public Music() {
    }

    /**
     *
     * @param id
     */
    public Music(Long id) {
        this.id = id;
    }

    /**
     *
     * @param yearOfRelease
     * @param name
     * @param author
     * @param album
     * @param pathSound
     */
    public Music(int yearOfRelease, String name, String author, String album, String pathSound) {
        this.yearOfRelease = yearOfRelease;
        this.name = name;
        this.author = author;
        this.album = album;
        this.pathSound = pathSound;

    }

    /**
     *
     * @return
     */
    /**
     *
     * @param yearOfRelease
     */
    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     */
    public String getAlbum() {
        return album;
    }

    /**
     *
     * @param album
     */
    public void setAlbum(String album) {
        this.album = album;
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
    public String getPathSound() {
        return pathSound;
    }

    /**
     *
     * @param pathSound
     */
    public void setPathSound(String pathSound) {
        this.pathSound = pathSound;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Music)) {
            return false;
        }
        Music other = (Music) object;
        if ((this.id == null && other.id != null) || (this.id != null
                && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * @return the userOwner
     */
    public UserPlay getUserOwner() {
        return userOwner;
    }

    /**
     * @param userOwner the userOwner to set
     */
    public void setUserOwner(UserPlay userOwner) {
        this.userOwner = userOwner;
    }

    @Override
    public String toString() {
        return "entities.Music[ id=" + id + " ]";
    }

    /**
     *
     * @param pl
     */
    public void setPlaylistItem(Playlist pl) {
        lstPlaylist.add(pl);
    }

    /**
     * @return the lstPlaylist
     */
    public List<Playlist> getLstPlaylist() {
        return lstPlaylist;
    }

    /**
     * @param lstPlaylist the lstPlaylist to set
     */
    public void setLstPlaylist(List<Playlist> lstPlaylist) {
        this.lstPlaylist = lstPlaylist;
    }

}
