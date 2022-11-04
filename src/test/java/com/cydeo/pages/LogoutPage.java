package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LogoutPage {
    public LogoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//span[@class='oe_topbar_name']")
    public WebElement usernameBar;

    @FindBy (xpath = "//a[@data-menu='logout']")
    public WebElement logout;

    @FindBy (xpath = "//div[@class='o_dialog_warning modal-body']")
    public WebElement message;







}
