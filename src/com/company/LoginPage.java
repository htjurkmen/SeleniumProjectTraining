package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    By registerLinkLoc = By.linkText("Register");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public RegistrationForm clickRegister(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement registerLink = wait.until(ExpectedConditions.elementToBeClickable(registerLinkLoc));

        registerLink.click();
        RegistrationForm regForm = new RegistrationForm(driver);
        return regForm;
    }
}
