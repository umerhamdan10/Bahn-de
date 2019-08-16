package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class IndexPage extends TestBase {

    //create own xpath( xpath="//header[@type or name or class =value ]")
    @FindBy(xpath = "//ul[@class='main-nav-right' ]//li[@class='loginform']//font[text()='Login']")
    WebElement login;

    @FindBy(id="js-auskunft-autocomplete-from")
    WebElement vonReiseauskunft;

    //*[@id="js-auskunft-autocomplete-to"]
    @FindBy(id="js-auskunft-autocomplete-to")
    WebElement nachReiseauskunft;

    //*[@id="js-tab-auskunft"]/div/form/fieldset[5]/div/font[1]/font/font/font/input
    @FindBy(css = "input[class='btn pull-right js-submit-btn']")
    WebElement suchenReiseauskunft;

    @FindBy(className = "btn pull-right js-submit-btn")
    WebElement search;

    @FindBy(id="dp1565905251647")
    WebElement fromDate;

    @FindBy(xpath ="//*[@id='js-auskunft-timeinput']//input[@name='time']")
    WebElement fromTime;

    //*[@title="1st class" and @for="radio07"]
    @FindBy(xpath ="//*[@for='radio07']")
    WebElement firstClassRadioButton;



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

    public ConnectionInfoPage searchConnection(String startFrom,String endTo){

        vonReiseauskunft.sendKeys(startFrom);
        nachReiseauskunft.sendKeys(endTo);
        suchenReiseauskunft.click();
        //demy
        return new ConnectionInfoPage();

    }

    public ConnectionInfoPage searchConnection(String startFrom,String endTo,String date, String time,String cradio) {
        vonReiseauskunft.click();
        vonReiseauskunft.sendKeys(startFrom);
        nachReiseauskunft.sendKeys(endTo);
//        fromDate.sendKeys(date);
        fromTime.clear();
        fromTime.sendKeys(time);

        if (cradio.equals("true")){
            firstClassRadioButton.click();
    }
        suchenReiseauskunft.click();
        //demy
        return new ConnectionInfoPage();

    }
    //        WebElement element = driver.findElement(By.cssSelector("input[class='btn pull-right js-submit-btn']"));
//        element.click();
}
