package test;

import base.BaseTest;
import com.zs.constants.Constants;
import com.zs.pages.common.LoginPage;
import com.zs.pages.common.ProfilePage;
import com.zs.pages.tamimi.ProfilePageTamimi;
import com.zs.utils.CommonUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class EditProfileTest extends BaseTest {

    @Test(groups = {"regression"}, dependsOnGroups = {"login"})
    @Parameters("appName")
    public void editDetails(@Optional String appName) {

        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        CommonUtils commonUtils = new CommonUtils(driver, wait);
        LoginPage loginPage = new LoginPage(driver,wait);
        ProfilePage profilePage = new ProfilePage(driver,wait);
        ProfilePageTamimi profilePageTamimi = new ProfilePageTamimi(driver,wait);

        commonUtils.navigateToHome(appName);
        loginPage.clickOnProfileIcon(appName);
        profilePage.clickEditBtn(appName);
        profilePageTamimi.selectSalutation(Constants.TAMIMI_SALUTATION);
        profilePageTamimi.enterDetails(Constants.TAMIMI_FNAME, Constants.TAMIMI_LNAME, Constants.TAMIMI_EMAIL);
        WebElement successLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(CommonUtils.getProfileLocator(appName, "editProfileSuccessfulLabel")));
        assertEquals("Profile details updated successfully.", successLabel.getText());
        driver.findElement(CommonUtils.getProfileLocator(appName, "okBtn")).click();
    }
}
