package com.amazon.uiautomation.homepage;

import com.amazon.uiautomation.testbase.TestBase;
import com.amazon.uiautomation.uiactions.HomePage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_VerifyLoginWithInvalidCredintioal extends TestBase {
//    WebDriver driver;
    public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredintioal.class.getName());
    protected HomePage homePage;


    @Test
    public void verifyLoginWithInvalidCredintioal(){
//        WebElement signinButtion1 = driver.findElement(By.linkText("Need help?"));
//        signinButtion1.click();
        log.info("------------- Starting verifyLoginWithInvalidCredintioal Test -------------");
        homePage = new HomePage(driver);
        homePage.loginToProfile("test2@gmail.com","pas123","y");

        String expected = "To better protect your account, please re-enter your password " +
                "and then enter the characters as they are shown in the image below.";

        Assert.assertEquals(homePage.getInvalidLoginText(),expected);
        log.info("------------- Finshed verifyLoginWithInvalidCredintioal Test -------------");

    }

}
