package com.zopsmart.eazyupdates.pages;

import com.zopsmart.eazyupdates.constants.Constants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DashboardPage {


    private final AppiumDriver driver;
    private final WebDriverWait wait;

    public DashboardPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_WAIT_TIMEOUT));
    }

    @FindAll({
            @FindBy(xpath = "(//android.view.View[@content-desc='Users Project'])[1]"),
            @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='DummyProject'])[1]")
    })
    private WebElement projectNavigationButton;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text='View All>>']"),
            @FindBy(xpath = "//XCUIElementTypeButton[@name='View Direct Reportees Updates']")
    })
    private WebElement directReportees;

    @FindAll({
            @FindBy(xpath = "//android.view.View[@content-desc='back-button']"),
            @FindBy(xpath = "//XCUIElementTypeOther[@name='person.circle.fill']//XCUIElementTypeButton")
    })
    private WebElement hamburgerMenu;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text='My Timeline']"),
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name='My Timeline']")
    })
    private WebElement myTimelineButton;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text='Leaves']"),
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Leaves']")
    })
    private WebElement leavesButton;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text='Logout']"),
            @FindBy(xpath = "//XCUIElementTypeButton[@name='Logout']")
    })
    private WebElement logoutButton;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text='Logout']"),
            @FindBy(xpath = "(//XCUIElementTypeButton[@name='Logout'])[2]")
    })
    private WebElement logoutAlertButton;

    /**
     * Clicks on the project navigation button after waiting for it to be clickable
     */
    public void clickOnProjectNavigationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(projectNavigationButton));
        projectNavigationButton.click();
    }

    /**
     * Clicks on the direct reportees button after waiting for it to be clickable
     */
    public void clickOnDirectReporteeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(directReportees));
        directReportees.click();
    }

    /**
     * Verifies that the user is logged in by checking if the hamburger menu is visible
     * @throws AssertionError if user is not logged in
     */
    public void verifyUserIsLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(hamburgerMenu));
        Assert.assertTrue(hamburgerMenu.isDisplayed(), "User is not logged in - hamburger menu not visible");
    }

    /**
     * Clicks on the hamburger menu after waiting for it to be clickable
     */
    public void clickHamburgerMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu)).click();
    }

    /**
     * Clicks on the My Timeline button after waiting for it to be clickable
     */
    public void clickOnMyTimeline() {
        wait.until(ExpectedConditions.elementToBeClickable(myTimelineButton)).click();
    }

    /**
     * Clicks on the Leaves button after waiting for it to be clickable
     */
    public void clickOnLeaves() {
        wait.until(ExpectedConditions.elementToBeClickable(leavesButton)).click();
    }

    /**
     * Clicks on the logout button after waiting for it to be clickable
     */
    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    /**
     * Clicks on the logout confirmation button in the alert dialog after waiting for it to be clickable
     */
    public void clickLogoutAlertButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutAlertButton)).click();
    }


}