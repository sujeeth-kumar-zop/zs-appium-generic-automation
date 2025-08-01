package com.zopsmart.eazyupdates.UITesting;


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
            System.out.println(" Server initiated (properties not loaded): " + e.getMessage());
        }
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    @BeforeSuite(alwaysRun = true)
    public void startAppiumServer() {

        appiumServiceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File(System.getProperty("AppiumServerPath")))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appiumServiceBuilder.start();
    }

    @BeforeClass(alwaysRun = true)
    public void launchDevice() throws Exception {
        serverUrl = new URL("http://127.0.0.1:4723");
        String platform = System.getProperty("platform").toLowerCase();

        switch (platform) {
            case "android":
                UiAutomator2Options androidOptions = new UiAutomator2Options()
                        .setDeviceName(System.getProperty("AndroidDevice"))
                        .setApp(System.getProperty("AndroidBuildPath"))
                        .setAutoGrantPermissions(true)
                        .setAppWaitDuration(Duration.ofSeconds(30));
                driver.set(new AndroidDriver(serverUrl, androidOptions));
                break;

            case "ios":
                XCUITestOptions iosOptions = new XCUITestOptions()
                        .setDeviceName(System.getProperty("iOSDevice"))
                        .setApp(System.getProperty("iOSBuildPath"))
                        .setAutoAcceptAlerts(true)
                        .setPlatformVersion(System.getProperty("iOSPlatformVersion"))
                        .setWdaLaunchTimeout(Duration.ofSeconds(30));
                driver.set(new IOSDriver(serverUrl, iosOptions));
                break;

            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        try {
            if (driver.get() != null) {
                driver.get().quit();
            }
        } catch (Exception e) {
            System.err.println("Error quitting driver: " + e.getMessage());
        }
        StopAppiumServer();
        serveAllureReport();
    }

    public void StopAppiumServer() {
        if (appiumServiceBuilder != null && appiumServiceBuilder.isRunning()) {
            appiumServiceBuilder.stop();
        }
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
