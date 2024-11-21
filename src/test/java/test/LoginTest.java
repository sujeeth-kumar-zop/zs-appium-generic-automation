package test;

import com.zs.constants.Constants;
import com.zs.pages.common.LoginPage;
import com.zs.pages.common.ProfilePage;
import com.zs.utils.ExcelUtils;
import base.BaseTest;
import org.testng.annotations.*;

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
    @Test
    @Parameters("appName")
    public void login(@Optional String appName) {

        //fetch the credentials for the given application
        String[] credentials = ExcelUtils.getCredentialsForApp(appName);
        assert credentials != null;

        String username = credentials[0];
        String password = credentials[1];

        //perform the login action
        LoginPage loginPage=new LoginPage(driver, wait);
        loginPage.loginFlow(password, username, appName);

        //verify the username is displayed in the profile page after logging in
        ProfilePage profilePage=new ProfilePage(driver,wait);
        assertTrue(profilePage.isUsernameVisible(appName));
    }
}
