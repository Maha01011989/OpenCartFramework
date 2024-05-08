package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageTitleTest() {
        String actTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actTitle, "Account Login");
    }

    @Test
    public void loginPageURLTest() {
        String actURL = loginPage.getLoginPageURL();
        Assert.assertTrue(actURL.contains("route=account/login"));
    }

    @Test
    public void loginPagePwdLinkExistsTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkDisplayed());
    }

    @Test
    public void doLogin() {
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
}
