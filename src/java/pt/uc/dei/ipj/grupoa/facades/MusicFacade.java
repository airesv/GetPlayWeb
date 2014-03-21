/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.facades;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import pt.uc.dei.ipj.grupoa.entities.Music;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.Part;
import pt.uc.dei.ipj.grupoa.EJB.UploadBean;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import pt.uc.dei.ipj.grupoa.manager.MusicManager;

/**
 *
 * @author Alvaro/Vitor
 */
@Stateless
public class MusicFacade extends AbstractFacade<Music> {
    
    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;
    @EJB
    private UploadBean uploadBean;
    
    @Override
    
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public MusicFacade() {
        super(Music.class);
    }

    /**
     *
     * @return List of all musics
     */
    public List<Music> listOfAllMusics() {
        Query query = em.createNamedQuery("Music.findAll", Music.class);
        return query.getResultList();
    }

    /**
     *
     *
     * @param name
     * @return List of Searched musics
     */
    public List<Music> searchedMusic(String name) {
        Query query = em.createNamedQuery("Music.findByName", Music.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
        
    }

    /**
     *
     * @param author
     * @return List of musics of the searched author
     */
    public List<Music> searchedAuthor(String author) {
        Query query = em.createNamedQuery("Music.findByAuthor", Music.class);
        query.setParameter("author", "%" + author + "%");
        return query.getResultList();
    }

        /**
         * Edit specific Music
         *
         * @param idMusic
         * @param album
         * @param author
         * @param YearOfRelease
         * @param name
         */
    public void editMusic(Long idMusic, String album, String author, int YearOfRelease, String name) {
        Music m = em.find(Music.class, idMusic);
        //Set the attributes into music
        m.setAlbum(album);
        m.setAuthor(author);
        m.setYearOfRelease(YearOfRelease);
        m.setName(name);
        em.merge(m);
    }

    /**
     *
     * @param yearOfRelease
     * @param name
     * @param author
     * @param album
     * @param path
     * @param id
     * @param file
     * @throws IOException
     *
     */
    public void createMusic(int yearOfRelease, String name, String author, String album, String path, Long id, Part file) throws IOException {
        UserPlay up = em.find(UserPlay.class, id);
        Music music = new Music();
        //Possible exception when trying to upload a music
        try {
            uploadBean.upload(file);
        } catch (IOException ex) {
            Logger.getLogger(MusicManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        music.setAlbum(album);
        music.setAuthor(author);
        music.setPathSound(uploadBean.getPath());
        music.setName(name);
        music.setYearOfRelease(yearOfRelease);
        music.setUserOwner(up);
        em.persist(music);//persist music
        up.setMusicItem(music);//update on User
    }

    ///Getters and Setters///
    public void setNewMusicPlaylist(Music mus, Playlist pl) {
        mus.setPlaylistItem(pl);
    }
    
    public UploadBean getUploadBean() {
        return uploadBean;
    }
    
    public void setUploadBean(UploadBean uploadBean) {
        this.uploadBean = uploadBean;
    }
    
}
