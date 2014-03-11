/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

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
public class EditUser {


    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;

    @EJB
    private EncryptPassword encryptPassword;

    @EJB
    private UserPlayFacade userPlayFacade;

    private String message;
    private String confirmPassword;
    private String name;
    private String newEmail;
    private String newName;

    private String email;
    private long id;
    private String password;

    /**
     *
     * @return
     */
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
    public EditUser() {
        message = "";
    }

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
        return userlogin.getName();
    }

    public EncryptPassword getEncryptPassword() {
        return encryptPassword;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public void setEncryptPassword(EncryptPassword encryptPassword) {
        this.encryptPassword = encryptPassword;
    }

    public UserPlayFacade getUserPlayFacade() {
        return userPlayFacade;
    }

    public void setUserPlayFacade(UserPlayFacade userPlayFacade) {
        this.userPlayFacade = userPlayFacade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return userlogin.getUseremail();
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
    public long getid() {
        return userlogin.getId();

    }

    public String verification() {
        userPlayFacade.editUser(getName(), getEmail(), getPassword());
        message = "Successfully inserted";
        return "edituser";

    }

}
