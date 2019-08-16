package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.ConnectionInfoPage;
import com.qa.pages.HomePage;
import com.qa.pages.IndexPage;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IndexPageTest extends TestBase {
    IndexPage indexPage;
    //just for landing Page
    LoginPage loginPage;
    HomePage homePage;
    ConnectionInfoPage connectionInfoPage;


    public IndexPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        indexPage=new IndexPage();
    }
    @Test(priority = 1)
    public void indexPageTitleTest(){
        String expectedTitle="Deutsche Bahn: bahn.de - Ihr Mobilitätsportal für Reisen, Bahn, Urlaub, Hotels, Städtereisen und Mietwagen";
        String title=indexPage.verifyIndexPageTitle();
        Assert.assertEquals(title,expectedTitle,"Test failed: Title not match");
    }

    @Test(priority = 2)
    public void clickLoginButtonTest(){
        loginPage=indexPage.clickLoginButton();
    }

    @Test(priority = 3)
    public void searchConnectionTest(){
        connectionInfoPage=indexPage.searchConnection(prop.getProperty("fromLocation"),prop.getProperty("toLocation"));
    }

    @Test(priority = 4)
    public void searchConnectionWithTimeTest(){
        connectionInfoPage=indexPage.searchConnection(prop.getProperty("fromLocation"),prop.getProperty("toLocation"),
                prop.getProperty("fromDate"),prop.getProperty("fromTime"),prop.getProperty("classRadio"));
    }



    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}
