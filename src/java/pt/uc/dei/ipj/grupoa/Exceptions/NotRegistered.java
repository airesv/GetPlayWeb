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
public class NotRegistered extends Exception {

    public NotRegistered() {
    }

    public NotRegistered(String message) {
        super("This User is not registered");
    }

    public NotRegistered(String message, Throwable cause) {
        super(message, cause);
    }

    public NotRegistered(Throwable cause) {
        super(cause);
    }

    public NotRegistered(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
    
    
    
}
