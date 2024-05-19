package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegPageTest extends BaseTest {

    @BeforeClass
    public void regSetUp() {
        regPage = loginPage.navigateToRegistrationPage();
    }

    @DataProvider
    public Object[][] getUserData() {

        return new Object[][]{
                {"Gaurav", "Gupta", StringUtils.getRandomEmailId(), "1234123412", "Password@123", "Yes"},
                {"Ohm", "Lakshmi", StringUtils.getRandomEmailId(), "1234123412", "Password@123", "No"},
                {"Shilpa", "Rithu", StringUtils.getRandomEmailId(), "1234123412", "Password@123", "Yes"}
        };
    }


    @Test(dataProvider = "getUserData")
    public void userRegTest(String fName,String lName, String emailId, String pNum, String password, String sub) {
        Assert.assertTrue(regPage.userRegister(fName,lName,emailId,pNum,password,sub));
    }


}
