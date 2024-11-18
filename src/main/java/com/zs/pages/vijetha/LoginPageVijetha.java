package com.zs.pages.vijetha;

import com.zs.locators.VijethaLocators;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageVijetha {

    public static void clickOnLoginWPass(AndroidDriver driver, WebDriverWait wait, String appName){
        By logInWPassLoc= VijethaLocators.getLoginLocator("logInWithPasswordLinkText");
        WebElement logInWPass= wait.until(ExpectedConditions.elementToBeClickable(logInWPassLoc));
        logInWPass.click();
    }

    public static void clickOnAllowAccess(AndroidDriver driver, WebDriverWait wait, String appName){
        By allowLocationAccessBtnLoc= VijethaLocators.getHomePageLocator("allowLocationAccessBtn");
        WebElement allowBtn=wait.until(ExpectedConditions.elementToBeClickable(allowLocationAccessBtnLoc));
        allowBtn.click();
    }
}
