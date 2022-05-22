package com.pom.test_cases.base_pages;

import com.pom.base.TestBase;
import com.pom.pages.base_pages.LoginPage;
import com.pom.pages.base_pages.MyLearnings;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginPage extends TestBase {
    LoginPage loginPage;
    MyLearnings myLearnings;

    public TestLoginPage() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();

        loginPage = new LoginPage();
        myLearnings = new MyLearnings();
    }

    // Todo All test cases will be here
    @Test(priority = 1)
    public void test_loginPageTitle() {
        String title = loginPage.validatePageTitle();
        Assert.assertEquals(title, "Log in - W3Schools");
    }

    @Test(priority = 2)
    public void test_logoTest() {
        Boolean isImageAvailable = loginPage.validateLogo();
        Assert.assertTrue(isImageAvailable);
    }

    @Test(priority = 3)
    public void test_logIn() {
        myLearnings = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertNotNull(myLearnings);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
