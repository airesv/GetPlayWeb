 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.facades;

import java.util.List;
import pt.uc.dei.ipj.grupoa.EJB.EncryptPassword;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.omg.CORBA.UserException;
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
                return ("Sucesseful inserted");
            } else {
                return ("Email: " + email + " is in Database ");
            }
        } else {
            // não há problema com o email.
            editUser(id, name, email, Password);//
            return ("Sucesseful inserted");
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
     * @param id
     */
    public void removeUser(Long idUser) {
//        Query query = em.createNamedQuery("UserPlay.findAll", UserPlay.class);
//        List<UserPlay> users = query.getResultList();

        UserPlay up = em.find(UserPlay.class, idUser);
//        up.removeAllPlayLists(up.getPlaylists());
//        for (int a = 0; a < users.size(); a++) {
//            if (up.getPlaylists() != null) {
//                for (int i = 0; i < users.get(a).getPlaylists().size(); i++) {
//                    for (int j = 0; j < users.get(a).getPlaylists().get(i).getMusicList().size(); j++) {
//                        if (users.get(a).getPlaylists().get(i).getMusicList().get(j).getUserOwner().equals(up)) {
//                            up.removeAllMusic(up.getPlaylists().get(i).getMusicList());
//                        }
//                    }
//                }
//            }
//        }
      
        em.flush();
        em.remove(up);
        em.flush();
    }
//     
//        Music mus=em.find(Music.class, idMusic);
//        
//        for (Playlist pl : mus.getLstPlaylist()) {
//            pl.getMusicList().remove(mus);
//            em.merge(pl);
//        }
//        
//        UserPlay up = em.find(UserPlay.class, ud.getIdUser());
//        up.getMusic().remove(mus);
//        
//      
//        em.remove(mus);
//        
//        
//       // em.merge(mus);
//        em.flush();
//        ud.refreshPlaylist();
//        ud.refreshMusics();
//        ud.refreshMusicsUser();

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
