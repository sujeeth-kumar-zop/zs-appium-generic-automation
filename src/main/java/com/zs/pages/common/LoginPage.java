package com.zs.pages;

import com.zs.locators.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public static void clickLoginBtn(AndroidDriver driver, WebDriverWait wait,String appName){

        By loginBtnLoc = switch (appName) {
            case "Vijetha" -> VijethaLocators.getLoginLocator("loginBtn");
            case "Tamimi" -> TamimiLocators.getLoginLocator("loginBtn");
            case "Brimbary" -> BrimbaryLocators.getLoginLocator("loginBtn");
            case "Ekam" -> EkamLocators.getLoginLocator("loginBtn");
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };

        WebElement loginBtn = driver.findElement(loginBtnLoc);
        loginBtn.click();
        System.out.println("Clicked on the login button for " + appName);
    }

    public static void clickOnProfileIcon(AndroidDriver driver, WebDriverWait wait,String appName){

        By profileIconLoc = switch (appName) {
            case "Vijetha" -> VijethaLocators.getLoginLocator("profileIcon");
            case "Tamimi" -> TamimiLocators.getLoginLocator("profileIcon");
            case "Brimbary" -> BrimbaryLocators.getLoginLocator("profileIcon");
            case "Ekam" -> EkamLocators.getLoginLocator("profileIcon");
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
        WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(profileIconLoc));
        profileIcon.click();
        System.out.println("Clicked on the profile icon for " + appName);
    }

    public static void enterPhNo(AndroidDriver driver, WebDriverWait wait, String username, String appName){

        By phnoTextBoxLoc = switch (appName) {
            case "Vijetha" -> VijethaLocators.getLoginLocator("enterEmailOrPhoneTextBox");
            case "Tamimi" -> TamimiLocators.getLoginLocator("enterEmailOrPhoneTextBox");
            case "Brimbary" -> BrimbaryLocators.getLoginLocator("enterEmailOrPhoneTextBox");
            case "Ekam" -> EkamLocators.getLoginLocator("enterEmailOrPhoneTextBox");
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };

        WebElement phnoTextBox= driver.findElement(phnoTextBoxLoc);

        wait.until(ExpectedConditions.visibilityOf(phnoTextBox)).sendKeys(username);
        System.out.println("Entered email in the login text box for "+appName);
    }

    public static void enterPass(AndroidDriver driver, WebDriverWait wait, String password, String appName){

        By passTextBoxLoc = switch (appName) {
            case "Vijetha" -> VijethaLocators.getLoginLocator("enterPassTextBox");
            case "Tamimi" -> TamimiLocators.getLoginLocator("enterPassTextBox");
            case "Brimbary" -> BrimbaryLocators.getLoginLocator("enterPassTextBox");
            case "Ekam" -> EkamLocators.getLoginLocator("enterPassTextBox");
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
        WebElement passTextBox= driver.findElement(passTextBoxLoc);

        wait.until(ExpectedConditions.visibilityOf(passTextBox)).sendKeys(password);
        System.out.println("Entered password in the password text box for "+appName);
    }

}
