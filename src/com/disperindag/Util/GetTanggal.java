package com.disperindag.Util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvin
 */
public class GetTanggal {
    
    public static String showDateNow() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd - MM - yyyy");
        String hasil = sdf.format(d);
        return hasil;
    }
    
    public static String getYear(Date d, int add) {
        Calendar date = Calendar.getInstance();
        date.setTime(d);
        Format f = new SimpleDateFormat("dd-MM-yyyy");
        date.add(Calendar.YEAR, add);
        return f.format(date.getTime());
    }
}
