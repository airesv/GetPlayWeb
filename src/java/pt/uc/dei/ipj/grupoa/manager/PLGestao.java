/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.manager;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pt.uc.dei.ipj.grupoa.entities.Music;

/**
 *
 * @author Aires
 */
@ManagedBean(name = "PLGestao")
@RequestScoped
public class PLGestao {
    
    @ManagedProperty(value = "#{PLTable}")
    private PLTable pltable;
    
    private String namepl;
    private List<Music> lstMusic;
    
   
    
    
    

    /**
     * Creates a new instance of PLGestao
     */
    public PLGestao() {
        
    }
    
  
    
    public String showPL(){
        setNamepl(pltable.editPlaylist());
        return "viewpl";
    }
    
    
    
///////////////////Getters & Setter
    public PLTable getPltable() {
        return pltable;
    }

    public void setPltable(PLTable pltable) {
        this.pltable = pltable;
    }

    public String getNamepl() {
        return namepl;
    }

    public void setNamepl(String namepl) {
        this.namepl = namepl;
    }
    
    
   
    
}
