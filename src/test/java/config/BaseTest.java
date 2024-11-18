package config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AndroidDriver driver;
    public WebDriverWait wait;
    public String appName;

    @BeforeTest
    public void setup() throws MalformedURLException {
        String appiumServerUrl="http://127.0.0.1:4723";

        System.out.println("AppName system property: " + System.getProperty("appName"));

        appName = System.getProperty("appName");
        if (appName == null || appName.isEmpty()) {
            System.out.println("AppName property not set, defaulting to 'Tamimi'");
            appName = "Tamimi";
        }

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("platformName","Android");
        cap.setCapability("appium:automationName","uiautomator2");
        if("Tamimi".equals(appName))
            cap.setCapability("appium:app",System.getProperty("user.dir")+ "/apps/app-visionstg-debug.apk");
        else if("Vijetha".equals(appName))
            cap.setCapability("appium:app", System.getProperty("user.dir")+ "/apps/app-vijethasupermarkets-debug_latest.apk");
        else if("Ekam".equals(appName))
            cap.setCapability("appium:app", System.getProperty("user.dir") + "/apps/app-ekam-debug.apk");
        else if("Brimbary".equals(appName))
            cap.setCapability("appium:app", System.getProperty("user.dir")+ "/apps/app-brimbary-debug.apk");
        else throw new IllegalArgumentException("Invalid app name: " + appName);

        driver=new AndroidDriver(new URL(appiumServerUrl), cap);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}
