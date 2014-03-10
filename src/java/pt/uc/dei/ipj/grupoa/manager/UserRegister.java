/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "UserRegister")
@RequestScoped
public class UserRegister implements Serializable {

    @EJB
    private UserPlayFacade userPlayFacade;
    private String name;
    private String useremail;
    private String password;
    private String confirmPassword;
    private String message;

    /**
     * Creates a new instance of Register
     */
    public UserRegister() {
        message = "";
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
     * @param userPlayFacade
     */
    public void setUserPlayFacade(UserPlayFacade userPlayFacade) {
        this.userPlayFacade = userPlayFacade;
    }

    /**
     *
     * @return
     */
    public String getName() {
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
    public String verification() {
        if (userPlayFacade.existsUser(getUseremail())) {
            message = "This user already exists!";
            return "register";
        }
        if (!password.equals(confirmPassword)) {
            message = "Passwords do not match";
            return "register";
        } else {
            userPlayFacade.createUser(getName(), getUseremail(), getPassword());
            message = "Successfully inserted";
            return "register";

        }
    }

}
