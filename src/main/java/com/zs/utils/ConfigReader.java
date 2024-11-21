package com.zs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class for reading configuration properties from a file.
 * Provides a centralized way to fetch configuration values for the application.
 */
public class ConfigReader {

    /**
     * Properties object to store key-value pairs from the configuration file.
     */
    private static Properties properties;

    // Static block to initialize and load the properties file when the class is first accessed.
    static {
        try (FileInputStream fileInput = new FileInputStream("src/main/resources/config.properties")) {
            properties = new Properties();
            properties.load(fileInput); // Load properties from the file
        } catch (IOException e) {
            // Log the error and terminate the application if the configuration file fails to load.
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file.");
        }
    }

    /**
     * Fetches the value of a given key from the loaded configuration file.
     *
     * @param key The key whose corresponding value is to be fetched.
     * @return The value associated with the given key, or null if the key does not exist.
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
