package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DashboardPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-topbar-header-title']//h6")
    WebElement dashboardTitle;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-brand-banner']//img")
    WebElement logo;

    @CacheLookup
    @FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
    WebElement userProfile;

    @CacheLookup
    @FindBy(linkText = "Logout")
    WebElement logOut;

    public String getDashboardTitle() {
        Reporter.log("get the Dashboard page title " + dashboardTitle.toString());
        CustomListeners.test.log(Status.PASS, "Getting dashboard page heading. ");
        return getTextFromElement(dashboardTitle);
    }

    public boolean verifyLogoDisplayed() {
        Reporter.log("Verify the logo is displayed " + logo.toString());
        CustomListeners.test.log(Status.PASS, "Logo is displayed on home page.");
        return logo.isDisplayed();
    }

    public void clickOnUserProfileImage() {
        clickOnElement(userProfile);
        Reporter.log("Click on user profile image " + userProfile.toString());
        CustomListeners.test.log(Status.PASS, "Click on user profile image");
    }

    public void mouseHoverOnLogOutLinkAndClick() {
        mouseHoverToElementAndClick(logOut);
        Reporter.log("Click on logout link " + logOut.toString());
        CustomListeners.test.log(Status.PASS, "Click on log out link");
    }
}
