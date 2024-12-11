package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ViewSystemUserPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement successfullyDeletedMessage;

    public String getSuccessDeleteMessage() {
        Reporter.log("get success message : " + successfullyDeletedMessage);
        CustomListeners.test.log(Status.PASS, "get success message :" + successfullyDeletedMessage);
        return getTextFromElement(successfullyDeletedMessage);
    }
}
