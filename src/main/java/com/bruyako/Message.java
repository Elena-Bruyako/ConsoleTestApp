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
            return getStringByKey("morning");
        } else if (hours >= 9 && hours <= 19) {
            return getStringByKey("day");
        } else if (hours >= 19 && hours <= 23) {
            return getStringByKey("evening");
        } else {
            return getStringByKey("night");
        }
    }

    private ResourceBundle getResourceBundle() {
        Locale currentLocale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("message", currentLocale);
        return rb;
    }

    private String getStringByKey(String key) throws UnsupportedEncodingException {
        String value = getResourceBundle().getString(key);
        return new String(value.getBytes("ISO-8859-1"), "UTF-8");
    }
}
