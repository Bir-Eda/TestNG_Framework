package com.hubspot.pages;

import com.hubspot.util.ElementUtilPF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPF {
    WebDriver driver;
    ElementUtilPF elementUtilPF;

    public LoginPF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementUtilPF = new ElementUtilPF(driver);
    }

    @FindBy( how = How.ID, using = "username")
    WebElement emailID;

    @FindBy( how = How.ID, using = "password")
    WebElement password;

    @FindBy( how = How.ID, using = "loginBtn")
    WebElement loginButton;
//Page Factory == @FindBy
    public void doLogin(String username, String pwd){
        elementUtilPF.waitForElementPresent(emailID);
        emailID.sendKeys(username);
        password.sendKeys(pwd);
        loginButton.click();

    }
}
