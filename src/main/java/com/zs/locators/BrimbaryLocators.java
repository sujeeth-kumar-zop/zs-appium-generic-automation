package com.zs.locators;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

/**
 * Locators for Brimbary application elements grouped by page or UI component.
 * <p>
 * This class provides a structured way to define and retrieve locators for
 * various elements in the application, such as login, home, profile, product pages, etc.
 * </p>
 */
public class BrimbaryLocators {

    /**
     * Locators for the login screen elements.
     */
    public static final Map<String, By> loginLocators = new HashMap<>();
    /**
     * Locators for the home screen elements.
     */
    public static final Map<String,By> homePageLocators=new HashMap<>();
    /**
     * Locators for the profile screen elements.
     */
    public static final Map<String,By> profileLocators=new HashMap<>();
    /**
     * Locators for the product screen elements.
     */
    public static final Map<String, By> productPageLocators=new HashMap<>();
    /**
     * Locators for the side drawer elements.
     */
    public static final Map<String, By> drawerLocators=new HashMap<>();
    /**
     * Locators for the menu elements.
     */
    public static final Map<String, By> menuLocators=new HashMap<>();
    /**
     * Locators for the cart elements.
     */
    public static final Map<String, By> cartLocators=new HashMap<>();


    static {
        //login locators
        loginLocators.put("drawerIcon", By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']"));
        loginLocators.put("profileIcon", By.xpath("//android.widget.ImageButton[@content-desc='Close navigation drawer']"));
        loginLocators.put("enterEmailOrPhoneTextBox", By.id("com.zopsmart.brimbary:id/et_email"));
        loginLocators.put("enterPassTextBox", By.id("com.zopsmart.brimbary:id/et_password"));
        loginLocators.put("loginBtn", By.id("com.zopsmart.brimbary:id/btn_sign_in"));

        //home page locators
        homePageLocators.put("headerLogo", By.id("com.zopsmart.scarlet:id/logo"));
        homePageLocators.put("drawerIcon", By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']"));
        homePageLocators.put("product", By.xpath("(//android.widget.ImageView[@resource-id='com.zopsmart.brimbary:id/iv_item'])[1]"));
        homePageLocators.put("productsInSearch", By.xpath("//android.widget.GridView[@resource-id='com.zopsmart.brimbary:id/rv_search_items']/android.view.ViewGroup"));
        homePageLocators.put("searchIcon", By.id("com.zopsmart.brimbary:id/search_icon_trendsetter"));
        homePageLocators.put("searchBar", By.id("com.zopsmart.brimbary:id/et_search_gift"));


        //profile locators
        profileLocators.put("username", By.id("com.zopsmart.brimbary:id/tv_username"));

        //product page locators
        productPageLocators.put("addToCartBtn", By.id("com.zopsmart.brimbary:id/add_to_cart_btn"));
        productPageLocators.put("productLabel", By.id("com.zopsmart.brimbary:id/product_name_tv"));

        //drawer locators
        drawerLocators.put("username", By.id("com.zopsmart.brimbary:id/tv_sign_in"));

        //menu locators
        menuLocators.put("cartBtn", By.id("com.zopsmart.brimbary:id/cart_icon_trendsetter"));

        //cart locators
        cartLocators.put("checkOutBtn", By.id("com.zopsmart.brimbary:id/checkout_btn_for_trendsetter"));
        cartLocators.put("increaseQuantityBtn", By.xpath("(//android.widget.ImageView[@resource-id='com.zopsmart.brimbary:id/ib_add'])[1]"));
        cartLocators.put("quantityItem1", By.id("com.zopsmart.brimbary:id/tv_quantity"));
    }

    /**
     * Retrieves a locator for a given element on the login screen.
     *
     * @param locatorName the name of the locator to retrieve.
     * @return the {@link By} locator for the specified element.
     */
    public static By getLoginLocator(String locatorName) {
        return loginLocators.get(locatorName);
    }
    /**
     * Retrieves a locator for a given element on the home screen.
     *
     * @param locatorName the name of the locator to retrieve.
     * @return the {@link By} locator for the specified element.
     */
    public static By getHomePageLocator(String locatorName) {
        return homePageLocators.get(locatorName);

    }
    /**
     * Retrieves a locator for a given element on the profile page.
     *
     * @param locatorName the name of the locator to retrieve.
     * @return the {@link By} locator for the specified element.
     */
    public static By getProfileLocators(String locatorName){
        return profileLocators.get(locatorName);
    }
    /**
     * Retrieves a locator for a given element on the product screen.
     *
     * @param locatorName the name of the locator to retrieve.
     * @return the {@link By} locator for the specified element.
     */
    public static By getProductPageLocators(String locatorName){
        return productPageLocators.get(locatorName);
    }
    /**
     * Retrieves a locator for a given element on the side drawer.
     *
     * @param locatorName the name of the locator to retrieve.
     * @return the {@link By} locator for the specified element.
     */
    public static By getDrawerLocators(String locatorName){
        return drawerLocators.get(locatorName);
    }
    /**
     * Retrieves a locator for a given element on the menu.
     *
     * @param locatorName the name of the locator to retrieve.
     * @return the {@link By} locator for the specified element.
     */
    public static By getMenuLocators(String locatorName){
        return menuLocators.get(locatorName);
    }
    /**
     * Retrieves a locator for a given element on the menu.
     *
     * @param locatorName the name of the locator to retrieve.
     * @return the {@link By} locator for the specified element.
     */
    public static By getCartLocators(String locatorName){
        return cartLocators.get(locatorName);
    }
}
