 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.facades;

import pt.uc.dei.ipj.grupoa.EJB.EncryptPassword;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pt.uc.dei.ipj.grupoa.entities.Playlist;

/**
 *
 * @author alvaro
 */
@Stateless
public class UserPlayFacade extends AbstractFacade<UserPlay> {

    @PersistenceContext(unitName = "GetPlayWebPU")
    private EntityManager em;


    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @EJB
    private EncryptPassword encryptPassword;

//    @EJB
//    private Playlist pl;

    /**
     *
     */
    public UserPlayFacade() {
        super(UserPlay.class);
    }

    /**
     *
     * @param email - email from User
     * @param pass
     * @return
     */
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

    /**
     *
     * @param name
     * @param email
     * @param Password
     */
    public void createUser(String name, String email, String Password) {
        UserPlay up = new UserPlay(name, email, encryptPassword.cryptWithMD5(Password));
        if (existsUser(email) == false) {
            em.persist(up);
        }
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean existsUser(String email) {
        Query query = em.createNamedQuery("UserPlay.findByEmail", UserPlay.class);
        query.setParameter("email", email);
        int result = query.getResultList().size();
        return (result > 0);
    }

    public void editUser(long id, String name, String email, String Password) {

//        userlogin.setUseremail(email);
//        userlogin.setName(name);
//        userlogin.setPassword(encryptPassword.cryptWithMD5(Password));
        UserPlay up = em.find(UserPlay.class, id);
        up.setName(name);
        up.setEmail(email);
        up.setPassword(encryptPassword.cryptWithMD5(Password));
        em.merge(up);
    }

    public String editnewUser(long id, String name, String email, String Password) {
        //pesquisar pelo antigo utilizador
        Query query = em.createNamedQuery("UserPlay.findById", UserPlay.class);
        query.setParameter("id", id);

        UserPlay olduser = (UserPlay) query.getSingleResult();
        //verifica. se há outo utilizador com o mesmo email
        if (!olduser.getEmail().equals(email)) {
            query = em.createNamedQuery("UserPlay.findByEmail", UserPlay.class);
            query.setParameter("email", email);
            int tamanho = query.getResultList().size();
            //caso não exista outro user com o mesmo email
            if (tamanho == 0) {
                editUser(id, name, email, Password);
                return ("Sucesseful inserted");
            } else {
                return ("Email: " + email + " is in Database ");
            }
        } else {
            // não há problema com o email.
            editUser(id, name, email, Password);
            return ("Sucesseful inserted");
        }
    }

    public void setNewPlayList(long id, Playlist pl) {
        UserPlay up = em.find(UserPlay.class, id);
        up.setPlaylistsItem(pl);
    }

    /**
     *
     * @param email
     * @return
     */
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
