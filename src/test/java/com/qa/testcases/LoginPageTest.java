package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.IndexPage;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    public static IndexPage indexPage;
    public static LoginPage loginPage;
    // just for landing Page
    public static HomePage homePage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        indexPage=new IndexPage();
        loginPage=indexPage.clickLoginButton();
    }
    @Test
    public void verifyLoginPageTitleTest(){
        String title=loginPage.verifyLoginPageTitle();
        Assert.assertEquals(title,"DB BAHN - Login","Test failed: Login page title not match" );
    }

    @Test(dependsOnMethods = "verifyLoginPageTitleTest")
    public void loginTest(){
        homePage=loginPage.login(prop.getProperty("name"),prop.getProperty("password"));
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
