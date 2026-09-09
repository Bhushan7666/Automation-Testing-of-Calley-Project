package com.calley.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandardImportPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public StandardImportPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ==========================================
    // LOCATORS
    // ==========================================
    private By modalCloseBtn = By.cssSelector("button.close span");
    private By pushNotificationCancelBtn = By.cssSelector("#onesignal-slidedown-cancel-button");
    private By callListMenu = By.xpath("//a[contains(normalize-space(),'Call List')]");
    private By standardImportSubMenu = By.xpath("//a[contains(normalize-space(),'Standard Import')]");

    // Form Fill aur Upload ke locators
    private By listNameInput = By.cssSelector("#ContentPlaceHolder1_txtlistname");
    private By fileUploadInput = By.cssSelector("input[type='file']");
    
    // UPDATED LOCATOR: Exact ID for Upload Button
    private By uploadButton = By.id("ContentPlaceHolder1_btnUpload");

    // ==========================================
    // ACTIONS / METHODS
    // ==========================================

    public void handlePopups() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement closeBtn = shortWait.until(ExpectedConditions.elementToBeClickable(modalCloseBtn));
            closeBtn.click();
            System.out.println("[INFO] Website Modal Popup closed.");
        } catch (Exception e) {
            System.out.println("[INFO] Website Modal Popup not visible.");
        }
        try {
            WebElement cancelBtn = shortWait.until(ExpectedConditions.elementToBeClickable(pushNotificationCancelBtn));
            cancelBtn.click();
            System.out.println("[INFO] Push Notification Popup closed.");
        } catch (Exception e) {
            System.out.println("[INFO] Push Notification Popup not visible.");
        }
    }

    public void hoverOnCallList() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(callListMenu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        System.out.println("[INFO] Successfully hovered over 'Call List'.");
    }

    public void clickStandardImport() {
        WebElement subMenu = wait.until(ExpectedConditions.presenceOfElementLocated(standardImportSubMenu));
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(subMenu).click().perform();
            System.out.println("[INFO] Clicked 'Standard Import' via normal click.");
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", subMenu);
            System.out.println("[INFO] Clicked 'Standard Import' via JavaScript fallback.");
        }
    }

    public void enterListName(String name) {
        System.out.println("[INFO] Waiting for List Name text box...");
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(listNameInput));
        nameField.clear();
        nameField.sendKeys(name);
        System.out.println("[INFO] Entered List Name: " + name);
    }

    public void chooseFile(String filePath) {
        System.out.println("[INFO] Selecting file from path...");
        WebElement uploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(fileUploadInput));
        uploadElement.sendKeys(filePath);
        System.out.println("[INFO] File path successfully sent: " + filePath);
    }

    // UPDATED METHOD: Upload button click with JavaScript fallback for hidden elements
    public void clickUploadFile() {
        System.out.println("[INFO] Locating Upload Button...");
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(uploadButton));
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement clickableBtn = shortWait.until(ExpectedConditions.elementToBeClickable(uploadButton));
            clickableBtn.click();
            System.out.println("[INFO] Clicked on Upload Button via normal click.");
        } catch (Exception e) {
            System.out.println("[WARN] Normal click failed, using JavaScript click fallback...");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", btn);
            System.out.println("[INFO] Clicked on Upload Button via JavaScript.");
        }
    }
}