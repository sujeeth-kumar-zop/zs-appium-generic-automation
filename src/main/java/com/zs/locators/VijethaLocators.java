package com.zs.locators;

import org.openqa.selenium.By;
import java.util.HashMap;
import java.util.Map;

/**
 * The VijethaLocators class contains static mappings of locators used in the Vijetha application.
 * These locators are organized by the page or functionality they belong to, such as login page, home page, profile, product page, and others.
 * This class also provides methods to retrieve locators for different pages of the Vijetha app based on a given locator name.
 */
public class VijethaLocators {

    // ****************** Locator Maps ******************
    /**
     * Locators for the Login page.
     */
    public static final Map<String, By> loginLocators = new HashMap<>();
    /**
     * Locators for the home page.
     */
    public static final Map<String,By> homePageLocators=new HashMap<>();
    /**
     * Locators for the profile page.
     */
    public static final Map<String,By> profileLocators=new HashMap<>();
    /**
     * Locators for the product page.
     */
    public static final Map<String, By> productPageLocators=new HashMap<>();
    /**
     * Locators for the cart page.
     */
    public static final Map<String, By> cartLocators=new HashMap<>();
    /**
     * Locators for the menu page.
     */
    public static final Map<String, By> menuLocators =new HashMap<>();

    static {
        //login locators
        loginLocators.put("whileUsingAppBtn", By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
        loginLocators.put("profileIcon", By.id("in.vijetha.live:id/iv_my_account_icon"));
        loginLocators.put("logInWithPasswordLinkText", By.id("in.vijetha.live:id/tv_switch_login"));
        loginLocators.put("enterEmailOrPhoneTextBox", By.id("in.vijetha.live:id/email_or_phone_et"));
        loginLocators.put("enterPassTextBox", By.id("in.vijetha.live:id/password_et"));
        loginLocators.put("loginBtn", By.id("in.vijetha.live:id/login_btn"));

        //home page locators
        homePageLocators.put("headerLogo", By.id("com.zopsmart.scarlet:id/logo"));
        homePageLocators.put("allowLocationAccessBtn", By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
        homePageLocators.put("productCategory1", By.xpath("(//android.widget.ImageView[@resource-id='in.vijetha.live:id/iv_item_image'])[1]"));

        //profile locators
        profileLocators.put("username", By.id("in.vijetha.live:id/tv_username"));
        profileLocators.put("backBtn", By.id("in.vijetha.live:id/iv_navigation_icon"));

        //products page locators
        productPageLocators.put("product", By.xpath("(//android.widget.ImageView[@resource-id='in.vijetha.live:id/iv_item_image'])[1]"));
        productPageLocators.put("productLabel", By.id("in.vijetha.live:id/tv_item_name"));
        productPageLocators.put("addToCartBtn", By.xpath("//android.widget.Button[@text='Add']"));
        productPageLocators.put("cartBtn", By.id("in.vijetha.live:id/tv_view_cart"));

        //cart locators
        cartLocators.put("addedProductLabel", By.xpath("//android.widget.TextView[@resource-id='in.vijetha.live:id/tv_item_name' and @text='Tomato Local - Tamatar - 2 kg']"));
    }

    /**
     * Retrieves the login page locator by its name.
     *
     * @param locatorName The name of the locator to fetch.
     * @return The locator corresponding to the provided name.
     */
    public static By getLoginLocator(String locatorName) {
        return loginLocators.get(locatorName);
    }
    /**
     * Retrieves the home page locator by its name.
     *
     * @param locatorName The name of the locator to fetch.
     * @return The locator corresponding to the provided name.
     */
    public static By getHomePageLocator(String locatorName) {
        return homePageLocators.get(locatorName);
    }
    /**
     * Retrieves the profile page locator by its name.
     *
     * @param locatorName The name of the locator to fetch.
     * @return The locator corresponding to the provided name.
     */
    public static By getProfileLocators(String locatorName){
        return profileLocators.get(locatorName);
    }
    /**
     * Retrieves the product page locator by its name.
     *
     * @param locatorName The name of the locator to fetch.
     * @return The locator corresponding to the provided name.
     */
    public static By getProductPageLocators(String locatorName){
        return productPageLocators.get(locatorName);
    }
    /**
     * Retrieves the cart page locator by its name.
     *
     * @param locatorName The name of the locator to fetch.
     * @return The locator corresponding to the provided name.
     */
    public static By getCartLocators(String locatorName){
        return cartLocators.get(locatorName);
    }
    /**
     * Retrieves the menu locator by its name.
     *
     * @param locatorName The name of the locator to fetch.
     * @return The locator corresponding to the provided name.
     */
    public static By getMenuLocators(String locatorName){
        return menuLocators.get(locatorName);
    }
}

