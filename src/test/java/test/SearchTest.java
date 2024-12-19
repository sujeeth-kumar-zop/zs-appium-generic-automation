package test;

import base.BaseTest;
import com.zs.constants.Constants;
import com.zs.pages.common.Flows;
import com.zs.pages.common.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SearchTest extends BaseTest {

    @Test(groups = {"regression"})
    @Parameters("appName")
    public void searchTest(@Optional String appName){

        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        driver.navigate().back();
        Flows flows=new Flows(driver,wait);
        HomePage homePage=new HomePage(driver,wait);
        flows.checkSearch(appName);
        String randomProductText= homePage.fetchRandomProduct(appName);
        System.out.println(randomProductText);
        assertTrue("The product text should contain the search keyword.",
                randomProductText.toLowerCase().contains(Constants.EGGPLANT_STRING.toLowerCase()));

    }
}
