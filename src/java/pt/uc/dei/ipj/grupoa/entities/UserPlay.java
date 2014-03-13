
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Aires
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "UserPlay.findAll", query = "SELECT u FROM UserPlay u"),
    @NamedQuery(name = "UserPlay.findByName", query = "SELECT u FROM UserPlay u WHERE u.name=:name"),
    @NamedQuery(name = "UserPlay.findById", query = "SELECT u FROM UserPlay u WHERE u.id=:id"),
    @NamedQuery(name = "UserPlay.findByEmail", query = "SELECT u FROM UserPlay u WHERE u.email=:email"),
    @NamedQuery(name = "UserPlay.findNameByEmail", query = "SELECT u.name FROM UserPlay u WHERE u.email=:email")
})
public class UserPlay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 1, message = "Please, enter a Name")
    private String name;

    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+"
            + "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "{invalid.email}")
    private String email;

    @Size(min = 1, message = "Password is mandatory and cannot contain"
            + " more than 10 characters")
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "userOwner")
    private List<Music> music;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "userOwner")
    private List<Playlist> playlists;

    /**
     *
     */
    public UserPlay() {
    }

    /**
     *
     * @param id
     */
    public UserPlay(Long id) {
        this.id = id;
    }

    /**
     *
     * @param name
     * @param email
     * @param password
     */
    public UserPlay(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id
        //fields are not set
        if (!(object instanceof UserPlay)) {
            return false;
        }
        UserPlay other = (UserPlay) object;
        if ((this.id == null && other.id != null) || (this.id != null
                && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ id=" + id + " ]";
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
     * @return the playlists
     */
    public List<Playlist> getPlaylists() {
        return playlists;
    }

    /**
     * @param playlists the playlists to set
     */
    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void setPlaylistsItem(Playlist pl) {
        playlists.add(pl);
    }

    public void removePlaylistItem(long id) {
        boolean exists=true;
        for (int i = 0; i < playlists.size() && exists ; i++) {
            if(playlists.get(i).getId()==id){
                playlists.remove(i);
                exists=false;
            
            }
            
        }
        
        

    }

    public void setMusicItem(Music m) {
        music.add(m);
    }

    /**
     * @return the music
     */
    public List<Music> getMusic() {
        return music;
    }

    /**
     * @param music the music to set
     */
    public void setMusic(List<Music> music) {
        this.music = music;
    }

}
