package com.zs.locators;

import org.openqa.selenium.By;
import java.util.HashMap;
import java.util.Map;

public class VijethaLocators {

    public static final Map<String, By> loginLocators = new HashMap<>();
    static {
        loginLocators.put("whileUsingAppBtn", By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
        loginLocators.put("profileIcon", By.id("in.vijetha.live:id/iv_my_account_icon"));
        loginLocators.put("logInWithPasswordLinkText", By.id("in.vijetha.live:id/tv_switch_login"));
        loginLocators.put("enterEmailOrPhoneTextBox", By.id("in.vijetha.live:id/email_or_phone_et"));
        loginLocators.put("enterPassTextBox", By.id("in.vijetha.live:id/password_et"));
        loginLocators.put("loginBtn", By.id("in.vijetha.live:id/login_btn"));
    }

    public static By getLoginLocator(String locatorName) {
        return loginLocators.get(locatorName);
    }

    public static final Map<String,By> homePageLocators=new HashMap<>();

    static {
        homePageLocators.put("headerLogo", By.id("com.zopsmart.scarlet:id/logo"));
        homePageLocators.put("allowLocationAccessBtn", By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
    }

    public static By getHomePageLocator(String locatorName) {
        return homePageLocators.get(locatorName);
    }

    public static final Map<String,By> profileLocators=new HashMap<>();

    static{
        profileLocators.put("username", By.id("in.vijetha.live:id/tv_username"));
    }

    public static By getProfileLocators(String locatorName){
        return profileLocators.get(locatorName);
    }
}

