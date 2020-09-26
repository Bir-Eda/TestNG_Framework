package com.hubspot.tests;

import com.hubspot.base.BasePage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class HomePageTest {
    WebDriver driver;
    Properties prop;
    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod
    public void setUp()  {
        basePage = new BasePage();
        prop = basePage.initialize_properties();
        driver= basePage.initialize_driver(prop);
        loginPage = new LoginPage(driver);
        homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 1, description = "get homepage title")
    public void verifyHomePageTitle(){
        String title = homePage.getHomePageTitle();
        System.out.println("Homepage title is: "+title);
        Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);

    }
    @Test(priority = 2, description = "get homepage header")
    public void verifyHomePageHeader(){
        String header = homePage.getHeader();
        System.out.println("Home page header is: "+header);
        Assert.assertEquals(header,Constants.HOME_PAGE_HEADER);
    }
    @Test(priority = 3, description = "get user account name")
    public void verifyLoggedInUserAccount() {
        String account = homePage.verifyLoggedInAccountName();
        System.out.println("Account name is: " + account);
        Assert.assertEquals(account, Constants.ACCOUNT_NAME);
    }
    @AfterMethod
    public void tearDown(){
        basePage.quitBrowser();
    }
}
