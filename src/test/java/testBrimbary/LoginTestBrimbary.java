package testBrimbary;

import base.BaseTest;
import com.zs.constants.Constants;
import com.zs.pages.common.HomePage;
import com.zs.pages.common.LoginPage;

public class LoginTestBrimbary extends BaseTest {

    public static void loginBrimbary(String username, String password){
        HomePage.clickOnDrawer(driver, wait, Constants.BRIMBARY);
        LoginPage.clickOnProfileIcon(driver, wait, Constants.BRIMBARY);
        LoginPage.enterPhNo(driver, wait, username, Constants.BRIMBARY);
        LoginPage.enterPass(driver, wait, password, Constants.BRIMBARY);
        LoginPage.clickLoginBtn(driver, wait, Constants.BRIMBARY);
        HomePage.clickOnDrawer(driver, wait, Constants.BRIMBARY);
    }
}
