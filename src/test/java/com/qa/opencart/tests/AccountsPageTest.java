package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AccountsPageTest extends BaseTest {

    @BeforeClass
    public void accSetUp() {
        accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test
    public void accountsPageTitleTest() {
        String actTitle = accountsPage.getAccPageTitle();
        Assert.assertEquals(actTitle, AppConstant.ACCOUNTS_PAGE_TITLE);
    }

    @Test
    public void accountsPageURLTest() {
        String actURL = accountsPage.getAccPageURL();
        Assert.assertTrue(actURL.contains(AppConstant.ACC_PAGE_URL_FRACTION));
    }

    @Test
    public void isLogoutLinkExistTest() {
        Assert.assertTrue(accountsPage.isLogoutLinkExist());
    }

    @Test
    public void isMyAccountLinkExistTest() {
        Assert.assertTrue(accountsPage.myAccountLinkExist());
    }

    @Test
    public void accountsPageHeadersTest() {
        List<String> actHeadersList = accountsPage.getAccountsPageHeadersList();
        System.out.println(actHeadersList);
    }

    @Test
    public void searchTest() {
        accountsPage.doSearch("macbook");
    }

}
