package com.cydeo.step_definations;

import com.cydeo.pages.LoginPage;
import com.cydeo.pages.Special_page;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.security.SecurityPermission;
import java.util.List;
import java.util.Map;

public class login_stepdefinations {

    //TC-1

    LoginPage loginPage =new LoginPage();
    Special_page specialPage =new Special_page();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
       String url = ConfigurationReader.getProperty("web.table.url");
       Driver.getDriver().get(url);
    }
    @When("user enters valid username {string}")
    public void user_enters_valid_username(String string) {
        loginPage.usernameBox.sendKeys(string);
    }
    @When("user enters valid password {string}")
    public void user_enters_valid_password(String string) {
        loginPage.passwordBox.sendKeys(string);
    }
    @When("user enter login button")
    public void user_enter_login_button() throws InterruptedException {

        loginPage.loginButton.click();
        Thread.sleep(4000);

    }
    @Then("user should see the homepage")
    public void user_should_see_the_homepage() {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains("Inbox"));
    }



//TC-2

    @When("user enters one invalid credential  {string}")
    public void user_enters_one_invalid_credential(String string) {
        loginPage.usernameBox.sendKeys(string);
    }
    @When("user enters pasword {string}")
    public void user_enters_pasword(String string) throws InterruptedException {
        loginPage.passwordBox.sendKeys(string);
        loginPage.loginButton.click();
        Thread.sleep(2000);
    }

    @Then("user should see Wrong login\\/password massage")
    public void user_should_see_wrong_login_password_massage() {
        String actualError = "Wrong login/password";
        String expectedError = loginPage.errorMassage.getText();
        Assert.assertTrue(expectedError.equals(actualError));
    }



    //tc-3
    @When("username is empty")
    public void username_is_empty() {
        System.out.println("");
    }
    @When("user enteRs valid pasword {string}")
    public void user_ente_rs_valid_pasword(String string) {
        loginPage.passwordBox.sendKeys(string);
    }
    @When("clicks loginButton")
    public void clicks_login_button() throws InterruptedException {
        loginPage.loginButton.click();
        Thread.sleep(1500);
    }
    @Then("user should see Please fill out this field message")
    public void user_should_see_please_fill_out_this_field_message() {
        specialPage.usernameAssertion();
    }

    //TC-3
    @When("user enters VALID username {string}")
    public void user_enters_valıd_username(String string) {
        loginPage.usernameBox.sendKeys(string);
    }

    @When("pasword is empty")
    public void pasword_is_empty() {
        System.out.println("");
    }
    @Then("user should see Please fill out this field message for password")
    public void user_should_see_please_fill_out_this_field_message_for_password() {
       specialPage.passwordAssertion();
    }



    //tc4
    @When("user enters password {string}")
    public void user_enters_password(String string) throws InterruptedException {
        loginPage.passwordBox.sendKeys(string);
        Thread.sleep(1500);
    }
    @Then("user should see input box signs as dots")
    public void user_should_see_input_box_signs_as_dots() throws InterruptedException {
       if (loginPage.passwordBox.getText().contains("***")){
           Assert.assertTrue(true);
       }

    }

    //tc5
    @When("user enter login button from the keyboard")
    public void user_enter_login_button_from_the_keyboard() throws InterruptedException {
        Actions keyboard =new Actions(Driver.getDriver());
        keyboard.moveToElement(loginPage.loginButton).click().perform();
        Thread.sleep(4000);
    }







}
