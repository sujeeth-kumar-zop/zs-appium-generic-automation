package com.zs.pages.tamimi;

import com.zs.constants.Constants;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPageTamimi {
    private static final Logger logger= LoggerUtil.getLogger();
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor for CartPageTamimi
     *
     * @param driver AndroidDriver instance to interact with the app.
     * @param wait WebDriverWait instance to wait for elements.
     */
    public CartPageTamimi(AndroidDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }

    public void selectSubstitutionMethod(){
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCartLocators(Constants.TAMIMI, "substitutionDropDown"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getCartLocators(Constants.TAMIMI, "substitutionOption1"))).click();
    }
}
