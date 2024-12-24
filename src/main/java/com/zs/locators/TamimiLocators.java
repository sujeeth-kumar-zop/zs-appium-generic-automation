package com.zs.locators;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;
/**
 * The TamimiLocators class contains static mappings of locators used in the Tamimi application.
 * These locators are organized by the page or functionality they belong to, such as login page, home page, profile, product page, and others.
 * This class also provides methods to retrieve locators for different pages of the Tamimi app based on a given locator name.
 */
public class TamimiLocators {

    public static final Map<String, By> loginLocators = new HashMap<>();
    public static final Map<String,By> homePageLocators=new HashMap<>();
    public static final Map<String, By> drawerLocators=new HashMap<>();
    public static final Map<String, By> stagingUrlLocators=new HashMap<>();
    public static final Map<String,By> profileLocators=new HashMap<>();
    public static final Map<String,By> productPageLocators =new HashMap<>();
    public static final Map<String, By> menuLocators=new HashMap<>();
    public static final Map<String, By> cartLocators= new HashMap<>();
    public static final Map<String, By> deliveryTypeDrawerLocators=new HashMap<>();
    public static final Map<String, By> checkoutLocators=new HashMap<>();

    static {


        //login page locators
        loginLocators.put("profileIcon", By.id("com.zopsmart.stg.scarlet:id/account"));
        loginLocators.put("enterEmailOrPhoneTextBox", By.id("com.zopsmart.stg.scarlet:id/et_username"));
        loginLocators.put("enterPassTextBox", By.id("com.zopsmart.stg.scarlet:id/et_password"));
        loginLocators.put("loginBtn", By.id("com.zopsmart.stg.scarlet:id/button3"));


        //home page locators
        homePageLocators.put("headerLogo", By.id("com.zopsmart.stg.scarlet:id/logo"));
        homePageLocators.put("drawerIcon", By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']"));
        homePageLocators.put("productCategory1", By.xpath("(//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/iv_category'])[3]"));
        homePageLocators.put("searchBar", By.id("com.zopsmart.stg.scarlet:id/et_search"));
        homePageLocators.put("searchIcon", By.id("com.zopsmart.stg.scarlet:id/ic_search"));
        homePageLocators.put("productsInSearch", By.xpath("//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_item_name']"));
        homePageLocators.put("searchPlaceholder", By.xpath("//*[@text='What are you looking for?']"));
        //drawer locators
        drawerLocators.put("versionText", By.xpath("//android.widget.FrameLayout[@content-desc='Cart']/android.widget.FrameLayout[1]"));
        drawerLocators.put("appUrl", By.id("com.zopsmart.scarlet:id/et_store_url"));
        drawerLocators.put("applyBtn", By.id("com.zopsmart.scarlet:id/btn_apply"));
        drawerLocators.put("okBtn", By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
        drawerLocators.put("username", By.id("com.zopsmart.stg.scarlet:id/tv_sign_in"));

        //profile locators
        profileLocators.put("username", By.id("com.zopsmart.stg.scarlet:id/tv_name"));
        profileLocators.put("editBtn", By.id("com.zopsmart.stg.scarlet:id/edit_profile_btn"));
        profileLocators.put("dob", By.id("com.zopsmart.stg.scarlet:id/dobCl"));
        profileLocators.put("fnameTextBox", By.id("com.zopsmart.stg.scarlet:id/firstNameEt"));
        profileLocators.put("lnameTextBox", By.id("com.zopsmart.stg.scarlet:id/lastNameEt"));
        profileLocators.put("emailTextBox", By.id("com.zopsmart.stg.scarlet:id/emailEt"));
        profileLocators.put("submitBtn", By.id("com.zopsmart.stg.scarlet:id/submitBtn"));
        profileLocators.put("okBtn", By.id("android:id/button1"));
        profileLocators.put("editProfileSuccessfulLabel", By.id("android:id/message"));

        //products page locators
        productPageLocators.put("product", By.id("com.zopsmart.stg.scarlet:id/tv_item_name"));
        productPageLocators.put("productLabel", By.id("com.zopsmart.stg.scarlet:id/tv_item_name"));
        productPageLocators.put("addToCartBtn", By.xpath("(//android.widget.ImageView[@resource-id='com.zopsmart.stg.scarlet:id/ib_add'])[1]"));
        productPageLocators.put("filterBtn", By.id("com.zopsmart.stg.scarlet:id/btn_filter"));
        productPageLocators.put("applyBtn", By.id("com.zopsmart.stg.scarlet:id/btn_apply"));

        //bottom menu locators
        menuLocators.put("cartBtn", By.xpath("//android.widget.FrameLayout[@content-desc='Cart']/android.widget.FrameLayout[4]"));
        menuLocators.put("homeBtn", By.id("com.zopsmart.stg.scarlet:id/home"));

        //cart locators
        cartLocators.put("productInCartLabel", By.id("com.zopsmart.stg.scarlet:id/tv_item_name"));
        cartLocators.put("checkOutBtn", By.id("com.zopsmart.stg.scarlet:id/button_checkout"));
        cartLocators.put("quantityItem1", By.xpath("(//android.widget.TextView[@resource-id='com.zopsmart.stg.scarlet:id/tv_quantity'])[1]"));
        cartLocators.put("quantityTextBox", By.id("com.zopsmart.stg.scarlet:id/et_value"));
        cartLocators.put("submitQuantity", By.id("com.zopsmart.stg.scarlet:id/btn_YES"));
        cartLocators.put("continueQuantityBox", By.id("android:id/button1"));
        cartLocators.put("substitutionDropDown", By.id("com.zopsmart.stg.scarlet:id/select_substitution_spinner"));
        cartLocators.put("substitutionOption1", By.xpath("//*[@text='Call for substitution']"));

        //delivery-type drawer locators
        deliveryTypeDrawerLocators.put("clickAndCollect", By.id("com.zopsmart.stg.scarlet:id/cv_click_and_collect"));
        deliveryTypeDrawerLocators.put("city", By.xpath("(//android.widget.FrameLayout[@resource-id='com.zopsmart.stg.scarlet:id/cv_city'])[1]"));
        deliveryTypeDrawerLocators.put("store", By.id("com.zopsmart.stg.scarlet:id/epoxy_stores") );

        //checkout locators
        checkoutLocators.put("debitCardRadio", By.id("com.zopsmart.stg.scarlet:id/radio_debit_card"));
        checkoutLocators.put("debitCard1", By.id("com.zopsmart.stg.scarlet:id/constraint_layout_card"));
        checkoutLocators.put("cashOnDeliveryRadio", By.id("com.zopsmart.stg.scarlet:id/radio_cash_on_delivery"));
        checkoutLocators.put("placeOrderBtn", By.id("com.zopsmart.stg.scarlet:id/btn_place_order"));
        checkoutLocators.put("orderPlacedLabel", By.id("com.zopsmart.stg.scarlet:id/order_placed_label"));
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
     * Retrieves the drawer locator by its name.
     *
     * @param locatorName The name of the locator to fetch.
     * @return The locator corresponding to the provided name.
     */
    public static By getDrawerLocators(String locatorName){
        return drawerLocators.get(locatorName);
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
     * Retrieves the menu locator by its name.
     *
     * @param locatorName The name of the locator to fetch.
     * @return The locator corresponding to the provided name.
     */
    public static By getMenuLocators(String locatorName){
        return menuLocators.get(locatorName);
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
     * Retrieves the delivery type drawer locator by its name.
     *
     * @param locatorName The name of the locator to fetch.
     * @return The locator corresponding to the provided name.
     */
    public static By getDeliveryTypeDrawerLocators(String locatorName){
        return deliveryTypeDrawerLocators.get(locatorName);
    }
    /**
     * Retrieves the checkout page's locator by its name.
     *
     * @param locatorName The name of the locator to fetch.
     * @return The locator corresponding to the provided name.
     */
    public static By getCheckoutLocators(String locatorName){
        return checkoutLocators.get(locatorName);
    }

}

