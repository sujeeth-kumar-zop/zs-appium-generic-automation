package base;

import com.zs.constants.Constants;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.zs.utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static AndroidDriver driver;
    public static WebDriverWait wait;
    public static Logger logger;

    @BeforeTest
    @Parameters("appName")
    public void setup(@Optional(Constants.TAMIMI) String appName) throws MalformedURLException {

        logger= LogManager.getLogger(this.getClass());
        String appiumServerUrl="http://127.0.0.1:4723";

        if (appName == null || appName.isEmpty()) {
            logger.info("App name null. Defaulting to Tamimi");
            appName = Constants.TAMIMI;
        }
        logger.info("App name: "+appName);
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:automationName", "uiautomator2");

        String appPathKey = appName + ".apk.path";
        String appPath = ConfigReader.get(appPathKey);

        if (appPath == null || appPath.isEmpty()) {
            throw new IllegalArgumentException("App path not found for app: " + appName);
        }

        cap.setCapability("appium:app", System.getProperty("user.dir") + "/" + appPath);

        driver = new AndroidDriver(new URL(appiumServerUrl), cap);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void close() {
        if (driver != null) {
            logger.info("Closing driver");
            driver.quit();
        }
    }
}
