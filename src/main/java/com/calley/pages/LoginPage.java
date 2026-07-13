package com.calley.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By email = By.cssSelector("input#txtEmailId");
    By password = By.cssSelector("input#txtPassword");
    By loginBtn = By.cssSelector("input#btnLogIn");

    // Error Message
    By errorMessage = By.cssSelector("div.sweet-alert h2");

    // Actions
    public void enterEmail(String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
    }

    public void enterPassword(String userPassword) {
        driver.findElement(password).sendKeys(userPassword);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public void login(String userEmail, String userPassword) {
        enterEmail(userEmail);
        enterPassword(userPassword);
        clickLogin();
    }

    // Read Error Message
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

}