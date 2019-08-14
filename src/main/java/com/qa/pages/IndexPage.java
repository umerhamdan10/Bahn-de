package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends TestBase {

    //create own xpath( xpath="//header[@type or name or class =value ]")
    @FindBy(xpath = "//ul[@class='main-nav-right' ]//li[@class='loginform']//font[text()='Login']")
    WebElement login;

    //initialize Page object
    public IndexPage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyIndexPageTitle(){
        return driver.getTitle();
    }

    public LoginPage clickLoginButton(){
        //login.click();
        driver.findElement(By.linkText("Login")).click();
        return new LoginPage();

    }
}
