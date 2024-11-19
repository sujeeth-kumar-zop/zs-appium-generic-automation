package com.zs.pages;

import com.zs.locators.BrimbaryLocators;
import com.zs.locators.EkamLocators;
import com.zs.locators.TamimiLocators;
import com.zs.locators.VijethaLocators;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public static boolean isHomePageLoaded(AndroidDriver driver, WebDriverWait wait, String appName){

        By homeLogoLoc = switch (appName) {
            case "Vijetha" -> VijethaLocators.getLoginLocator("profileIcon");
            case "Tamimi" -> TamimiLocators.getHomePageLocator("headerLogo");
            case "Brimbary" -> BrimbaryLocators.getLoginLocator("profileIcon");
            case "Ekam" -> EkamLocators.getLoginLocator("profileIcon");
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
        try{
            WebElement homeLogo= wait.until(ExpectedConditions.visibilityOfElementLocated(homeLogoLoc));
            return homeLogo.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void clickOnDrawer(AndroidDriver driver, WebDriverWait wait, String appName){
        By drawerIconLoc = switch(appName) {
            case "Tamimi" -> TamimiLocators.getHomePageLocator("drawerIcon");
            case "Brimbary" -> BrimbaryLocators.getHomePageLocator("drawerIcon");
            default -> throw new IllegalArgumentException("Invalid app name: "+appName);
        };
        WebElement drawerIcon= wait.until(ExpectedConditions.elementToBeClickable(drawerIconLoc));
        drawerIcon.click();
    }

    public static void clickOnVersionText(AndroidDriver driver, WebDriverWait wait, String appName){
        By versionTextLoc = switch(appName) {
            case "Tamimi" -> TamimiLocators.getHomePageLocator("versionText");
            default -> throw new IllegalArgumentException("Invalid app name: "+appName);
        };
        WebElement versionText = wait.until(ExpectedConditions.visibilityOfElementLocated(versionTextLoc));
        for(int i=0;i<5;i++){
            versionText.click();
        }
    }

    public static void changeUrlToStaging(AndroidDriver driver, WebDriverWait wait, String appName){
        By appUrlLoc = switch(appName) {
            case "Tamimi" -> TamimiLocators.getStagingUrlLocators("appUrl");
            default -> throw new IllegalArgumentException("Invalid app name: "+appName);
        };
        WebElement appUrl=wait.until(ExpectedConditions.elementToBeClickable(appUrlLoc));
        String initialUrl=appUrl.getText();
        appUrl.sendKeys("staging." + initialUrl);

        By applyBtnLoc = switch (appName) {
            case "Tamimi" -> TamimiLocators.getStagingUrlLocators("applyBtn");
            default -> throw new IllegalArgumentException("Invalid app name: "+appName);
        };
        WebElement applyBtn= driver.findElement(applyBtnLoc);
        applyBtn.click();

        By okBtnLoc = switch (appName) {
            case "Tamimi" -> TamimiLocators.getStagingUrlLocators("okBtn");
            default -> throw new IllegalArgumentException("Invalid app name: "+appName);
        };
        WebElement okBtn= wait.until(ExpectedConditions.elementToBeClickable(okBtnLoc));
        okBtn.click();
    }
}
