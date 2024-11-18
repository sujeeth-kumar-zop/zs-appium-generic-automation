package com.zs.locators;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;


public class EkamLocators {

    public static final Map<String, By> loginLocators = new HashMap<>();
    static {
        loginLocators.put("profileIcon", By.id("com.zopping.ekam:id/iv_profile_pic"));
        loginLocators.put("enterEmailOrPhoneTextBox", By.id("com.zopping.ekam:id/et_email"));
        loginLocators.put("enterPassTextBox", By.id("com.zopping.ekam:id/et_password_gift"));
        loginLocators.put("loginBtn", By.id("com.zopping.ekam:id/btn_sign_in"));
    }
    public static By getLoginLocator(String locatorName) {
        return loginLocators.get(locatorName);
    }

    public static final Map<String,By> homePageLocators=new HashMap<>();

    static {
        homePageLocators.put("headerLogo", By.id("com.zopsmart.scarlet:id/logo"));
    }

    public static By getHomePageLocator(String locatorName) {
        return homePageLocators.get(locatorName);
    }

    public static final Map<String,By> profileLocators=new HashMap<>();

    static{
        profileLocators.put("username", By.id("com.zopping.ekam:id/tv_username"));
    }

    public static By getProfileLocators(String locatorName){
        return profileLocators.get(locatorName);
    }
}

