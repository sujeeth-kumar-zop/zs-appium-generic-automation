package com.zs.locators;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class BrimbaryLocators {
    public static final Map<String, By> loginLocators = new HashMap<>();

    static {
        loginLocators.put("drawerIcon", By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']"));
        loginLocators.put("profileIcon", By.xpath("//android.widget.ImageButton[@content-desc='Close navigation drawer']"));
        loginLocators.put("enterEmailOrPhoneTextBox", By.id("com.zopsmart.brimbary:id/et_email"));
        loginLocators.put("enterPassTextBox", By.id("com.zopsmart.brimbary:id/et_password"));
        loginLocators.put("loginBtn", By.id("com.zopsmart.brimbary:id/btn_sign_in"));
    }

    public static By getLoginLocator(String locatorName) {
        return loginLocators.get(locatorName);
    }

    public static final Map<String,By> homePageLocators=new HashMap<>();

    static {
        homePageLocators.put("headerLogo", By.id("com.zopsmart.scarlet:id/logo"));
        homePageLocators.put("drawerIcon", By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']"));
    }

    public static By getHomePageLocator(String locatorName) {
        return homePageLocators.get(locatorName);
    }

    public static final Map<String,By> profileLocators=new HashMap<>();

    static{
        profileLocators.put("username", By.id("com.zopsmart.brimbary:id/tv_username"));
    }

    public static By getProfileLocators(String locatorName){
        return profileLocators.get(locatorName);
    }
}

