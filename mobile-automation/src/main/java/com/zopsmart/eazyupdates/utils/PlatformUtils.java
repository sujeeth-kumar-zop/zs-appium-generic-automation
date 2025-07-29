package com.zopsmart.eazyupdates.utils;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Allure;
import org.testng.annotations.BeforeSuite;
import java.io.IOException;


import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class PlatformUtils {
    static String platform;
    static String device;
    public static boolean isIOS() throws IOException {
        return  "ios".equalsIgnoreCase(System.getProperty("platform"));
    }

    @BeforeSuite
    public static void logPlatformAndDeviceToAllure() {
        platform = System.getProperty("platform");
        switch (platform.toLowerCase()) {
            case "android":
                device = System.getProperty("AndroidDevice");
                break;
            case "ios":
                device = System.getProperty("iOSDevice");
                break;
            default:
                device = "Unknown Device";
        }

        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Platform", platform)
                        .put("Device", device)
                        .build()
        );
        String info = "Platform: " + platform + "\nDevice: " + device;
        Allure.addAttachment("Test Device Info", "text/plain", info);
    }
}
