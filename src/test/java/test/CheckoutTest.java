package test;

import base.BaseTest;
import com.zs.pages.common.CheckoutPage;
import com.zs.pages.common.Flows;
import com.zs.utils.CommonUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"regression"}, dependsOnGroups = {"login", "addToCart"})
    @Parameters("appName")
    public void checkOut(@Optional String appName){

        //get the driver and wait instances
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        Flows flows=new Flows(driver,wait);
        CheckoutPage checkoutPage=new CheckoutPage(driver,wait);

        flows.checkOut(appName);
        assertTrue(checkoutPage.isOrderPlaced(appName));
    }

}
