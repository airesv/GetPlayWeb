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
public class PasswordUser extends Exception{

    public PasswordUser() {
    }

    public PasswordUser(String message) {
        super("Password does not match");
    }

    public PasswordUser(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordUser(Throwable cause) {
        super(cause);
    }

    public PasswordUser(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
