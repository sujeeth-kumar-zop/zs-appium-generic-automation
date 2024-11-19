package testTamimi;

import base.BaseTest;
import com.zs.constants.Constants;
import com.zs.pages.common.LoginPage;

public class LoginTestTamimi extends BaseTest {

    public static void loginTamimi(String username, String password){
        LoginPage.clickOnProfileIcon(driver, wait, Constants.TAMIMI);
        LoginPage.enterPhNo(driver, wait, username, Constants.TAMIMI);
        LoginPage.enterPass(driver, wait, password, Constants.TAMIMI);
        LoginPage.clickLoginBtn(driver, wait, Constants.TAMIMI);
        LoginPage.clickOnProfileIcon(driver, wait, Constants.TAMIMI);
    }
}
