package com.zs.pages.common;

import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private static final Logger logger= LoggerUtil.getLogger();
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor for Checkout Page
     *
     * @param driver AndroidDriver instance to interact with the app.
     * @param wait WebDriverWait instance to wait for elements.
     */
    public CheckoutPage(AndroidDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }

    public void selectDebitCardForPayment(String appName){
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCheckoutLocators(appName, "debitCardRadio"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCheckoutLocators(appName, "debitCard1"))).click();
    }

    public void placeOrder(String appName){
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCheckoutLocators(appName, "placeOrderBtn"))).click();
    }

    public boolean isOrderPlaced(String appName){
        WebElement orderPlacedLabel = wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCheckoutLocators(appName,"orderPlacedLabel")));
        return orderPlacedLabel.isDisplayed();
    }
}
