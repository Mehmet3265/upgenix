package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import org.junit.Assert;

public class Special_page {
    public Special_page(){
    }

    LoginPage loginPage =new LoginPage();

    public void usernameAssertion(){
        String validationMassage = loginPage.usernameBox.getAttribute("validationMessage");
        Assert.assertEquals("Lütfen bu alanı doldurun.",validationMassage);
    }
    public void passwordAssertion(){
        String validationMassage = loginPage.passwordBox.getAttribute("validationMessage");

        Assert.assertEquals("Lütfen bu alanı doldurun.",validationMassage);
    }


    public void login(){
        loginPage.usernameBox.sendKeys(ConfigurationReader.getProperty("web.table.username"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("web.table.pw"));
        loginPage.loginButton.click();
    }






}
