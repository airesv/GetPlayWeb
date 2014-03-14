/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.facades;

import java.util.List;
import pt.uc.dei.ipj.grupoa.entities.Music;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;

/**
 *
 * @author alvaro
 */
@Stateless
public class MusicFacade extends AbstractFacade<Music> {

    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;

    private long id;
 

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    private boolean editable;


    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public List<Music> listOfAllMusics() {
        Query query = em.createNamedQuery("Music.findAll", Music.class);
        return query.getResultList();
    }

    /**
     */
    public MusicFacade() {
        super(Music.class);
    }
    
//    public List<Music>  searchedAuthor() {
//        Query query = em.createNamedQuery("Music.findByAuthorAsc", Music.class);
//        query.setParameter(null, query)
//        return query.getResultList();
//    }
    
    
   

    /**
     *
     * @param yearOfRelease
     * @param name
     * @param author
     * @param album
     * @param path
     * @param up
     */
    public void createMusic(int yearOfRelease, String name, String author, String album, String path, UserPlay up) {
        Music music = new Music();
        music.setAlbum(album);
        music.setAuthor(author);
        music.setPathSound(path);
        music.setName(name);
        music.setYearOfRelease(yearOfRelease);
        music.setUserOwner(up);
        em.persist(music);//cria pl
        up.setMusicItem(music);//atualliza no UserPlay
    }

    
    
    public void setNewMusicPlaylist(Music mus, Playlist pl) {
        mus.setPlaylistItem(pl);
    }
    
    
    
}
