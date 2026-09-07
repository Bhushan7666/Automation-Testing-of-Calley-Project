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
    
    // NAYA LOCATOR: Standard Import par click karne ke liye
    private By standardImportSubMenu = By.xpath("//a[contains(normalize-space(),'Standard Import')]");

    // ==========================================
    // ACTIONS / METHODS
    // ==========================================

    // 1. Popups Close karne ka method
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

    // 2. Call List par Hover karne ka method
    public void hoverOnCallList() {
        System.out.println("[INFO] Waiting for 'Call List' menu element...");
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(callListMenu));

        System.out.println("[INFO] Performing Hover action on 'Call List'...");
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        System.out.println("[INFO] Successfully hovered over 'Call List'.");
    }

    // 3. NAYA METHOD: Standard Import par click karne ke liye
    public void clickStandardImport() {
        System.out.println("[INFO] Waiting for 'Standard Import' sub-menu...");
        WebElement subMenu = wait.until(ExpectedConditions.presenceOfElementLocated(standardImportSubMenu));

        try {
            // Pehle normal click try karega
            Actions actions = new Actions(driver);
            actions.moveToElement(subMenu).click().perform();
            System.out.println("[INFO] Clicked 'Standard Import' via normal click.");
        } catch (Exception e) {
            // Agar UI overlay ki wajah se fail hua, toh JavaScript click karega
            System.out.println("[WARN] Normal click blocked, using JavaScript click fallback...");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", subMenu);
            System.out.println("[INFO] Clicked 'Standard Import' via JavaScript.");
        }
    }
}