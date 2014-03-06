/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import facades.UserPlayFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aires
 */
@ManagedBean(name = "UserLogin")
@SessionScoped
public class UserLogin {
    @EJB
    private UserPlayFacade userPlayFacade;

    private String useremail;
    private String password;

    public UserLogin() {
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

    public String verification(){
         if(userPlayFacade.userIsDataBase(getUseremail(), getPassword()))
         { 
             return "main";}
         else{return "notlogin";}
    }
}
