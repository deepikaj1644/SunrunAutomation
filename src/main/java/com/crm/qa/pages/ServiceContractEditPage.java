package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceContractEditPage extends TestBase {

    @FindBy(xpath="(//label[text()='Install Date']/following::td/span/input)[1]")
    WebElement InstallDate_Textbox;

    @FindBy(xpath="(//label[text()='Roof Warranty Length']/following::td/span/input)[1]")
    WebElement RoofLenght_Textbox;

    @FindBy(xpath="(//label[text()='System Activation Date']/following::td/span/input)[1]")
    WebElement SystemDate_Textbox;

    @FindBy(xpath="(//label[text()='PG Threshold %']/following::td/input)[1]")
    WebElement Threshold_Textbox;

    @FindBy(xpath="(//label[text()='PG Yearly Payment Cadence']/following::td/input)[1]")
    WebElement YearlyPayment_Textbox;

    @FindBy(xpath="(//label[text()='Energy Storage Price']/following::td/input)[1]")
    WebElement EnergyStorage_Textbox;

    @FindBy(xpath="(//label[text()='Lease Payment Amount After Step Down']/following::td/input)[1]")
    WebElement LeasePayment_Textbox;

    @FindBy(xpath="(//label[text()='Step Down Month']/following::td/input)[1]")
    WebElement StepDownMonth_Textbox;

    @FindBy(xpath="(//label[text()='Step Down Product']/following::td/input)[1]")
    WebElement StepDownProduct_Textbox;

    @FindBy(xpath="(//label[text()='Safe Harbor Fulfillment Type']/following::td/span/select)[1]")
    WebElement SafeHarbor_Lst;

    @FindBy(xpath="(//label[text()='Equipment Order Threshold']/following::td/span/select)[1]")
    WebElement EquipmentOrder_Lst;

    @FindBy(xpath="(//label[text()='Status']/following::td/span/select)[1]")
    WebElement Status_Lst;

    @FindBy(xpath="(//label[text()='TE Fund Name']/following::td/span/select)[1]")
    WebElement TEFund_Lst;

    @FindBy(xpath="(//label[text()='In TE Fund']/following::td/span/input)[1]")
    WebElement InTEFund_Textbox;

    @FindBy(xpath="(//label[text()='Agreement Number']/following::td/input)[1]")
    WebElement AgreementNo_Textbox;

    @FindBy(xpath="(//label[text()='Contract Name']/following::div/input)[1]")
    WebElement ContractName_Textbox;

    @FindBy(xpath="(//label[text()='Deal ID']/following::td/input)[1]")
    WebElement DealID_Textbox;

    @FindBy(xpath="(//label[text()='Master ID-M']/following::td/input)[1]")
    WebElement MasterID_Textbox;

    @FindBy(xpath="(//label[text()='C1 Terms']/following::td/input)[1]")
    WebElement C1Terms_Textbox;










    @FindBy(xpath="//input[@type='submit' and @name='save']")
    WebElement SaveBtn;



    public ServiceContractEditPage()
    {
        PageFactory.initElements(driver, this);
    }

}
