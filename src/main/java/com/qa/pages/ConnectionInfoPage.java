package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConnectionInfoPage extends TestBase {
    //*[@id="querySummaryTextual"]/div[1]/div

    @FindBy(xpath ="//*[@id='querySummaryTextual']/div[1]/div" )
    WebElement fromToDestination;

    //*[@id="querySummaryTextual"]/div[3]
    @FindBy(xpath ="//*[@id='querySummaryTextual']/div[3]" )
    WebElement adultAndClasse;

    //*[@id="resultsOverview"]/tbody[8]/tr/td[2]
    @FindBy(xpath = "//*[@id='resultsOverview']/tbody[8]/tr/td[2]")
    WebElement moreConnection;

    //*[@id="resultsOverview"]/tbody
    @FindBy(xpath = "//*[@id='resultsOverview']/tbody")
    WebElement connectionTable;

    //initialize Page object
    public ConnectionInfoPage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyConnectionPageTitle(){

        return driver.getTitle();
    }


    public boolean verifyFromLocation(String fromLcation){
        String divText=fromToDestination.getText();
        System.out.println(divText);
        return divText.contains(fromLcation);

    }

    public boolean verifyToLocation(String toLcation){
        String divText=fromToDestination.getText();
        System.out.println(divText);
        return divText.contains(toLcation);


    }

    public boolean verifyConnectionTime(String connectionTime){
        String divText=fromToDestination.getText();
        System.out.println(divText);
        return divText.contains(connectionTime);
    }

    public boolean verifyConnectionClasse(String classe){
        String divText=adultAndClasse.getText();
        System.out.println(divText);
        return divText.contains(classe);
    }
    public boolean verifyMoreConnectionButton(){
        if(moreConnection.isDisplayed()){
            moreConnection.click();
            return true;
        } else{
            return false;
        }
    }

    public boolean connectionTableRows(){
        WebElement parentTable=driver.findElement(By.xpath("//*[@id='resultsOverview']"));
        if(parentTable.isDisplayed()) {
            List<WebElement> rows = parentTable.findElements(By.xpath("./tbody"));
            System.out.println("Total rows"+rows.size());

            return true;
        }else {
            return false;

        }

    }
}
