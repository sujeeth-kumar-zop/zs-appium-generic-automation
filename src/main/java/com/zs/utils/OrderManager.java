package com.zs.utils;

import org.openqa.selenium.WebElement;

import java.util.*;

public class OrderManager {
    private static List<String> orderIds = new ArrayList<>();

    public static void addOrder(String orderId) {
        orderIds.add(orderId);
    }

    public static List<String> getOrderIds() {
        return orderIds;
    }

    public static String fetchOrderNumber(WebElement orderText) {
        String messageText = orderText.getText();
        return messageText.split(" ")[2];
    }
}

