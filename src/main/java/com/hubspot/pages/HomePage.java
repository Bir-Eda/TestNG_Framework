package com.hubspot.pages;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.constant.Constable;

public class HomePage extends BasePage {
    WebDriver driver;
    ElementUtil elementUtil;

    By header = By.xpath("//*[text()='Setup Guide']");
    By account = By.xpath("//*[@class='account-name ']");
    By contactMainTab = By.id("nav-primary-contacts-branch");
    By contatcChildTab = By.id("nav-secondary-contacts");

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getHomePageTitle(){
        return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
    }

    public String getHeader(){
        return elementUtil.doGetText(header);
    }

    public String verifyLoggedInAccountName(){
        return elementUtil.doGetText(account);
        //return driver.findElement(account).getText();
    }
    //helper method
    private void clickOnContacts(){
        elementUtil.doClick(contactMainTab);
        elementUtil.doClick(contatcChildTab);
    }

    public ContactsPage gotoContactsPage(){
        clickOnContacts();

        return new ContactsPage(driver);
    }
}
