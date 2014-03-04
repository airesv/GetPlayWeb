/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Music implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @Pattern(regexp = "(19|20)\\d\\d",
            message = "{invalid.yearOfRelease}")
    private int yearOfRelease;
    @Size(min =1,max=20 , message = "Name is mandatory and cannot contain "
            + "more than 20 characters")
    private String name;
    @Size(min =1,max=20 , message = "Author is mandatory and cannot contain "
            + "more than 20 characters")
    private String author;
    @Size(max=20 , message = "Album cannot contain more than 20 characters")
    private String album;
    @OneToOne
    private UserPlay userPlay;

    public Music() {
    }

    public Music(Long id) {
        this.id = id;
    }

    public Music(int yearOfRelease, String name, String author,
            String album, UserPlay userPlay) {
        this.yearOfRelease = yearOfRelease;
        this.name = name;
        this.author = author;
        this.album = album;
        this.userPlay = userPlay;

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

    public UserPlay getUserPlay() {
        return userPlay;
    }

    public void setUserPlay(UserPlay userPlay) {
        this.userPlay = userPlay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if ((this.id == null && other.id != null) || (this.id != null && 
                !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Music[ id=" + id + " ]";
    }

}
