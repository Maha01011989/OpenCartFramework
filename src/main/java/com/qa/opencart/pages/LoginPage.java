package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By loginButton = By.xpath("//input[@class='btn btn-primary']");
    private By forgotPwdLink = By.linkText("Forgotten Password");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getLoginPageTitle()
    {
        return driver.getTitle();
    }

    public String getLoginPageURL()
    {
        return driver.getCurrentUrl();
    }

    public boolean isForgotPwdLinkDisplayed()
    {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void doLogin(String username,String pword)
    {
        driver.findElement(email).sendKeys(username);
        driver.findElement(password).sendKeys(pword);
        driver.findElement(loginButton).click();
    }


}
