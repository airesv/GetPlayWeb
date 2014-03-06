/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import entities.UserPlay;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alvaro
 */
@Stateless
public class UserPlayFacade extends AbstractFacade<UserPlay> {
    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserPlayFacade() {
        super(UserPlay.class);
    }
    
   public boolean userIsDataBase(String email, String pass){
       
       Query query=em.createNamedQuery("UserPlay.getPassByEmail", UserPlay.class);
       query.setParameter("email", email);
       String result=(String)query.getSingleResult();
       
       return pass.equals(result);
          
    
   }  
   
   
   
    
}
