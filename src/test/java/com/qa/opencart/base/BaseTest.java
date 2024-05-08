package com.qa.opencart.base;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    DriverFactory driverFactory;
    protected LoginPage loginPage;
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver("chrome");
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }

}
