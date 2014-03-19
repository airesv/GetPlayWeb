/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.EJB;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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

    @EJB
    private UploadBean uploadBean;    


    protected EntityManager getEntityManager() {
        return em;
    }
  
    
//     public List<Music> allMusicinPLaylistlist(long idPlaylist) {
////        Query query = em.createQuery("Select")
////                
////                ;
////        query.setParameter("name", name);
////        return query.getResultList();
//
//    }
    
    
}
