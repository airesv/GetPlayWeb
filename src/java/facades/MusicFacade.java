/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import entities.Music;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alvaro
 */
@Stateless
public class MusicFacade extends AbstractFacade<Music> {
    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MusicFacade() {
        super(Music.class);
    }
    
     public void createMusic(int yearOfRelease, String name, String author,String album) {
         Music music = new Music(yearOfRelease, name,author,album);
        // loggedUserPlay.musics.add(music);
        em.persist(music);
    }
    
}
