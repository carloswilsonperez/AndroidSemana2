package com.dominio.jc.androidsemana2.util;

import android.widget.DatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by JC on 3/4/2018.
 */

public class ContactAppUtil {


    public static String getDateAsString(DatePicker dp){
        Date d = new Date() ;
        d.getDate();
        d.getMonth();
        d.getYear();
        d.getDay();
        return String.valueOf(dp.getDayOfMonth()+"/"+(dp.getMonth()+1)+"/"+dp.getYear());

    }

    public static void updateDatePicker(DatePicker datePicker, String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(formatter.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        datePicker.updateDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));


    }
}
