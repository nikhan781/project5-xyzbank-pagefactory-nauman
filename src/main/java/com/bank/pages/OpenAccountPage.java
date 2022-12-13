package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class OpenAccountPage extends Utility {

    //Creating object to invoke its method
    HomePage homePage = new HomePage();

    //Declaring WebElement variable to locate web elements
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerField;
    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']//option[@value]")
    List<WebElement> currencyField;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;

    //This method will select customer name from drop down menu
    public void selectName(String name) {
        Reporter.log("Select Your Name " + customerField.toString());
        selectByContainsTextFromDropDown(customerField, name);
        CustomListeners.test.log(Status.PASS, "Your Name is \"" + name.toString() + "\"");

    }
    //This method will let customer choose their na,e
    public void selectYourName() {
        Reporter.log("Select Your Name " + customerField.toString());
        selectLastIndexOfDropdownBox(customerField);
        CustomListeners.test.log(Status.PASS, "Your Name is ");
    }

    //This method will select the currency
    public void selectCurrency(String sCurrency) {
        Reporter.log("Select currency " + currencyField.toString());
        List<WebElement> currencyName = currencyField;
        for (WebElement currency : currencyName) {
            if (currency.getText().equalsIgnoreCase(sCurrency)) {
                currency.click();
            }
            CustomListeners.test.log(Status.PASS, "Selected Currency \"" + sCurrency.toString() + "\"");

        }
    }

    //This method will click process button
    public void clickOnProcessButton() {
        Reporter.log("Click on Process Button " + processButton.toString());
        clickOnElement(processButton);
        CustomListeners.test.log(Status.PASS, "Click on Process Button ");

    }
    //this method will have all steps to open an account
    public void openAccount() {
        selectYourName();
        selectCurrency("Pound");
        clickOnProcessButton();
        acceptAlert();
        clickOnElement(homePage.homeButton);
        clickOnElement(homePage.customerLoginButton);
    }

}
