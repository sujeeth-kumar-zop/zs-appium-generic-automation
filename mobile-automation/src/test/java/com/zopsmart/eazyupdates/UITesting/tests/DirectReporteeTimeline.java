package com.zopsmart.eazyupdates.UITesting.tests;


import com.zopsmart.eazyupdates.base.Base;
import com.zopsmart.eazyupdates.pages.DashboardPage;
import com.zopsmart.eazyupdates.pages.DirectReporteeTimelinePage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Feature("Direct reportee timeline Navigation")
public class DirectReporteeTimeline extends Base {
    DashboardPage dashboardPage;
    DirectReporteeTimelinePage directReporteeTimelinePage;

    @BeforeMethod
    public void initPageObjects() {
        dashboardPage = new DashboardPage(getDriver());
        directReporteeTimelinePage = new DirectReporteeTimelinePage(getDriver());
    }

    /**
     * *Test to validate that logged-in user can navigate to the Direct Reportees timeline
     * from the dashboard screen
     * Preconditions:
     * User must be logged in (handled in Base @BeforeMethod)
     */
    @Test(description = "Verify login via Google and access to Direct reportee Timeline section")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Subordinate timeline")
    @Description("Ensures that a user can successfully log in using Google credentials, and navigate to the Direct reportee Timeline")
    public void directReporteesTimeLineNavigation() {
        dashboardPage.clickOnDirectReporteeButton();
        directReporteeTimelinePage.validateWeekendText();

    }
}
