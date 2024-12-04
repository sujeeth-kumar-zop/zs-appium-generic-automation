package com.zs.pages.common;

import com.zs.constants.Constants;
import com.zs.locators.BrimbaryLocators;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents the Products Browsing Page of an Application.
 * Contains all methods that are required to perform an action on the products page.
 */
public class ProductsPage {

    private static Logger logger= LoggerUtil.getLogger();
    private final AndroidDriver driver;
    private  final WebDriverWait wait;

    public ProductsPage(AndroidDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }

    /**
     * Clicks on add to cart button.
     * @param appName The name of the application under test.
     */
    public void addToCartBtn(String appName){
        if(Constants.BRIMBARY.equals(appName))
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Add to Cart\").instance(0))")).click();
        else
            wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProductPageLocator(appName,"addToCartBtn"))).click();
        LoggerUtil.logInfo("Clicked on Add to Cart Button for "+ appName);
    }

    /**
     * Navigates to Cart.
     * @param appName The name of the application under test.
     */
    public void goToCart(String appName){
        WebElement cart= switch(appName){
            case Constants.TAMIMI, Constants.EKAM, Constants.BRIMBARY -> wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getMenuLocators(appName,"cartBtn")));
            case Constants.VIJETHA -> wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProductPageLocator(appName,"cartBtn")));
            default -> throw new IllegalStateException("Unexpected value: " + appName);
        };
        cart.click();
        LoggerUtil.logInfo("Clicked on Cart Icon for "+ appName);
    }

    /**
     * Clicks on a product.
     * @param appName The name of the application under test.
     */
    public void openProduct(String appName){
        WebElement prod= switch (appName){
            case Constants.TAMIMI, Constants.EKAM, Constants.VIJETHA -> wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProductPageLocator(appName,"product")));
            case Constants.BRIMBARY -> wait.until(ExpectedConditions.elementToBeClickable(BrimbaryLocators.getHomePageLocator("product")));
            default -> throw new IllegalStateException("Unexpected value: " + appName);
        };
        prod.click();
        LoggerUtil.logInfo("Clicked on a Product for "+appName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommonUtils.getProductPageLocator(appName,"productLabel")));
        LoggerUtil.logInfo("Retrieved the added product's name for "+appName);
    }

    /**
     * Clicks on a product category (Example: Dairy, Fruits and Vegetables, Meat etc)
     * @param appName The name of the application under test.
     */
    public void clickProductCategory(String appName){
        WebElement btn= wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getHomePageLocator(appName,"productCategory1")));
        btn.click();
        LoggerUtil.logInfo("Clicked on a product category for "+appName);
    }
}
