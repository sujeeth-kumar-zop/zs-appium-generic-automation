package com.zs.constants;

/**
 * A utility class to define application-wide constants.
 * These constants include app names and common resource paths used across the project.
 */
public class Constants {

    // ****************** Application Names ******************
    /**
     * Constant for the Tamimi application.
     */
    public static final String TAMIMI = "Tamimi";
    /**
     * Constant for the Vijetha application.
     */
    public static final String VIJETHA = "Vijetha";
    /**
     * Constant for the Brimbary application.
     */
    public static final String BRIMBARY = "Brimbary";
    /**
     * Constant for the Ekam application.
     */
    public static final String EKAM = "Ekam";


    // ****************** Resource Paths ******************
    /**
     * Path to the login details Excel file containing credentials.
     */
    public static final String LOGIN_DETAILS_PATH = "src/main/resources/login_details.xlsx";

    /**
     * Remote host and port
     */
    // ****************** URLs *******************
    public static final String APPIUM_URL ="http://127.0.0.1:4723";

    public static final String TSHIRT_STRING="Shirt";

    //Tamimi Constants
    public static final String EGGPLANT_STRING="Eggplant";
    public static final String TAMIMI_SALUTATION="Mr";
    public static final String TAMIMI_FNAME="Ahmed";
    public static final String TAMIMI_LNAME="Khan";
    public static final String TAMIMI_EMAIL="ahmed@gmail.com";
    public static final String TAMIMI_DATE_FOR_DOB="12";
    public static final String TAMIMI_SIGNUP = "Sign In / Sign Up";
    public static final String TAMIMI_INVALID_PNO="1234";
    public static final String TAMIMI_INVALID_PASS="1234";
    public static final String TAMIMI_BRAND_KSA="KSA";
    public static final String TAMIMI_WATER= "water";
    public static final String TAMIMI_PRODUCT_LIMIT_WARNING="You cannot add more items of this product";
    public static final String TAMIMI_EMPTY_CART="Your cart is empty";
    public static final String TAMIMI_WATER_PRODUCT = "Bottled Drinking Water-40×330ML";

    //general texts
    public static final String LOGOUT="Logout";
    public static final String INVALID_CREDS="invalid credentials";
    public static final String BRAND="Brand";
    public static final String ORDERS="My Orders";
    public static final String CANCEL="Cancel";
    public static final String INVALID_CREDS="invalid credentials";

    //general locators
    public static final String PARENT_LOC = "/./..";
    public static final String FOURTH_CHILD="/*[4]";
    public static final String EIGHTH_CHILD="/*[8]";
}

