package com.zs.utils;

import com.zs.constants.Constants;
import com.zs.locators.BrimbaryLocators;
import com.zs.locators.EkamLocators;
import com.zs.locators.TamimiLocators;
import com.zs.locators.VijethaLocators;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility class containing common methods used across different test scenarios.
 * Provides helper methods for locator retrieval, app-specific actions, and navigation.
 */
public class CommonUtils{

    /**
     * Logger instance for logging activities within this utility class.
     */
    private static final Logger logger=LoggerUtil.getLogger();
    /**
     * Driver instance to interact with the application.
     */
    private final AndroidDriver driver;
    /**
     * Wait instance for implementing explicit waits.
     */
    private final WebDriverWait wait;

    /**
     * Constructor to initialize the CommonUtils instance with driver and wait.
     *
     * @param driver AndroidDriver instance for interacting with the app.
     * @param wait   WebDriverWait instance for explicit waits.
     */
    public CommonUtils(AndroidDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }

    /**
     * Checks if text is present on the current screen
     * @param text The text to search for.
     * @return true if text is present, false otherwise.
     */
    public boolean isTextPresent(String text){
        try {
            WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Fetches a profile locator based on app's name and key
     * @param appName name of the application whose locator needs to be retrieved
     * @param key key of that locator in hashmap
     * @return locator for the specified key
     */
    public static By getProfileLocator(String appName, String key){
        return switch (appName){
            case Constants.VIJETHA -> VijethaLocators.getProfileLocators(key);
            case Constants.TAMIMI -> TamimiLocators.getProfileLocators(key);
            case Constants.BRIMBARY -> BrimbaryLocators.getDrawerLocators(key);
            case Constants.EKAM -> EkamLocators.getProfileLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }
    /**
     * Fetches a login locator based on app's name and key
     * @param appName name of the application whose locator needs to be retrieved
     * @param key key of that locator in hashmap
     * @return locator for the specified key
     */
    public static By getLoginLocator(String appName, String key){
        return switch (appName){
            case Constants.VIJETHA -> VijethaLocators.getLoginLocator(key);
            case Constants.TAMIMI -> TamimiLocators.getLoginLocator(key);
            case Constants.BRIMBARY -> BrimbaryLocators.getLoginLocator(key);
            case Constants.EKAM -> EkamLocators.getLoginLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }
    /**
     * Fetches a home page locator based on app's name and key
     * @param appName name of the application whose locator needs to be retrieved
     * @param key key of that locator in hashmap
     * @return locator for the specified key
     */
    public static By getHomePageLocator(String appName, String key){
        return switch (appName){
            case Constants.VIJETHA -> VijethaLocators.getHomePageLocator(key);
            case Constants.TAMIMI -> TamimiLocators.getHomePageLocator(key);
            case Constants.BRIMBARY -> BrimbaryLocators.getHomePageLocator(key);
            case Constants.EKAM -> EkamLocators.getHomePageLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    /**
     * Fetches a product page locator based on app's name and key
     * @param appName name of the application whose locator needs to be retrieved
     * @param key key of that locator in hashmap
     * @return locator for the specified key
     */
    public static By getProductPageLocator(String appName, String key){
        return switch (appName){
            case Constants.VIJETHA -> VijethaLocators.getProductPageLocators(key);
            case Constants.TAMIMI -> TamimiLocators.getProductPageLocators(key);
            case Constants.BRIMBARY -> BrimbaryLocators.getProductPageLocators(key);
            case Constants.EKAM -> EkamLocators.getProductPageLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    /**
     * Fetches a drawer menu locator based on app's name and key
     * @param appName name of the application whose locator needs to be retrieved
     * @param key key of that locator in hashmap
     * @return locator for the specified key
     */
    public static By getDrawerLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getDrawerLocators(key);
            case Constants.BRIMBARY -> BrimbaryLocators.getDrawerLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    /**
     * Fetches a menu locator based on app's name and key
     * @param appName name of the application whose locator needs to be retrieved
     * @param key key of that locator in hashmap
     * @return locator for the specified key
     */
    public static By getMenuLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getMenuLocators(key);
            case Constants.EKAM -> EkamLocators.getMenuLocators(key);
            case Constants.VIJETHA -> VijethaLocators.getMenuLocators(key);
            case Constants.BRIMBARY -> BrimbaryLocators.getMenuLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    /**
     * Fetches a cart page locator based on app's name and key
     * @param appName name of the application whose locator needs to be retrieved
     * @param key key of that locator in hashmap
     * @return locator for the specified key
     */
    public static By getCartLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getCartLocators(key);
            case Constants.EKAM -> EkamLocators.getCartLocators(key);
            case Constants.VIJETHA -> VijethaLocators.getCartLocators(key);
            case Constants.BRIMBARY -> BrimbaryLocators.getCartLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }
    /**
     * Fetches a checkout page locator based on app's name and key
     * @param appName name of the application whose locator needs to be retrieved
     * @param key key of that locator in hashmap
     * @return locator for the specified key
     */
    public static By getCheckoutLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getCheckoutLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public boolean isElementVisible(By locator){
        WebElement webElement=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement.isDisplayed();
    }

    public void navigateToHome(String appName) {

        int maxRetries = 10;
        int attempts = 0;
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        while (attempts < maxRetries) {
            try {

                WebElement searchBar = shortWait.until(ExpectedConditions.visibilityOfElementLocated(CommonUtils.getHomePageLocator(appName, "searchPlaceholder")));
                if (searchBar.isDisplayed()) {
                    break;
                }
            } catch (NoSuchElementException | TimeoutException e) {
                LoggerUtil.logInfo("Not at home page. Navigating back: " + attempts);
                driver.navigate().back();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
            attempts++;

            if (attempts == maxRetries) {
                LoggerUtil.logFail("Failed to navigate back to Home page after " + maxRetries + " attempts.");
                throw new RuntimeException("Unable to navigate back to Home page.");
            }
        }
    }

    public static By generateLocator(String text) {
        return By.xpath(String.format("//*[@text='%s']",text));
    }

    public boolean isLoggedIn(String appName) {
        navigateToHome(appName);
        driver.findElement(CommonUtils.getHomePageLocator(appName, "drawerIcon")).click();
        String username = driver.findElement(CommonUtils.getDrawerLocators(appName, "username")).getText();
        if(username.equalsIgnoreCase(Constants.TAMIMI_SIGNUP)){
            return false;
        }
        return true;
    }



}