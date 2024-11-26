package com.zs.pages.common;

import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartPage {
    private static final Logger logger= LoggerUtil.getLogger();
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor for LoginPage
     *
     * @param driver AndroidDriver instance to interact with the app.
     * @param wait WebDriverWait instance to wait for elements.
     */
    public CartPage(AndroidDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }

    public void tapAndIncreaseQuantityOfItem(String appName){
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCartLocators(appName, "quantityItem1"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCartLocators(appName, "quantityTextBox"))).sendKeys("20");
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCartLocators(appName, "submitQuantity"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCartLocators(appName,"continueQuantityBox"))).click();
    }

    public String verifyQuantity(String appName){
        return wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCartLocators(appName,"quantityItem1"))).getText();
    }

}
