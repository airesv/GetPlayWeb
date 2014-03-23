/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.ipj.grupoa.Exceptions;

/**
 *
 * @author Alvaro/Vitor
 */
public class PlaylistAlreadyExists extends Exception {
    

    public PlaylistAlreadyExists() {
    }

    public PlaylistAlreadyExists(String message) {
        super("This Playlist already exists");
        
    }

    public PlaylistAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaylistAlreadyExists(Throwable cause) {
        super(cause);
    }

    public PlaylistAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
    
}
