package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.utilities.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpportunityTest extends TestBase {

    LoginPage loginpage;
    HomePage homepage;
    ObjectHomePage objHomePage;
    SelectObjectRecordTypePage RecTypePage;
    AccountEditPage accEditpage;
    AccountDetailsPage accDetailspage;
    String sheetName = "Residential_Account";


    public OpportunityTest()
    {
        super();
    }

    @DataProvider
    public Object[][] getLeadTestData() {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @BeforeClass
    public void Setup() throws InterruptedException {
        initialization();
        loginpage = new LoginPage();
        homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
    }

    @Test(priority = 1, description="Creates a new Account of type 'Residential'",enabled= true)
    public void VerifyCreateNewResidentialAccountTest() throws InterruptedException {

        objHomePage = homepage.ClickAnyTabOnHomePage("Opportunities");
        Assert.assertTrue(homepage.ValidateTabLabelDisplayed("Opportunities"),"Label Does not exist");

        RecTypePage = objHomePage.ClickOnNewButton();
        RecTypePage.SelectRecordType("Bronze");

        accEditpage = new AccountEditPage();

        accDetailspage = accEditpage.CreateNewResidentialAccount("7370 Silent Water Way-89149","No","Standardized","Google Maps","USA:NV:LAS VEGAS:SILENT WATER WAY:7370:89149","36.295095400000000","-115.307233100000000","ROOFTOP","PST","true","702","04","018","004");
        Assert.assertTrue(accDetailspage.ValidateVisibilityofEditButton());

        homepage.PerformGlobalSearch("7370 Silent Water Way-89149");
        accDetailspage = new AccountDetailsPage();
        Assert.assertTrue(accDetailspage.ValidateAccountDetailLabel());
        accDetailspage.FillAddressInformationResidentialAccount("7370 Silent Water Way","Las Vegas","NV","89149","USA","Clark","(256) 283-3633","Las Vegas","Clark","REAVES", "REAVES KATHRYN RUTH (TE)","SFR (single family residence)","CLEARWATER EST PLAT BOOK 134 PAGE 9 LOT 9 BLOCK 1","TRUST","125-18-410-009","LAS VEGAS");
        Assert.assertTrue(accDetailspage.ValidateAccountDetailLabel());

    }

    @AfterClass
    public void TearDown()
    {
        driver.quit();
    }
}
