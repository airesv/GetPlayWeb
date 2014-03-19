
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
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import pt.uc.dei.ipj.grupoa.facades.MusicFacade;

/**
 *
 * @author Aires
 */
@Named("userLogin")
@SessionScoped
public class UserLogin implements Serializable {

    @EJB
    private UserPlayFacade userPlayFacade;

    private UserPlay loggedUser;

    private Long idUser;
    private String name;
    private String useremail;
    private String password;
    private String erro;

    private String message;
    private String confirmPassword;
    private String email;
    private String newUserEmail;
    
    public UserLogin() {

    }

    @PostConstruct
    public void init() {
        erro = "";
    }

    public String verification() {
        UserPlay user = userPlayFacade.getUser(useremail);

        if (user == null) {
            setErro("Este Email não está na BD");
            return "index";
        } else if (userPlayFacade.authValidation(getPassword(), user)) {
            this.loggedUser = user;
            this.setIdUser(user.getId());
            this.setName(user.getName());
            this.setUseremail(user.getEmail());
            this.setEmail(user.getEmail());//necessario, caso o utilizador mude de passowrd

            return "main";
        } else {
            setErro("Password mal inserida");
            return "index";
        }
    }

    public String insertNewUser() {
        if (userPlayFacade.existsUser(getNewUserEmail())) {
            message = "This user already exists!";
            return "register";
        }
        if (!password.equals(confirmPassword)) {
            message = "Passwords do not match";
            return "register";
        } else {
            userPlayFacade.createUser(getName(), getNewUserEmail(), getPassword());
            message = "Successfully inserted";
            return "register";

        }
    }

    public String deleteUser() {
         //userPlayFacade.remove(loggedUser);
        //userPlayFacade.removeUser(getIdUser(), loggedUser.getMusic(), loggedUser.getPlaylists());
        userPlayFacade.removeUser(getIdUser());//, loggedUser.getMusic(), loggedUser.getPlaylists());
        return "index";
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }

    public String insertEditUser() {
        if (password.equals(confirmPassword)) {
            message = userPlayFacade.editnewUser(getIdUser(), getName(), getEmail(), getPassword(), getUseremail());
            this.setName(getName());
            this.setUseremail(getEmail());
        } else {
            message = "Password doesn´t match";
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

    public UserPlay getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(UserPlay loggedUser) {
        this.loggedUser = loggedUser;
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

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
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

}
