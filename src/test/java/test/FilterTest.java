package test;

import base.BaseTest;
import com.zs.constants.Constants;
import com.zs.pages.common.ProductsPage;
import com.zs.utils.CommonUtils;
import com.zs.utils.ExtentReport;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class FilterTest extends BaseTest {

    @Test(groups = {"regression"})
    @Parameters("appName")
    public void filterTest(@Optional String appName) throws InterruptedException {

        // Set the ExtentTest object in LoggerUtil to log to both ExtentReport and Log4j
        LoggerUtil.setExtentTest(ExtentReport.getTest());
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait = BaseTest.getWait();

        CommonUtils commonUtils=new CommonUtils(driver,wait);
        ProductsPage productsPage=new ProductsPage(driver,wait);

        commonUtils.navigateToHome(appName);
        productsPage.clickProductCategory(appName);

        productsPage.clickFilterButton(appName);
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.generateLocator(Constants.BRAND))).click();
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.generateLocator(Constants.TAMIMI_BRAND_KSA))).click();
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getProductPageLocator(appName, "applyBtn"))).click();

        Thread.sleep(3000);

        List<WebElement> updatedProductList = driver.findElements(By.id("com.zopsmart.stg.scarlet:id/tv_brand_text"));

        boolean filterAppliedCorrectly = true;
        for (WebElement product : updatedProductList) {
            if (!product.getText().equalsIgnoreCase(Constants.TAMIMI_BRAND_KSA)) {
                filterAppliedCorrectly = false;
                break;
            }
        }
        assertTrue("Filter functionality failed", filterAppliedCorrectly);

    }
}
