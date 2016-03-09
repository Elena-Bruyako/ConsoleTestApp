package com.bruyako;

import com.bruyako.models.MessageResources;
import com.bruyako.utils.Const;
import com.bruyako.utils.PathHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

/**
 * Created by brunyatko on 09.03.16.
 */
public class MessageHelper {

    private static final Logger log = Logger.getLogger(MessageHelper.class);

    public String getDate(int hours) {

        MessageResources messageResources = getLocalizableResources();

        if (hours >= 6 && hours <= 9) {
            return messageResources.getMorningString();
        } else if (hours >= 9 && hours <= 19) {
            return messageResources.getDayString();
        } else if (hours >= 19 && hours <= 23) {
            return messageResources.getEveningString();
        } else {
            return messageResources.getNightString();
        }
    }

    private MessageResources getLocalizableResources() {
        String language = System.getProperty("user.language");
        String path = PathHelper.getLocalizablePath(language);

        try {
            return getResources(path);
        } catch (NoSuchFileException e) {

            try {
                return getResources(PathHelper.getDefaultPath());
            } catch (IOException exception){
                log.info("Localization not found. Default localization was used.");
                return Const.getDefaultResources();
            }

        } catch (IOException e) {
            log.info("An IOException was caught.");
            return Const.getDefaultResources();
        }
    }

    private MessageResources getResources(String path) throws IOException {
        String json = readFile(path);
        MessageResources message = convertStringToJson(json);
        return message;
    }

    private String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

    private MessageResources convertStringToJson(String json){
        Gson gson = new GsonBuilder().create();
        MessageResources message = gson.fromJson(json, MessageResources.class);
        return message;
    }
}

