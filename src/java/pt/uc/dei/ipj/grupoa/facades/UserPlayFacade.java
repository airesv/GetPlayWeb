 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.facades;

import java.util.List;
import pt.uc.dei.ipj.grupoa.EJB.EncryptPassword;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pt.uc.dei.ipj.grupoa.EJB.UserData;
import pt.uc.dei.ipj.grupoa.entities.Music;
import pt.uc.dei.ipj.grupoa.entities.Playlist;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;

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
    @Inject
    private UserData ud;

    /**
     *
     */
    public UserPlayFacade() {
        super(UserPlay.class);
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
     * @param attempt
     * @param up
     * @return
     */
    public boolean authValidation(String attempt, UserPlay up) {
        String encryptedAttempt = encryptPassword.cryptWithMD5(attempt);
        return (encryptedAttempt.equals(up.getPassword()));
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean existsUser(String email) {
        UserPlay up = getUser(email);
        return (up != null);
    }

    /**
     *
     * @param id
     * @param name
     * @param email
     * @param Password
     */
    public void editUser(long id, String name, String email, String Password) {
        //procurar o utilizador 
        UserPlay up = em.find(UserPlay.class, id);

        up.setName(name);
        up.setEmail(email);
        up.setPassword(encryptPassword.cryptWithMD5(Password));
        em.merge(up);
    }

    /**
     *
     * @param id
     * @param name
     * @param email
     * @param Password
     * @param oldEmail
     * @return
     */
    public String editnewUser(long id, String name, String email, String Password, String oldEmail) {

        //verifica. se há outro utilizador com o mesmo email
        if (!oldEmail.equals(email)) {
            //caso não exista outro user com o mesmo email
            if (!existsUser(email)) {
                editUser(id, name, email, Password);//
                return ("Sucessefully inserted");
            } else {
                return ("Email: " + email + " is in Database ");
            }
        } else {
            // não há problema com o email.
            editUser(id, name, email, Password);//
            return ("Sucessefully inserted");
        }
    }

    /**
     *
     * @param id
     * @param pl
     */
    public void setNewPlayList(long id, Playlist pl) {
        UserPlay up = em.find(UserPlay.class, id);
        up.setPlaylistsItem(pl);
    }

    /**
     *
     * @param email
     * @return
     * @throws org.omg.CORBA.UserException
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

    /**
     *
     * @param idUser
     * @param id
     */
    public void removeUser(Long idUser) {
        UserPlay up = em.find(UserPlay.class, idUser);
        em.remove(em.merge(up));
    }


    /**
     *
     * @param id
     * @return
     */
    public List<Playlist> lstPlaylist(Long id) {
        UserPlay up = em.find(UserPlay.class, id);
        return up.getPlaylists();
    }

    /**
     *
     * @param id
     * @return
     */
    public List<Music> lstMusicList(Long id) {
        UserPlay up = em.find(UserPlay.class, id);
        return up.getMusic();
    }

}
