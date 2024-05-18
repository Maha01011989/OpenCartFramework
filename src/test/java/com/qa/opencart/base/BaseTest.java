package com.qa.opencart.base;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
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
    WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException {
        driverFactory = new DriverFactory();
        prop = driverFactory.initProp();
        driver = driverFactory.initDriver(prop);
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }

}
