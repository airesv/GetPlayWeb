/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import facades.UserPlayFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alvaro
 */
@ManagedBean(name = "UserRegister")
@RequestScoped
public class UserRegister {
    @EJB
    private UserPlayFacade userPlayFacade;
    private String name;
    private String useremail;
    private String password;
    private String confirmPassword;

    /**
     * Creates a new instance of Register
     */
    public UserRegister() {
    }

    public UserPlayFacade getUserPlayFacade() {
        return userPlayFacade;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    

    public void setUserPlayFacade(UserPlayFacade userPlayFacade) {
        this.userPlayFacade = userPlayFacade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String verification() {
       if (userPlayFacade.existsUser(email) {
            return "notregister";
        } 
        if(!password.equals(confirmPassword)){
            return "notregister";
        }

        else {
            userPlayFacade.createUser(name, useremail, password);
            return "index";
        }
    }

}
