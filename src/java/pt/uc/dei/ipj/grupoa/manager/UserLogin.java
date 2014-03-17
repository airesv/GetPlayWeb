
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import pt.uc.dei.ipj.grupoa.entities.UserPlay;
import pt.uc.dei.ipj.grupoa.facades.UserPlayFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import pt.uc.dei.ipj.grupoa.EJB.UserLogged;

/**
 *
 * @author Aires
 */
//@ManagedBean(name = "UserLogin")
@Named("UserLogin")
@SessionScoped
public class UserLogin implements Serializable {

    @EJB
    private UserPlayFacade userPlayFacade;

    @Inject
    private UserLogged userlogged;
    
    private UserPlay loggedUser;

    private String useremail = "jo@gmail.com";
    private String password = "12";
    private String erro;

    
    public UserLogin() {
        erro = "";

    }
    
    public String verification() {
        UserPlay user = userPlayFacade.getUser(useremail);

        if (user == null) {
            setErro("Este Email não está na BD");
            return "index";
        } else if (userPlayFacade.authValidation(getPassword(), user)) {
           this.loggedUser = user;
           userlogged.setNameUserLogged(user.getName());
            //userlogged.setUserlogged(user);
            return "main";
        } else {
            setErro("Password mal inserida");
            return "index";
        }
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
  public long getId() {
        
        return loggedUser.getId();
    }

  
    public String getErro() {
        return erro;
    }

   
    public void setErro(String erro) {
        this.erro = erro;
    }

    public UserPlay getLoggedUser() {
        return loggedUser;
    }

    
    public void setLoggedUser(UserPlay loggedUser) {
        this.loggedUser = loggedUser;
    }

    public UserLogged getUserlogged() {
        return userlogged;
    }

    public void setUserlogged(UserLogged userlogged) {
        this.userlogged = userlogged;
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
    
    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }
}
