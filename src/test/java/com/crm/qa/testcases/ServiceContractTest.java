package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ObjectHomePage;
import com.crm.qa.pages.SelectObjectRecordTypePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ServiceContractTest extends TestBase {

    LoginPage loginpage;
    HomePage homepage;
    ObjectHomePage objHomePage;
    SelectObjectRecordTypePage RecTypePage;

    public ServiceContractTest()
    {
        super();
    }

    @BeforeClass
    public void Setup()
    {
        initialization();
        loginpage = new LoginPage();
        homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
    }


    public void CreateNewServiceContractTest(){

        objHomePage = homepage.ClickAnyTabOnHomePage("Contacts");
        Assert.assertTrue(homepage.ValidateTabLabelDisplayed("Contacts"),"Label Does not exist");

        RecTypePage = objHomePage.ClickOnNewButton();



    }

    @AfterClass
    public void TearDown()
    {
        driver.quit();
    }

}
