package com.bruyako;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by brunyatko on 10.03.16.
 */
public class MessageService {

    private Locale locale = Locale.getDefault();
    private Calendar date = Calendar.getInstance(new Locale("ru","UA"));

    public String getMessage() throws UnsupportedEncodingException {
        int hours = date.get(Calendar.HOUR_OF_DAY);

        return getLocalizebleMessage(hours);
    }

    private String getLocalizebleMessage(int hours) throws UnsupportedEncodingException {
        if (hours >= 6 && hours <= 9) {
            return getStringByKey(locale, "morning");
        } else if (hours >= 9 && hours <= 19) {
            return getStringByKey(locale, "day");
        } else if (hours >= 19 && hours <= 23) {
            return getStringByKey(locale, "evening");
        } else {
            return getStringByKey(locale, "night");
        }
    }

    private String getStringByKey(Locale local, String key) throws UnsupportedEncodingException {
        ResourceBundle resource = ResourceBundle.getBundle("message", local);
        String message = resource.getString(key);
        return new String(message.getBytes("ISO-8859-1"), "UTF-8");
    }
}
