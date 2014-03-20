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

    public List<Music> allMusicinPLaylistlist(long idPlaylist) {
        Query query = em.createQuery("SELECT m.ID, m.ALBUM, m.AUTHOR, m.NAME, m.PathSound, m.userID, m.YEAR_OF_RELEASE\n"
                + "FROM Music m , hasmusic h\n"
                + "where h.idPlaylist=?1");
        query.setParameter(1,""+ ud.getIdPlaylist());
        int i=0;
        
        return query.getResultList();

    }

   public List<Music> allMusicNOTINPLaylistlist(long idPlaylist) {
      Query query = em.createQuery("select m from Music music inner join music.lstPlaylist playlists where playlists in music.playlists;");
//       Query query = em.createQuery("SELECT m FROM Music m");
        //query.setParameter(1,""+ ud.getIdPlaylist());
        int i=0;
        
        return query.getResultList();

    }
    
    
    
}
