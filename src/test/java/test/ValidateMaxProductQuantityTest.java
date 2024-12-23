package test;

import base.BaseTest;
import com.zs.constants.Constants;
import com.zs.pages.common.HomePage;
import com.zs.pages.common.ProductsPage;
import com.zs.utils.CommonUtils;
import com.zs.utils.ExtentReport;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ValidateMaxProductQuantityTest extends BaseTest {

    @Test(groups = {"regression"}, dependsOnGroups = {"login"})
    @Parameters("appName")
    public void productLimitTest(@Optional String appName) {

        // Set the ExtentTest object in LoggerUtil to log to both ExtentReport and Log4j
        LoggerUtil.setExtentTest(ExtentReport.getTest());

        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait = BaseTest.getWait();
        CommonUtils commonUtils=new CommonUtils(driver,wait);
        HomePage homePage=new HomePage(driver,wait);
        ProductsPage productsPage=new ProductsPage(driver,wait);

        commonUtils.navigateToHome(appName);
        productsPage.goToCart(appName);
        if(!commonUtils.isCartEmpty(appName)){
            commonUtils.emptyCart(appName);
        }
        commonUtils.navigateToHome(appName);
        homePage.enterTextInSearchBar(appName, Constants.TAMIMI_WATER);
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getHomePageLocator(appName, "searchBar"))).sendKeys(Keys.RETURN);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Bottled Drinking Water-40×330ML\").instance(0))")).click();

        for(int i=0;i<5;i++){
            wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProductPageLocator(appName,"addToCartBtn"))).click();
        }
        assertTrue("Warning was not displayed",wait.until(ExpectedConditions.visibilityOfElementLocated(CommonUtils.generateLocator(Constants.TAMIMI_PRODUCT_LIMIT_WARNING))).isDisplayed());
    }
}
