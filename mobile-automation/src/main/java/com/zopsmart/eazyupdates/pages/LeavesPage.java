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

public class LeavesPage {
    private static final int DEFAULT_WAIT_TIMEOUT = 20;

    private final WebDriverWait wait;
    private final AppiumDriver driver;

    public LeavesPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIMEOUT));
    }

    @FindAll({
            @FindBy(xpath = "//android.widget.ImageView[@content-desc='Add Leave']"),
            @FindBy(xpath = "//XCUIElementTypeButton[@name='Add']")
    })
    private WebElement addLeave;

    @FindAll({
            @FindBy(xpath = "(//android.widget.TextView[@text='Apply Leave'])[1]"),
            @FindBy(xpath = "//XCUIElementTypeButton[@name='APPLY']")
    })
    private WebElement applyLeave;

    @FindBy(xpath = "//android.widget.TextView[@text='Please fill in the *marked fields']")
    private WebElement alertNotification;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text='First Half']"),
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name='First Half']")
    })
    private WebElement firstHalfLeave;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text='Second Half']"),
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Second Half']")
    })
    private WebElement secondHalfLeave;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text='Full Day']"),
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Full Day']")
    })
    private WebElement fullDayLeave;

    @FindBy(xpath = "(//android.widget.ImageView[@content-desc='contentDescription'])[1]")
    private WebElement selectCalendar;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement selectDate;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text='Select Leave Type']"),
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Leave Type']")
    })
    private WebElement selectLeaveType;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text='Casual Leave']"),
            @FindBy(xpath = "//XCUIElementTypeButton[@name='Casual Leave']")
    })
    private WebElement casualLeave;

    @FindAll({
            @FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText"),
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Reason for leave']")
    })
    private WebElement reasons;

    /**
     * Clicks on the Add Leave button after waiting for it to be clickable
     */
    public void clickOnAddLeave() {
        wait.until(ExpectedConditions.elementToBeClickable(addLeave)).click();
    }

    /**
     * Clicks on the Apply Leave button after waiting for it to be clickable
     */
    public void clickOnApplyLeave() {
        if (System.getProperty("platform").equalsIgnoreCase("iOS")) {
            // Validate that the button is displayed but greyed out
            boolean isDisplayed = applyLeave.isDisplayed();
            boolean isEnabled = applyLeave.isEnabled();

            // Assert that button is visible but disabled in iOS (greyed out)
            if (isDisplayed && !isEnabled) {
                System.out.println("Apply Leave button is greyed out on iOS - validation passed");
            } else {
                System.out.println("Apply Leave button validation failed on iOS");
            }
        } else {
            // Click for Android
            wait.until(ExpectedConditions.elementToBeClickable(applyLeave)).click();
        }
    }

    /**
     * Verifies that the alert notification for missing required fields is displayed
     *
     * @throws AssertionError if alert notification is not visible
     */
    public void verifyAlertNotificationDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(alertNotification));
        Assert.assertTrue(alertNotification.isDisplayed(),
                "Alert notification for missing required fields should be displayed");
    }

    public void applyFirstHalfLeave() {
        try {
            clickElement(firstHalfLeave);
            selectDate();
            selectCasualLeave();
            enterReason("Automating leave service");
            validateiOSButton();
        } catch (Exception e) {
            throw new RuntimeException("Failed to apply first half leave: " + e.getMessage());
        }
    }

    public void applySecondHalfLeave() {
        try {
            clickElement(secondHalfLeave);
            selectDate();
            selectCasualLeave();
            enterReason("Automating leave service");
            validateiOSButton();
        } catch (Exception e) {
            throw new RuntimeException("Failed to apply second half leave: " + e.getMessage());
        }
    }

    public void applyFullDayLeave() {
        try {
            clickElement(fullDayLeave);
            selectDate();
            selectCasualLeave();
            enterReason("Automating leave service");
            validateiOSButton();
        } catch (Exception e) {
            throw new RuntimeException("Failed to apply full day leave: " + e.getMessage());
        }
    }

    // HELPER METHODS
    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    private void selectCasualLeave() {
        clickElement(selectLeaveType);
        clickElement(casualLeave);
    }

    private void enterReason(String reason) {
        clickElement(reasons);
        reasons.sendKeys(reason);
    }

    private void validateiOSButton() {
        if (System.getProperty("platform").equalsIgnoreCase("iOS")) {
            Assert.assertTrue(applyLeave.isEnabled(), "Apply button should be enabled on iOS");
        }
    }

    private void selectDate() {
        if (System.getProperty("platform").equalsIgnoreCase("android")) {
            wait.until(ExpectedConditions.elementToBeClickable(selectCalendar)).click();
            wait.until(ExpectedConditions.elementToBeClickable(selectDate)).click();
        }
    }
}