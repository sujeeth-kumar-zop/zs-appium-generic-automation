package test;

import base.BaseTest;
import com.zs.constants.Constants;
import com.zs.pages.common.LoginPage;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginNegativeTest extends BaseTest {
    @Test
    @Parameters("appName")
    public void loginNegative(@Optional String appName) throws InterruptedException {

        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        CommonUtils commonUtils=new CommonUtils(driver,wait);
        LoginPage loginPage=new LoginPage(driver,wait);

        commonUtils.navigateToHome(appName);
        if(commonUtils.isLoggedIn(appName)){
            driver.navigate().back();
            LoggerUtil.logInfo("Performing Logout");
            loginPage.clickOnProfileIcon(appName);
            LoggerUtil.logInfo("Clicked on Profile Icon");
            wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.generateLocator(Constants.LOGOUT))).click();
            LoggerUtil.logInfo("Clicked on Logout");
        }
        else{
            driver.navigate().back();
        }
        loginPage.clickOnProfileIcon(appName);
        loginPage.enterPhNo(Constants.TAMIMI_INVALID_PNO, appName);
        loginPage.enterPass(Constants.TAMIMI_INVALID_PASS, appName);
        loginPage.clickLoginBtn(appName);
        assertTrue("No pop up displaying Invalid Credentials",commonUtils.isElementVisible(CommonUtils.generateLocator(Constants.INVALID_CREDS)));
    }
}
