package com.zs.pages.common;

import com.zs.constants.Constants;
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
    private static final Logger logger=LoggerUtil.getLogger();
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public LoginPage(AndroidDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }
    public void clickLoginBtn(String appName){

        By loginBtnLoc = CommonUtils.getLoginLocator(appName, "loginBtn");
        WebElement loginBtn = driver.findElement(loginBtnLoc);
        loginBtn.click();
        logger.info("Clicked on the Login Button for {}", appName);
    }

    public void clickOnProfileIcon(String appName){

        By profileIconLoc = CommonUtils.getLoginLocator(appName, "profileIcon");
        WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(profileIconLoc));
        profileIcon.click();
        logger.info("Clicked on the profile icon for {}", appName);
    }

    public void enterPhNo(String username, String appName){

        By phnoTextBoxLoc = CommonUtils.getLoginLocator(appName, "enterEmailOrPhoneTextBox");
        WebElement phnoTextBox= driver.findElement(phnoTextBoxLoc);
        wait.until(ExpectedConditions.visibilityOf(phnoTextBox)).sendKeys(username);
        logger.info("Entered email in the login text box for {}", appName);
    }

    public void enterPass(String password, String appName){

        By passTextBoxLoc = CommonUtils.getLoginLocator(appName, "enterPassTextBox");
        WebElement passTextBox= driver.findElement(passTextBoxLoc);
        wait.until(ExpectedConditions.visibilityOf(passTextBox)).sendKeys(password);
        logger.info("Entered password in the password text box for {}", appName);
    }

    public void loginFlow(String password, String username, String appName){
        HomePage homePage=new HomePage(driver, wait);
        LoginPage loginPage=new LoginPage(driver, wait);
        switch(appName){
            case Constants.BRIMBARY :
                homePage.clickOnDrawer(Constants.BRIMBARY);
                loginPage.clickOnProfileIcon(Constants.BRIMBARY);
                loginPage.enterPhNo(username, Constants.BRIMBARY);
                loginPage.enterPass(password, Constants.BRIMBARY);
                loginPage.clickLoginBtn(Constants.BRIMBARY);
                homePage.clickOnDrawer(Constants.BRIMBARY);
                break;
            case Constants.TAMIMI:
                loginPage.clickOnProfileIcon(Constants.TAMIMI);
                loginPage.enterPhNo(username, Constants.TAMIMI);
                loginPage.enterPass(password, Constants.TAMIMI);
                loginPage.clickLoginBtn(Constants.TAMIMI);
                loginPage.clickOnProfileIcon(Constants.TAMIMI);
                break;
            case Constants.VIJETHA:
                LoginPageVijetha loginPageVijetha=new LoginPageVijetha(driver, wait);
                loginPageVijetha.clickOnAllowAccess(Constants.VIJETHA);
                loginPage.clickOnProfileIcon(Constants.VIJETHA);
                loginPageVijetha.clickOnLoginWPass(Constants.VIJETHA);
                loginPage.enterPhNo(username, Constants.VIJETHA);
                loginPage.enterPass(password, Constants.VIJETHA);
                loginPage.clickLoginBtn(Constants.VIJETHA);
                loginPage.clickOnProfileIcon(Constants.VIJETHA);
                break;
            case Constants.EKAM:
                loginPage.clickOnProfileIcon(Constants.EKAM);
                loginPage.enterPhNo(username, Constants.EKAM);
                loginPage.enterPass(password, Constants.EKAM);
                loginPage.clickLoginBtn(Constants.EKAM);
                loginPage.clickOnProfileIcon(Constants.EKAM);
                break;
        }
    }

}
