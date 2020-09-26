package com.hubspot.pages;

import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;
import com.hubspot.util.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage {
    WebDriver driver;
    ElementUtil elementUtil;
    JavaScriptUtil jsUtil;

    //Locators
    By createContactButton = By.xpath("//div[@class='nav-left']//a[@id='nav-primary-contacts-branch']");
    By createContactButton2 = By.xpath("(//li[@class='expandable active']//div[@class='secondary-nav expansion']//a//div)[position()=1]");
    By email = By.xpath("//input[@name='textInput']");
    By firstName = By.xpath("//input[@class='form-control private-form__control' and @data-field='firstname']");
    By lastName = By.xpath("//input[@class='form-control private-form__control' and @data-field='lastname']");
    By jobTitle = By.xpath("//input[@class='form-control private-form__control' and @data-field='jobtitle']");
    By createBtn = By.xpath("//button[@class='uiButton private-button private-button--primary private-button--default add-obj private-button--non-link']");
    By createContactFormBtn = By.xpath("//div[@class='private-layer']//li[1]");

    public ContactsPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
        jsUtil = new JavaScriptUtil();
    }
    public String getConctactsPageTitle() {
        return elementUtil.waitForGetPageTitle(Constants.CONTACTS_PAGE_TITLE);
    }

    public void createNewConctact(String emailID, String FN, String LN, String jobTitleVal) throws InterruptedException{

        elementUtil.doClick(createContactButton);
        Thread.sleep(2000);
        elementUtil.doClick(createContactButton2);
        Thread.sleep(2000);
        elementUtil.doClick(createBtn);
        Thread.sleep(2000);
        elementUtil.doSendKeys(email, emailID);
        Thread.sleep(2000);
        elementUtil.doSendKeys(firstName, FN);
        Thread.sleep(2000);
        elementUtil.doSendKeys(lastName, LN);
        Thread.sleep(2000);
        elementUtil.doSendKeys(jobTitle, jobTitleVal);
        Thread.sleep(2000);
        elementUtil.doClick(createContactFormBtn);
        Thread.sleep(2000);

    }
}
