package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    ElementUtil elementUtil;

    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By loginButton = By.xpath("//input[@class='btn btn-primary']");
    private By forgotPwdLink = By.linkText("Forgotten Password");

    private By registerLink = By.linkText("Register");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }


    public String getLoginPageTitle() {
        return elementUtil.waitForTitleIs("Account Login", TimeUtil.DEFAULT_Medium_TIME);
    }

    public String getLoginPageURL() {
        return elementUtil.waitForURLContains("account/login", TimeUtil.DEFAULT_Medium_TIME);
    }

    public boolean isForgotPwdLinkDisplayed() {
        return elementUtil.isElementDisplayed(forgotPwdLink);
    }

    public AccountsPage doLogin(String username, String pword) {
        elementUtil.waitForElementVisible(email, TimeUtil.DEFAULT_Medium_TIME).sendKeys(username);
        elementUtil.doSendKeys(password, pword, TimeUtil.DEFAULT_Medium_TIME);
        elementUtil.doClick(loginButton);
        return new AccountsPage(driver);
    }

    public RegPage navigateToRegistrationPage() {
        elementUtil.waitForElementVisible(registerLink,TimeUtil.DEFAULT_Long_TIME).click();
        return new RegPage(driver);
    }
}
