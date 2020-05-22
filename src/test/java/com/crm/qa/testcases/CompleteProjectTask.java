package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.utilities.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CompleteProjectTask extends TestBase {

    LoginPage loginpage;
    HomePage homepage;
    ProjectPage projectpage;
    CompleteProjectTask completeprojecttask;
    TaskPage taskpage;


    public CompleteProjectTask()
    {
        super();
    }

    @BeforeMethod
    public void Setup()
    {
        initialization();
        loginpage = new LoginPage();
        homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
    }

    @Test
    public void VerifyCompleteProjectTask() throws InterruptedException {
        homepage.PerformGlobalSearch("PR-2115006529");

        projectpage = new ProjectPage();

        TestUtil.SwitchToMainWindow();
        taskpage = projectpage.NavigateToRequiredTask("Project Handoff (E)");
        TestUtil.SwitchToNewWindow(1);
        TestUtil.SwitchToMainWindow();

        String ActStatus = taskpage.CompleteAnyTask();
        Assert.assertEquals(ActStatus,"Open");

    }

    @AfterMethod
    public void TearDown()
    {
        driver.quit();
    }
}
