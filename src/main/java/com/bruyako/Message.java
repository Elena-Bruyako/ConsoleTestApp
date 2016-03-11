package com.bruyako;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by brunyatko on 10.03.16.
 */
public class Message {

    private Calendar date = Calendar.getInstance(new Locale("ru","UA"));
    private int hours = date.get(Calendar.HOUR_OF_DAY);

    public String getMessage() throws UnsupportedEncodingException {

        if (hours >= 6 && hours <= 9) {
            String morning = getResourceBundle().getString("morning");
            return new String(morning.getBytes("ISO-8859-1"), "UTF-8");
        } else if (hours >= 9 && hours <= 19) {
            String day = getResourceBundle().getString("day");
            return new String(day.getBytes("ISO-8859-1"), "UTF-8");
        } else if (hours >= 19 && hours <= 23) {
            String evening = getResourceBundle().getString("evening");
            return new String(evening.getBytes("ISO-8859-1"), "UTF-8");
        } else {
            String night = getResourceBundle().getString("night");
            return new String(night.getBytes("ISO-8859-1"), "UTF-8");
        }
    }

    private ResourceBundle getResourceBundle() {
        Locale currentLocale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("message", currentLocale);
        return rb;
    }
}
