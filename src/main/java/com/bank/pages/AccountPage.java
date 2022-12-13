package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class AccountPage extends Utility {

    //Declaring WebElement variable to locate web elements
    @CacheLookup
    @FindBy(xpath = "//div[@class='box mainhdr']/button[2]")
    WebElement logoutButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']/div[3]//button")
    List<WebElement> customerAccountPageOptions;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountToBeDepositedField;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositButton;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement withdrawlButton;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessfulMessage;
    @CacheLookup
    @FindBy(xpath = "//div[@class='ng-scope']/span[@ng-show='message']")
    WebElement transactionSuccessfulMessage;

    @CacheLookup
    @FindBy(xpath = "//input[@type='number']")
    WebElement withdrawlFiled;

    @CacheLookup
    @FindBy(xpath = "(//button[@class='btn btn-lg tab'])[3]")
    WebElement withdrawlOption;

    //This method will verify Logout button
    public boolean verifyLogoutButton() {
        Reporter.log("Click on Login Button " + logoutButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on Login Button ");
        return verifyThatElementIsDisplayed(logoutButton);
    }


    //this method will click on 'Logout' button
    public void clickOnLogoutButton() {
        Reporter.log("Click on Logout Button " + logoutButton.toString());
        clickOnElement(logoutButton);
        CustomListeners.test.log(Status.PASS, "Click on Logout Button ");

    }

    //This method will select options available to customers
    public void selectCustomerAccountPageOption(String customerOption) {
        Reporter.log("The customer options are " + customerAccountPageOptions.toString());
        List<WebElement> options = customerAccountPageOptions;

        for (WebElement e : options) {
            if (e.getText().equalsIgnoreCase(customerOption)) {
                e.click();
            }
        }
        CustomListeners.test.log(Status.PASS, "The customer options are \"" + customerAccountPageOptions.toString() + "\"");

    }

    //This method will send the amount figure to amount field
    public void sendTextToAmountField(String amount) {
        Reporter.log("The deposit amount is " + amountToBeDepositedField.toString());
        sendTextToElement(amountToBeDepositedField, amount);
        CustomListeners.test.log(Status.PASS, "The deposit amount is \"" + amount.toString() + "\"");
    }

    //This method will click on 'Deposit' button
    public void clickOnDepositlButton() {
        Reporter.log("Click on Deposit Button " + depositButton.toString());
        clickOnElement(depositButton);
        CustomListeners.test.log(Status.PASS, "Click on Deposit Button ");
    }

    //This method will return text for successful message
    public String getDepositSuccessfulMessage() {

        Reporter.log("Deposit successful " + depositSuccessfulMessage.toString());
        CustomListeners.test.log(Status.PASS, "Deposit successful \"" + depositSuccessfulMessage.getText() + "\"");
        return getTextFromElement(depositSuccessfulMessage);
    }

    //this method will get these
    public String getTransactionSuccessfulText() {
        Reporter.log("Transaction successful message " + transactionSuccessfulMessage.toString());
        CustomListeners.test.log(Status.PASS, "Transaction successful message is ");
        return getTextFromElement(transactionSuccessfulMessage);
    }

    //this method will send text to deposit amount field and click on deposit button
    public void depositCash(String amount) {
        Reporter.log("Send text to deposit field and click deposit button ");
        sendTextToAmountField(amount);
        clickOnDepositlButton();
        CustomListeners.test.log(Status.PASS, "Amount deposited " + amount);

    }

    //This mehtod will send text to amount withdrawl field
    public void withdrawAmount(String amount) {
        Reporter.log("Send text to withdrawl field " + withdrawlFiled.toString());
        sendTextToElement(withdrawlFiled, amount);
        CustomListeners.test.log(Status.PASS, "Amount withdrawl " + amount);

    }

    //Click on WIthdrawl button
    public void clickOnWithdrawlButton() {
        Reporter.log("Click on Deposit Button " + withdrawlButton.toString());
        clickOnElement(withdrawlButton);
        CustomListeners.test.log(Status.PASS, "Click on Withdraw Button ");
    }
    //Click on WIthdrawl button

    public void clickOnWithdrawlOption() {
        Reporter.log("Click on Deposit Button " + withdrawlOption.toString());
        clickOnElement(withdrawlOption);
        CustomListeners.test.log(Status.PASS, "Click on Withdraw Button ");
    }

}