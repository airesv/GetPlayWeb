/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Music;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import manager.UserLogin;
import manager.UserManagerBean;

/**
 *
 * @author alvaro
 */
@Stateless
public class MusicFacade extends AbstractFacade<Music> {

    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;
    @ManagedProperty(value = "#{UserManagerBean}")
    private UserManagerBean userManager;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MusicFacade() {
        super(Music.class);
    }

    public void createMusic(int yearOfRelease, String name, String author, String album, String pathSound) {
        Music music = new Music(yearOfRelease, name, author, album, pathSound);
        userManager.getLoggedUser().getMusic().add(music);

// loggedUserPlay.musics.add(music);
        em.merge(userManager.getLoggedUser());//u
    }

}
