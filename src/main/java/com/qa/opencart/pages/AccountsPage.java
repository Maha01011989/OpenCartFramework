package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {
    WebDriver driver;
    ElementUtil elementUtil;

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }


    private By logoutLink = By.linkText("Logout");
    private By myAccountLink = By.linkText("My Account");
    private By headers = By.cssSelector("div#content h2");
    private By search = By.name("search");
    private By searchIcon = By.cssSelector("div#search button");


    public String getAccPageTitle() {
        String title = elementUtil.waitForTitleIs(AppConstant.ACCOUNTS_PAGE_TITLE, 5);
        System.out.println("Acc page title : " + title);
        return title;
    }

    public String getAccPageURL() {
        String url = elementUtil.waitForURLContains(AppConstant.ACC_PAGE_URL_FRACTION, 5);
        System.out.println("acc page url : " + url);
        return url;
    }

    public boolean isLogoutLinkExist() {
        return elementUtil.waitForElementVisible(logoutLink, 10).isDisplayed();
    }

    public boolean myAccountLinkExist() {
        return elementUtil.waitForElementVisible(myAccountLink, 10).isDisplayed();
    }


    public List<String> getAccountsPageHeadersList() {
        List<WebElement> headersEleList = elementUtil.getElements(headers);
        List<String> headersList = new ArrayList<String>();
        for (WebElement e : headersEleList) {
            String header = e.getText();
            headersList.add(header);
        }
        return headersList;
    }


    public SearchResultsPage doSearch(String SearchKey) {
        System.out.println("searching for : " + SearchKey);
        elementUtil.doClear(search);
        elementUtil.doSendKeys(search, SearchKey);
        elementUtil.doClick(searchIcon);
        return new SearchResultsPage(driver);
    }
}
