package com.zs.locators;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

/**
 * Locator class for the Ekam application.
 * Provides easy access to element locators grouped by page or feature.
 */
public class EkamLocators {

    // ****************** Locator Maps ******************
    /**
     * Locators for the Login page.
     */
    public static final Map<String, By> loginLocators = new HashMap<>();
    /**
     * Locators for the Home page.
     */
    public static final Map<String,By> homePageLocators=new HashMap<>();
    /**
     * Locators for the Profile page.
     */
    public static final Map<String,By> profileLocators=new HashMap<>();
    /**
     * Locators for the Product page.
     */
    public static final Map<String, By> productPageLocators=new HashMap<>();
    /**
     * Locators for the Bottom menu.
     */
    public static final Map<String, By> menuLocators=new HashMap<>();
    /**
     * Locators for the Cart page.
     */
    public static final Map<String, By> cartLocators=new HashMap<>();

    // ****************** Static Initializer ******************
    static {

        //login page locators
        loginLocators.put("profileIcon", By.id("com.zopping.ekam:id/iv_profile_pic"));
        loginLocators.put("enterEmailOrPhoneTextBox", By.id("com.zopping.ekam:id/et_email"));
        loginLocators.put("enterPassTextBox", By.id("com.zopping.ekam:id/et_password_gift"));
        loginLocators.put("loginBtn", By.id("com.zopping.ekam:id/btn_sign_in"));

        //home page locators
        homePageLocators.put("headerLogo", By.id("com.zopsmart.scarlet:id/logo"));
        homePageLocators.put("productCategory1", By.xpath("(//android.widget.ImageView[@resource-id='com.zopping.ekam:id/iv_item_image'])[2]"));

        //profile page locators
        profileLocators.put("username", By.id("com.zopping.ekam:id/tv_username"));
        profileLocators.put("backBtn", By.id("com.zopping.ekam:id/navigation_icon"));

        //product page locators
        productPageLocators.put("product", By.xpath("(//android.view.ViewGroup[@resource-id='com.zopping.ekam:id/linearLayout'])[1]"));
        productPageLocators.put("productLabel", By.id("com.zopping.ekam:id/tv_item_name"));
        productPageLocators.put("addToCartBtn", By.id("com.zopping.ekam:id/add_to_cart_cl"));

        //bottom menu locators
        menuLocators.put("cartBtn", By.xpath("//android.widget.FrameLayout[@content-desc='Cart']/android.widget.FrameLayout[37]"));
        menuLocators.put("homeBtn", By.id("com.zopping.ekam:id/home"));
    }


    // ****************** Locator Retrieval Methods ******************

    /**
     * Gets a locator from the Login locators map.
     *
     * @param locatorName the name of the locator
     * @return the By locator
     */
    public static By getLoginLocator(String locatorName) {
        return loginLocators.get(locatorName);
    }
    /**
     * Gets a locator from the Home page locators map.
     *
     * @param locatorName the name of the locator
     * @return the By locator
     */
    public static By getHomePageLocator(String locatorName) {
        return homePageLocators.get(locatorName);
    }
    /**
     * Gets a locator from the Profile locators map.
     *
     * @param locatorName the name of the locator
     * @return the By locator
     */
    public static By getProfileLocators(String locatorName){
        return profileLocators.get(locatorName);
    }
    /**
     * Gets a locator from the Product Page locators map.
     *
     * @param locatorName the name of the locator
     * @return the By locator
     */
    public static By getProductPageLocators(String locatorName){
        return productPageLocators.get(locatorName);
    }
    /**
     * Gets a locator from the Menu locators map.
     *
     * @param locatorName the name of the locator
     * @return the By locator
     */
    public static By getMenuLocators(String locatorName){
        return menuLocators.get(locatorName);
    }
    /**
     * Gets a locator from the Cart locators map.
     *
     * @param locatorName the name of the locator
     * @return the By locator
     */
    public static By getCartLocators(String locatorName){
        return cartLocators.get(locatorName);
    }
}

