package com.zopsmart.eazyupdates.appium;

import com.zopsmart.eazyupdates.utils.ReadPropertyLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public static AppiumDriver driver;
    AppiumDriverLocalService appiumServiceBuilder;
    Properties prop = new Properties();
    URL serverUrl;

    @BeforeSuite
    public void launchDevice() throws IOException {
        appiumServiceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/Users/zopsmart/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appiumServiceBuilder.start();

        ReadPropertyLoader.loadPropertiesToSystem(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        serverUrl = new URL("http://127.0.0.1:4723");

        if ("android" .equalsIgnoreCase(System.getProperty("platform"))) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName(System.getProperty("AndroidDevice"))
                    .setApp("/Users/zopsmart/Desktop/projects/eazy-android/mobile-automation/src/test/builds/Hamburger-testtag.apk")
                    .setAutoGrantPermissions(true)
                    .setAppWaitDuration(Duration.ofSeconds(30));

            driver = new AndroidDriver(serverUrl, options);

        } else if ("ios" .equalsIgnoreCase(System.getProperty("platform"))) {
            XCUITestOptions options = new XCUITestOptions()
                    .setDeviceName(System.getProperty("iOSDevice"))
                    .setApp(System.getProperty("iOSBuildPath"))
                    .setAutoAcceptAlerts(true);
            options.setCapability("platformVersion", System.getProperty("iOSPlatformVersion"));
            options.setWdaLaunchTimeout(Duration.ofSeconds(30));


            driver = new IOSDriver(serverUrl, options);
        } else {
            throw new IllegalArgumentException("Unsupported platform: " + System.getProperty("platform"));
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void openHtmlReportAndStopAppiumServer() {
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

        } catch (IOException | InterruptedException e) {
            System.err.println("Failed to serve Allure report: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

}
