/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.facades;

import java.io.Serializable;
import java.util.List;
import pt.uc.dei.ipj.grupoa.entities.Playlist;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pt.uc.dei.uc.grupoa.utils.TodayDate;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;

/**
 *
 * @author Alvaro/Vitor
 */
@Stateless
public class PlaylistFacade extends AbstractFacade<Playlist> implements Serializable {

    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;

    private TodayDate diaHoje;
//    @EJB
//    private UserPlayFacade up;

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     */
    public PlaylistFacade() {
        super(Playlist.class);
    }

    /**
     *
     * @return
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     *
     * @param em
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     *
     * @param name
     * @param id
     */
    public void createPlayList(String name, long id) {

        UserPlay up = em.find(UserPlay.class, id);
        diaHoje = new TodayDate();

        Playlist pl = new Playlist();
        pl.setNamePlaylist(name);
        pl.setDateCreation(diaHoje.getToday());
        pl.setUserOwner(up);
        em.persist(pl);//cria pl
        up.setPlaylistsItem(pl);//atualliza no UserPlay
        em.flush();
    }

    /**
     *
     * @param pl
     * @param id
     */
    public void removePlaylist(Playlist pl, long id) {

        UserPlay up = em.find(UserPlay.class, id);
        up.removePlaylistItem(pl);
        remove(pl);
        em.flush();
    }

    /**
     *
     * @param pl
     * @return
     */
    public List<Music> createListMusic(Playlist pl) {
        return pl.getMusicList();

    }

    /**
     *
     * @param mus
     * @param pl
     */
    public void setNewMusicPlaylist(Music mus, Playlist pl) {
        pl.setPlaylistItem(mus);
    }

    /**
     *
     * @param idUser
     * @param idPlaylist
     * @param name
     * @return
     */
    public boolean changeNamePlaylist(long idUser, long idPlaylist, String name) {
        UserPlay up = em.find(UserPlay.class, idUser);
        Playlist pl = em.find(Playlist.class, idPlaylist);
        int count = 0;
        for (int i = 0; i < up.getPlaylists().size(); i++) {
            if (up.getPlaylists().get(i).getNamePlaylist().equals(name)) {
                count++;
                
            }
        }
        if (count == 0) {
            up.removePlaylistItem(pl);//apaga a playlist da BD
            pl.setNamePlaylist(name);
            em.merge(pl);
            up.setPlaylistsItem(pl);//insere a nova Playlist
            return true;

        } else {
            return false;

        }

    }

    /**
     *
     * @param idUser
     * @return
     */
    public List<Playlist> orderPLbyNameASC(Long idUser) {
        Query query = em.createNamedQuery("Playlist.findAllOrderByNameAsc", Playlist.class);
        query.setParameter("id", idUser);

        try {
            return  query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     *
     * @param idUser
     * @return
     */
    public List<Playlist> orderPLbyNameDESC(Long idUser) {
        Query query = em.createNamedQuery("Playlist.findAllOrderByNameDesc",Playlist.class);
        query.setParameter("id", idUser);

        try {
            return  query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
