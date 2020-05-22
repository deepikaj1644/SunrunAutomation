package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage extends TestBase {

    @FindBy(xpath="//span/b[text()='Project Details']")
    WebElement ProjectDetailsText;


    public ProjectPage()
    {
        PageFactory.initElements(driver, this);
    }


    public TaskPage NavigateToRequiredTask(String TaskName)
    {

        ProjectDetailsText.isDisplayed();
        TestUtil.ClickOn(driver,driver.findElement(By.xpath("//td/a/span[contains(text(),'" + TaskName + "')]")),20);
        return new TaskPage();
    }
}
