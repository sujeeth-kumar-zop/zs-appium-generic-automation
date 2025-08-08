package com.zopsmart.eazyupdates.UITesting.tests;


import com.zopsmart.eazyupdates.UITesting.Base;
import com.zopsmart.eazyupdates.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("User Session Management")
@Feature("Login & Logout Flow")
public class UserSession extends Base {
    public LoginPage loginPage;

    @BeforeMethod
    public void initPageObjects() {
        loginPage = new LoginPage(getDriver());
    }

    @Test(description = "User logs in using Google sign-in")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login with valid credentials")
    @Description("Verify user is able to login using Google sign-in and select a profile if radio button is present")
    public void loginAction() {
        loginPage.assertUserIsLoggedIn();
    }

    @Test(description = "User logs out", dependsOnMethods = "loginAction")
    @Severity(SeverityLevel.NORMAL)
    @Story("Logout functionality")
    @Description("Verify user is able to logout successfully from the hamburger menu")
    public void logoutAction() {
        loginPage = new LoginPage(getDriver());
        loginPage.clickHamburgerMenu();
        loginPage.clickLogoutButton();
        loginPage.clickLogoutAlertButton();
    }
}

