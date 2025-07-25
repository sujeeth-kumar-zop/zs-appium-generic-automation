package com.zopsmart.eazyupdates.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Base {
    public AppiumDriverLocalService appiumServiceBuilder;
    public static AndroidDriver driver;

    @BeforeClass
    public void launchDevice() throws IOException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("/Users/zopsmart/Desktop/projects/eazy-android/androidautomation/src/test/builds/Hamburger-testtag.apk");
        options.setDeviceName("Pixel 9 Pro");
        options.setCapability("autoGrantPermissions", true);
        options.setNoReset(false);
        options.setFullReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }
}

