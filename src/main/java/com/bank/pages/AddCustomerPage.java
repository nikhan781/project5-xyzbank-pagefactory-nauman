package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {


    //Declaring WebElement variable to locate web elements

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcodeField;
    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement addCustomerButton;

    //This method will send text to first name field
    public void sendTextToFirstNameField(String fNames) {
        Reporter.log("Enter First Name  " + fNames + firstNameField.toString());
        sendTextToElement(firstNameField, fNames + getAlphaNumericString(3));
        CustomListeners.test.log(Status.PASS, "First Name is \"" + fNames + "\"");
    }

    //This method will send text to last name field
    public void sendTextToLastNameField(String lNames) {
        Reporter.log("Enter Last Name  " + lNames + lastNameField.toString());
        sendTextToElement(lastNameField, lNames + getAlphaNumericString(3));
        CustomListeners.test.log(Status.PASS, "Last Name is \"" + lNames + "\"");
    }

    //This method will send text to first name field
    public void sendTextToPostCodeField(String postCode) {
        Reporter.log("Enter Postcode  " + postCode + postcodeField.toString());
        sendTextToElement(postcodeField, postCode + getAlphaNumericString(3));
        CustomListeners.test.log(Status.PASS, "Postcode is \"" + postCode + "\"");
    }

    //This method will click on Add Customer Button
    public void clickOnAddCustomerButton() {
        Reporter.log("Click on Add Customer Button " + addCustomerButton.toString());
        clickOnElement(addCustomerButton);
        CustomListeners.test.log(Status.PASS, "Click on Add Customer Button ");
    }

    public void addCustomer() {
        sendTextToFirstNameField("Prime");
        sendTextToLastNameField("Testing");
        sendTextToPostCodeField("BB1 ");
        clickOnAddCustomerButton();
        acceptAlert();
    }


}
