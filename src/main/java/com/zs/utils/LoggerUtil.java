package com.zs.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for logging.
 * Provides a singleton logger instance for use throughout the application.
 */
public class LoggerUtil {
    // Logger instance, specific to the LoggerUtil class
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);
    private static ExtentTest extentTest;

    /**
     * Sets the ExtentTest object. This should be done once in the test setup.
     * @param test The ExtentTest object to be set.
     */
    public static void setExtentTest(ExtentTest test) {
        extentTest = test;
    }

    /**
     * Logs an info message to both Log4j and ExtentReports.
     * @param message The message to log.
     */
    public static void logInfo(String message) {
        // Log to Log4j console
        logger.info(message);

        // Log to ExtentReports (if ExtentTest is initialized)
        if (extentTest != null) {
            extentTest.log(Status.INFO, message);
        }
    }

    /**
     * Logs a pass message to both Log4j and ExtentReports.
     * @param message The message to log.
     */
    public static void logPass(String message) {
        // Log to Log4j console
        logger.info(message);

        // Log to ExtentReports
        if (extentTest != null) {
            extentTest.log(Status.PASS, message);
        }
    }

    /**
     * Logs a fail message to both Log4j and ExtentReports.
     * @param message The message to log.
     */
    public static void logFail(String message) {
        // Log to Log4j console
        logger.error(message);

        // Log to ExtentReports
        if (extentTest != null) {
            extentTest.log(Status.FAIL, message);
        }
    }

    /**
     * Logs an error message to both Log4j and ExtentReports.
     * @param message The message to log.
     */
    public static void logError(String message, Throwable throwable) {
        // Log to Log4j console
        logger.error(message, throwable);

        // Log to ExtentReports
        if (extentTest != null) {
            extentTest.log(Status.FAIL, message+ " - Exception: "+ throwable.getMessage());
        }
    }

    /**
     * Gets the logger instance.
     * @return the logger instance
     */
    public static Logger getLogger() {
        return logger;
    }
}
