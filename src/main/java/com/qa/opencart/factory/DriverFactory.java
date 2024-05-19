package com.qa.opencart.factory;

import com.qa.opencart.exceptions.BrowserException;
import com.qa.opencart.logger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class DriverFactory {

    WebDriver driver;
    Properties prop;

    public WebDriver initDriver(Properties prop) {

        switch (prop.getProperty("browser").toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                Log.info(prop.getProperty("browser").toLowerCase()+" Browser opened successfully");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                Log.info(prop.getProperty("browser").toLowerCase()+" Browser opened successfully");
                break;
            case "edge":
                driver = new EdgeDriver();
                Log.info(prop.getProperty("browser").toLowerCase()+" Browser opened successfully");
                break;
            case "safari":
                driver = new SafariDriver();
                Log.info(prop.getProperty("browser").toLowerCase()+" Browser opened successfully");
                break;
            default:
               // System.out.println("Please enter the right browser " + prop.getProperty("browser"));
                Log.error("Browser name is not entered correctly");
                throw new BrowserException("No browser found");

        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        return driver;
    }

    public Properties initProp() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
        prop.load(fis);
        return prop;
    }

}
