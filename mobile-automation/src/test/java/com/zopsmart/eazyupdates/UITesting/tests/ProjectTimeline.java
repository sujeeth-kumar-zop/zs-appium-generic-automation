package com.zopsmart.eazyupdates.UITesting.tests;

import com.zopsmart.eazyupdates.UITesting.Base;
import com.zopsmart.eazyupdates.helper.LoginToApplication;
import com.zopsmart.eazyupdates.pages.DashboardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProjectTimeline extends Base {
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void initPageObjects() {
        dashboardPage = new DashboardPage(getDriver());
    }
/**
 * Test to validate that a logged-in user can navigate to the Project Timeline section
 * from the dashboard screen and see team members listed.
 * Preconditions:
 * - User must be logged in (handled in Base @BeforeMethod)
 */
    @Test(description = "Verify login via Google and access to Project Timeline section")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensures that a user can successfully log in using Google credentials, and navigate to the Project Timeline section from the dashboard.")
    public void projectTimeLineNavigation() {
        dashboardPage.clickOnProjectNavigationButton();
        dashboardPage.assertTeamMembersVisible();
    }
}
