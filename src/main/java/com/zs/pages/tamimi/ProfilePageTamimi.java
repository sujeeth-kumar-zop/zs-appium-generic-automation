package com.zs.pages.tamimi;

import com.zs.constants.Constants;
import com.zs.pages.common.ProfilePage;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePageTamimi {

    private static final Logger logger= LoggerUtil.getLogger();
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public ProfilePageTamimi(AndroidDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }

    public void selectSalutation(String salutation) {
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.generateLocator(salutation))).click();
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.generateLocator(salutation))).click();
    }

    public void enterDetails(String fname, String lname, String email){
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProfileLocator(Constants.TAMIMI,"fnameTextBox"))).sendKeys(fname);
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProfileLocator(Constants.TAMIMI,"lnameTextBox"))).sendKeys(lname);
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProfileLocator(Constants.TAMIMI, "emailTextBox"))).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProfileLocator(Constants.TAMIMI, "dob"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.generateLocator(Constants.TAMIMI_DATE_FOR_DOB))).click();
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProfileLocator(Constants.TAMIMI, "okBtn"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProfileLocator(Constants.TAMIMI, "submitBtn"))).click();
    }


}
