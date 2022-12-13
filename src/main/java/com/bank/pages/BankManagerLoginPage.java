package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class BankManagerLoginPage extends Utility {

    //Declaring WebElement variable to locate web elements
    @CacheLookup
    @FindBy(xpath = "//div[@class='center']//button[@class='btn btn-lg tab']")
    List<WebElement> bankManagerLoginPageOptions;

    //This method will select options available to manager on Manager login page
    public void selectBankManagerLoginPageOptions(String managersOptions) {
        Reporter.log("The Bank manager options are " + bankManagerLoginPageOptions.toString());
        List<WebElement> managerOptions = bankManagerLoginPageOptions;

        for (WebElement options : managerOptions) {
            if (options.getText().equalsIgnoreCase(managersOptions))
                options.click();
        }
        CustomListeners.test.log(Status.PASS, "TThe Bank manager options are \"" + bankManagerLoginPageOptions.toString() + "\"");
    }



}
