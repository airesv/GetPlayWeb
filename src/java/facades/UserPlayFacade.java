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

    public boolean userIsDataBase(String email, String pass) {

        Query query = em.createNamedQuery("UserPlay.getPassByEmail", UserPlay.class);
        query.setParameter("email", email);
        String result = (String) query.getSingleResult();
        return pass.equals(result);

    }

    public void createUser(String nome, String email, String password) {
        if(!existsUser(email)){
        UserPlay up = new UserPlay(nome, email, password);
        em.persist(up);}
    }

    public boolean existsUser(String email) {
        Query query = em.createNamedQuery("UserPlay.findByEmail", UserPlay.class);
        query.setParameter("email", email);
        int result = query.getFirstResult();
        if (result == 0) {
            return true;
        } else {
            return false;
        }

    }
}
