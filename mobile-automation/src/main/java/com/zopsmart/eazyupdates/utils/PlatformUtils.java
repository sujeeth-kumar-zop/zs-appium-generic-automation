package com.zopsmart.eazyupdates.utils;


import java.io.IOException;

public class PlatformUtils {
    public static boolean isIOS() throws IOException {
        return "ios".equalsIgnoreCase(System.getProperty("platform"));
    }
}
