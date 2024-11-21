package com.zs.pages.vijetha;

import com.zs.locators.VijethaLocators;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The LoginPageVijetha class represents the login page for the Vijetha application.
 * It contains methods for interacting with key elements on the Login Page of Vijetha Application only (common methods like
 * add to cart, click on log in button etc. are written in the pages.common package.
 */
public class LoginPageVijetha {

    // Logger to capture log messages
    public static Logger logger= LoggerUtil.getLogger();
    // AndroidDriver instance to interact with the application
    public static AndroidDriver driver;
    // WebDriverWait instance to wait for elements to be ready for interaction
    public static WebDriverWait wait;

    /**
     * Constructor for the LoginPageVijetha class.
     * @param driver The AndroidDriver instance to interact with the app.
     * @param wait The WebDriverWait instance to wait for elements to be visible or clickable.
     */
    public LoginPageVijetha(AndroidDriver driver, WebDriverWait wait){
        LoginPageVijetha.driver =driver;
        LoginPageVijetha.wait=wait;
    }
    /**
     * This method clicks the "Login with Password" option on the Vijetha login page.
     * @param appName The name of the app being tested, used for logging purposes.
     */
    public void clickOnLoginWPass(String appName){
        By logInWPassLoc= VijethaLocators.getLoginLocator("logInWithPasswordLinkText");
        WebElement logInWPass= wait.until(ExpectedConditions.elementToBeClickable(logInWPassLoc));
        logInWPass.click();
        logger.info("Clicked on login with password for {}", appName);
    }
    /**
     * This method clicks the button to allow the app to access the device's location.
     * @param appName The name of the app being tested, used for logging purposes.
     */
    public void clickOnAllowAccess(String appName){
        By allowLocationAccessBtnLoc= VijethaLocators.getHomePageLocator("allowLocationAccessBtn");
        WebElement allowBtn=wait.until(ExpectedConditions.elementToBeClickable(allowLocationAccessBtnLoc));
        allowBtn.click();
        logger.info("Clicked on allow location access for {}", appName);
    }
}
