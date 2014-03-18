/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.EJB;


import javax.ejb.Stateful;

/**
 *
 * @author Aires
 */
//@Named
@Stateful
public class UserLogged {

//    private UserPlay userlogged;

 
    private long idUserLogged;
    private String nameUserLogged;
    private String emailUserLogged;

    public UserLogged() {
    }

    public long getIdUserLogged() {
        return idUserLogged;
    }

    public void setIdUserLogged(long idUserLogged) {
        this.idUserLogged = idUserLogged;
    }

    public String getNameUserLogged() {
        return nameUserLogged;
    }

    public void setNameUserLogged(String nameUserLogged) {
        this.nameUserLogged = nameUserLogged;
    }

    public void setEmailUserLogged(String emailUserLogged) {
        this.emailUserLogged = emailUserLogged;
    }

    
//       public UserPlay getUserlogged() {
//        return userlogged;
//    }
//
//    public void setUserlogged(UserPlay userlogged) {
//        this.userlogged = userlogged;
//    }

    public String getEmailUserLogged() {
        return emailUserLogged;
    }
}
