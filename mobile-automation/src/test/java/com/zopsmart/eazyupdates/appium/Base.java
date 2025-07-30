package com.zopsmart.eazyupdates.appium;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;


public class Base {
    public AppiumDriver driver;
    public Properties props = new Properties();
    public AppiumDriverLocalService appiumServiceBuilder;
    public URL serverUrl;


    @BeforeSuite
    public void startAppiumServer(){
        try (FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties")) {
            props.load(input);
        } catch (Exception e) {
            System.out.println("Server initiated");
        }
        appiumServiceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File(props.getProperty("AppiumServerPath")))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appiumServiceBuilder.start();
    }

    @BeforeClass
    public void launchDevice() throws MalformedURLException {
        serverUrl = new URL("http://127.0.0.1:4723");

        if ("android".equalsIgnoreCase(props.getProperty("platform"))) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName(props.getProperty("AndroidDevice"))
                    .setApp(props.getProperty("AndroidBuildPath"))
                    .setAutoGrantPermissions(true)
                    .setAppWaitDuration(Duration.ofSeconds(30));

            driver = new AndroidDriver(serverUrl, options);

        } else if ("ios".equalsIgnoreCase(System.getProperty("platform"))) {
            XCUITestOptions options = new XCUITestOptions()
                    .setDeviceName(props.getProperty("iOSDevice"))
                    .setApp(props.getProperty("iOSBuildPath"))
                    .setAutoAcceptAlerts(true);
            options.setCapability("platformVersion", props.getProperty("iOSPlatformVersion"));
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
