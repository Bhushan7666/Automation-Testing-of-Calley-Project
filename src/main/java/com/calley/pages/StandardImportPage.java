package com.calley.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandardImportPage {

    WebDriver driver;

    // Constructor
    public StandardImportPage(WebDriver driver) {
        this.driver = driver;
    }

    // Correct Locators
    By callListMenu = By.xpath("//a[normalize-space()='Call List']");
    By standardImport = By.xpath("//a[contains(text(),'Standard Import')]");
    By listName = By.cssSelector("#ContentPlaceHolder1_txtlistname");
    By fileUpload = By.cssSelector("input[type='file']");									
    
    // Actions
    public void ClickStandardImport() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        // 1. Call List visible hone tak wait karein
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(callListMenu));
        
        // 2. Call List par Hover karein
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        
        // 3. Sub-menu (Standard Import) clickable hone par click karein
        WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(standardImport));
        subMenu.click();
    }
    
    public void enterListName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(listName)).sendKeys(name);
    } 

    public void uploadFile(String filePath) {
        driver.findElement(fileUpload).sendKeys(filePath);
    }
}