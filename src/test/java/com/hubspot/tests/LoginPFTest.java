package com.hubspot.tests;

import com.hubspot.base.BasePage;
import com.hubspot.pages.LoginPF;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPFTest {
    WebDriver driver;
    Properties prop;
    BasePage basePage;
    LoginPF loginPF;

    @BeforeMethod
    public void setUp(){
        basePage = new BasePage();
        prop = basePage.initialize_properties();
        driver = basePage.initialize_driver(prop);
        loginPF = new LoginPF(driver);
    }
    @Test
    public void loginTest(){
        loginPF.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
    @AfterMethod
    public void tearDown(){
        basePage.quitBrowser();
    }
}
