/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alvaro
 */
@ManagedBean
@SessionScoped
public class UserLogout {

    /**
     * Creates a new instance of UserLogout
     */
    public UserLogout() {
    }

    @ManagedProperty(value = "#{UserLogout}")
    private UserLogout userlogout;

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
    public UserLogout getUserlogout() {
        return userlogout;
    }

    /**
     *
     * @param userlogout
     */
    public void setUserlogout(UserLogout userlogout) {
        this.userlogout = userlogout;
    }

}
