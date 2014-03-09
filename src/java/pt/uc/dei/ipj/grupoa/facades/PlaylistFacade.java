/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.facades;

import pt.uc.dei.ipj.grupoa.entities.Playlist;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    public PlaylistFacade() {
        super(Playlist.class);
    }
    
    public void createPlayList(String name) {
       // Playlist playlist = new Playlist(name);
        // loggedUserPlay.musics.add(music);
       // em.persist(playlist);
    }
    
    
    
    
    
    
}
