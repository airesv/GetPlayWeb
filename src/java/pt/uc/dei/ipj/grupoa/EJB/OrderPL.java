/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.EJB;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.Stateless;
import pt.uc.dei.ipj.grupoa.entities.Playlist;

/**
 *
 * @author Aires
 */
@Stateless
public class OrderPL {

    private List<Playlist> lstPL;
    
    public List<Playlist> order(List<Playlist> list, boolean asc) {

        if (asc) {
            Collections.sort(list, new Comparator<Playlist>() {
                @Override
                public int compare(Playlist o1, Playlist o2) {
                    return o1.getNamePlaylist().compareTo(o2.getNamePlaylist());
                }
            });

            return list;
        } else {

            Collections.sort(list, new Comparator<Playlist>() {
                @Override
                public int compare(Playlist o1, Playlist o2) {
                    return o2.getNamePlaylist().compareTo(o1.getNamePlaylist());
                }
            });

            return list;

        }

    }

   
//////////////getter & Setter
    public List<Playlist> getLstPL() {
        return lstPL;
    }

    public void setLstPL(List<Playlist> lstPL) {
        this.lstPL = lstPL;
    }

}