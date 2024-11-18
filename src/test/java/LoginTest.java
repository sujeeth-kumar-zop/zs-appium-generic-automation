import com.zs.pages.vijetha.LoginPageVijetha;
import com.zs.utils.ExcelUtils;
import config.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import com.zs.pages.*;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    public void login() {

        String[] credentials = ExcelUtils.getCredentialsForApp(appName);

        if (credentials == null) {
            // If no credentials found, print error and fail the test
            System.out.println("Credentials not found for app: " + appName);
            fail("No credentials found for app: " + appName);
        } else {
            String username = credentials[0];
            String password = credentials[1];
            System.out.println("Running login test for app: " + appName);
            if (appName.equals("Vijetha"))
                LoginPageVijetha.clickOnAllowAccess(driver, wait, appName);
            else if (appName.equals("Brimbary")) {
                HomePage.clickOnDrawer(driver, wait, appName);
            }
            LoginPage.clickOnProfileIcon(driver, wait, appName);
            if (appName.equals("Vijetha")) {
                LoginPageVijetha.clickOnLoginWPass(driver, wait, appName);
            }
            LoginPage.enterPhNo(driver, wait, username, appName);
            LoginPage.enterPass(driver, wait, password, appName);
            LoginPage.clickLoginBtn(driver, wait, appName);

            if (appName.equals("Brimbary")) {
                HomePage.clickOnDrawer(driver, wait, appName);
            }
            LoginPage.clickOnProfileIcon(driver, wait, appName);
            assertTrue(ProfilePage.isUsernameVisible(driver, wait, appName));
        }
    }

}
