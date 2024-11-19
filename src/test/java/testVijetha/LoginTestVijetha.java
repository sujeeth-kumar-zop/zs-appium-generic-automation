package testVijetha;

import base.BaseTest;
import com.zs.constants.Constants;
import com.zs.pages.common.LoginPage;
import com.zs.pages.vijetha.LoginPageVijetha;

public class LoginTestVijetha extends BaseTest {

    public static void loginVijetha(String username, String password){

        LoginPageVijetha.clickOnAllowAccess(driver, wait, Constants.VIJETHA);
        LoginPage.clickOnProfileIcon(driver, wait, Constants.VIJETHA);
        LoginPageVijetha.clickOnLoginWPass(driver, wait, Constants.VIJETHA);
        LoginPage.enterPhNo(driver, wait, username, Constants.VIJETHA);
        LoginPage.enterPass(driver, wait, password, Constants.VIJETHA);
        LoginPage.clickLoginBtn(driver, wait, Constants.VIJETHA);
        LoginPage.clickOnProfileIcon(driver, wait, Constants.VIJETHA);
    }

}
