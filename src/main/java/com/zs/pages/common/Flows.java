package com.zs.pages.common;

import com.zs.constants.Constants;
import com.zs.pages.vijetha.LoginPageVijetha;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains flows for all the tests.
 * Utilizes methods of Page classes to construct and execute flows.
 */
public class Flows {
    private static final Logger logger= LoggerUtil.getLogger();
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor for Flows
     *
     * @param driver AndroidDriver instance to interact with the app.
     * @param wait WebDriverWait instance to wait for elements.
     */
    public Flows(AndroidDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }

    /**
     * Executes the login flow for the specified app, entering the username and password.
     *
     * @param username The username (email or phone number) to be used for login.
     * @param password The password to be used for login.
     * @param appName The name of the app being tested, used to switch between different login flows.
     */
    public void loginFlow(String password, String username, String appName){
        HomePage homePage=new HomePage(driver, wait);
        LoginPage loginPage=new LoginPage(driver, wait);
        // Switch based on the app name and execute the specific login steps.
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

    /**
     * @param appName The name of the app being tested, used to switch between different login flows.
     */
    public void addSingleProductToCartFlow(String appName){
        HomePage homePage=new HomePage(driver,wait);
        LoginPage loginPage=new LoginPage(driver,wait);
        ProductsPage productsPage=new ProductsPage(driver,wait);
        switch(appName){
            case Constants.BRIMBARY :
                productsPage.openProduct(appName);
                productsPage.addToCartBtn(appName);
                break;
            case Constants.TAMIMI, Constants.VIJETHA, Constants.EKAM :
                productsPage.clickProductCategory(appName);
                productsPage.openProduct(appName);
                productsPage.addToCartBtn(appName);
                productsPage.goToCart(appName);
                break;
        }
    }


}
