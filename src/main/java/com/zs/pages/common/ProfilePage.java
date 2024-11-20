package com.zs.pages;

import com.zs.locators.BrimbaryLocators;
import com.zs.locators.EkamLocators;
import com.zs.locators.TamimiLocators;
import com.zs.locators.VijethaLocators;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    public static boolean isUsernameVisible(AndroidDriver driver, WebDriverWait wait, String appName){
        By usernameLoc = switch (appName) {
            case "Vijetha" -> VijethaLocators.getProfileLocators("username");
            case "Tamimi" -> TamimiLocators.getProfileLocators("username");
            case "Brimbary" -> BrimbaryLocators.getProfileLocators("username");
            case "Ekam" -> EkamLocators.getProfileLocators("username");
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };

        WebElement username = driver.findElement(usernameLoc);
        return username.isDisplayed();
    }
}
