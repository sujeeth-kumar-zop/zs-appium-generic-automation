package com.zopsmart.eazyupdates.appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserSession extends Base {
    WebDriverWait wait;

    @Test
    public void loginAction() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@text='Sign In with Google']"))).click();

        Thread.sleep(2000);
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.widget.LinearLayout\").instance(3)"
        )).click();

        By radioButtonLocator = By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.RadioButton");

        if (driver.findElements(radioButtonLocator).size() > 0 &&
                driver.findElement(radioButtonLocator).isDisplayed()) {

            wait.until(ExpectedConditions.elementToBeClickable(radioButtonLocator)).click();
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.TextView[@text='Apply']"))).click();
        }
    }

    @Test(dependsOnMethods = "loginAction")
    public void logoutAction() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        By backBtn = AppiumBy.accessibilityId("back-button");
        wait.until(ExpectedConditions.elementToBeClickable(backBtn)).click();

        By logoutItem = AppiumBy.androidUIAutomator("new UiSelector().text(\"Logout\")");
        wait.until(ExpectedConditions.elementToBeClickable(logoutItem)).click();

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(logoutItem)).click();
        String logoText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Get Started\")")
        )).getText();

        Assert.assertEquals(logoText, "Get Started", "Google sign in text after logout mismatch");
    }


    @AfterTest
    public void quitApplication() {
        if (driver != null) {
            driver.quit();
        }
    }
}
