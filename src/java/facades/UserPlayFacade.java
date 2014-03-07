 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


import EJB.EncryptPassword;
import entities.UserPlay;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sun.security.util.Password;

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
    @EJB
    private EncryptPassword encryptPassword;

   
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

            if (!encryptPassword.cryptWithMD5(pass).equals(result)) {
                return 1; //a password está errada

            } else {
                return 2;//está tudo correto está logsdo
            }
        }
    }

        
    public void createUser(String nome, String email, String Password) {
        UserPlay up = new UserPlay(nome, email, encryptPassword.cryptWithMD5(Password));
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

  public UserPlay getUser(String email) {
        Query query = em.createNamedQuery("UserPlay.findByEmail", UserPlay.class);
        query.setParameter("email", email);

        try {
            return (UserPlay) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
   /* public UserPlay getUser(String email, String encryptedPassword) {
        Query query = em.createNamedQuery("UserPlay.getUserByCredentials", UserPlay.class);
        query.setParameter("email", email);
        query.setParameter("password", encryptedPassword);

        try {
            return (UserPlay) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }*/


}