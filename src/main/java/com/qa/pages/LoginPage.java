package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(id="login-input-loginname")
    WebElement userName;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="button.weiter")
    WebElement continueButton;

    //Initialize the page factory
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyLoginPageTitle(){
        return driver.getTitle();
    }

    public HomePage login(String un,String pasw){
        userName.sendKeys(un);
        password.sendKeys(pasw);

        continueButton.click();
        return new HomePage();

    }


}
