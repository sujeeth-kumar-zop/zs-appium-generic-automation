package com.zs.pages.common;

import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.math3.analysis.function.Exp;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * The ProfilePage class is responsible for interacting with the profile page in the application.
 * It provides methods to interact with and retrieve information from the profile section,
 * such as checking if the username is visible on the profile page.
 */
public class ProfilePage {


    /**
     * Logger instance for logging actions
     */
    private static Logger logger= LoggerUtil.getLogger();
    /**
     * android driver instance for interacting with the application
     */
    private final AndroidDriver driver;
    /** Web driver wait instance for implementing explicit wait
     */
    private final WebDriverWait wait;

    /**
     * Constructor for initializing the ProfilePage object with the AndroidDriver and WebDriverWait.
     *
     * @param driver The AndroidDriver instance used to interact with the app.
     * @param wait The WebDriverWait instance used to wait for elements to be visible or clickable.
     */
    public ProfilePage(AndroidDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }
    /**
     * Checks if the username element is visible on the profile page.
     * This is used to verify that the profile page is correctly loaded and the username is visible.
     *
     * @param appName The name of the application to fetch the appropriate locator.
     * @return true if the username element is visible, false otherwise.
     */
    public boolean isUsernameVisible(String appName){
        By usernameLoc = CommonUtils.getProfileLocator(appName, "username");
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLoc));
        return username.isDisplayed();
    }

    public void clickEditBtn(String appName){
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProfileLocator(appName, "editBtn"))).click();
    }
}
