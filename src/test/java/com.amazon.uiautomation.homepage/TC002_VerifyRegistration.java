package com.amazon.uiautomation.homepage;

import com.amazon.uiautomation.testbase.TestBase;
import com.amazon.uiautomation.uiactions.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TC002_VerifyRegistration extends TestBase {
//  WebDriver driver;
    public static final Logger log = Logger.getLogger(TC002_VerifyRegistration.class.getName());
    HomePage homePage;

    @Test
    public void verifyRegistration(){
//        WebElement signinButtion1 = driver.findElement(By.linkText("Need help?"));
//        signinButtion1.click();
        log.info("---------- verifyRegistration test started -----------");
         homePage = new HomePage(driver);
         homePage.registrationProfiel("demo.nashib","nashib.freelancer@gmail.com","pass1234");
         log.info("---------- verifyRegistration test finished -----------");

    }

    @AfterTest
    public void endTest(){
//        driver.close();
    }
}
