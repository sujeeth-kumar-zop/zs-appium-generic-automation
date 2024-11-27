package test;

import base.BaseTest;
import com.zs.pages.common.CheckoutPage;
import com.zs.pages.common.Flows;
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

        //get the driver and wait instances
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        Flows flows=new Flows(driver,wait);
        CheckoutPage checkoutPage=new CheckoutPage(driver,wait);

        flows.checkOutUsingDebitCard(appName);
        assertTrue(checkoutPage.isOrderPlaced(appName));
    }

    @Test(groups = {"regression"}, dependsOnGroups = {"login", "addToCart"})
    @Parameters("appName")
    public void checkOutUsingCashOnDelivery(@Optional String appName){

        //get the driver and wait instances
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        Flows flows=new Flows(driver,wait);

        CheckoutPage checkoutPage=new CheckoutPage(driver,wait);

        flows.checkOutUsingCashOnDelivery(appName);
        assertTrue(checkoutPage.isOrderPlaced(appName));
    }

}
