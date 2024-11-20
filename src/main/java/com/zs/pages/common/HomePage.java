package com.zs.pages.common;

import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private static final Logger logger=LoggerUtil.getLogger();
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public HomePage(AndroidDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }

    public void clickOnDrawer(String appName) {
        By drawerIconLoc = CommonUtils.getHomePageLocator(appName, "drawerIcon");
        WebElement drawerIcon = wait.until(ExpectedConditions.elementToBeClickable(drawerIconLoc));
        drawerIcon.click();
        logger.info("Clicked on the drawer for {}", appName);
    }
}
