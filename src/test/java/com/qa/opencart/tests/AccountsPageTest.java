package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import org.testng.annotations.BeforeClass;

public class AccountsPageTest extends BaseTest {

    @BeforeClass
    public void accSetUp()
        {
            loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        }

}
