package test;

import com.zs.pages.common.CartPage;
import com.zs.pages.common.Flows;
import com.zs.utils.CommonUtils;
import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.util.concurrent.Flow;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Contains all the tests related to the Add to Cart functionality.
 */
public class AddProductToCartTest extends BaseTest {


    /**
     * Test to add a single product to the cart.
     * @param appName The name of the Application Under Test.
     */
    @Test(dependsOnGroups = {"login"})
    @Parameters("appName")
    public void addSingleProductToCart(@Optional String appName){

        //get the driver and wait instances
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        CommonUtils commonUtils=new CommonUtils(driver,wait);
        Flows flows=new Flows(driver,wait);

        driver.navigate().back();
        flows.addSingleProductToCartFlow(appName);
        By checkOutBtn = CommonUtils.getCartLocators(appName, "checkOutBtn");
        assertTrue(commonUtils.isElementVisible(checkOutBtn), "Checkout Button is not visible"); //assert by checking if the check out button is visible
    }

    @Test(dependsOnMethods = {"addSingleProductToCart"})
    @Parameters("appName")
    public void addMultipleProductToCart(@Optional String appName){
        //get the driver and wait instances
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        Flows flows=new Flows(driver,wait);
        CartPage cartPage=new CartPage(driver,wait);

        flows.increaseQuantityOfProduct(appName);
        assertEquals(cartPage.verifyQuantity(appName), "20");

    }
}

