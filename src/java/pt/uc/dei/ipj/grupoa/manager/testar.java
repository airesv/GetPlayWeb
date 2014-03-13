/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import pt.uc.dei.ipj.grupoa.entities.Playlist;

/**
 *
 * @author Aires
 */
@ManagedBean(name="Testar")
@RequestScoped
public class testar {
    private Playlist pl;
    private DataModel items =null;
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Creates a new instance of testar
     */
    public testar() {
    }
    
    
    public String prepareView() {
        int i=0;
        
//        pl = (Playlist) getItems().getRowData();
//        setName(pl.getNamePlaylist());
        System.out.println(getItems().getRowIndex() );
       // setName(getItems().getRowIndex() +"");
        return "teste";
    }
 
    public DataModel getItems() {

        return items;
    }
    
    
    
}
