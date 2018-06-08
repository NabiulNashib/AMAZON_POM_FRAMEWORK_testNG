package com.amazon.uiautomation.testbase;

import com.amazon.uiautomation.excelreader.ExcelReader01;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    @BeforeMethod
    public void setUp(){
        init();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    public static final Logger log = Logger.getLogger(TestBase.class.getName());
    protected WebDriver driver;
    String browser = "chrome";
    String url = "http://www.amazon.com";
    protected ExcelReader01 excel;

    public void init(){
        selectBrowser(browser);
        getUrl(url);

        String log4jConfigPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfigPath);
    }

    public void selectBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
            driver = new ChromeDriver();
            log.info("Creating object of " + browser);
        }
            else if(browser.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/driver/geckodriver32.exe");
                driver = new FirefoxDriver();
                log.info("Creating object of " + browser);
        }
        else if(browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") +"/driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            log.info("Creating object of " + browser);
        }
    }
    public void getUrl(String url){
        log.info("Navigating to : " + url);
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public String [][] getData(String excelName,String sheetName){
        String path = System.getProperty("user.dir")+"/src/main/java/com.amazon.uiautomation.data/" + excelName;
        excel = new ExcelReader01(path);
        String[][] data = excel.getDataFromSheet(excelName, sheetName);
        return data;
    }
}
