/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.uc.dei.ipj.grupoa.EJB.EncryptPassword;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author alvaro
 */
@ManagedBean
@SessionScoped
public class EditUser implements Serializable {

    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;

    @EJB
    private EncryptPassword encryptPassword;

    @EJB
    private UserPlayFacade userPlayFacade;

    private String message ;
    private String confirmPassword;
    private long id;
    private String name;
    private String email;
    private String password;

    /**
     *
     * @return
     */
    public EditUser() {
       
    }

    @PostConstruct
    public void init() {
         message = "";
        id = userlogin.getLoggedUser().getId();
        name = userlogin.getLoggedUser().getName();
        email = userlogin.getLoggedUser().getEmail();

    }

    public UserLogin getUserlogin() {
        return userlogin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param userlogin
     */
    public void setUserlogin(UserLogin userlogin) {
        this.userlogin = userlogin;
    }

    /**
     * Creates a new instance of EditUser
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
    public String getName() {
        return name;
    }

    public UserPlayFacade getUserPlayFacade() {
        return userPlayFacade;
    }

    public void setUserPlayFacade(UserPlayFacade userPlayFacade) {
        this.userPlayFacade = userPlayFacade;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public long getId() {
        return userlogin.getId();

    }

    public String verification() {
//        userPlayFacade.editUser(getName(), getEmail(), getPassword());
//        message = "Successfully inserted";
        return "edituser";

    }

    public String insertEditUser() {
        if (password.equals(confirmPassword)) {
//            message = userPlayFacade.editnewUser(getId(), getName(), getEmail(), getPassword());
            message = userPlayFacade.editnewUser(getId(), getName(), getEmail(), getPassword(), userlogin.getLoggedUser());
        } else {
            message = "Password does´t match";
        }
        return "edituser";
    }

}
