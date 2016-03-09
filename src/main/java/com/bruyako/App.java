package com.bruyako;

import java.util.Calendar;

/**
 * Created by brunyatko on 09.03.16.
 */
public class App {

    public static void main(String[] args) {

        Calendar date = Calendar.getInstance();
        int hours = date.get(Calendar.HOUR_OF_DAY);

        MessageHelper messageHelper = new MessageHelper();
        System.out.println(messageHelper.getDate(hours));

    }
}
