package com.zs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for logging.
 * Provides a singleton logger instance for use throughout the application.
 */
public class LoggerUtil {
    // Logger instance, specific to the LoggerUtil class
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    /**
     * Gets the logger instance.
     * @return the logger instance
     */
    public static Logger getLogger() {
        return logger;
    }
}
