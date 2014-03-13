/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.facades;

import java.io.Serializable;
import javax.ejb.EJB;
import pt.uc.dei.ipj.grupoa.entities.Playlist;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pt.uc.dei.ipj.grupoa.EJB.TodayDate;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;


/**
 *
 * @author alvaro
 */
@Stateless
public class PlaylistFacade extends AbstractFacade<Playlist> implements Serializable{
    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;

    @EJB
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
        pl.setNamePlaylist(name);
        pl.setDateCreation(diaHoje.getToday());
        pl.setUserOwner(up);
        em.persist(pl);//cria pl
        up.setPlaylistsItem(pl);//atualliza no UserPlay
    }
    
}
