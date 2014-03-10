/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aires
 */
@ManagedBean(name = "MainBean")
@SessionScoped
public class MainBean {

    @ManagedProperty(value = "#{UserLogin}")
    private UserLogin userlogin;

    public UserLogin getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(UserLogin userlogin) {
        this.userlogin = userlogin;
    }

    private String name;
    private String email;
    private long id;

    public MainBean() {
    }


    public String getName() {
        return userlogin.getName();
    }

   

    public String getEmail() {
        return userlogin.getUseremail();
    }

 
    public long getid(){
    return userlogin.getId();
    
    }
    
    
    
    
    
    
    
    
}
