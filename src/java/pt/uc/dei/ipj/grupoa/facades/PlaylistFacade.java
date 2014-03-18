/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.facades;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import pt.uc.dei.ipj.grupoa.entities.Playlist;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import pt.uc.dei.ipj.grupoa.EJB.TodayDate;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import pt.uc.dei.uc.grupoa.utils.TodayDate;

/**
 *
 * @author alvaro
 */
@Stateless
public class PlaylistFacade extends AbstractFacade<Playlist> implements Serializable {

    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;

    private TodayDate todayDate;
//    @EJB
//    private TodayDate diaHoje;
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

    public UserPlay getUser() {
        Query query = em.createNamedQuery("UserPlay.findByEmail", UserPlay.class);
        //query.setParameter("email", createPlaylist.getUserlogin().getUseremail());
        try {
            return (UserPlay) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     *
     * @param name
     */
    public void createPlayList(String name, UserPlay up) {
        Playlist pl = new Playlist();
        todayDate=new TodayDate();
        pl.setNamePlaylist(name);
        pl.setDateCreation(todayDate.getToday());
        pl.setUserOwner(up);
        em.persist(pl);//cria pl
        up.setPlaylistsItem(pl);//atualliza no UserPlay
        em.flush();
    }

    public void removePlaylist(Playlist pl, UserPlay up) {
        up.removePlaylistItem(pl);
        remove(pl);
        em.flush();
    }

    public List<Music> createListMusic(Playlist pl) {
        return pl.getMusicList();

    }

    public void setNewMusicPlaylist(Music mus, Playlist pl) {
        pl.setPlaylistItem(mus);
    }

}
