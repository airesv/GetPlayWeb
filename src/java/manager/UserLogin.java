


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import EJB.EncryptPassword;
import entities.UserPlay;
import facades.UserPlayFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aires
 */
@ManagedBean(name = "UserLogin")
@SessionScoped
public class UserLogin implements Serializable {

    @EJB
    private UserPlayFacade userPlayFacade;
    
    @EJB
    private UserManagerBean userManagerBean;
    
    private String useremail;
    private String password;
    private String erro;
    
    @EJB
    private EncryptPassword encryptPassword;
    
    public UserLogin() {
        erro="";
        
        
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
        UserPlay loggedUser = userPlayFacade.getUser(useremail/*, encryptPassword.cryptWithMD5(password)*/);
        
        if(loggedUser != null) {
            // user correctly logged
            userManagerBean.setLoggedUser(loggedUser);
        } else {
            
        }
        
        switch (userPlayFacade.userIsDataBase(getUseremail(), getPassword())) {
            case 0:
                setErro("Este Email não está na BD");
                return "index";
            case 1:
                setErro("Password mal inserida");
                return "index";
           case 2:
               //userManagerBean.setLoggedUser( userPlayFacade.getUser(getUseremail()) );//instancia o user
                return "main";//ligado
                
            default:
                throw new AssertionError();
        }
    }

    /**
     * @return the erro
     */
    public String getErro() {
        return erro;
    }

    /**
     * @param erro the erro to set
     */
    public void setErro(String erro) {
        this.erro = erro;
    } 

   

  
}