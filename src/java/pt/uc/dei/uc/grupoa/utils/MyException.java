/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.uc.grupoa.utils;

/**
 *
 * @author alvaro
 */
public class MyException extends Exception {

    /**
     *
     */
    public MyException() {
    }

    /**
     *
     * @param e
     */
    public MyException(NumberFormatException e) {
        super("Year not valid");
    }

    /**
     *
     * @param cause
     */
    public MyException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
