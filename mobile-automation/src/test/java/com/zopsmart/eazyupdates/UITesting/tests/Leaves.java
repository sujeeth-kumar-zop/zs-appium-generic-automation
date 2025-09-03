package com.zopsmart.eazyupdates.UITesting.tests;

import com.zopsmart.eazyupdates.pages.DashboardPage;
import com.zopsmart.eazyupdates.pages.LeavesPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Feature("Leave request workflow")
public class Leaves extends com.zopsmart.eazyupdates.base.Base {
    private DashboardPage dashboardPage;
    private LeavesPage leavesPage;

    private DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(getDriver());
        }
        return dashboardPage;
    }

    private LeavesPage getLeavesPage() {
        if (leavesPage == null) {
            leavesPage = new LeavesPage(getDriver());
        }
        return leavesPage;
    }

    /**
     * Common method to navigate to leaves page and click add leave
     * This method encapsulates the repeated navigation steps
     */
    private void navigateToAddLeavePage() {
        getDashboardPage().clickHamburgerMenu();
        getDashboardPage().clickOnLeaves();
        getLeavesPage().clickOnAddLeave();
    }

    /**
     * Common method to handle platform-specific apply leave validation
     * Centralizes the platform-specific logic for better maintainability
     */
    private void performApplyLeaveAndValidate() {
        getLeavesPage().clickOnApplyLeave();

        // Only verify alert for Android (iOS validation happens in clickOnApplyLeave)
        if (isAndroidPlatform()) {
            getLeavesPage().verifyAlertNotificationDisplayed();
        }
    }

    /**
     * Utility method to check if current platform is Android
     * @return true if platform is Android, false otherwise
     */
    private boolean isAndroidPlatform() {
        return System.getProperty("platform").equalsIgnoreCase("android");
    }

    /**
     * Test to validate that a logged-in user can navigate to the leaves section
     * and attempt to apply leave without filling required details
     * Preconditions:
     * - User must be logged in (handled in com.zopsmart.eazyupdates.base.Base @BeforeMethod)
     * - User must have appropriate permissions to access leaves section
     */
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Validate incomplete leave application submission")
    @Description("Ensures that a user can successfully navigate to the leaves page and validates behavior when applying leave without required details")
    public void applyLeaveWithoutFillingTheDetails() {
        navigateToAddLeavePage();
        performApplyLeaveAndValidate();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Apply first half day leave")
    @Description("Ensures that a user can successfully navigate to the leaves page and apply first half leave with required details")
    public void applyFirstHalfLeave() {
        navigateToAddLeavePage();
        getLeavesPage().applyFirstHalfLeave();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Apply second half day leave")
    @Description("Ensures that a user can successfully navigate to the leaves page and apply second half leave with required details")
    public void applySecondHalfLeave() {
        navigateToAddLeavePage();
        getLeavesPage().applySecondHalfLeave();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Apply full day leave")
    @Description("Ensures that a user can successfully navigate to the leaves page and apply full day leave with required details")
    public void applyFullDayLeave() {
        navigateToAddLeavePage();
        getLeavesPage().applyFullDayLeave();
    }
}