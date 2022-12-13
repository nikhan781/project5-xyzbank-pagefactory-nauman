package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    //Declaring WebElement variable to locate web elements
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='borderM box padT20']//button")
    List<WebElement> homePageOptions;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginButton;

    //This method will click on home button
    public void clickOnHomeButton() {
        Reporter.log("Click on Home Button " + homeButton.toString());
        clickOnElement(homeButton);
        CustomListeners.test.log(Status.PASS, "Click on Home Button \"" + homeButton.toString() + "\"");
    }

    //This method will select option available on home page
    public void selectHomePageOptions(String homeOptions) {
        Reporter.log("The home page options are " + homePageOptions.toString());
        List<WebElement> homePageOption = homePageOptions;

        for (WebElement options : homePageOption) {
            if (options.getText().equalsIgnoreCase(homeOptions))
                options.click();
        }
        CustomListeners.test.log(Status.PASS, "The customer options are \"" + homeOptions.toString() + "\"");
    }

    //This method will accept the alert
    public void handleAndAcceptTheAlertMessage() {
        // Reporter.log("Accept Alert ");
        acceptAlert();
        //CustomListeners.test.log(Status.PASS, "Accept Alert ");
    }

    //This method will get the text from alert
    public String getTextFromTheAlertMessage() {
        //Reporter.log("The alert text is " + getTextFromAlert().toString());
        //CustomListeners.test.log(Status.PASS, "The alert text is \"" + getTextFromAlert().toString() + "\"");
        return getTextFromAlert();
    }

    //This method will click on Customer login button
    public void clickOnCustomerLoginButton() {
        Reporter.log("Click on login button" + customerLoginButton.toString());
        clickOnElement(customerLoginButton);
        CustomListeners.test.log(Status.PASS, "Login button clicked ");

    }


}


