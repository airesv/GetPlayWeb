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
import pt.uc.dei.ipj.grupoa.EJB.RandomName;
import pt.uc.dei.ipj.grupoa.EJB.UploadBean;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import pt.uc.dei.ipj.grupoa.manager.CreateMusic;

/**
 *
 * @author alvaro
 */
@Stateless
public class MusicFacade extends AbstractFacade<Music> {

    @EJB
    private RandomName randomName;

    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;

    @EJB
    private UploadBean uploadBean;

    private long id;

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

    public List<Music> searchedMusic(String name) {
        if (name != null) {
            return em.createNamedQuery("Music.findByNameAsc", Music.class).setParameter("name", name).getResultList();
        } else {
            return null;
        }
    }
    /* public List<Music> searchedAuthor(String author) {
     Query query = em.createNamedQuery("Music.findByAuthorAsc", Music.class);
     query.setParameter("author", author);
     return query.getResultList();
     }*/

    // getters and setters for file1 and file2
    public void createMusic(int yearOfRelease, String name, String author, String album, String path, UserPlay up, Part file) throws IOException {
        Music music = new Music();

        //Possible exception when trying to upload a music
        try {
            uploadBean.upload(file);
        } catch (IOException ex) {
            Logger.getLogger(CreateMusic.class.getName()).log(Level.SEVERE, null, ex);
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
