package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {

    @Test
    public void verifyPageTitle(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        //wait.until(ExpectedConditions.titleContains("Dashboard"));
        //Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        BrowserUtils.wait(3);
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
    }

    @Test
    public void verifyWarningMessage(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
    }

}