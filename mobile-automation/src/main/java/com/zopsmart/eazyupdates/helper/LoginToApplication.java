package com.zopsmart.eazyupdates.helper;

import com.zopsmart.eazyupdates.pages.LoginPage;
import io.appium.java_client.AppiumDriver;


public class LoginToApplication {
    public static void login(AppiumDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickGoogleSignInButton();
        loginPage.clickEmailSignInButton();
        loginPage.clickLocationRadioButton();
    }
}
