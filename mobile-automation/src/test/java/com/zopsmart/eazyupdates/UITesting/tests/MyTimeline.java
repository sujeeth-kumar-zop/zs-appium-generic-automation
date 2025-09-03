package com.zopsmart.eazyupdates.UITesting.tests;



import com.zopsmart.eazyupdates.base.Base;
import com.zopsmart.eazyupdates.pages.DashboardPage;
import com.zopsmart.eazyupdates.pages.MyTimelinePage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Feature("My Timeline Navigation")
public class MyTimeline extends Base {

    /**
     * Test to validate that logged-in user can navigate to My timeline
     * from the dashboard screen
     * Preconditions
     * User must be logged in (handled in com.zopsmart.eazyupdates.base.Base @BeforeMethod)
     */
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("My timeline")
    @Description("Ensures that a user can successfully log in using Google credentials, and navigate to the My Timeline")
    public void myTimelineNavigation() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        MyTimelinePage timelinePage = new MyTimelinePage(getDriver());
        dashboardPage.clickHamburgerMenu();
        dashboardPage.clickOnMyTimeline();
        timelinePage.getCalendarComponent();
    }
}
