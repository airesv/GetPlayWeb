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
    private int yearOfRelease;  
    @NotNull
    private String name;
    @NotNull
    private String author;
    private String album;
    @OneToOne
    private UserPlay userPlay;
    

    public Music() {
    }

    public Music(Long id) {
        this.id = id;
    }

    public Music(Long id, int yearOfRelease, String name, String author, String album, UserPlay userPlay) {
        this.id = id;
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Music[ id=" + id + " ]";
    }
    
}
