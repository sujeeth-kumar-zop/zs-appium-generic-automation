package test;

import com.zs.constants.Constants;
import com.zs.pages.common.HomePage;
import com.zs.pages.common.LoginPage;
import com.zs.pages.common.ProfilePage;
import com.zs.pages.vijetha.LoginPageVijetha;
import com.zs.utils.CommonUtils;
import com.zs.utils.ExcelUtils;
import base.BaseTest;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    @Parameters("appName")
    public void login(@Optional(Constants.TAMIMI) String appName) {

        String[] credentials = ExcelUtils.getCredentialsForApp(appName);
        assert credentials != null;

        String username = credentials[0];
        String password = credentials[1];

        CommonUtils.callAppSpecificLoginMethod(appName, username, password);

        assertTrue(ProfilePage.isUsernameVisible(driver, wait, appName));
    }
}
