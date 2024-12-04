package test;

import base.BaseTest;
import com.zs.pages.common.CheckoutPage;
import com.zs.pages.common.Flows;
import com.zs.utils.ExtentReport;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    boolean flag=true;

    @Test(groups = {"regression"}, dependsOnGroups = {"login", "addToCart"})
    @Parameters("appName")
    public void checkOutUsingDebitCard(@Optional String appName){

        // Set the ExtentTest object in LoggerUtil to log to both ExtentReport and Log4j
        LoggerUtil.setExtentTest(ExtentReport.getTest());
        LoggerUtil.logInfo("Starting the checkout with debit card test");
        //get the driver and wait instances
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        Flows flows=new Flows(driver,wait);
        CheckoutPage checkoutPage=new CheckoutPage(driver,wait);

        flows.checkOutUsingDebitCard(appName);
        assertTrue(checkoutPage.isOrderPlaced(appName));
        LoggerUtil.logPass("Checkout with debit card test passed");
    }

    @Test(groups = {"regression"}, dependsOnGroups = {"login", "addToCart"})
    @Parameters("appName")
    public void checkOutUsingCashOnDelivery(@Optional String appName){

        // Set the ExtentTest object in LoggerUtil to log to both ExtentReport and Log4j
        LoggerUtil.setExtentTest(ExtentReport.getTest());

        //get the driver and wait instances
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        Flows flows=new Flows(driver,wait);

        CheckoutPage checkoutPage=new CheckoutPage(driver,wait);

        LoggerUtil.logInfo("Starting the checkout using cash on delivery test");
        flows.checkOutUsingCashOnDelivery(appName);
        assertTrue(checkoutPage.isOrderPlaced(appName));
        LoggerUtil.logPass("Checkout using cash on delivery test passed.");
    }

}