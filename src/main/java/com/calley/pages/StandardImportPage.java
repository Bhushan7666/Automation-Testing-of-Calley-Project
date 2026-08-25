package com.calley.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StandardImportPage {

    WebDriver driver;

    // Constructor
    public StandardImportPage(WebDriver driver) {
        this.driver = driver;
    }

    //locater add standard import
    By standardImport = By.cssSelector(
    		"li[class='active'] li:nth-child(1) a:nth-child(1) span:nth-child(1)"		
    );
    
    By listName = By.cssSelector("");
    
    // File Upload
    By fileUpload = By.cssSelector("");
    
    // action 
    public void ClickStandardImport() {
    	driver.findElement(standardImport);
    }
    
    public void enterListName(String name) {
    	driver.findElement(listName).sendKeys(name);
    }

    public void uploadFile(String filePath) {
        driver.findElement(fileUpload).sendKeys(filePath);
    }
}