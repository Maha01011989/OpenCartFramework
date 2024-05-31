package com.qa.opencart.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    DriverFactory driverFactory;
    protected Properties prop;
    protected LoginPage loginPage;
    protected AccountsPage accountsPage;
    protected SearchResultsPage searchResultsPage;
    protected ProductInfoPage productInfoPage;
    protected RegPage regPage;
    WebDriver driver;
ExtentReports report;
ExtentTest test;


    @BeforeTest
    public void setUp() throws IOException {
        driverFactory = new DriverFactory();
        prop = driverFactory.initProp();
        driver = driverFactory.initDriver(prop);
        loginPage = new LoginPage(driver);
        report = new ExtentReports();
       // test = report.startTest("ExtentDemo");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }
}
