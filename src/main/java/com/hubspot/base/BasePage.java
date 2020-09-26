package com.hubspot.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author Orhan Demirci
 */
public class BasePage {
    public WebDriver driver;
    public Properties prop;
    public static String flash;

    /**
     *
     * @return
     * @throws InterruptedException
     */
    public  WebDriver initialize_driver(Properties prop)  {
        //String browser = "chrome";
        String browser = prop.getProperty("browser");
        String headless = prop.getProperty("headless");
        flash = prop.getProperty("elementflash");
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            if(headless.equals("yes")){
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--headless");
                driver = new ChromeDriver(co);
            }
            else{
                driver = new ChromeDriver();
            }

        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            if(headless.equals("yes")){
                FirefoxOptions co = new FirefoxOptions();
                co.addArguments("--headless");
                driver = new FirefoxDriver(co);
            }
            else{
                driver = new FirefoxDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        String url = prop.getProperty("url");
        driver.get(url);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return driver;
    }

    /**
     *
     * @return
     */
    public Properties initialize_properties(){
        prop = new Properties();
        try{
            FileInputStream ip = new FileInputStream("C:\\Users\\demir\\SiliconeLabTestNGFramework\\src\\main\\java\\config" +
                    "\\hubspot\\config\\config.properties");
            prop.load(ip);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }
 public void quitBrowser(){
        try{
            driver.quit();
        }
        catch(Exception e){
            System.out.println("some exception occured while quitting the browser");
     }
 }
    public void closeBrowser(){
        try{
            driver.close();
        }
        catch(Exception e){
            System.out.println("some exception occured while closing the browser");
        }
    }

}
