package com.zs.pages.common;

import com.zs.constants.Constants;
import com.zs.locators.BrimbaryLocators;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    private static Logger logger= LoggerUtil.getLogger();
    private final AndroidDriver driver;
    private  final WebDriverWait wait;

    public ProductsPage(AndroidDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }

    public void addToCartBtn(String appName){
        WebElement btn=wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProductPageLocator(appName,"addToCartBtn")));
        btn.click();
        logger.info("Clicked on Add to Cart Button for {}", appName);
    }

    public void goToCart(String appName){
        WebElement cart= switch(appName){
            case Constants.TAMIMI, Constants.EKAM, Constants.BRIMBARY -> wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getMenuLocators(appName,"cartBtn")));
            case Constants.VIJETHA -> wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProductPageLocator(appName,"cartBtn")));
            default -> throw new IllegalStateException("Unexpected value: " + appName);
        };
        cart.click();
        logger.info("Clicked on Cart Icon for {}", appName);
    }

    public void openProduct(String appName){
        WebElement prod= switch (appName){
            case Constants.TAMIMI, Constants.EKAM, Constants.VIJETHA -> wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProductPageLocator(appName,"product")));
            case Constants.BRIMBARY -> wait.until(ExpectedConditions.elementToBeClickable(BrimbaryLocators.getHomePageLocator("product")));
            default -> throw new IllegalStateException("Unexpected value: " + appName);
        };
        prod.click();
        logger.info("Clicked on a Product for {}", appName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CommonUtils.getProductPageLocator(appName,"productLabel")));
        logger.info("Retrieved the added product's name for {}", appName);
    }

    public void clickProductCategory(String appName){
        WebElement btn= wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getHomePageLocator(appName,"productCategory1")));
        btn.click();
        logger.info("Clicked on a product category for {}", appName);
    }
}
