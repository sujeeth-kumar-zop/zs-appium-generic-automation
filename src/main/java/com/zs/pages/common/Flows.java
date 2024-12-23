package com.zs.pages.common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zs.constants.Constants;
import com.zs.pages.tamimi.CartPageTamimi;
import com.zs.pages.vijetha.LoginPageVijetha;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

        LoggerUtil.logInfo("Starting login flow for app: " + appName);
        // Switch based on the app name and execute the specific login steps.
        switch(appName){
            case Constants.BRIMBARY :
                LoggerUtil.logInfo("Navigating through BRIMBARY login flow.");
                homePage.clickOnDrawer(Constants.BRIMBARY);
                loginPage.clickOnProfileIcon(Constants.BRIMBARY);
                loginPage.enterPhNo(username, Constants.BRIMBARY);
                loginPage.enterPass(password, Constants.BRIMBARY);
                loginPage.clickLoginBtn(Constants.BRIMBARY);
                homePage.clickOnDrawer(Constants.BRIMBARY);
                LoggerUtil.logInfo("Login completed for " + appName);
                break;
            case Constants.TAMIMI:
                LoggerUtil.logInfo("Navigating through TAMIMI login flow.");
                loginPage.clickOnProfileIcon(Constants.TAMIMI);
                loginPage.enterPhNo(username, Constants.TAMIMI);
                loginPage.enterPass(password, Constants.TAMIMI);
                loginPage.clickLoginBtn(Constants.TAMIMI);
                loginPage.clickOnProfileIcon(Constants.TAMIMI);
                LoggerUtil.logInfo("Login completed for " + appName);
                break;
            case Constants.VIJETHA:
                LoggerUtil.logInfo("Navigating through Vijetha login flow.");
                LoginPageVijetha loginPageVijetha=new LoginPageVijetha(driver, wait);
                loginPageVijetha.clickOnAllowAccess(Constants.VIJETHA);
                loginPage.clickOnProfileIcon(Constants.VIJETHA);
                loginPageVijetha.clickOnLoginWPass(Constants.VIJETHA);
                loginPage.enterPhNo(username, Constants.VIJETHA);
                loginPage.enterPass(password, Constants.VIJETHA);
                loginPage.clickLoginBtn(Constants.VIJETHA);
                loginPage.clickOnProfileIcon(Constants.VIJETHA);
                LoggerUtil.logInfo("Login completed for " + appName);
                break;
            case Constants.EKAM:
                LoggerUtil.logInfo("Navigating through EKAM login flow.");
                loginPage.clickOnProfileIcon(Constants.EKAM);
                loginPage.enterPhNo(username, Constants.EKAM);
                loginPage.enterPass(password, Constants.EKAM);
                loginPage.clickLoginBtn(Constants.EKAM);
                loginPage.clickOnProfileIcon(Constants.EKAM);
                LoggerUtil.logInfo("Login completed for " + appName);
                break;
        }
        LoggerUtil.logInfo("Completed Login Flow");
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

    /**
     * Increases the quantity of the product in cart
     * @param appName The name of the application under test
     */
    public void increaseQuantityOfProduct(String appName){
        CartPage cartPage=new CartPage(driver,wait);
        CartPageTamimi cartPageTamimi=new CartPageTamimi(driver,wait);
        switch (appName){
            case Constants.TAMIMI:
                cartPageTamimi.tapAndIncreaseQuantityOfItem();
                break;
            case Constants.BRIMBARY, Constants.VIJETHA:
                cartPage.tapAndIncreaseQuantityOfItem(appName);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + appName);
        }
    }

    /**
     * Checks out and handles payment using debit card
     * @param appName The name of the application under test
     */
    public void checkOutUsingDebitCard(String appName){

        Flows flows=new Flows(driver,wait);
        CartPage cartPage=new CartPage(driver,wait);
        CartPageTamimi cartPageTamimi=new CartPageTamimi(driver,wait);
        CheckoutPage checkoutPage=new CheckoutPage(driver,wait);
        CommonUtils commonUtils= new CommonUtils(driver,wait);

        switch (appName){
            case Constants.TAMIMI:
                commonUtils.navigateToHome(appName);
                flows.addSingleProductToCartFlow(appName);
                flows.increaseQuantityOfProduct(appName);
                cartPage.clickOnCheckoutBtn(appName);
                checkoutPage.selectDebitCardForPayment(appName);
                checkoutPage.placeOrder(appName);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + appName);
        }
    }

    /**
     * Checks out and chooses payment mode as cash on delivery.
     * @param appName The name of the application under test.
     */
    public void checkOutUsingCashOnDelivery(String appName){
        CartPage cartPage=new CartPage(driver,wait);
        CartPageTamimi cartPageTamimi=new CartPageTamimi(driver,wait);
        ProductsPage productsPage=new ProductsPage(driver,wait);
        HomePage homePage=new HomePage(driver,wait);
        Flows flows=new Flows(driver,wait);
        CheckoutPage checkoutPage=new CheckoutPage(driver,wait);

        switch (appName){
            case Constants.TAMIMI:

                cartPageTamimi.selectSubstitutionMethod();
                cartPage.clickOnCheckoutBtn(appName);
                checkoutPage.selectCashOnDeliveryForPayment(appName);
                checkoutPage.placeOrder(appName);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + appName);
        }
    }

    public void checkSearch(String appName){
        HomePage homePage=new HomePage(driver,wait);
        switch (appName){
            case Constants.TAMIMI:
                homePage.enterTextInSearchBar(appName, Constants.EGGPLANT_STRING);
                break;
            case Constants.BRIMBARY:
                driver.navigate().back();
                homePage.enterTextInSearchBar(appName, Constants.TSHIRT_STRING);
                break;
        }
    }

}
