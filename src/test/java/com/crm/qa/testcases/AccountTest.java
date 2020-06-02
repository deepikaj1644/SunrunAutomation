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

   @Test(priority = 1, description="Creates a new Account of type 'Residential'",enabled= false)
    public void VerifyCreateNewResidentialAccountTest() throws InterruptedException {

        objHomePage = homepage.ClickAnyTabOnHomePage("Accounts");
        Assert.assertTrue(homepage.ValidateTabLabelDisplayed("Accounts"),"Label Does not exist");

        RecTypePage = objHomePage.ClickOnNewButton();
        RecTypePage.SelectRecordType("Residential");

        accEditpage = new AccountEditPage();

        accDetailspage = accEditpage.CreateNewResidentialAccount("AutoTestAcc1","No","Standardized","Google Maps","USA:NV:LAS VEGAS:SILENT WATER WAY:7370:89149","36.295095400000000","-115.307233100000000","ROOFTOP","PST","true","702","04","018","004");
        Assert.assertTrue(accDetailspage.ValidateVisibilityofEditButton());

        homepage.PerformGlobalSearch("AutoTestAcc1");
        accDetailspage = new AccountDetailsPage();
        Assert.assertTrue(accDetailspage.ValidateAccountDetailLabel());
        accDetailspage.FillAddressInformationResidentialAccount("7370 Silent Water Way","Las Vegas","NV","89149","USA","Clark","(256) 283-3633","Las Vegas","Clark","REAVES", "REAVES KATHRYN RUTH (TE)","SFR (single family residence)","CLEARWATER EST PLAT BOOK 134 PAGE 9 LOT 9 BLOCK 1","TRUST","125-18-410-009","LAS VEGAS");
        Assert.assertTrue(accDetailspage.ValidateAccountDetailLabel());

    }

    @Test(priority = 2, description="Creates a new Account of type 'Branch'",enabled= false)
    public void VerifyCreateNewBranchAccountTest() throws InterruptedException {

        objHomePage = homepage.ClickAnyTabOnHomePage("Accounts");
        Assert.assertTrue(homepage.ValidateTabLabelDisplayed("Accounts"),"Label Does not exist");

        RecTypePage = objHomePage.ClickOnNewButton();
        RecTypePage.SelectRecordType("Branch");

        accEditpage = new AccountEditPage();

        accDetailspage = accEditpage.CreateNewBranchAccount("Auto1_Las Vegas", "Las Vegas","Branch","1.2263900000","-0.2642600000","0.2700000000","0.0000000000","Standardized","Google Maps","USA:NV:HENDERSON:EASTGATE RD:8385:130:89015","36.034969400000000","-115.011566300000000","PST","TRUE","702");
        Assert.assertTrue(accDetailspage.ValidateVisibilityofEditButton());

        homepage.PerformGlobalSearch("Auto_Las Vegas");
        accDetailspage = new AccountDetailsPage();
        Assert.assertTrue(accDetailspage.ValidateAccountDetailLabel());
        accDetailspage.FillAddressInformationBranchAccount("8385 Eastgate Rd #130","Henderson","NV","89015","USA","Clark","Northwest","COLFIN 2018-5 INDUSTRIAL OWNER L","SFR (single family residence)","HENDERSON FREEWAY CROSSING PLAT BOOK 151 PAGE 54 PT LOT 1");
        Assert.assertTrue(accDetailspage.ValidateAccountDetailLabel());


    }

    @Test(priority = 1, description="Creates a new Account of type 'Branch'")
    public void VerifyCreateNewCompanyAccountTest() throws InterruptedException {

        objHomePage = homepage.ClickAnyTabOnHomePage("Accounts");
        Assert.assertTrue(homepage.ValidateTabLabelDisplayed("Accounts"),"Label Does not exist");

        RecTypePage = objHomePage.ClickOnNewButton();
        RecTypePage.SelectRecordType("Company");

        accEditpage = new AccountEditPage();

        accDetailspage = accEditpage.CreateNewCompanyAccount("Auto_Sunrun","Auto_1541941078","024 Rialto St, Oxnard, CA, 93035","00G0d000002eCmr","San Francisco - CA","6/1/2013","sunrundocusign.majstg@gmail.com","SunRun.png","Matrix","Sunrun eSignAdmin","Auto Normal","02d320000004Cm2AAE","Yes","-0.3300000000","1.3000000000","1024 Rialto St","Oxnard","CA","93035","USA","Ventura","(415) 580-6800","Oxnard","Oxnard","Ventura","37.0000","OROZCO LEOCADIO O","OJEDA JOSE O","BLOCK 3 LOT 19, REF: 021MR 045","183-0-183-155","SFR (single family residence)","Standardized","Google Maps","USA:CA:OXNARD:RIALTO ST:1024:93035","34.191069300000000","-119.197742600000000","PST","true","805","26","019","044");
        Assert.assertTrue(accDetailspage.ValidateVisibilityofEditButton());

        homepage.PerformGlobalSearch("Auto_Sunrun");
        accDetailspage = new AccountDetailsPage();
        Assert.assertTrue(accDetailspage.ValidateAccountDetailLabel());
        accDetailspage.FillAddressInformationCompanyAccount("1024 Rialto St","Oxnard","CA","93035","USA","OROZCO LEOCADIO O","OJEDA JOSE O","SFR (single family residence)","BLOCK 3 LOT 19, REF: 021MR 045","183-0-183-155");
        Assert.assertTrue(accDetailspage.ValidateAccountDetailLabel());


    }



    @AfterClass
    public void TearDown()
    {
        driver.quit();
    }
}
