package com.zopsmart.eazyupdates.UITesting.tests;


import com.zopsmart.eazyupdates.base.Base;
import com.zopsmart.eazyupdates.pages.DashboardPage;
import com.zopsmart.eazyupdates.pages.ProjectTimelinePage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Feature("ProjectTimeline Navigation")
public class ProjectTimeline extends Base {

    /**
     * Test to validate that a logged-in user can navigate to the Project Timeline section
     * from the dashboard screen and see team members listed.
     * Preconditions:
     * - User must be logged in (handled in com.zopsmart.eazyupdates.base.Base @BeforeMethod)
     */
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Project timeline")
    @Description("Ensures that a user can successfully log in using Google credentials, and navigate to the Project Timeline section from the dashboard.")
    public void projectTimeLineNavigation() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        ProjectTimelinePage projectTimelinePage = new ProjectTimelinePage(getDriver());
        dashboardPage.clickOnProjectNavigationButton();
        projectTimelinePage.assertTeamMembersVisible();
    }
}
