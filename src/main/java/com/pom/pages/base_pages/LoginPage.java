package com.pom.pages.base_pages;

import com.pom.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "current-password")
    WebElement passwordField;

    @FindBy(xpath = "//span[.='Log in']")
    WebElement loginBtn;

    @FindBy(xpath = "(//a[contains(@href,\"w3schools.com\")])[1]")
    WebElement w3schoolLogo;

    // Now we have to init page factory objects or variables
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Now create some actions on page
    public String validatePageTitle() {
        return driver.getTitle();
    }

    public Boolean validateLogo() {
        return w3schoolLogo.isDisplayed();
    }

    public MyLearnings login(String email, String pwd) {
        emailField.sendKeys(email);
        passwordField.sendKeys(pwd);
        loginBtn.click();

        // lending page
        return new MyLearnings();
    }
}
