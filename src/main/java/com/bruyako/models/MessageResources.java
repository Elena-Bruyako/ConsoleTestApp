package com.bruyako.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by brunyatko on 09.03.16.
 */
public class MessageResources {

    @SerializedName("string_morning")
    private String morningString;

    @SerializedName("string_day")
    private String dayString;

    @SerializedName("string_evening")
    private String eveningString;

    @SerializedName("string_night")
    private String nightString;

    public String getMorningString() {
        return morningString;
    }

    public void setMorningString(String morningString) {
        this.morningString = morningString;
    }

    public String getDayString() {
        return dayString;
    }

    public void setDayString(String dayString) {
        this.dayString = dayString;
    }

    public String getEveningString() {
        return eveningString;
    }

    public void setEveningString(String eveningString) {
        this.eveningString = eveningString;
    }

    public String getNightString() {
        return nightString;
    }

    public void setNightString(String nightString) {
        this.nightString = nightString;
    }
}
