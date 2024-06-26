package com.qa.opencart.factory;

import com.qa.opencart.exceptions.BrowserException;
import com.qa.opencart.logger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;

public class DriverFactory {

    WebDriver driver;
    Properties prop;
    OptionsManager optionsManager;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public WebDriver initDriver(Properties prop) {
        optionsManager = new OptionsManager(prop);

        switch (prop.getProperty("browser").toLowerCase()) {
            case "chrome":
                if (Boolean.parseBoolean(prop.getProperty("remote"))) {
                    initRemoteDriver("chrome");
                } else {
                    tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
                    Log.info(prop.getProperty("browser").toLowerCase() + " Browser opened successfully");

                }
                break;
            case "firefox":
                if (Boolean.parseBoolean(prop.getProperty("remote"))) {
                    initRemoteDriver("firefox");
                } else {
                    tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
                    Log.info(prop.getProperty("browser").toLowerCase() + " Browser opened successfully");
                }
                break;
            case "edge":
                if (Boolean.parseBoolean(prop.getProperty("remote"))) {
                    initRemoteDriver("edge");
                } else {
                    tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
                    Log.info(prop.getProperty("browser").toLowerCase() + " Browser opened successfully");
                }
                break;
            case "safari":
                tlDriver.set(new SafariDriver());
                Log.info(prop.getProperty("browser").toLowerCase() + " Browser opened successfully");
                break;
            default:
                // System.out.println("Please enter the right browser " + prop.getProperty("browser"));
                Log.error("Browser name is not entered correctly");
                throw new BrowserException("No browser found");

        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(prop.getProperty("url"));
        return getDriver();
    }

    private void initRemoteDriver(String browserName) {
        try {

            switch (browserName.toLowerCase()) {
                case "chrome":
                    tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getChromeOptions()));
                    break;
                case "firefox":
                    tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getFirefoxOptions()));
                    break;
                case "edge":
                    tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getEdgeOptions()));
                    break;
                default:
                    System.out.println("Please pass the right browser on grid");
                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }


    public Properties initProp() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
        prop.load(fis);
        return prop;
    }

}
