package test;

import base.BaseTest;
import com.zs.constants.Constants;
import com.zs.pages.common.LoginPage;
import com.zs.pages.common.ProfilePage;
import com.zs.pages.tamimi.ProfilePageTamimi;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
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
        LoggerUtil.logInfo("Navigating to home");
        loginPage.clickOnProfileIcon(appName);
        LoggerUtil.logInfo("Clicked on the profile icon");
        profilePage.clickEditBtn(appName);
        LoggerUtil.logInfo("Clicked on the Edit Button");
        profilePageTamimi.selectSalutation(Constants.TAMIMI_SALUTATION);
        LoggerUtil.logInfo("Selected the salutation");
        profilePageTamimi.enterDetails(Constants.TAMIMI_FNAME, Constants.TAMIMI_LNAME, Constants.TAMIMI_EMAIL);
        LoggerUtil.logInfo("Entered details and clicked on submit");
        WebElement successLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(CommonUtils.getProfileLocator(appName, "editProfileSuccessfulLabel")));
        assertEquals("Profile details updated successfully.", successLabel.getText());
        LoggerUtil.logPass("Edit Profile Test Passed");
        driver.findElement(CommonUtils.getProfileLocator(appName, "okBtn")).click();
        LoggerUtil.logInfo("Clicked on Ok");
    }
}
