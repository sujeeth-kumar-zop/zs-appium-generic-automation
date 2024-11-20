package com.zs.pages.common;

import com.zs.constants.Constants;
import com.zs.locators.*;
import com.zs.pages.vijetha.LoginPageVijetha;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    //get logger
    public static Logger logger=LoggerUtil.getLogger();


    public static void clickLoginBtn(AndroidDriver driver, WebDriverWait wait,String appName){

        By loginBtnLoc = CommonUtils.getLoginLocator(appName, "loginBtn");
        WebElement loginBtn = driver.findElement(loginBtnLoc);
        loginBtn.click();
        logger.info("Clicked on the Login Button for {}", appName);
    }

    public static void clickOnProfileIcon(AndroidDriver driver, WebDriverWait wait,String appName){

        By profileIconLoc = CommonUtils.getLoginLocator(appName, "profileIcon");
        WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(profileIconLoc));
        profileIcon.click();
        logger.info("Clicked on the profile icon for {}", appName);
    }

    public static void enterPhNo(AndroidDriver driver, WebDriverWait wait, String username, String appName){

        By phnoTextBoxLoc = CommonUtils.getLoginLocator(appName, "enterEmailOrPhoneTextBox");
        WebElement phnoTextBox= driver.findElement(phnoTextBoxLoc);
        wait.until(ExpectedConditions.visibilityOf(phnoTextBox)).sendKeys(username);
        logger.info("Entered email in the login text box for {}", appName);
    }

    public static void enterPass(AndroidDriver driver, WebDriverWait wait, String password, String appName){

        By passTextBoxLoc = CommonUtils.getLoginLocator(appName, "enterPassTextBox");
        WebElement passTextBox= driver.findElement(passTextBoxLoc);
        wait.until(ExpectedConditions.visibilityOf(passTextBox)).sendKeys(password);
        logger.info("Entered password in the password text box for {}", appName);
    }

    public static void loginFlow(AndroidDriver driver, WebDriverWait wait, String password, String username, String appName){
        switch(appName){
            case Constants.BRIMBARY :
                HomePage.clickOnDrawer(driver, wait, Constants.BRIMBARY);
                LoginPage.clickOnProfileIcon(driver, wait, Constants.BRIMBARY);
                LoginPage.enterPhNo(driver, wait, username, Constants.BRIMBARY);
                LoginPage.enterPass(driver, wait, password, Constants.BRIMBARY);
                LoginPage.clickLoginBtn(driver, wait, Constants.BRIMBARY);
                HomePage.clickOnDrawer(driver, wait, Constants.BRIMBARY);
                break;
            case Constants.TAMIMI:
                LoginPage.clickOnProfileIcon(driver, wait, Constants.TAMIMI);
                LoginPage.enterPhNo(driver, wait, username, Constants.TAMIMI);
                LoginPage.enterPass(driver, wait, password, Constants.TAMIMI);
                LoginPage.clickLoginBtn(driver, wait, Constants.TAMIMI);
                LoginPage.clickOnProfileIcon(driver, wait, Constants.TAMIMI);
                break;
            case Constants.VIJETHA:
                LoginPageVijetha.clickOnAllowAccess(driver, wait, Constants.VIJETHA);
                LoginPage.clickOnProfileIcon(driver, wait, Constants.VIJETHA);
                LoginPageVijetha.clickOnLoginWPass(driver, wait, Constants.VIJETHA);
                LoginPage.enterPhNo(driver, wait, username, Constants.VIJETHA);
                LoginPage.enterPass(driver, wait, password, Constants.VIJETHA);
                LoginPage.clickLoginBtn(driver, wait, Constants.VIJETHA);
                LoginPage.clickOnProfileIcon(driver, wait, Constants.VIJETHA);
                break;
            case Constants.EKAM:
                LoginPage.clickOnProfileIcon(driver, wait, Constants.EKAM);
                LoginPage.enterPhNo(driver, wait, username, Constants.EKAM);
                LoginPage.enterPass(driver, wait, password, Constants.EKAM);
                LoginPage.clickLoginBtn(driver, wait, Constants.EKAM);
                LoginPage.clickOnProfileIcon(driver, wait, Constants.EKAM);
                break;
        }
    }

}
