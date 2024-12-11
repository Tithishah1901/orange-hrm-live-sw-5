package com.orangehrmlive.demo.testsuit;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
    }

    @Test(groups = {"sanity"})
    public void verifyUserShouldLoginSuccessFully() {
        //Enter username
        //Enter password
        loginPage.enterUserNameAndPasswordForLogin("Admin", "admin123");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {
        //Login To The application
        loginPage.enterUserNameAndPasswordForLogin("Admin", "admin123");
        //Verify Logo is Displayed
        Assert.assertEquals(homePage.verifyUserProfileIsDisplayed(), true);
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() {
        //Login To The application
        loginPage.enterUserNameAndPasswordForLogin("Admin", "admin123");
        //Click on User Profile logo
        dashboardPage.clickOnUserProfileImage();
        //Mouse hover on "Logout" and click
        dashboardPage.mouseHoverOnLogOutLinkAndClick();

    }

    @Test(dataProvider = "credentials",dataProviderClass = TestData.class)
    public void verifyErrorMessageWithInvalidCredentials(String username, String pass, String errorMsg) {
        //Enter username <username>
       //Enter password <password>
       //Click on Login Button
        loginPage.enterUserNameAndPasswordForLogin(username, pass);
        //Verify Error message <errorMessage>
        if (!username.equalsIgnoreCase("")
                && !pass.equalsIgnoreCase("")) {
            Assert.assertEquals(loginPage.getErrorMessageOfInvalidCredentials(), errorMsg);
        } else if (username.equalsIgnoreCase("")
                && pass.equalsIgnoreCase("")) {
            Assert.assertEquals(loginPage.getErrorMessageRequiredOfUsername(), errorMsg);
        } else if (username.equalsIgnoreCase("") && !pass.equalsIgnoreCase("")) {
            Assert.assertEquals(loginPage.getErrorMessageRequiredOfUsername(), errorMsg);
        } else {
            Assert.assertEquals(loginPage.getErrorMessageRequiredOfPassword(), errorMsg);
        }

    }


    }

