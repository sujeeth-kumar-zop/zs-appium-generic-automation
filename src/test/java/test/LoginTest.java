package test;
import base.BaseTest;
import com.zs.pages.common.Flows;
import com.zs.pages.common.LoginPage;
import com.zs.pages.common.ProfilePage;
import com.zs.utils.ExcelUtils;
import io.appium.java_client.android.AndroidDriver;
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
    @Test(groups = {"login"})
    @Parameters("appName")
    public void login(@Optional String appName) throws MalformedURLException {
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();
        //fetch the credentials for the given application
        String[] credentials = ExcelUtils.getCredentialsForApp(appName);
        assert credentials != null;

        String username = credentials[0];
        String password = credentials[1];

        //perform the login action
        LoginPage loginPage = new LoginPage(driver, wait);
        Flows flows = new Flows(driver, wait);
        flows.loginFlow(password, username, appName);

        //verify the username is displayed in the profile page after logging in
        ProfilePage profilePage = new ProfilePage(driver, wait);
        assertTrue(profilePage.isUsernameVisible(appName));
        String sessionId = driver.getSessionId().toString();
        System.setProperty("appiumSessionId", sessionId);
        logger.info("Storing session ID: {}", sessionId);
    }
}
