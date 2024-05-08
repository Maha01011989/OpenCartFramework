package com.qa.opencart.factory;

import com.qa.opencart.exceptions.BrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;

public class DriverFactory {

    WebDriver driver;

    public WebDriver initDriver(String browserName)
    {

        switch (browserName.toLowerCase()){
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "edge":
                driver=new EdgeDriver();
                break;
            case "safari":
                driver=new SafariDriver();
                break;
            default:
                System.out.println("Please enter the right browser "+browserName);
                throw new BrowserException("No browser found");

        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

        return driver;
    }
}
