package com.zopsmart.eazyupdates.UITesting.tests;


import com.zopsmart.eazyupdates.base.Base;
import com.zopsmart.eazyupdates.pages.DashboardPage;
import com.zopsmart.eazyupdates.pages.ProjectTimelinePage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("ProjectTimeline Navigation")
public class ProjectTimeline extends Base {
    private DashboardPage dashboardPage;
    private ProjectTimelinePage projectTimelinePage;

    @BeforeMethod
    public void initPageObjects() {

        dashboardPage = new DashboardPage(getDriver());
        projectTimelinePage = new ProjectTimelinePage(getDriver());
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
        projectTimelinePage.assertTeamMembersVisible();
    }
}
