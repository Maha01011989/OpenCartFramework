package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.errors.AppError;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String actTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actTitle, AppConstant.LOGIN_PAGE_TITLE, AppError.TITLE_NOT_FOUND);
    }

    @Test(priority = 2)
    public void loginPageURLTest() {
        String actURL = loginPage.getLoginPageURL();
        Assert.assertTrue(actURL.contains(AppConstant.LOGIN_PAGE_URL_FRACTION),AppError.URL_NOT_FOUND);
    }

    @Test(priority = 3)
    public void loginPagePwdLinkExistsTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkDisplayed());
    }

    @Test(priority = 4)
    public void doLogin() {
        loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
}
