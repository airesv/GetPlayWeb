/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.facades;

import javax.ejb.EJB;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.uc.dei.ipj.grupoa.manager.UserManagerBean;

/**
 *
 * @author alvaro
 */
@Stateless
public class PlaylistFacade extends AbstractFacade<Playlist> {

    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @EJB
    private UserManagerBean userManagedBean;
    
    @EJB
    private UserPlayFacade userPlayFacade;
    

    public PlaylistFacade() {
        super(Playlist.class);
    }

    public void createPlayList(String name) {
        Playlist playlist = new Playlist(name);
        userManagedBean.getLoggedUser().getPlaylists().add(playlist);
        em.persist(playlist);
    }

}
