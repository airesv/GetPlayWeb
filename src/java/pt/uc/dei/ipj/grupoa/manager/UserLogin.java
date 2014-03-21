
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import pt.uc.dei.ipj.grupoa.EJB.UserData;

/**
 *
 * @author Alvaro/Vitor
 */
@Named("userLogin")
@RequestScoped
public class UserLogin implements Serializable {

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

    public UserLogin() {

    }

    @PostConstruct
    public void init() {
        errorMessage = "";

    }

    /**
     *
     * @return
     */
    public String verification() {
        UserPlay user = userPlayFacade.getUser(useremail);

        if (user == null) {
            setErrorMessage("Este Email não está na BD");
            return "index";
        } else if (userPlayFacade.authValidation(getPassword(), user)) {
            this.setIdUser(user.getId());

            this.setName(user.getName());
            this.setUseremail(user.getEmail());
            this.setEmail(user.getEmail());//necessario, caso o utilizador mude de passowrd

            ud.setIdUser(user.getId());
            ud.setNameUser(user.getName());
            ud.setEmailUser(user.getEmail());
            ud.refreshPlaylist();
            ud.refreshMusics();
            ud.refreshMusicsUser();

            return "main";
        } else {
            setErrorMessage("Password badly inserted");
            return "index";
        }
    }

    /**
     *
     * @return
     */
    public String insertNewUser() {
        if (userPlayFacade.existsUser(getNewUserEmail())) {
            message = "This user already exists!";
            return "register";
        }
        if (!password.equals(confirmPassword)) {
            message = "Passwords do not match";
            return "register";
        } else {
            userPlayFacade.createUser(getNewName(), getNewUserEmail(), getPassword());
            message = "Successfully inserted";
            return "register";

        }
    }

    /**
     *
     * @return
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
     * @return
     */
    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }

    /**
     *
     * @return
     */
    public String insertEditUser() {
        if (password.equals(confirmPassword)) {
            message = userPlayFacade.editnewUser(ud.getIdUser(), ud.getNameUser(), ud.getEmailUser(), getPassword(), getEmail());
        } else {
            message = "Password doesn´t match";
        }
        return "edituser";
    }

    /**
     *
     * @return
     */
    public String getNewUserEmail() {
        return newUserEmail;
    }

    /**
     *
     * @param newUserEmail
     */
    public void setNewUserEmail(String newUserEmail) {
        this.newUserEmail = newUserEmail;
    }

    /**
     *
     * @return
     */
    public Long getIdUser() {
        return idUser;
    }

    /**
     *
     * @param idUser
     */
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    /**
     *
     * @return
     */
    public String getName() {
        name = ud.getNameUser();
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public UserPlayFacade getUserPlayFacade() {
        return userPlayFacade;
    }

    /**
     *
     * @param userPlayFacade
     */
    public void setUserPlayFacade(UserPlayFacade userPlayFacade) {
        this.userPlayFacade = userPlayFacade;
    }

    /**
     *
     * @return
     */
    public String getUseremail() {
        return useremail;
    }

    /**
     *
     * @param useremail
     */
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     *
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     *
     * @param confirmPassword
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        email = ud.getEmailUser();
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        //email=ud.getEmailUser();
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
