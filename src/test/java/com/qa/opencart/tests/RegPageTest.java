package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

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

    @DataProvider
    public Object[][] getUserDataFromExcel() throws IOException, InvalidFormatException {

        return ExcelUtil.getTestData(AppConstant.REGISTER_SHEET_NAME);
    }


    @Test(dataProvider = "getUserDataFromExcel")
    public void userRegTest(String fName,String lName, String emailId, String pNum, String password, String sub) {
        Assert.assertTrue(regPage.userRegister(fName,lName,StringUtils.getRandomEmailId(),pNum,password,sub));
    }


}
