/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.uc.grupoa.utils;

import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Aires
 */

public class TodayDate {

    private Date today;

    public TodayDate() {

    }

    public Date getToday() {
        Calendar myCal = Calendar.getInstance();
        Date today = myCal.getTime();
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }


    
}