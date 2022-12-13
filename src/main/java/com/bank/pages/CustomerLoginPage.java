package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    //Declaring WebElement variable to locate web elements
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameText;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement customerLoginButton;
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement yourNameField;

    //This method will get 'Your Name' text on customer login page
    public String getYourNameTextOnCustomerLoginPage() {
        Reporter.log("Your Name Text is " + yourNameText.toString());
        CustomListeners.test.log(Status.PASS, "Your Name Text is \"" + yourNameText.getText() + "\"");
        return getTextFromElement(yourNameText);

    }

    //This method will click on customer login button
    public void clickOnCustomerLoginButton() {
        Reporter.log("Click on Customer Login Button " + customerLoginButton.toString());
        clickOnElement(customerLoginButton);
        CustomListeners.test.log(Status.PASS, "Click on Customer Login Button ");
    }



    //This method will select name of customer
    public void selectCustomerName() throws InterruptedException {
        Reporter.log("Select Your Name " + yourNameField.toString());
        selectLastIndexOfDropdownBox(yourNameField);
        CustomListeners.test.log(Status.PASS, "Your Name is ");
    }
}
