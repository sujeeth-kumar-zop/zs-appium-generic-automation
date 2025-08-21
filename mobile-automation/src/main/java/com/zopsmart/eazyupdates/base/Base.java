package com.zopsmart.eazyupdates.base;

import com.zopsmart.eazyupdates.helper.LoginToApplication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import static com.zopsmart.eazyupdates.utils.AllureScreenshotUtil.attachScreenshot;

public class Base {
    protected static Properties props = new Properties();
    private AppiumDriverLocalService appiumServiceBuilder;
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    protected URL serverUrl;

    static {
        try (FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties")) {
            props.load(input);
            for (String key : props.stringPropertyNames()) {
                System.setProperty(key, props.getProperty(key));
            }
        } catch (Exception e) {
            System.out.println("Server initiated (properties not loaded): " + e.getMessage());
        }
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    private String getApkPath() {
        // GitHub Actions path
        String envPath = System.getenv("APK_PATH");
        if (envPath != null) {
            return envPath;
        }

        // CI path
        String workingDir = System.getProperty("user.dir");
        String ciPath = workingDir + "/mobile-automation/src/test/resources/builds/Hamburger-testtag.apk";
        if (new File(ciPath).exists()) {
            return ciPath;
        }

        // Local path from config
        return System.getProperty("AndroidBuildPath");
    }

    @BeforeSuite(alwaysRun = true)
    protected void startAppiumServer() {
        try {
            new URL("http://127.0.0.1:4723/status").openConnection().connect();
            return;
        } catch (Exception e) {
            // Start server
        }

        appiumServiceBuilder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appiumServiceBuilder.start();
    }

    @BeforeClass(alwaysRun = true)
    protected void launchDevice() throws Exception {
        serverUrl = new URL("http://127.0.0.1:4723");
        String platform = System.getProperty("platform").toLowerCase();

        switch (platform) {
            case "android":
                String apkPath = getApkPath();
                System.out.println("Using APK: " + apkPath);

                UiAutomator2Options androidOptions = new UiAutomator2Options()
                        .setDeviceName(System.getProperty("AndroidDevice"))
                        .setApp(apkPath)
                        .setAutoGrantPermissions(true)
                        .setAppWaitDuration(Duration.ofSeconds(30));
                driver.set(new AndroidDriver(serverUrl, androidOptions));
                break;

            case "ios":
                XCUITestOptions iosOptions = new XCUITestOptions()
                        .setDeviceName(System.getProperty("iOSDevice"))
                        .setApp(System.getProperty("iOSBuildPath"))
                        .setAutoAcceptAlerts(true)
                        .setAutoDismissAlerts(true)
                        .setPlatformVersion(System.getProperty("iOSPlatformVersion"))
                        .setWdaLaunchTimeout(Duration.ofSeconds(30));
                driver.set(new IOSDriver(serverUrl, iosOptions));
                break;

            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }

        loginBeforeEachTest();
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        try {
            if (driver.get() != null) {
                driver.get().quit();
            }
        } catch (Exception e) {
            System.err.println("Error quitting driver: " + e.getMessage());
        }
    }

    public void loginBeforeEachTest() {
        LoginToApplication.login(getDriver());
    }

    @AfterMethod
    public void allureScreenshot() {
        attachScreenshot(getDriver(), "Initial Screenshot");
    }

    @AfterSuite
    protected void StopAppiumServer() {
        if (appiumServiceBuilder != null && appiumServiceBuilder.isRunning()) {
            appiumServiceBuilder.stop();
        }
        serveAllureReport();
    }

    private void serveAllureReport() {
        try {
            String resultsDir = "allure-results";
            ProcessBuilder builder = new ProcessBuilder("allure", "serve", resultsDir);
            builder.inheritIO();
            Process process = builder.start();
            Thread.sleep(20_000);

            process.destroyForcibly();
            System.out.println("Allure report closed after 20 seconds.");

        } catch (Exception e) {
            System.err.println("Failed to serve Allure report: " + e.getMessage());
        }
    }
}