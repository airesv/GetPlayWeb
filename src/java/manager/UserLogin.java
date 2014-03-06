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
    private String erro;
    
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
        switch (userPlayFacade.userIsDataBase(getUseremail(), getPassword())) {
            case 0:
                setErro("Este Email não está na BD");
                return "index";
            case 1:
                setErro("Password mal inserida");
                return "index";
           case 2:  
                return "main";
                
            default:
                throw new AssertionError();
        }
//        if (userPlayFacade.userIsDataBase(getUseremail(), getPassword())) {
//            return "main";
//        } else {
//            setErro("Sorry");
//            return "index"   ;
//        }
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
