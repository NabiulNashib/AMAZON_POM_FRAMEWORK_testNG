package com.amazon.uiautomation.uiactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomePage {
    public static final Logger log = Logger.getLogger(HomePage.class.getName());
    WebDriver driver;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    WebElement signinButtion;

    @FindBy(xpath = "//input[@id='ap_email']")
    WebElement emailBox;

//    @FindBy(xpath = "//input[@id='continue']")
//    WebElement continueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement passWordBox;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    WebElement signinSubmit;

    @FindBy(xpath = "//span[@class='a-list-item']")
    WebElement expected;

    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    WebElement nameTextBox;

    @FindBy(xpath = "//input[@id='ap_email']")
    WebElement regemailBox;

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement passwordBox;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    WebElement passwordRecheckBox;

    @FindBy(xpath = "//a[@id='auth-fpp-link-bottom']")
    WebElement loginAssertion;



    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginToProfile(String email, String passWord, String rumMode) {
        signinButtion.click();
        log.info("Clicked in signinButton and object is :-" + signinButtion.toString());
        emailBox.sendKeys(email);
        log.info("Entered email address : " + email + " and object is " + emailBox.toString());
//        continueButton.click();
//        log.info("Clicked in continueButton and object is :-" + continueButton.toString());
        passWordBox.sendKeys(passWord);
        log.info("Entered passWord : " + passWord + " and object is " + passWordBox.toString());
        signinSubmit.click();
        log.info("Clicked in signinSubmitButton and object is :- " + signinSubmit.toString());
        String actual = loginAssertion.getText();
        String expected = "Forgot your password?";
        Assert.assertEquals(expected,actual);
        log.info("Assertion done" + "actual :" + actual + " expected :" + expected);
    }
    public void registrationProfiel(String userName, String email, String passWord){
        log.info("Clicked in signinButton and object is :-" + signinButtion.toString());
        signinButtion.click();
        log.info("Clicked in createAnAccountButton and object is :-" + createAnAccountButton.toString());
        createAnAccountButton.click();
        log.info("Enter userName :-" + userName + nameTextBox.toString());
        nameTextBox.sendKeys(userName);
        log.info("Enter email :-" + email + regemailBox.toString());
        regemailBox.sendKeys(email);
        log.info("Enter passWord :-" + passWord + passwordBox.toString());
        passwordBox.sendKeys(passWord);
        log.info("Enter confirmPassWord :-" + passWord + passwordRecheckBox.toString());
        passwordRecheckBox.sendKeys(passWord);
    }

    public String getInvalidLoginText() {
        log.info("error massage is :- " + expected.getText());
        String actual = expected.getText();
        return actual;
    }
}
