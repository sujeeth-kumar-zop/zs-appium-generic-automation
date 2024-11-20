package com.zs.pages.common;

import com.zs.locators.BrimbaryLocators;
import com.zs.locators.EkamLocators;
import com.zs.locators.TamimiLocators;
import com.zs.locators.VijethaLocators;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public static Logger logger=LoggerUtil.getLogger();

    public static void clickOnDrawer(AndroidDriver driver, WebDriverWait wait, String appName) {
        By drawerIconLoc = CommonUtils.getHomePageLocator(appName, "drawerIcon");
        WebElement drawerIcon = wait.until(ExpectedConditions.elementToBeClickable(drawerIconLoc));
        drawerIcon.click();
        logger.info("Clicked on the drawer for {}", appName);
    }
}
