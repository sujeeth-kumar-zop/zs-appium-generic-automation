package testEkam;

import base.BaseTest;
import com.zs.constants.Constants;
import com.zs.pages.common.LoginPage;

public class LoginTestEkam extends BaseTest {

    public static void loginEkam(String username, String password){
        LoginPage.clickOnProfileIcon(driver, wait, Constants.EKAM);
        LoginPage.enterPhNo(driver, wait, username, Constants.EKAM);
        LoginPage.enterPass(driver, wait, password, Constants.EKAM);
        LoginPage.clickLoginBtn(driver, wait, Constants.EKAM);
        LoginPage.clickOnProfileIcon(driver, wait, Constants.EKAM);
    }
}
