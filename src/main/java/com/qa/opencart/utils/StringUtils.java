package com.qa.opencart.utils;

public class StringUtils {

    public static String getRandomEmailId() {
        String emailId = "testautomation" + System.currentTimeMillis() + Math.random() + "@opencart.com";
        return emailId;
    }

}
