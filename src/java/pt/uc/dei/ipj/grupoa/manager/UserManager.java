
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import pt.uc.dei.ipj.grupoa.EJB.UserData;
import pt.uc.dei.ipj.grupoa.Exceptions.ExistsUser;
import pt.uc.dei.ipj.grupoa.Exceptions.IncorretPassword;
import pt.uc.dei.ipj.grupoa.Exceptions.NotRegistered;
import pt.uc.dei.ipj.grupoa.Exceptions.PasswordUser;

/**
 *
 * @author Alvaro/Vitor
 */
@Named
@RequestScoped
public class UserManager implements Serializable {

    @EJB
    private UserPlayFacade userPlayFacade;
    @Inject
    private UserData ud;
    private Long idUser;
    private String name;
    private String useremail;
    private String password;
    private String errorMessage;
    private String message;
    private String confirmPassword;
    private String email;
    private String newName;
    private String newUserEmail;

    public UserManager() {

    }

    @PostConstruct
    public void init() {
        errorMessage = "";

    }

    /**
     *
     * @return to the same page, if the user didn t introduce data correctly. If
     * yes, he goes to main page
     */
    public String verification() {
        UserPlay user = userPlayFacade.getUser(useremail);

        try {
            if (user != null) {
                if (userPlayFacade.authValidation(getPassword(), user)) {
                    this.setIdUser(user.getId());

                    this.setName(user.getName());
                    this.setUseremail(user.getEmail());
                    this.setEmail(user.getEmail());//if the user changes his password

                    ud.setIdUser(user.getId());
                    ud.setNameUser(user.getName());
                    ud.setEmailUser(user.getEmail());
                    ud.refreshPlaylist();
                    ud.refreshMusics();
                    ud.refreshMusicsUser();

                    return "main";
                }
            } else if (user == null) {
                throw new NotRegistered("message");

            } else {
                throw new IncorretPassword("message");

            }
        } catch (NotRegistered | IncorretPassword ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            setErrorMessage(ex.getMessage());

        }
        return "index";

    }

    /**
     *
     * @return a new user, if all fields are introduced, according to premises.
     * If not, receives a new message with the detailed errors.
     */
    public String insertNewUser() {
        try {
            if (!userPlayFacade.existsUser(getNewUserEmail()) && password.equals(confirmPassword)) {
                userPlayFacade.createUser(getNewName(), getNewUserEmail(), getPassword());
                setErrorMessage("Successfully inserted");
            } else if (userPlayFacade.existsUser(getNewUserEmail())) {
                throw new ExistsUser("message");
            } else {
                throw new PasswordUser("message");

            }
        } catch (ExistsUser | PasswordUser ex) {
            Logger.getLogger(UserManager.class
                    .getName()).log(Level.SEVERE, null, ex);
            setErrorMessage(ex.getMessage());
        }
        return "register";
    }

    /**
     *
     * @return to index. User is deleted, as his created musics and his
     * playlists
     */
    public String deleteUser() {
        userPlayFacade.removeUser(ud.getIdUser());
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }

    /**
     *
     * @return to index and session of this user is finished
     */
    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }

    /**
     *
     * @return User edited
     */
    public String insertEditUser() {
        if (password.equals(confirmPassword)) {
            message = userPlayFacade.editnewUser(ud.getIdUser(), ud.getNameUser(), ud.getEmailUser(), getPassword(), getEmail());
        } else {
            message = "Password doesn't match";
        }
        return "edituser";
    }

    public String getNewUserEmail() {
        return newUserEmail;
    }

    public void setNewUserEmail(String newUserEmail) {
        this.newUserEmail = newUserEmail;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        name = ud.getNameUser();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserPlayFacade getUserPlayFacade() {
        return userPlayFacade;
    }

    public void setUserPlayFacade(UserPlayFacade userPlayFacade) {
        this.userPlayFacade = userPlayFacade;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public UserData getUd() {
        return ud;
    }

    public void setUd(UserData ud) {
        this.ud = ud;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

}
