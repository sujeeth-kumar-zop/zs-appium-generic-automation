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

public class DirectReporteeTimelinePage {

    public WebDriverWait wait;
    public AppiumDriver driver;

    public DirectReporteeTimelinePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_WAIT_TIMEOUT));
    }

    @FindAll({
            @FindBy(xpath = "(//android.widget.TextView[@text='Weekend'])[1]"),
            @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Weekend'])[1]")
    })
    private WebElement validateWeekend;

    public void validateWeekendText() {
        wait.until(ExpectedConditions.visibilityOf(validateWeekend));
        Assert.assertTrue(validateWeekend.isDisplayed(), "Weekend text is not displayed");
    }
}
