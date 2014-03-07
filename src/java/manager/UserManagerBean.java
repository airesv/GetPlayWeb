/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entities.UserPlay;
import facades.UserPlayFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aires
 */
@ManagedBean(name = "UserManagerBean")
@SessionScoped
public class UserManagerBean {

    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userLogin;
    private UserPlay userPlay;
    
     @EJB
    private UserPlayFacade userPlayFacade;

    /**
     * Creates a new instance of UserMangerBean
     */
    public UserManagerBean() {

    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }
    
    public UserPlay setUserPlay(){
    return userPlayFacade.
    
    }
    
    
}
