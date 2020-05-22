package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountEditPage extends TestBase {

    @FindBy(xpath="//label[text()='Account Name']/following::td/div/input[@name='acc2']")
    WebElement AccountName_Textbox;

    @FindBy(xpath="(//label[text()='Incorporated']/following::td/input)[1]")
    WebElement Incorporated_Textbox;

    @FindBy(xpath="(//label[text()='Address Standardization Status']/following::td/span/select)[1]")
    WebElement AddressStandardizationStatus_Lst;

    @FindBy(xpath="(//label[text()='Address Standardization Source']/following::td/span/select)[1]")
    WebElement AddressStandardizationSource_Lst;

    @FindBy(xpath="(//label[text()='Address Token']/following::td/input)[1]")
    WebElement AddressToken_Textbox;

    @FindBy(xpath="(//label[text()='Latitude']/following::td/input)[1]")
    WebElement Latitude_Textbox;

    @FindBy(xpath="(//label[text()='Longitude']/following::td/input)[1]")
    WebElement Longitude_Textbox;

    @FindBy(xpath="(//label[text()='Address Standardization Confidence Level']/following::td/input)[1]")
    WebElement AddStaConfiLevel_Textbox;

    @FindBy(xpath="(//label[text()='Time Zone']/following::td/input)[1]")
    WebElement TimeZone_Textbox;

    @FindBy(xpath="(//label[text()='Has Daylight Savings']/following::td/input)[1]")
    WebElement HasDaylightSavings_Textbox;

    @FindBy(xpath="(//label[text()='Area Code']/following::td/input)[1]")
    WebElement AreaCode_Textbox;

    @FindBy(xpath="(//label[text()='Congress District Number']/following::td/input)[1]")
    WebElement CongressDistrictNumber_Textbox;

    @FindBy(xpath="(//label[text()='State Legislative Upper']/following::td/input)[1]")
    WebElement StateLegislativeUpper_Textbox;

    @FindBy(xpath="(//label[text()='State Legislative Lower']/following::td/input)[1]")
    WebElement StateLegislativeLower_Textbox;

    @FindBy(xpath="//input[@type='submit' and @name='save']")
    WebElement SaveBtn;



    public AccountEditPage()
    {
        PageFactory.initElements(driver, this);
    }

    public AccountDetailsPage CreateNewAccount(String AccName, String Incorporated, String  AddressStandardizationStatus, String AddressStandardizationSource, String AddressToken, String Latitude, String Longitude, String AddStaConfiLevel, String TimeZone, String HasDaylightSavings, String AreaCode, String CongressDistrictNumber, String StateLegislativeUpper, String StateLegislativeLower) throws InterruptedException {
        TestUtil.WaitForElementToBeVisible(driver,AccountName_Textbox,30);
        AccountName_Textbox.sendKeys(AccName);
        Incorporated_Textbox.sendKeys(Incorporated);
        TestUtil.Sleep(TestUtil.XSMALL_WAIT_TIME);

        Select AddStaStatus = new Select(AddressStandardizationStatus_Lst);
        AddStaStatus.selectByVisibleText(AddressStandardizationStatus);


        Select AddStaSource = new Select(AddressStandardizationSource_Lst);
        AddStaSource.selectByVisibleText(AddressStandardizationSource);
        TestUtil.Sleep(TestUtil.XSMALL_WAIT_TIME);

        TestUtil.WaitForElementToBeVisible(driver,AddressToken_Textbox,30);
        AddressToken_Textbox.click();
        AddressToken_Textbox.sendKeys(AddressToken);
        TestUtil.Sleep(TestUtil.XSMALL_WAIT_TIME);

        TestUtil.WaitForElementToBeVisible(driver,Latitude_Textbox,30);
        Latitude_Textbox.sendKeys(Latitude);
        Longitude_Textbox.sendKeys(Longitude);
        AddStaConfiLevel_Textbox.sendKeys(AddStaConfiLevel);
        TimeZone_Textbox.sendKeys(TimeZone);
        HasDaylightSavings_Textbox.sendKeys(HasDaylightSavings);
        AreaCode_Textbox.sendKeys(AreaCode);
        CongressDistrictNumber_Textbox.sendKeys(CongressDistrictNumber);
        StateLegislativeUpper_Textbox.sendKeys(StateLegislativeUpper);
        StateLegislativeLower_Textbox.sendKeys(StateLegislativeLower);

        TestUtil.ClickOn(driver,SaveBtn,20);

        return new AccountDetailsPage();


    }


}
