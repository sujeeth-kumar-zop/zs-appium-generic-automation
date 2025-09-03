package com.zopsmart.eazyupdates.UITesting.tests;


import com.zopsmart.eazyupdates.base.Base;
import com.zopsmart.eazyupdates.pages.DashboardPage;
import com.zopsmart.eazyupdates.pages.DirectReporteeTimelinePage;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Feature("Direct reportee timeline Navigation")
public class DirectReporteeTimeline extends Base {

    /**
     * *Test to validate that logged-in user can navigate to the Direct Reportees timeline
     * from the dashboard screen
     * Preconditions:
     * User must be logged in (handled in com.zopsmart.eazyupdates.base.Base @BeforeMethod)
     */
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Subordinate timeline")
    @Description("Ensures that a user can successfully log in using Google credentials, and navigate to the Direct reportee Timeline")
    public void directReporteesTimeLineNavigation() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        DirectReporteeTimelinePage directReporteeTimelinePage = new DirectReporteeTimelinePage(getDriver());
        dashboardPage.clickOnDirectReporteeButton();
        directReporteeTimelinePage.validateWeekendText();

    }
}
