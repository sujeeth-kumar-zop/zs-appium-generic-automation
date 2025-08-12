package com.zopsmart.eazyupdates.UITesting.tests;


import com.zopsmart.eazyupdates.base.Base;
import com.zopsmart.eazyupdates.pages.DashboardPage;
import com.zopsmart.eazyupdates.pages.MyTimelinePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("My Timeline Navigation")
public class MyTimeline extends Base {
    private DashboardPage dashboardPage;
    private MyTimelinePage timelinePage;

    @BeforeMethod
    public void initPageObjects() {
        dashboardPage = new DashboardPage(getDriver());
        timelinePage = new MyTimelinePage(getDriver());
    }

    /**
     * Test to validate that logged-in user can navigate to My timeline
     * from the dashboard screen
     * Preconditions
     * User must be logged in (handled in Base @BeforeMethod)
     */
    @Test(description = "Verify login via Google and access to My Timeline section")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensures that a user can successfully log in using Google credentials, and navigate to the My Timeline")
    public void myTimelineNavigation() {
        dashboardPage.clickHamburgerMenu();
        dashboardPage.clickOnMyTimeline();
        timelinePage.getCalendarComponent();
    }
}
