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

public class DirectReporteeTimeline {

    public WebDriverWait wait;
    public AppiumDriver driver;

    @FindAll({
            @FindBy(xpath = "(//android.widget.TextView[@text=\"Weekend\"])[1]"),
            @FindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Weekend\"])[1]")
    })
    private WebElement validateWeekend;

    public DirectReporteeTimeline(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void validateWeekendText() {
        wait.until(ExpectedConditions.visibilityOf(validateWeekend));
        Assert.assertTrue(validateWeekend.isDisplayed(), "Weekend text is not displayed");
    }
}
