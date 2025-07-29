package com.zopsmart.eazyupdates.appium;

import com.zopsmart.eazyupdates.pages.LoginPage;
import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

@Epic("User Session Management")
@Feature("Login & Logout Flow")
public class UserSession extends Base {
    WebDriverWait wait;
    public LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
    }

    @Test(description = "User logs in using Google sign-in", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login with valid credentials")
    @Description("Verify user is able to login using Google sign-in and select a profile if radio button is present")
    public void loginAction() throws InterruptedException {
        System.out.println(System.getProperty("platform"));
        loginPage.clickGoogleSignInButton();
        loginPage.clickEmailSignInButton();
        Thread.sleep(2000);
        loginPage.clickLocationRadioButton();
    }

    @Test(description = "User logs out", dependsOnMethods = "loginAction", priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Story("Logout functionality")
    @Description("Verify user is able to logout successfully from the hamburger menu")
    public void logoutAction() {
        loginPage.clickHamburgerMenu();
        loginPage.clickLogoutButton();
        loginPage.clickLogoutAlertButton();
    }
}

