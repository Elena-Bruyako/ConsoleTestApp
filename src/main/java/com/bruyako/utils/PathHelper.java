package com.bruyako.utils;

/**
 * Created by brunyatko on 09.03.16.
 */
public class PathHelper {

    private static final String DEFAULT_PATH_TEMPLATE = "resource/message_resource_{language}";

    public static String getLocalizablePath(String language){
        return DEFAULT_PATH_TEMPLATE.replace("{language}", language);
    }

    public static String getDefaultPath(){
        return getLocalizablePath("en");
    }

}
