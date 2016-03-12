package com.bruyako;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;


/**
 * Created by brunyatko on 09.03.16.
 */
public class App {

    private static final Logger log = Logger.getLogger(MessageService.class);

    public static void main(String[] args) {

        try {
            MessageService messageService = new MessageService();
            String message = messageService.getMessage();
            System.out.println(message);
            log.info(message);
        } catch (UnsupportedEncodingException e) {
            log.error(" \n" +
                    " An error occurred with the character encoding in the message. " +
                    "Exception: UnsupportedEncodingException");
        }
    }
}
