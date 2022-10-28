package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(id = "prependedInput")
    public WebElement username;


    @FindBy(id = "prependedInput2")
    public WebElement password;


    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(id="remember_me")
    public WebElement rememberMeButton;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement warningWithTwoInvalid;

    String actualValidationMessageForEmptyPasswordField= password.getAttribute("validationMessage");
    String actualValidationMessageForEmptyUsernameField= username.getAttribute("validationMessage");

    public  void assertWarningMessage(String warningMessage){

        if(warningMessage.equals("Invalid user name or password.")){

            Assert.assertEquals(warningMessage,warningWithTwoInvalid.getText());

        } else if (warningMessage.equals("Please fill out this field.")) {
            Assert.assertEquals(warningMessage,actualValidationMessageForEmptyPasswordField);
        }


    }









}
