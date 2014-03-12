/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.facades;

import pt.uc.dei.ipj.grupoa.entities.Music;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import pt.uc.dei.ipj.grupoa.manager.UserManagerBean;

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
    public MusicFacade() {
        super(Music.class);
    }

    /**
     *
     * @param yearOfRelease
     * @param name
     * @param author
     * @param album
     * @param pathSound
     * @param up
     */
    public void createMusic(int yearOfRelease, String name, String author, String album, String pathSound, UserPlay up) {
        Music music = new Music();
        music.setAlbum(album);
        music.setAuthor(author);
        music.setPathSound(pathSound);
        music.setName(name);
        music.setYearOfRelease(yearOfRelease);      
        music.setUserOwner(up);
        em.persist(music);//cria pl
        up.setMusicItem(music);//atualliza no UserPlay
    }

}
