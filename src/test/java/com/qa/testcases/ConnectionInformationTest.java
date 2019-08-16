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

public class ConnectionInformationTest extends TestBase {
    IndexPage indexPage;
    //just for landing Page
    LoginPage loginPage;
    HomePage homePage;
    ConnectionInfoPage connectionInfoPage;

    public ConnectionInformationTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        indexPage=new IndexPage();
        connectionInfoPage=indexPage.searchConnection(prop.getProperty("fromLocation"),prop.getProperty("toLocation"),
                prop.getProperty("fromDate"),prop.getProperty("fromTime"),prop.getProperty("classRadio"));
    }
    @Test(priority = 1)
    public void verifyConnectionPageTitleTest(){
        String title=connectionInfoPage.verifyConnectionPageTitle();
        Assert.assertEquals(title,"DB BAHN - Verbindungen - Ihre Auskunft","Test failed verifyConnectionPageTitleTest");
    }
    @Test(priority = 2)
    public void VerifyFromLocationTest(){
        boolean flag=connectionInfoPage.verifyFromLocation(prop.getProperty("fromLocation"));
        Assert.assertTrue(flag);

    }

    @Test(priority = 3)
    public void VerifyToLocationTest(){
        Boolean flag=connectionInfoPage.verifyToLocation(prop.getProperty("toLocation"));
        Assert.assertTrue(flag);

    }
    @Test(priority = 4)
    public void VerifyConnectionTimeTest(){
        Boolean flag=connectionInfoPage.verifyConnectionTime(prop.getProperty("fromTime"));
        Assert.assertTrue(flag);

    }

    @Test(priority = 5)
    public void VerifyConnectionClasseTest(){
        Boolean flag=connectionInfoPage.verifyConnectionClasse(prop.getProperty("classe"));
        Assert.assertTrue(flag);

    }
    @Test(priority = 6)
    public void verifyMoreConnectionBttonTest(){
        Boolean flag=connectionInfoPage.verifyMoreConnectionButton();
        Assert.assertTrue(flag);
    }
    @Test(priority = 7)
    public void verifyMoreConnectionTableTest(){
        Boolean flag=connectionInfoPage.connectionTableRows();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown(){
//        driver.quit();
    }

}
