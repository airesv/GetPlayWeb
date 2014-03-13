/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import pt.uc.dei.ipj.grupoa.EJB.EncryptPassword;
import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;
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

    private UserPlay loggedUser;

    private String useremail = "jo@gmail.com";
    private String password = "12";
    private String name;
    
    
    private String erro;
    private long id;

    @EJB
    private EncryptPassword encryptPassword;

    /**
     *
     */
    public UserLogin() {
        erro = "";

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

    ////////////////////////

    /**
     *
     * @return
     */
        public String getName() {
       return loggedUser.getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEncryptPassword(EncryptPassword encryptPassword) {
        this.encryptPassword = encryptPassword;
    }
        

    /**
     *
     * @return
     */
    public long getId() {
        return loggedUser.getId();
    }

 
    
    
    
    
///////////////////////

    /**
     *
     * @return
     */
        public String verification() {
         loggedUser = userPlayFacade.getUser(useremail/*, encryptPassword.cryptWithMD5(password)*/);

        if (loggedUser != null) {
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

    /**
     *
     * @return
     */
    public UserPlay getLoggedUser() {
        return loggedUser;
    }

    /**
     *
     * @param loggedUser
     */
    public void setLoggedUser(UserPlay loggedUser) {
        this.loggedUser = loggedUser;
    }

    /**
     *
     * @param loggedUser
     * @return
     */
    public String getNameUserLogged(UserPlay loggedUser) {
        return loggedUser.getName();
    }

    /**
     *
     * @return
     */
    public String getEmailUserLogged() {
        return loggedUser.getEmail();
    }
}
