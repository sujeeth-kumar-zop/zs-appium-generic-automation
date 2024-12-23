package test;

import base.BaseTest;
import com.zs.constants.Constants;
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

    @Test(groups = {"regression"}, dependsOnGroups = {"checkout"})
    @Parameters("appName")
    public void cancelOrderTest(@Optional String appName) throws InterruptedException {

        LoggerUtil.logInfo("Starting Cancel Order Test");
        AndroidDriver driver = BaseTest.getDriver();
        WebDriverWait wait= BaseTest.getWait();

        CommonUtils commonUtils=new CommonUtils(driver,wait);

        commonUtils.navigateToHome(appName);
        LoggerUtil.logInfo("Navigating to home page");
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.getLoginLocator(appName, "profileIcon"))).click();
        LoggerUtil.logInfo("Clicked on the Profile Icon");
        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.generateLocator(Constants.ORDERS))).click();
        LoggerUtil.logInfo("Clicked on My Orders");

        List<String> orderNums = OrderManager.getOrderIds();

        String order1Loc = CommonUtils.generateLocator("#"+orderNums.get(0)).toString();
        String order1XpathValue = order1Loc.substring(order1Loc.indexOf(": ") + 2);
        LoggerUtil.logInfo("Found the order number of order 1");

        String order2Loc = CommonUtils.generateLocator("#"+orderNums.get(1)).toString();
        String order2XpathValue = order2Loc.substring(order2Loc.indexOf(": ") + 2);
        LoggerUtil.logInfo("Found the order number of order 2");

        WebElement order1Parent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(order1XpathValue+Constants.PARENT_LOC)));
        LoggerUtil.logInfo("Found the parent element of order1");
        WebElement order2Parent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(order2XpathValue+Constants.PARENT_LOC)));
        LoggerUtil.logInfo("Found the parent element of order2");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(order1XpathValue+Constants.PARENT_LOC+Constants.FOURTH_CHILD)))).click();
        LoggerUtil.logInfo("Clicked on the 4th child of parent of order 1: Kebab Menu");

        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.generateLocator(Constants.CANCEL))).click();
        LoggerUtil.logInfo("Clicked on Cancel for Order 1");

        System.out.println(order2XpathValue+Constants.PARENT_LOC+Constants.FOURTH_CHILD);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(order2XpathValue + Constants.PARENT_LOC + Constants.FOURTH_CHILD)));

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(order2XpathValue+Constants.PARENT_LOC+Constants.FOURTH_CHILD)))).click();
        LoggerUtil.logInfo("Clicked on the 4th child of parent of order 2: Kebab Menu");

        wait.until(ExpectedConditions.elementToBeClickable(CommonUtils.generateLocator(Constants.CANCEL))).click();
        LoggerUtil.logInfo("Clicked on Cancel for Order 2");

        WebElement cancelLabel1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(order1XpathValue+Constants.PARENT_LOC+Constants.EIGHTH_CHILD)));
        WebElement cancelLabel2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(order2XpathValue+Constants.PARENT_LOC+Constants.EIGHTH_CHILD)));

        assertTrue("Order 1 did not get cancelled",cancelLabel1.getText().equalsIgnoreCase("Cancelled"));
        assertTrue("Order 2 did not get cancelled",cancelLabel2.getText().equalsIgnoreCase("Cancelled"));

    }
}

