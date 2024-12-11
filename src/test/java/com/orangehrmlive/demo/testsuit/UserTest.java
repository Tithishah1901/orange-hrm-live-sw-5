package com.orangehrmlive.demo.testsuit;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class UserTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    SideMenuPage sideMenuPage;
    AdminPage adminPage;
    ViewSystemUserPage viewSystemUserPage;
    AddUserPage addUserPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        sideMenuPage = new SideMenuPage();
        adminPage = new AdminPage();
        viewSystemUserPage = new ViewSystemUserPage();
        addUserPage = new AddUserPage();
    }

    @Test(groups = {"sanity"})
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        //Login to Application
        loginPage.enterUserNameAndPasswordForLogin("Admin", "admin123");
        //click On "Admin" Tab
        sideMenuPage.clickOnTab("Admin");
        //Verify "System Users" Text
        Assert.assertEquals(adminPage.getPageTitle(), "System Users");
        //click On "Add" button
        adminPage.clickOnAddButton();
        //Verify "Add User" Text
        Assert.assertEquals(addUserPage.getAdduserPageTitle(), "Add User");
        //Select User Role "Admin"
        addUserPage.selectUserRoleDropdown("Admin");
        //enter Employee Name "Ananya Dash"
        Thread.sleep(2000);
        addUserPage.enterEmployeeName("a");
        //enter Username
        Thread.sleep(2000);
        addUserPage.enterUserName("Riya");
        //Select status "Disable"
        addUserPage.selectStatusDropdown("Disable");
        //enter password
        addUserPage.enterPassword("Ri1234");
        //enter Confirm Password
        Thread.sleep(2000);
        addUserPage.enterConfirmPassword("Ri1234");
        //click On "Save" Button
        addUserPage.clickOnSaveButton();
        //verify message "Successfully Saved"
        Thread.sleep(2000);
        Assert.assertEquals(addUserPage.getSuccessMessage(), "Successfully Saved");
    }

    @Test(groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {

        String username = "Riya";
        //Login to Application
        loginPage.enterUserNameAndPasswordForLogin("Admin", "admin123");
        //click On "Admin" Tab
        sideMenuPage.clickOnTab("Admin");
        //Verify "System Users" Text
        Assert.assertEquals(adminPage.getPageTitle(), "System Users");
        //Enter Username
        adminPage.enterUserName(username);
        //Select User Role
        adminPage.selectUserRoleFromDropdown("Admin");
        //Select Satatus
        adminPage.selectStatusFromDropdown("Disable");
        // Click on "Search" Button
        adminPage.clickOnSearchButton();
        //Verify the User should be in Result list.
        Assert.assertEquals(adminPage.getUsernameFromSearchResult(), username);
    }

    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {

        String username = "Riya";

        //Login to Application
        loginPage.enterUserNameAndPasswordForLogin("Admin", "admin123");
        //click On "Admin" Tab
        sideMenuPage.clickOnTab("Admin");
        // Verify "System Users" Text
        Assert.assertEquals(adminPage.getPageTitle(), "System Users");
        //Enter Username
        adminPage.enterUserName(username);
        //Select User Role
        adminPage.selectUserRoleFromDropdown("Admin");
        //Select Satatus
        adminPage.selectStatusFromDropdown("Disable");
        //Click on "Search" Button
        adminPage.clickOnSearchButton();
        //Verify the User should be in Result list.
        Assert.assertEquals(adminPage.getUsernameFromSearchResult(), username);
        //Click on Check box
        adminPage.selectTheCheckboxOfUserNameResult();
        //Click on Delete Button
        adminPage.clickOnDeleteButtonInList();
        //Popup will display
        //Click on Ok Button on Popup
        adminPage.clickOnYesDeleteButtonOnPopUp();
        //verify message "Successfully Deleted"
        Assert.assertEquals(viewSystemUserPage.getSuccessDeleteMessage(), "Successfully Deleted");
    }

    @Test(dataProvider = "usertests", dataProviderClass = TestData.class)
    public void searchTheUserAndVerifyTheMessageRecordFound
            (String username, String userRole, String employeeName, String status) throws InterruptedException {
        //Login to Application
        loginPage.enterUserNameAndPasswordForLogin("Admin", "admin123");
        //click On "Admin" Tab
        sideMenuPage.clickOnTab("Admin");
        //Verify "System Users" Text
        Assert.assertEquals(adminPage.getPageTitle(), "System Users");
        //Enter Username <username>
        adminPage.enterUserName(username);
        //Select User Role <userRole>
        adminPage.selectUserRoleFromDropdown(userRole);
        //Enter EmployeeName <employeeName>
        adminPage.enterEmployeeName(employeeName);
        //Select Satatus <status>
        adminPage.selectStatusFromDropdown(status);
        //Click on "Search" Button
        adminPage.clickOnSearchButton();
        //verify message "(1) Record Found"
        Assert.assertEquals(adminPage.getRecordsFound(), "(1) Record Found");
        //Verify username <username>
        Assert.assertEquals(adminPage.getUsernameFromSearchResult(), username);
        //Click on Reset Tab
        adminPage.clickOnResetButton();

    }
}
