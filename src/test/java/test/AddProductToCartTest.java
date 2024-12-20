package test;

import com.zs.constants.Constants;
import com.zs.pages.common.CartPage;
import com.zs.pages.common.Flows;
import com.zs.utils.CommonUtils;
import base.BaseTest;
import com.zs.utils.ExtentReport;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


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
    @Test(groups = {"regression", "addToCart"}, dependsOnGroups = {"login"})
    @Parameters("appName")
    public void addSingleProductToCart(@Optional String appName){

        // Set the ExtentTest object in LoggerUtil to log to both ExtentReport and Log4j
        LoggerUtil.setExtentTest(ExtentReport.getTest());

        //get the driver and wait instances
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        CommonUtils commonUtils=new CommonUtils(driver,wait);
        Flows flows=new Flows(driver,wait);

        commonUtils.navigateToHome(appName);
        flows.addSingleProductToCartFlow(appName);
        By checkOutBtn = CommonUtils.getCartLocators(appName, "checkOutBtn");
        LoggerUtil.logInfo("Checking if checkout button is visible.");
        assertTrue(commonUtils.isElementVisible(checkOutBtn), "Checkout Button is not visible"); //assert by checking if the check out button is visible
        LoggerUtil.logPass("Add a single product to cart test passed.");
    }

    /**
     * Test to increase the quantity of the product in cart
     * @param appName The name of the application under test
     */
    @Test(groups = {"regression", "addToCart"}, dependsOnMethods = {"addSingleProductToCart"})
    @Parameters("appName")
    public void increaseProductQuantityInCart(@Optional String appName){

        // Set the ExtentTest object in LoggerUtil to log to both ExtentReport and Log4j
        LoggerUtil.setExtentTest(ExtentReport.getTest());

        //get the driver and wait instances
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        Flows flows=new Flows(driver,wait);
        CartPage cartPage=new CartPage(driver,wait);
        CommonUtils commonUtils=new CommonUtils(driver,wait);

        commonUtils.navigateToHome(appName);
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getMenuLocators(appName, "cartBtn"))).click();
        flows.increaseQuantityOfProduct(appName);
        LoggerUtil.logInfo("Checking if quantity increased.");

        String expectedQuantity;
        if (Constants.TAMIMI.equalsIgnoreCase(appName)) {
            expectedQuantity = "20";
        } else if (Constants.BRIMBARY.equalsIgnoreCase(appName) || Constants.VIJETHA.equalsIgnoreCase(appName)) {
            expectedQuantity = "2";
        } else {
            expectedQuantity = "10";
        }
        assertEquals(cartPage.verifyQuantity(appName), expectedQuantity);
        LoggerUtil.logPass("Increase Product Quantity test passed.");

    }
}

