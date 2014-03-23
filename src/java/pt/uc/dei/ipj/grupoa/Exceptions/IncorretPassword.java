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
public class IncorretPassword extends Exception {

    public IncorretPassword() {
    }

    public IncorretPassword(String message) {
        super("Password badly inserted");
    }

    public IncorretPassword(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorretPassword(Throwable cause) {
        super(cause);
    }

    public IncorretPassword(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
