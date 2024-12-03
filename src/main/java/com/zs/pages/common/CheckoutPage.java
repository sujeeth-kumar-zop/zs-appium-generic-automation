package com.zs.pages.common;

import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.AppiumBy;
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

    /**
     * Selects debit card as payment method.
     * @param appName The name of the application under test.
     */
    public void selectDebitCardForPayment(String appName){
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCheckoutLocators(appName, "debitCardRadio"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCheckoutLocators(appName, "debitCard1"))).click();
        LoggerUtil.logInfo("Selected Payment method as Debit Card");
    }

    public void selectCashOnDeliveryForPayment(String appName){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Cash on collection\").instance(0))")).click();
        LoggerUtil.logInfo("Selected ayment method: Cash on Delivery");
    }

    /**
     * Clicks on the place order button
     * @param appName The name of the application under test.
     */
    public void placeOrder(String appName){
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCheckoutLocators(appName, "placeOrderBtn"))).click();
        LoggerUtil.logInfo("Clicked on the Place Order Button");
    }

    /**
     * Checks if the order has been placed.
     * @param appName The name of the application under test.
     * @return A boolean value if the label of successful order placement is visible.
     */
    public boolean isOrderPlaced(String appName){
        WebElement orderPlacedLabel = wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCheckoutLocators(appName,"orderPlacedLabel")));
        return orderPlacedLabel.isDisplayed();
    }
}
