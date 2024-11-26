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


/**
 * Base class for all tests. Provides set up and tear down methods
 */
public class BaseTest {

    /**
     * ThreadLocal to store the AndroidDriver instance for each thread (test execution)
     */
    private static ThreadLocal<AndroidDriver> threadLocalDriver = new ThreadLocal<>();
    /**
     * ThreadLocal to store the WebDriverWait instance for each thread (test execution)
     */
    private static ThreadLocal<WebDriverWait> threadLocalWait = new ThreadLocal<>();
    /**
     * Android driver instance to interact with the application
     */
    public AndroidDriver driver;
    /**
     * WebDriverWait instance for explicit waits during test execution
     */
    public WebDriverWait wait;

    /**
     * Logger instance to logging test activities
     */
    public static Logger logger;

    //Define the appium url
    public final String appiumServerUrl=Constants.APPIUM_URL;

    protected DesiredCapabilities cap;


    /**
     * Sets up the test environment before the test execution
     * Initializes android driver with desired capabilities and sets up explicit wait
     * @param appName the name of the application to be tested
     * @throws MalformedURLException MalformedURLException if the appiumServerUrl is invalid
     * @throws IllegalArgumentException if appName not provided or appPath is null
     */
    @BeforeSuite
    @Parameters("appName")
    public void setup(@Optional String appName) throws MalformedURLException {

        //initialize the logger
        logger= LogManager.getLogger(this.getClass());

        //validate that the app name is provided
        if (appName == null || appName.isEmpty()) {
            throw new IllegalArgumentException("App name is mandatory but was not provided.");
        }
        logger.info("App name: {}",appName);

        //set up desired capabilities
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:automationName", "uiautomator2");

        //fetch the app path from the configuration file
        String appPathKey = appName + ".apk.path";
        String appPath = ConfigReader.get(appPathKey);

        //validate app path is not null
        if (appPath == null || appPath.isEmpty()) {
            throw new IllegalArgumentException("App path not found for app: " + appName);
        }

        //set the app capability
        cap.setCapability("appium:app", System.getProperty("user.dir") + "/" + appPath);

        //initialize android driver with appium url and the capabilities
        threadLocalDriver.set(new AndroidDriver(new URL(appiumServerUrl), cap));
        //initialize web driver wait with a timeout duration of 10 seconds
        threadLocalWait.set(new WebDriverWait(threadLocalDriver.get(), Duration.ofSeconds(30)));
    }

    /**
     * Getter for the thread-local Driver
     * @return AndroidDriver instance
     */
    public static AndroidDriver getDriver() {
        return threadLocalDriver.get();  // Retrieve the driver for the current thread
    }

    /**
     * Getter for the thread-local WebDriverWait
     * @return WebDriverWait instance
     */
    public static WebDriverWait getWait() {
        return threadLocalWait.get();
    }


    /**
     * Tears down test environment after test execution
     * closes android driver if it was initialized
     */
    @AfterSuite
    public void close() {
        AndroidDriver driver = threadLocalDriver.get();
        if (driver != null) {
            driver.quit();  // Quit the driver to end the session
        }
        threadLocalDriver.remove();
    }
}
