package com.navfort.step_definitions;

import com.navfort.pages.DashboardPage;
import com.navfort.pages.LoginPage;
import com.navfort.pages.QuickLaunchpadPage;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinitions {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    QuickLaunchpadPage quickLaunchpadPage=new QuickLaunchpadPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("url");

    }
    @When("user enters valid  {string} and {string}")
    public void user_enters_valid_and(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));
    }
    @Then("User should land on the {string} page after login")
    public void user_should_land_on_the_page_after_login(String header) {

        String expectedForDriver = header;
        String expectedForSalesAndStoreManager = header;
        String actualForDriver = quickLaunchpadPage.quickLaunchpadHeader.getText();
        String actualForSalesAndStoreManager = dashboardPage.dashboardHeader.getText();


        if (header.equals("Dashboard")) {
            Assert.assertEquals(expectedForSalesAndStoreManager, actualForSalesAndStoreManager);

        } else {

            Assert.assertEquals(expectedForDriver, actualForDriver);
        }


    }



}
