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
public class ExistsUser extends Exception {

    public ExistsUser() {
    }

    public ExistsUser(String message) {
        super("This user already exists");
    }

    public ExistsUser(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistsUser(Throwable cause) {
        super(cause);
    }

    public ExistsUser(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
