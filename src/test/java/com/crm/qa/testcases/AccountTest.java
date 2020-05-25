package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.utilities.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;

public class AccountTest extends TestBase {

    LoginPage loginpage;
    HomePage homepage;
    ObjectHomePage objHomePage;
    SelectObjectRecordTypePage RecTypePage;
    AccountEditPage accEditpage;
    AccountDetailsPage accDetailspage;


    public AccountTest()
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

   @Test(priority = 1)
    public void VerifyCreateNewAccountTest() throws InterruptedException {

        objHomePage = homepage.ClickAnyTabOnHomePage("Accounts");
        Assert.assertTrue(homepage.ValidateTabLabelDisplayed("Accounts"),"Label Does not exist");

        RecTypePage = objHomePage.ClickOnNewButton();
        RecTypePage.SelectRecordType("Residential");

        accEditpage = new AccountEditPage();

        accDetailspage = accEditpage.CreateNewAccount("AutoTestAcc1","No","Standardized","Google Maps","USA:NV:LAS VEGAS:SILENT WATER WAY:7370:89149","36.295095400000000","-115.307233100000000","ROOFTOP","PST","true","702","04","018","004");
        Assert.assertTrue(accDetailspage.ValidateVisibilityofEditButton());

    }

    @Test(priority = 2,enabled=false)
    public void VerifyEditAddressInformationTest() throws InterruptedException {

        homepage.PerformGlobalSearch("AutoTestAcc1");
        accDetailspage = new AccountDetailsPage();
        Assert.assertTrue(accDetailspage.ValidateAccountDetailLabel());
        accDetailspage.FillAddressInformation("7370 Silent Water Way","Las Vegas","NV","89149","USA","Clark","(256) 283-3633","Las Vegas","Clark","REAVES", "REAVES KATHRYN RUTH (TE)","SFR (single family residence)","CLEARWATER EST PLAT BOOK 134 PAGE 9 LOT 9 BLOCK 1","TRUST","125-18-410-009","LAS VEGAS");
        Assert.assertTrue(accDetailspage.ValidateAccountDetailLabel());


    }


    @AfterClass
    public void TearDown()
    {
        driver.quit();
    }
}
