package com.zopsmart.eazyupdates.pages;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.zopsmart.eazyupdates.utils.AllureScreenshotUtil.attachScreenshot;
import static java.sql.DriverManager.getDriver;


public class LoginPage {
    AppiumDriver driver;
    WebDriverWait wait;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    private WebElement iOSContinueButton;

    @FindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.RadioButton")
    private WebElement LocationButton;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text=\"Sign In with Google\"]"),
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign in with Google\"]")
    })
    private WebElement googleSignInButton;

    @FindAll({
            @FindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"com.google.android.gms:id/container\"])[1]/android.widget.LinearLayout"),
            @FindBy(xpath = "//XCUIElementTypeLink[@name=\"Pritam Horo pritam.horo@zopsmart.com\"]")
    })
    private WebElement emailSignInButton;

    @FindAll({
            @FindBy(xpath = "//android.view.View[@content-desc=\"back-button\"]"),
            @FindBy(xpath = "//XCUIElementTypeOther[@name=\"person.circle.fill\"]/XCUIElementTypeOther/XCUIElementTypeButton")
    })
    private WebElement hamburgerMenu;

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

    public void clickGoogleSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(googleSignInButton)).click();
    }

    public void clickEmailSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(emailSignInButton)).click();
        if ("ios".equalsIgnoreCase(System.getProperty("platform"))) {
            wait.until(ExpectedConditions.elementToBeClickable(iOSContinueButton)).click();
        }
    }

    public void clickLocationRadioButton() {
        By radioButtonLocator = By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.RadioButton");
        if (!driver.findElements(radioButtonLocator).isEmpty() &&
                driver.findElement(radioButtonLocator).isDisplayed()) {

            wait.until(ExpectedConditions.elementToBeClickable(radioButtonLocator)).click();
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.TextView[@text='Apply']"))).click();
        }

    }
    public void assertUserIsLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(hamburgerMenu));
        Assert.assertTrue(hamburgerMenu.isDisplayed(),"User is not logged in");
    }
    public void clickHamburgerMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu)).click();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public void clickLogoutAlertButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutAlertButton)).click();
    }
}
