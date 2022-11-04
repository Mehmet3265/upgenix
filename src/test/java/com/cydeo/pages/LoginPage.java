package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class LoginPage {

    public LoginPage(){
            PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//input[@name='login']")
    public WebElement usernameBox;

    @FindBy (xpath ="//input[@name='password']" )
    public WebElement passwordBox;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement loginButton;

    @FindBy (xpath = "//p[@class='alert alert-danger']")
    public WebElement errorMassage;

    @FindBy (xpath = "//a[@class='navbar-brand']")
    public WebElement loginpageMessage;
}
