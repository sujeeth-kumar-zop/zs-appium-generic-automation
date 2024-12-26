package test;

import base.BaseTest;
import com.zs.constants.Constants;
import com.zs.pages.common.Flows;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import com.zs.utils.OrderManager;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CancelOrderTest extends BaseTest {

    @Test(groups = {"regression"}, dependsOnGroups = {"checkout", "login"})
    @Parameters("appName")
    public void cancelOrderTest(@Optional String appName) throws InterruptedException {

        LoggerUtil.logInfo("Starting Cancel Order Test");
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        CommonUtils commonUtils=new CommonUtils(driver,wait);
        Flows flows = new Flows(driver, wait);

        commonUtils.navigateToHome(appName);

        commonUtils.click(CommonUtils.getLoginLocator(appName, "profileIcon"));
        LoggerUtil.logInfo("Clicked on the Profile Icon");

        commonUtils.click(CommonUtils.generateLocator(Constants.ORDERS));
        LoggerUtil.logInfo("Clicked on My Orders");

        List<String> orderNums = OrderManager.getOrderIds();

        List<String> orderStatus = flows.cancelOrders(orderNums);

        assertTrue("Order 1 did not get cancelled",orderStatus.get(0).equalsIgnoreCase("Cancelled"));
        assertTrue("Order 2 did not get cancelled",orderStatus.get(1).equalsIgnoreCase("Cancelled"));
    }
}

