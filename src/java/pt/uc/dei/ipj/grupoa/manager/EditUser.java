/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;

/**
 *
 * @author alvaro
 */
@Named("EditUser")
@SessionScoped
public class EditUser implements Serializable {

    @Inject
    private UserLogin ul;

    @EJB
    private UserPlayFacade userPlayFacade;

    

    private String message;
    private String confirmPassword;
    private long id;
    private String name;
    private String email;
    private String password;

    public EditUser() {

    }

    @PostConstruct
    public void init() {
        message = "";
        id = ul.getIdUser();
        name = ul.getName();
        email = ul.getUseremail();

    }

    public String insertEditUser() {
        if (password.equals(confirmPassword)) {
            message = userPlayFacade.editnewUser(getId(), getName(), getEmail(), getPassword(), ul.getUseremail());
        } else {
            message = "Password doesn´t match";
        }
        return "edituser";
    }

   public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public UserPlayFacade getUserPlayFacade() {
        return userPlayFacade;
    }

    public void setUserPlayFacade(UserPlayFacade userPlayFacade) {
        this.userPlayFacade = userPlayFacade;
    }

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

   
}
