/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import javax.ejb.Stateful;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;

/**
 *
 * @author Aires
 */
@Stateful
public class UserManagerBean {

    private UserPlay loggedUser;

    
    /**
     * Creates a new instance of UserMangerBean
     */
    public UserManagerBean() {

    }

   
    public UserPlay getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(UserPlay loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String getLoggedUserName(){
        
    return loggedUser.getName();
    }
    
    
}
