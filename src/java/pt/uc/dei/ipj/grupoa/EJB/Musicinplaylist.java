/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.entities.Playlist;

/**
 *
 * @author Aires
 */
@Stateless
public class Musicinplaylist {

    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;

    @Inject
    private UserData ud;

    protected EntityManager getEntityManager() {
        return em;
    }

    
      /**
     * List of music, thar are in the playlist.
     * @param idPl PK of Playlist Entity
     * @return List<Music>
     */
    
    
    public List<Music> allMusicinPLaylistlist(long idPl) {
        Query query = em.createQuery("SELECT m.ID, m.ALBUM, m.AUTHOR, m.NAME, m.PathSound, m.userID, m.YEAR_OF_RELEASE\n"
                + "FROM Music m , hasmusic h\n"
                + "where h.idPlaylist=?1");
        query.setParameter(1, idPl);
        List<Music> musiq = query.getResultList();


        return query.getResultList();

    }
    
  
    
    

    /**
     * List of music, does´t belong to the playlist.
     * @param idPl PK of Playlist Entity
     * @return List<Music>
     */
    
    
    public List<Music> allMusicNOTINPLaylistlist(long idPl) {
        //Query query = em.createQuery("select m from Music m inner join m.lstPlaylist pl where pl.id <>?");
        Query query = em.createQuery("select m from Playlist p inner join p.musicList m where p.id <>:id");
        query.setParameter("id", idPl);
        int i = 0;
        return query.getResultList();

    }

    /**
     * Insert a Music from a chosen Playlist
     * @param idMus PK of Music Entity
     * @param idPl PK of Playlist Entity
     */
    public void insertMusic(long idMus, long idPl) {
        //insere na Musica na List<Music> musicList
        Playlist pl = em.find(Playlist.class, idPl);
        Music mus = em.find(Music.class, idMus);

        pl.setPlaylistItem(mus);
        mus.setPlaylistItem(pl);
    }
/**
 * Remove a Music from a chosen Playlist
 * @param idMus PK of Music Entity
 * @param idPl PK of Playlist Entity
 */
    public void removeMusicPlayList(long idMus, long idPl) {
        Playlist pl = em.find(Playlist.class, idPl);
        Music mus = em.find(Music.class, idMus);

        pl.getMusicList().remove(mus);
        mus.getLstPlaylist().remove(pl);
    }

}
