package com.pom.pages.base_pages;

import com.pom.base.TestBase;
import com.pom.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyLearnings extends TestBase {
    LoginPage loginPage;

//     Page object Repository
    @FindBy(xpath = "//h2[contains(text(),'Hi')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//nav//a[.='Paid courses']")
    WebElement paidCoursesLink;

    @FindBy(xpath = "//nav//a[.='Videos']")
    WebElement videosLink;

    @FindBy(xpath = "//nav//a[.='Spaces']")
    WebElement spacesLink;

    @FindBy(xpath = "//nav//a[.='Settings']")
    WebElement settingsLink;

    @FindBy(xpath = "//nav//a[.='Billing']")
    WebElement billingLink;

    @FindBy(xpath = "//button[.='Show all in progress']")
    WebElement showProgressBtn;

    public MyLearnings() {
        PageFactory.initElements(driver, this);
        loginPage = new LoginPage();
    }

    public boolean isUsernameLabelPresent(){
        return userNameLabel.isDisplayed();
    }

    public String validatePageTitle(){
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        this.waitForElementDisplayed("//h2[contains(text(),'Hi')]");
        return driver.getTitle();
    }

    public void waitForElementDisplayed(String xpath){
        try {
            WebElement element = (new WebDriverWait(driver,
                    Duration.ofSeconds(TestUtils.PAGE_LOAD_TIME_OUT))
                    .until(ExpectedConditions
                            .presenceOfElementLocated(By.xpath(xpath))));
        } finally {
            System.out.println(xpath+" is not available");
        }
    }
}
