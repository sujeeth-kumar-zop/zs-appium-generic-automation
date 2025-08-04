package com.zopsmart.eazyupdates.utils;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;

public class AllureScreenshotUtil {

    /**
     * Captures a screenshot from the AppiumDriver and attaches it to the Allure report.
     *
     * @param driver the active AppiumDriver instance
     * @param name   the name of the screenshot attachment
     */
    public static void attachScreenshot(AppiumDriver driver, String name) {
        try {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, "image/png", new ByteArrayInputStream(screenshotBytes), ".png");
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot for Allure: " + e.getMessage());
        }
    }
}
