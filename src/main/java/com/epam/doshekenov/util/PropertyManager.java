package com.epam.doshekenov.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    Properties properties;
    private static final Logger logger = LoggerFactory.getLogger(PropertyManager.class.getSimpleName());

    public PropertyManager(String s) {
        this.properties = new Properties();
        load(s);
    }

    private void load(String path) {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        try {
            properties.load(in);
        } catch (IOException e) {
            logger.error("You need to create an 'email.properties' file with 'login', 'password' and 'receiver'  properties, and put it in resources folder");
        }
    }


    public String getProperty(String key) {
        return properties.getProperty(key);
    }


}

