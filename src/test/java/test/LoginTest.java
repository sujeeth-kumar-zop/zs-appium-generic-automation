package test;
import base.BaseTest;
import com.zs.pages.common.Flows;
import com.zs.pages.common.LoginPage;
import com.zs.pages.common.ProfilePage;
import com.zs.utils.ExcelUtils;
import com.zs.utils.ExtentReport;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.core.net.Priority;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.testng.Assert.*;


/**
 * Test for validating login functionality for different applications.
 * <p>
 * The test reads credentials from an external Excel file, performs a login action,
 * and verifies the success of the login by checking the visibility of the username on the profile page.
 * </p>
 */
public class LoginTest extends BaseTest {


    /**
     * Validates the login functionality by using credentials from an Excel file.
     * @param appName name of the application being tested
     */
    @Test(groups = {"login", "regression"})
    @Parameters("appName")
    public void login(@Optional String appName) throws Exception {

        // Set the ExtentTest object in LoggerUtil to log to both ExtentReport and Log4j
        LoggerUtil.setExtentTest(ExtentReport.getTest());

        // Log test start
        LoggerUtil.logInfo("Starting login test for app: " + appName);


        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        LoggerUtil.logInfo("Fetching credentials for app: " + appName);
        //fetch the credentials for the given application
//        String[] credentials = ExcelUtils.getCredentialsForApp(appName);
//        assert credentials != null;

        String username = "595124791";
        String password = "12345678";

        LoggerUtil.logInfo("Fetched credentials - Username: " + username);

        //perform the login action
        Flows flows = new Flows(driver, wait);

        LoggerUtil.logInfo("Performing login for user: " + username);
        flows.loginFlow(password, username, appName);

        //verify the username is displayed in the profile page after logging in
        ProfilePage profilePage = new ProfilePage(driver, wait);
        LoggerUtil.logInfo("Verifying username visibility on profile page.");
        assertTrue(profilePage.isUsernameVisible(appName));
        LoggerUtil.logPass("Login test passed for user: " + username);
    }
}
