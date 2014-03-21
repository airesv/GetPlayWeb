/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.uc.grupoa.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pt.uc.dei.ipj.grupoa.entities.Playlist;

/**
 *
 * @author Aires
 */

public class OrderPL {

    private List<Playlist> lstPL;
    
    /**
     *
     * @param list
     * @param asc
     * @return
     */
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

    
    public List<Playlist> orderSize(List<Playlist> list, boolean asc) {

        if (asc) {
            Collections.sort(list, new Comparator<Playlist>() {
                @Override
                public int compare(Playlist o1, Playlist o2) {
                    return o1.playlistSize() - o2.playlistSize();
                }
            });

            return list;
        } else {

            Collections.sort(list, new Comparator<Playlist>() {
                @Override
                public int compare(Playlist o1, Playlist o2) {
                    return o2.playlistSize() - o1.playlistSize();
                }
            });

            return list;

        }

    }
   
//////////////getter & Setter

    /**
     *
     * @return
     */
        public List<Playlist> getLstPL() {
        return lstPL;
    }

    /**
     *
     * @param lstPL
     */
    public void setLstPL(List<Playlist> lstPL) {
        this.lstPL = lstPL;
    }

}
