package com.calley.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // =======================
    // Locators
    // =======================

    By name = By.cssSelector("#txtName");
    By email = By.cssSelector("#txtEmail");
    By password = By.cssSelector("#txtPassword");
    By whatsapp = By.cssSelector("#txt_mobile");

    // Terms Label
    By terms = By.cssSelector("label[for='checkbox-signup']");

    By signUp = By.cssSelector("#btnSignUp");

    // =======================
    // Actions
    // =======================

    public void enterName(String userName) {
        driver.findElement(name).sendKeys(userName);
    }

    public void enterEmail(String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
    }

    public void enterPassword(String userPassword) {
        driver.findElement(password).sendKeys(userPassword);
    }

    public void enterWhatsapp(String mobile) {
        driver.findElement(whatsapp).sendKeys(mobile);
    }

    public void acceptTerms() {

        WebElement checkbox = driver.findElement(terms);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", checkbox);
    }

    public void clickSignUp() {
        driver.findElement(signUp).click();
    }

    public void register(String userName,
                         String userEmail,
                         String userPassword,
                         String mobile) {

        enterName(userName);
        enterEmail(userEmail);
        enterPassword(userPassword);
        enterWhatsapp(mobile);
    }

}