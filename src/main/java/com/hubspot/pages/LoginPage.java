package com.hubspot.pages;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    WebDriver driver;
    ElementUtil elementUtil;
    By emailId = By.id("username");
    By password = By.id("password");
    By loginBtn = By.id("loginBtn");

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
        elementUtil = new ElementUtil(driver);
    }

    //Page Actions
    public String getPageTitle(){
        return elementUtil.waitForGetPageTitle(Constants.LOGIN_PAGE_TITLE);
    }

    public HomePage doLogin(String username, String pwd){
        elementUtil.doSendKeys(emailId,username);
        elementUtil.doSendKeys(password,pwd);
        elementUtil.doClick(loginBtn);

//        driver.findElement(emailId).sendKeys(username);
//        driver.findElement(password).sendKeys(pwd);
//        driver.findElement(loginBtn).click();

        return new HomePage(driver);
    }

}
