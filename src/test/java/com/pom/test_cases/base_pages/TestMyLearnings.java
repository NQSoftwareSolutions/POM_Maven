package com.pom.test_cases.base_pages;

import com.pom.base.TestBase;
import com.pom.pages.base_pages.MyLearnings;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMyLearnings extends TestBase {
    MyLearnings myLearnings;

    public TestMyLearnings() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        myLearnings = new MyLearnings();
    }

    @Test
    public void test_MyLearningPageTitle(){
        String title = myLearnings.validatePageTitle();
        Assert.assertEquals(title, "My learning | W3Schools");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
