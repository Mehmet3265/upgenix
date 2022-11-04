package com.cydeo.step_definations;

import com.cydeo.pages.LoginPage;
import com.cydeo.pages.LogoutPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class logout_stepdefinations {
    LogoutPage logoutPage =new LogoutPage();
    LoginPage loginPage = new LoginPage();

    @When("user selects the log out option from topbar dropdown")
    public void user_selects_the_log_out_option_from_topbar_dropdown() throws InterruptedException {
        logoutPage.usernameBar.click();
        logoutPage.logout.click();
        Thread.sleep(3000);
    }
    @Then("user should see the login page")
    public void user_should_see_the_login_page() {
      Assert.assertTrue( loginPage.loginpageMessage.isDisplayed());
    }




    @When("user clicks the step back button")
    public void user_clicks_the_step_back_button() {
       Driver.getDriver().navigate().back();
    }

    @Then("user should see Odoo Session Expired is dissplayed")
    public void user_should_see_is_dissplayed() {
        Assert.assertTrue(logoutPage.message.isDisplayed());
    }




    @And("user closes all the tabs")
    public void userClosesAllTheTabs() {
       Set<String > windows = Driver.getDriver().getWindowHandles();
        for (String each : windows) {
            Driver.getDriver().switchTo().window(each).close();
        }
    }

    @Then("user should be logged out")
    public void userShouldBeLoggedOut() {

    }
}
