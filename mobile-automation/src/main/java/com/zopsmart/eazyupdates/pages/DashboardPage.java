package com.zopsmart.eazyupdates.pages;

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
    public AppiumDriver driver;
    WebDriverWait wait;

    public DashboardPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindAll({
            @FindBy(xpath = "(//android.view.View[@content-desc=\"Users Project\"])[1]"),
            @FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"DummyProject\"])[1]")

    })
    private WebElement projectNavigationButton;
    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text=\"View All>>\"]"),
            @FindBy(xpath = "//XCUIElementTypeButton[@name=\"View Direct Reportees Updates\"]")

    })
    private WebElement directReportees;

    @FindAll({
            @FindBy(xpath = "//android.view.View[@content-desc=\"back-button\"]"),
            @FindBy(xpath = "//XCUIElementTypeOther[@name=\"person.circle.fill\"]/XCUIElementTypeOther/XCUIElementTypeButton")
    })
    private WebElement hamburgerMenu;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text=\"My Timeline\"]"),
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"My Timeline\"]")
    })
    private WebElement myTimelineButton;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text=\"Logout\"]"),
            @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Logout\"]")
    })
    private WebElement logoutButton;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text=\"Logout\"]"),
            @FindBy(xpath = "(//XCUIElementTypeButton[@name=\"Logout\"])[2]")
    })
    private WebElement logoutAlertButton;

    public void clickOnProjectNavigationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(projectNavigationButton));
        projectNavigationButton.click();
    }

    public void clickOnDirectReporteeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(directReportees));
        directReportees.click();
    }

    public void assertUserIsLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(hamburgerMenu));
        Assert.assertTrue(hamburgerMenu.isDisplayed(), "User is not logged in");
    }

    public void clickHamburgerMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu)).click();
    }

    public void clickOnMyTimeline() {
        wait.until(ExpectedConditions.elementToBeClickable(myTimelineButton)).click();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public void clickLogoutAlertButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutAlertButton)).click();
    }

}
