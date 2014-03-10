/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aires
 */
@ManagedBean(name = "MainBean")
@SessionScoped
public class MainBean implements Serializable{

    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;

    /**
     *
     * @return
     */
    public UserLogin getUserlogin() {
        return userlogin;
    }

    /**
     *
     * @param userlogin
     */
    public void setUserlogin(UserLogin userlogin) {
        this.userlogin = userlogin;
    }

    private String name;
    private String email;
    private long id;

    /**
     *
     */
    public MainBean() {
    }

    /**
     *
     * @return
     */
    public String getName() {
        return userlogin.getName();
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return userlogin.getUseremail();
    }

    /**
     *
     * @return
     */
    public long getid(){
    return userlogin.getId();
    
    }
    
    
    
    
    
    
    
    
}
