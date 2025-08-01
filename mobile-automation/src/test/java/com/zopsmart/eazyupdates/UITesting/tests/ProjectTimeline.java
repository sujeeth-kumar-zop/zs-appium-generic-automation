package com.zopsmart.eazyupdates.UITesting.tests;

import com.zopsmart.eazyupdates.UITesting.Base;
import com.zopsmart.eazyupdates.helper.LoginHelper;
import com.zopsmart.eazyupdates.pages.DashboardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProjectTimeline extends Base {
    private DashboardPage dashboardPage;

    @BeforeClass
    public void setUp() {
        LoginHelper.login(getDriver());
        dashboardPage = new DashboardPage(getDriver());
    }

    @Test(description = "Verify login via Google and access to Project Timeline section")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensures that a user can successfully log in using Google credentials, and navigate to the Project Timeline section from the dashboard.")
    public void projectTimeLineNavigation() {
        dashboardPage.clickOnProjectNavigationButton();
        dashboardPage.assertTeamMembersVisible();
    }
}
