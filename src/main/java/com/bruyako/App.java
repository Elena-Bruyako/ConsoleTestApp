package com.bruyako;

import java.io.UnsupportedEncodingException;

/**
 * Created by brunyatko on 09.03.16.
 */
public class App {

    public static void main(String[] args) throws UnsupportedEncodingException {

        MessageService messageService = new MessageService();
        System.out.println(messageService.getMessage());
    }
}
