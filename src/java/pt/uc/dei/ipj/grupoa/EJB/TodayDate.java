/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.ipj.grupoa.EJB;

import java.util.Calendar;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Aires
 */
@Stateless
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
