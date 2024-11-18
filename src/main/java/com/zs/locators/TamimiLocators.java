package com.zs.locators;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class TamimiLocators {

    public static final Map<String, By> loginLocators = new HashMap<>();

    static {
        loginLocators.put("profileIcon", By.id("com.zopsmart.stg.scarlet:id/account"));
        loginLocators.put("enterEmailOrPhoneTextBox", By.id("com.zopsmart.stg.scarlet:id/et_username"));
        loginLocators.put("enterPassTextBox", By.id("com.zopsmart.stg.scarlet:id/et_password"));
        loginLocators.put("loginBtn", By.id("com.zopsmart.stg.scarlet:id/button3"));
    }
    public static By getLoginLocator(String locatorName) {
        return loginLocators.get(locatorName);
    }

    public static final Map<String,By> homePageLocators=new HashMap<>();
    static {
        homePageLocators.put("headerLogo", By.id("com.zopsmart.stg.scarlet:id/logo"));
        homePageLocators.put("drawerIcon", By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']"));
    }
    public static By getHomePageLocator(String locatorName) {
        return homePageLocators.get(locatorName);
    }

    public static final Map<String, By> drawerLocators=new HashMap<>();
    static {
        drawerLocators.put("versionText", By.xpath("//android.widget.FrameLayout[@content-desc='Cart']/android.widget.FrameLayout[1]"));
    }
    public static By getDrawerLocators(String locatorName){
        return drawerLocators.get(locatorName);
    }

    public static final Map<String, By> stagingUrlLocators=new HashMap<>();
    static {
        drawerLocators.put("appUrl", By.id("com.zopsmart.scarlet:id/et_store_url"));
        drawerLocators.put("applyBtn", By.id("com.zopsmart.scarlet:id/btn_apply"));
        drawerLocators.put("okBtn", By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
    }
    public static By getStagingUrlLocators(String locatorName){
        return stagingUrlLocators.get(locatorName);
    }

    public static final Map<String,By> profileLocators=new HashMap<>();

    static{
        profileLocators.put("username", By.id("com.zopsmart.stg.scarlet:id/tv_name"));
    }

    public static By getProfileLocators(String locatorName){
        return profileLocators.get(locatorName);
    }
}

