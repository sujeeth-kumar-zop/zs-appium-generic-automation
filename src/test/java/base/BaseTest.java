package base;

import com.zs.constants.Constants;
import io.appium.java_client.android.AndroidDriver;
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

    @BeforeTest
    @Parameters("appName")
    public void setup(@Optional(Constants.TAMIMI) String appName) throws MalformedURLException {

        String appiumServerUrl="http://127.0.0.1:4723";

        if (appName == null || appName.isEmpty()) {
            System.out.println("AppName property not set, defaulting to 'Tamimi'");
            appName = Constants.TAMIMI;
        }

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
            System.out.println("Quitting the Appium Driver...");
            driver.quit();
        }
    }
}
