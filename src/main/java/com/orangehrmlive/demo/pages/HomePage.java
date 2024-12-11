package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement userProfileImage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;

    public boolean verifyUserProfileIsDisplayed() {
        Reporter.log("verify user profile image is displayed  " + userProfileImage);
        CustomListeners.test.log(Status.PASS, "verify user profile image is displayed " + userProfileImage);
        return userProfileImage.isDisplayed();
    }

    public void clickOnLogoutButton() {
        clickOnElement(logoutButton);
        Reporter.log("click on " + logoutButton);
        CustomListeners.test.log(Status.PASS, "click on " + logoutButton);
    }
}
