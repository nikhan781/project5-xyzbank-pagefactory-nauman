package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {
    //Declaring objects on pages
    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;

    CustomerPage customerPage;
    AccountPage accountPage;
    CustomerLoginPage customerLoginPage;
    //This method will initialize the object
    @BeforeMethod(alwaysRun = true)
    public void pageObjects() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customerPage = new CustomerPage();
        accountPage = new AccountPage();
        customerLoginPage = new CustomerLoginPage();

    }

    //TEST 1
    @Test(groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        //click On "Bank Manager Login" Tab
        homePage.selectHomePageOptions("Bank Manager Login");
        //	click On "Add Customer" Tab
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Add Customer");
        //	enter FirstName
        addCustomerPage.sendTextToFirstNameField("Shaun");
        //	enter LastName
        addCustomerPage.sendTextToLastNameField("Dead");
        //	enter PostCode
        addCustomerPage.sendTextToPostCodeField("BB1 ");
        //	click On "Add Customer" Button
        addCustomerPage.clickOnAddCustomerButton();
        //	verify message "Customer added successfully"
        Assert.assertTrue(homePage.getTextFromTheAlertMessage().contains("Customer added successfully with customer"), "Customer added successfully with customer");
        //	click on "ok" button on popup.
        homePage.handleAndAcceptTheAlertMessage();
    }

    //Test 2
    @Test(groups = {"smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        homePage.selectHomePageOptions("Bank Manager Login");
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Add Customer");
        addCustomerPage.addCustomer();
        //	click On "Open Account" Tab
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Open Account");
        //	Search customer that created in first test
        openAccountPage.selectYourName();
        //	Select currency "Pound"
        openAccountPage.selectCurrency("Pound");
        //	click on "process" button
        openAccountPage.clickOnProcessButton();
        Thread.sleep(1000);
        //	verify message "Account created successfully"
        Assert.assertTrue(homePage.getTextFromTheAlertMessage().contains("Account created successfully with account Number"));
        //	click on "ok" button on popup.
        homePage.acceptAlert();
    }

    //Test 3
    @Test(groups = "regression")
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.selectHomePageOptions("Bank Manager Login");
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Add Customer");
        addCustomerPage.addCustomer();
        //	click On "Open Account" Tab
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Open Account");
        openAccountPage.openAccount();
        homePage.clickOnHomeButton();
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //	search customer that you created.
        customerPage.selectCustomerName();
        //	click on "Login" Button
        customerLoginPage.clickOnCustomerLoginButton();
        Thread.sleep(1500);
        //	verify "Logout" Tab displayed.
        Assert.assertTrue(accountPage.verifyLogoutButton(), "Logout");
        // Assert.assertEquals(accountPage.getTextFromLogoutButton(), "Logout");
        //	click on "Logout"
        accountPage.clickOnLogoutButton();
        //	verify "Your Name" text displayed.
        Assert.assertTrue(customerLoginPage.getYourNameTextOnCustomerLoginPage().contains("Your Name"), "Your Name");
    }

    //Test 4
    @Test(groups = "regression")
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        //Select Bank Manager Login button
        homePage.selectHomePageOptions("Bank Manager Login");
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Add Customer");
        addCustomerPage.addCustomer();
        //	click On "Open Account" Tab
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Open Account");
        openAccountPage.openAccount();
        homePage.clickOnHomeButton();
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //	search customer that you created.
        customerPage.selectCustomerName();
        //	click on "Login" Button
        customerLoginPage.clickOnCustomerLoginButton();
        //	click on "Deposit" Tab.
        accountPage.selectCustomerAccountPageOption("Deposit");
        //	Enter amount 100
        accountPage.sendTextToAmountField("100");
        //	click on "Deposit" Button
        accountPage.clickOnDepositlButton();
        //	verify message "Deposit Successful"
        Assert.assertEquals(accountPage.getDepositSuccessfulMessage(), "Deposit Successful");
    }

    //Test 5
    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        homePage.selectHomePageOptions("Bank Manager Login");
        //Select Add customer option from Manager Menu
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Add Customer");
        addCustomerPage.addCustomer();
        //	click On "Open Account" Tab
        bankManagerLoginPage.selectBankManagerLoginPageOptions("Open Account");
        //Add details of customer
        openAccountPage.openAccount();
        //Select customer name
        customerPage.selectCustomerName();
        //	click on "Login" Button
        customerLoginPage.clickOnCustomerLoginButton();
        accountPage.selectCustomerAccountPageOption("Deposit");
        accountPage.depositCash("100");
        Thread.sleep(1000);
        homePage.clickOnHomeButton();
        Thread.sleep(1000);
        homePage.clickOnCustomerLoginButton();
        Thread.sleep(1000);
        customerLoginPage.selectCustomerName();
        Thread.sleep(1000);
        customerPage.customerLoginButton();
        Thread.sleep(1000);
        accountPage.clickOnWithdrawlOption();
        Thread.sleep(1000);
        //	Enter amount 50
        accountPage.withdrawAmount("50");
        //	click on "Withdraw" Button
        accountPage.clickOnWithdrawlButton();
        //	verify message "Transaction Successful"
        Assert.assertEquals(accountPage.getTransactionSuccessfulText(), "Transaction successful");
    }
}
