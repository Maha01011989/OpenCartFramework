package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.WebDriver;

public class AccountsPage {
    WebDriver driver;
    ElementUtil elementUtil;

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }
}
