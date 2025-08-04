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

    @FindAll({
            @FindBy(xpath = "(//android.view.View[@content-desc=\"Users Project\"])[1]"),
            @FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"DummyProject\"])[1]")
    })
    private WebElement projectNavigationButton;

    @FindAll({
            @FindBy(xpath = "//android.widget.TextView[@text='Team Members']"),
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Team Members (7)\"]")
    })
    private WebElement teamMembersText;

    public DashboardPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickOnProjectNavigationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(projectNavigationButton));
        projectNavigationButton.click();
    }

    public void assertTeamMembersVisible() {
        wait.until(ExpectedConditions.visibilityOf(teamMembersText));
        Assert.assertTrue(teamMembersText.isDisplayed(), "'Team Members' text is not visible.");
    }
}
