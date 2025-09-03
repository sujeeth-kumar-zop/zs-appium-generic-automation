package com.zopsmart.eazyupdates.UITesting.tests;

import com.zopsmart.eazyupdates.base.Base;
import com.zopsmart.eazyupdates.pages.DashboardPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("User Session Management")
@Feature("Login & Logout Flow")
public class UserSession extends Base {
    private DashboardPage dashboardPage;

    private DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(getDriver());
        }
        return dashboardPage;
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login with valid credentials")
    @Description("Verify user is able to login using Google sign-in and select a profile if radio button is present")
    public void loginAction() {
        getDashboardPage().verifyUserIsLoggedIn();
    }

    @Test(dependsOnMethods = "loginAction")
    @Severity(SeverityLevel.NORMAL)
    @Story("Logout functionality")
    @Description("Verify user is able to logout successfully from the hamburger menu")
    public void logoutAction() {

        getDashboardPage().clickHamburgerMenu();
        getDashboardPage().clickLogoutButton();
        getDashboardPage().clickLogoutAlertButton();
    }
}