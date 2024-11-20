package com.zs.utils;

import com.zs.constants.Constants;
import com.zs.locators.BrimbaryLocators;
import com.zs.locators.EkamLocators;
import com.zs.locators.TamimiLocators;
import com.zs.locators.VijethaLocators;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.constant.ConstantDescs;
import java.lang.reflect.Method;

public class CommonUtils{
    public static boolean isTextPresent(String text, AndroidDriver driver, WebDriverWait wait){
        try {
            WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static void callAppSpecificLoginMethod(String appName, String username, String password) {
        try {

            String className = "test" + appName + ".LoginTest" + appName; // example: testVijetha.LoginTestVijetha or testTamimi.LoginTestTamimi

            Class<?> clazz = Class.forName(className); //load the class

            Method loginMethod = clazz.getMethod("login" + appName, String.class, String.class); //store the loginmethod of the class in a variable

            loginMethod.invoke(null, username, password); //call the stored method

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No test class found for app: " + appName, e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("No login method found for app: " + appName, e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke login method for app: " + appName, e);
        }
    }




    public static By getProfileLocator(String appName, String key){
        return switch (appName){
            case Constants.VIJETHA -> VijethaLocators.getProfileLocators(key);
            case Constants.TAMIMI -> TamimiLocators.getProfileLocators(key);
            case Constants.BRIMBARY -> BrimbaryLocators.getDrawerLocators(key);
            case Constants.EKAM -> EkamLocators.getProfileLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getLoginLocator(String appName, String key){
        return switch (appName){
            case Constants.VIJETHA -> VijethaLocators.getLoginLocator(key);
            case Constants.TAMIMI -> TamimiLocators.getLoginLocator(key);
            case Constants.BRIMBARY -> BrimbaryLocators.getLoginLocator(key);
            case Constants.EKAM -> EkamLocators.getLoginLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getHomePageLocator(String appName, String key){
        return switch (appName){
            case Constants.VIJETHA -> VijethaLocators.getHomePageLocator(key);
            case Constants.TAMIMI -> TamimiLocators.getHomePageLocator(key);
            case Constants.BRIMBARY -> BrimbaryLocators.getHomePageLocator(key);
            case Constants.EKAM -> EkamLocators.getHomePageLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getProductPageLocator(String appName, String key){
        return switch (appName){
            case Constants.VIJETHA -> VijethaLocators.getProductPageLocators(key);
            case Constants.TAMIMI -> TamimiLocators.getProductPageLocators(key);
            case Constants.BRIMBARY -> BrimbaryLocators.getProductPageLocators(key);
            case Constants.EKAM -> EkamLocators.getProductPageLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getDrawerLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getDrawerLocators(key);
            case Constants.BRIMBARY -> BrimbaryLocators.getDrawerLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getMenuLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getMenuLocators(key);
            case Constants.EKAM -> EkamLocators.getMenuLocators(key);
            case Constants.VIJETHA -> VijethaLocators.getMenuLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getCartLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getCartLocators(key);
            case Constants.EKAM -> EkamLocators.getCartLocators(key);
            case Constants.VIJETHA -> VijethaLocators.getMenuLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static void goToHome(String appName, AndroidDriver driver, WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getMenuLocators(appName, "homeBtn"))).click();
    }



}
