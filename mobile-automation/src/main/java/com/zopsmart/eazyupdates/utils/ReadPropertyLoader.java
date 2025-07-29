package com.zopsmart.eazyupdates.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyLoader {
    public static Properties props = new Properties();
    public static void loadPropertiesToSystem(String filePath) {
    try (FileInputStream input = new FileInputStream(filePath)) {
        props.load(input);
        for (String key : props.stringPropertyNames()) {
            System.setProperty(key, props.getProperty(key));
        }
    } catch (IOException e) {
        throw new RuntimeException(e.getMessage());
    }
}
}
