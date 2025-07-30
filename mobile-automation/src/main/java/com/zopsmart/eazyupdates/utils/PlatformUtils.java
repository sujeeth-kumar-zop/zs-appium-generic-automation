package com.zopsmart.eazyupdates.utils;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Allure;
import org.testng.annotations.BeforeSuite;
import java.io.IOException;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class PlatformUtils {
    public static boolean isIOS() throws IOException {
        return  "ios".equalsIgnoreCase(System.getProperty("platform"));
    }
}
