package com.amazon.browsers;

import com.amazon.uiautomation.testbase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Browsers extends TestBase {
    public Browsers(WebDriver driver){
        this.driver = driver;
    }

    @Parameters("browserName")
    @BeforeClass
    public void beforeClass(String browserName){
        if(browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/driver/geckodriver32.exe");
            driver = new FirefoxDriver();
        }
    }
}
