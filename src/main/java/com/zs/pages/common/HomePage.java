package com.zs.pages.common;

import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents the Home Page of the application.
 * Contains methods to interact with elements on the Home Page.
 */
public class HomePage {

    private static final Logger logger=LoggerUtil.getLogger();
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor to initialize the HomePage object with the driver and wait instance.
     *
     * @param driver the AndroidDriver instance
     * @param wait   the WebDriverWait instance
     */
    public HomePage(AndroidDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }

    /**
     * Clicks on the drawer icon in the Home Page.
     *
     * @param appName the name of the application (used to fetch app-specific locators)
     */
    public void clickOnDrawer(String appName) {
        By drawerIconLoc = CommonUtils.getHomePageLocator(appName, "drawerIcon");
        WebElement drawerIcon = wait.until(ExpectedConditions.elementToBeClickable(drawerIconLoc));
        drawerIcon.click();
        logger.info("Clicked on the drawer for {}", appName);
    }


    public void enterTextInSearchBar(String appName, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getHomePageLocator(appName,"searchIcon"))).click();
        logger.info("Clicked on Search Icon");
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getHomePageLocator(appName, "searchBar"))).sendKeys(text);
        logger.info("Entered text in Search Box");
    }

    public boolean isTextVisible(String text){
        WebElement label=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='"+text+"']")));
        return label.isDisplayed();
    }

    public String fetchRandomProduct(String appName){
        List<WebElement> productsList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(CommonUtils.getHomePageLocator(appName,"productsInSearch")));
        int productCount = productsList.size();
        int randomNumber= ThreadLocalRandom.current().nextInt(2, productCount);
        return productsList.get(randomNumber).getText();
    }
}

