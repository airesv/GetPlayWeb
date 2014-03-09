 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author alvaro
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Music.findAll", query = "SELECT m FROM Music m order by m asc"),
    @NamedQuery(name = "Music.findById", query = "SELECT m FROM Music m WHERE m.id = :Id"),
    @NamedQuery(name = "Music.findByAlbumAsc", query = "SELECT m FROM Music m WHERE m.album = :Album order by m.album asc"),
    @NamedQuery(name = "Music.findByAlbumDesc", query = "SELECT m FROM Music m WHERE m.album = :Album order by m.album desc"),
    @NamedQuery(name = "Music.findByNameAsc", query = "SELECT m FROM Music m WHERE m.name = :Name order by m.name asc"),
    @NamedQuery(name = "Music.findByNameDesc", query = "SELECT m FROM Music m WHERE m.name = :Name order by m.name desc"),
    @NamedQuery(name = "Music.findByAuthorAsc", query = "SELECT m FROM Music m WHERE m.author = :Author order by m.author asc"),
    @NamedQuery(name = "Music.findByAuthorDesc", query = "SELECT m FROM Music m WHERE m.author = :Author order by m.author desc"),
    @NamedQuery(name = "Music.findByYearOfReleaseAsc", query = "SELECT m FROM Music m WHERE m.yearOfRelease = :YearOfRelease order by m.yearOfRelease asc"),
    @NamedQuery(name = "Music.findByYearOfReleaseDesc", query = "SELECT m FROM Music m WHERE m.yearOfRelease = :YearOfRelease order by m.yearOfRelease desc")
})
public class Music implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull

    private Long id;
    @Pattern(regexp = "(19|20)\\d\\d",
            message = "{invalid.yearOfRelease}")
    @Column(name = "YEAR_OF_RELEASE")
    private int yearOfRelease;
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

    public Music() {
    }

    public Music(Long id) {
        this.id = id;
    }

    public Music(int yearOfRelease, String name, String author, String album, String pathSound) {
        this.yearOfRelease = yearOfRelease;
        this.name = name;
        this.author = author;
        this.album = album;
        this.pathSound=pathSound;

    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPathSound() {
        return pathSound;
    }

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

    @Override
    public String toString() {
        return "entities.Music[ id=" + id + " ]";
    }

}
