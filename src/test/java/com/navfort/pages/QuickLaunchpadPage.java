package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickLaunchpadPage {
    public QuickLaunchpadPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement quickLaunchpadHeader;

}
