package test;

import base.BaseTest;
import com.zs.constants.Constants;
import com.zs.pages.common.Flows;
import com.zs.pages.common.HomePage;
import com.zs.utils.ExtentReport;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SearchTest extends BaseTest {

    @Test(groups = {"regression"}, dependsOnGroups = {"addToCart"})
    @Parameters("appName")
    public void searchTest(@Optional String appName){

        // Set the ExtentTest object in LoggerUtil to log to both ExtentReport and Log4j
        LoggerUtil.setExtentTest(ExtentReport.getTest());

        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        LoggerUtil.logInfo("Starting the Search Test");
//        driver.navigate().back();
        if(Constants.TAMIMI.equals(appName))
            driver.navigate().back();
        Flows flows=new Flows(driver,wait);
        HomePage homePage=new HomePage(driver,wait);
        flows.checkSearch(appName);
        String randomProductText= homePage.fetchRandomProduct(appName);
        String textToCheck;
        if(Constants.BRIMBARY.equals(appName)){
            textToCheck=Constants.TSHIRT_STRING;
        }
        else if(Constants.TAMIMI.equals(appName)){
            textToCheck=Constants.EGGPLANT_STRING;
        }
        else{
            textToCheck=Constants.EGGPLANT_STRING;
        }
        assertTrue("The product text should contain the search keyword.",
                randomProductText.toLowerCase().contains(textToCheck.toLowerCase()));
        LoggerUtil.logPass("Search test passed.");
    }
}
