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

    public int userIsDataBase(String email, String pass) {

        if (!existsUser(email)) {
            return 0;//não há email na BD
        } else {
            
            Query query = em.createNamedQuery("UserPlay.getPassByEmail", UserPlay.class);
            query.setParameter("email", email);
            String result;
            try {
                result = (String) query.getSingleResult();
            } catch (Exception e) {
                return 1;
            }

            if (!pass.equals(result)) {
                return 1; //a password está errada

            } else {
                return 2;//está tudo correto está logsdo
            }
        }
        

    }

    public void createUser(String nome, String email, String password) {
        UserPlay up = new UserPlay(nome, email, password);
        if (existsUser(email) == false) {
            em.persist(up);
        }

    }

    public boolean existsUser(String email) {
        Query query = em.createNamedQuery("UserPlay.findByEmail", UserPlay.class);
        query.setParameter("email", email);
        int result = query.getResultList().size();
        return (result > 0);

    }
}
