package com.bruyako.utils;

import com.bruyako.models.MessageResources;

/**
 * Created by brunyatko on 09.03.16.
 */
public class Const {

    public static final String MORNING_STRING = "Good morning, World!";
    public static final String DAY_STRING = "Good day, World!";
    public static final String EVENING_STRING = "Good evening, World!";
    public static final String NIGHT_STRING = "Good night, World!";

    public static MessageResources getDefaultResources() {
        MessageResources messageResources = new MessageResources();
        messageResources.setMorningString(MORNING_STRING);
        messageResources.setDayString(DAY_STRING);
        messageResources.setEveningString(EVENING_STRING);
        messageResources.setNightString(NIGHT_STRING);
        return messageResources;
    }
}
