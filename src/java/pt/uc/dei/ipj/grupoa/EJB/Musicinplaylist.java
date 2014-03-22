/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.EJB;

import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;

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

    List<Music> musicList;

    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * List of music, thar are in the playlist.
     *
     * @param idPl PK of Playlist Entity
     * @return List<Music>
     */
    public List<Music> allMusicinPLaylistlist(long idPl) {
        Query query = em.createQuery("select m from Playlist p inner join p.musicList m where p.id =:id");
        query.setParameter("id", idPl);
        return query.getResultList();
    }

    public void removeMyMusic(long idMusic) {
        //be very afraid!!!

        Music mus = em.find(Music.class, idMusic);

        for (Playlist pl : mus.getLstPlaylist()) {
            pl.getMusicList().remove(mus);
            em.merge(pl);
        }

        UserPlay up = em.find(UserPlay.class, ud.getIdUser());
        up.getMusic().remove(mus);

        em.remove(mus);

        // em.merge(mus);
        em.flush();
        ud.refreshPlaylist();
        ud.refreshMusics();
        ud.refreshMusicsUser();
    }

    /**
     * List of music, does´t belong to the playlist.
     *
     * @param idPl PK of Playlist Entity
     * @return List<Music>
     */
    public List<Music> allMusicNOTINPLaylist(long idPl) {
        ud.refreshMusics();
        setMusicList(ud.getLstAllMusic());
        Playlist pl = em.find(Playlist.class, idPl);

        Iterator<Music> it = musicList.iterator();
        while (it.hasNext()) {
            Music mus = it.next();
            if (mus.getLstPlaylist().contains(pl)) {
                it.remove();
            }
        }
        return musicList;
    }

    /**
     * Insert a Music from a chosen Playlist
     *
     * @param idMus PK of Music Entity
     * @param idPl PK of Playlist Entity
     */
    public void insertMusic(long idMus, long idPl) {
        Playlist pl = em.find(Playlist.class, idPl);
        Music mus = em.find(Music.class, idMus);

        if (!pl.getMusicList().contains(mus)) {
            pl.setPlaylistItem(mus);
            mus.setPlaylistItem(pl);
        }

    }

    /**
     * Remove a Music from a chosen Playlist
     *
     * @param idMus PK of Music Entity
     * @param idPl PK of Playlist Entity
     */
    public void removeMusicPlayList(long idMus, long idPl) {
        Playlist pl = em.find(Playlist.class, idPl);
        Music mus = em.find(Music.class, idMus);

        pl.getMusicList()
                .remove(mus);
        mus.getLstPlaylist()
                .remove(pl);
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

}
