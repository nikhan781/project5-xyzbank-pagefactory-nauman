package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage extends Utility {

    //Declaring WebElement variable to locate web elements
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement yourNameField;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement loginButton;

    //This method will select name of customer
    public void selectCustomerName() {
        Reporter.log("Select Your Name " + yourNameField.toString());
        selectLastIndexOfDropdownBox(yourNameField);
        CustomListeners.test.log(Status.PASS, "Your Name is ");
    }

    //This method will click on customer login button
    public void customerLoginButton() {
        Reporter.log("Click on login button" + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Login button clicked ");


    }

}
