package com.zopsmart.eazyupdates.UITesting.tests;

import com.zopsmart.eazyupdates.base.Base;
import com.zopsmart.eazyupdates.pages.DashboardPage;
import com.zopsmart.eazyupdates.pages.DirectReporteeTimeline;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Direct reportee timeline Navigation")
public class TimeLine extends Base {
    DashboardPage dashboardPage;
    DirectReporteeTimeline directReporteeTimeline;

    @BeforeMethod
    public void initPageObjects() {
        dashboardPage = new DashboardPage(getDriver());
        directReporteeTimeline = new DirectReporteeTimeline(getDriver());
    }

    /**
     * *Test to validate that logged-in user can navigate to the Direct Reportees timeline
     * from the dashboard screen
     * Preconditions:
     * User must be logged in (handled in Base @BeforeMethod)
     */
    @Test(description = "Verify login via Google and access to Direct reportee Timeline section")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensures that a user can successfully log in using Google credentials, and navigate to the Direct reportee Timeline Timeline")
    public void directReporteesTimeLineNavigation() {
        dashboardPage.clickOnDirectReporteeButton();
        directReporteeTimeline.validateWeekendText();

    }
}
