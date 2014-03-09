/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

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

    
    
}
