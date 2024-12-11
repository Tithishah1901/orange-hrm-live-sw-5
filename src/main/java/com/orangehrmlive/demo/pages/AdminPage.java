package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AdminPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h5")
    WebElement title;

    @CacheLookup
    @FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab --parent --visited']")
    WebElement userManagement;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement btnAdd;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Username']/parent::div/following-sibling::div//input")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement userRollDropDown;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement statusDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement btnSearch;

    @CacheLookup
    @FindBy(xpath = "//div[@role='columnheader'or normalize-space()='Username'][2]/ancestor::div[@role='rowgroup']/following-sibling::div[@class='oxd-table-body']//div[@class='oxd-table-cell oxd-padding-cell'][2]")
    WebElement searchedUserInList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement cbForSearchResultItem;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Delete Selected']")
    WebElement btnDeleteInResultList;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement deletePopUpButtonYes;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Employee Name']/parent::div/following-sibling::div//input")
    WebElement enterEmployeeName;

   /* @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    WebElement recordsFound;*/

    @CacheLookup
    @FindBy(xpath = "//div[@id='oxd-toaster_1']")
    WebElement recordsFound;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetButton;


    public String getPageTitle() {
        Reporter.log("Get page title of : " + title.toString());
        CustomListeners.test.log(Status.PASS, "Get page title");
        return getTextFromElement(title);
    }

    public void clickOnUserManagement() {
        clickOnElement(userManagement);
        Reporter.log("Click on user management Tab : " + userManagement.toString());
        CustomListeners.test.log(Status.PASS, "Click on user management tab");
    }

    public void clickOnJob() {
        clickOnElement(userManagement);
        Reporter.log("click on Job tab : " + userManagement.toString());
        CustomListeners.test.log(Status.PASS, "Click on job tab");
    }

    public void clickOnOrganization() {
        clickOnElement(userManagement);
        Reporter.log("click on organization tab" + userManagement.toString());
        CustomListeners.test.log(Status.PASS, "Click on organization");
    }

    public void clickOnAddButton() {
        clickOnElement(btnAdd);
        Reporter.log("click on add button" + btnAdd.toString());
        CustomListeners.test.log(Status.PASS, "Click on add button");
    }

    public void enterUserName(String uName) {
        sendTextToElement(userName, uName);
        Reporter.log("Enter user name : " + uName);
        CustomListeners.test.log(Status.PASS, "Enter user name : " + uName);
    }

    public void selectUserRoleFromDropdown(String role) {
        mouseHoverToElementAndClick(userRollDropDown);
        typeKeysAndEnter(role.split("")[0]);
        Reporter.log("select user roll from drop down as " + role);
        CustomListeners.test.log(Status.PASS, "select user roll from drop down as " + role);

    }

    public void selectStatusFromDropdown(String status) {
        mouseHoverToElementAndClick(statusDropDown);
        typeKeysAndEnter(status.split("")[0]);
        Reporter.log("select user status from drop down as " + status);
        CustomListeners.test.log(Status.PASS, "select user status from drop down as " + status);
    }

    public void clickOnSearchButton() {
        clickOnElement(btnSearch);
        Reporter.log("Click on search button " + btnSearch.toString());
        CustomListeners.test.log(Status.PASS, "Click on search button ");
    }

    public String getUsernameFromSearchResult() {
        Reporter.log("get user name from search result " + searchedUserInList.toString());
        CustomListeners.test.log(Status.PASS, "get user name from search result");
        return getTextFromElement(searchedUserInList);
    }

    public void selectTheCheckboxOfUserNameResult() {
        clickOnElement(cbForSearchResultItem);
        Reporter.log("Click on search result item check box " + cbForSearchResultItem.toString());
        CustomListeners.test.log(Status.PASS, "Click on search result item check box");
    }

    public void clickOnDeleteButtonInList() {
        clickOnElement(btnDeleteInResultList);
        Reporter.log("Click on search result item delete button " + btnDeleteInResultList.toString());
        CustomListeners.test.log(Status.PASS, "Click on search result item delete button");
    }

    public void clickOnYesDeleteButtonOnPopUp() {
        clickOnElement(deletePopUpButtonYes);
        Reporter.log("Click on delete popup yes button " + deletePopUpButtonYes.toString());
        CustomListeners.test.log(Status.PASS, "Click on delete popup yes button");
    }

    public void enterEmployeeName(String empName) throws InterruptedException {
        sendTextToElement(enterEmployeeName, empName);
        Thread.sleep(5000);
        selectAutoPopulateFirstEntryByArrowKeysAndEnter(enterEmployeeName);
        Reporter.log("Enter the Employee Name "+empName);
        CustomListeners.test.log(Status.PASS,"Enter the employee Name  "+empName);
    }

    public String getRecordsFound(){
        Reporter.log("Get the records found. "+recordsFound.toString());
        CustomListeners.test.log(Status.PASS,"Get the records found. "+recordsFound.toString());
        return getTextFromElement(recordsFound);
    }

    public void clickOnResetButton(){
        clickOnElement(resetButton);
        Reporter.log("Clicking on Reset button "+resetButton.toString());
        CustomListeners.test.log(Status.PASS,"Clicking on Reset button "+resetButton.toString());
    }

}
