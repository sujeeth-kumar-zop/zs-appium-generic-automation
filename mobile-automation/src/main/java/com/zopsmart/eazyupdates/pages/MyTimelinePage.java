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

public class MyTimelinePage {
    public WebDriverWait wait;
    public AppiumDriver driver;

    public MyTimelinePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindAll({
            @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Calender\"]"),
            @FindBy(xpath = "//XCUIElementTypeButton[@name=\"calendar-1\"]")
    })
    private WebElement calendarComponent;

    public void getCalendarComponent() {
        wait.until(ExpectedConditions.visibilityOf(calendarComponent));
        Assert.assertTrue(calendarComponent.isDisplayed(),"calendar Component not displayed");
    }

}
