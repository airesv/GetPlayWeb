/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Aires
 */
@ManagedBean(name = "UserGestao")
@RequestScoped
public class UserGestao {

    @ManagedProperty(value = "#{MainBean}")
    private MainBean mainbean;
    private String name;
    private String email;
    private long id;

    /**
     * Creates a new instance of UserGestao
     */
    public UserGestao() {
    }

    
    public MainBean getMainbean() {
        return mainbean;
    }

    public void setMainbean(MainBean mainbean) {
        this.mainbean = mainbean;
    }

    public String getName() {
        return mainbean.getName();
    }

   

    public String getEmail() {
        return mainbean.getEmail();
    }


    public long getId() {
        return mainbean.getid();
    }

 

    
}
