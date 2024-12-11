package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    WebElement errorRequiredOfUsername;
    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement errorRequiredOfPassword;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement errorOfInvalidCredentials;


    public void enterUsername(String uName) {
        sendTextToElement(userName, uName);
        Reporter.log("enter user name :" + uName);
        CustomListeners.test.log(Status.PASS, "enter user name" + uName);

    }

    public void enterPassword(String pass) {
        sendTextToElement(password, pass);
        Reporter.log("enter password" + pass);
        CustomListeners.test.log(Status.PASS, "enter password" + pass);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        Reporter.log("click on " + loginButton);
        CustomListeners.test.log(Status.PASS, "click on " + loginButton);
    }

    public void enterUserNameAndPasswordForLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }

    public String getErrorMessageRequiredOfUsername() {
        Reporter.log("get error message " + errorRequiredOfUsername);
        CustomListeners.test.log(Status.PASS, "get error message " + errorRequiredOfUsername);
        return getTextFromElement(errorRequiredOfUsername);
    }

    public String getErrorMessageRequiredOfPassword() {
        Reporter.log("get error message " + errorRequiredOfPassword);
        CustomListeners.test.log(Status.PASS, "get error message " + errorRequiredOfPassword);
        return getTextFromElement(errorRequiredOfPassword);
    }

    public String getErrorMessageOfInvalidCredentials() {
        Reporter.log("get error message " + errorOfInvalidCredentials);
        CustomListeners.test.log(Status.PASS, "get error message " + errorOfInvalidCredentials);
        return getTextFromElement(errorOfInvalidCredentials);
    }

}
