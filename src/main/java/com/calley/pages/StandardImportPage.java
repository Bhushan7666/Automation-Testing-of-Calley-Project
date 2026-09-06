package com.calley.pages;

import java.time.Duration;
import org.openqa.selenium.By;
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

    // Locators
    private By modalCloseBtn = By.cssSelector("button.close span");
    private By pushNotificationCancelBtn = By.cssSelector("#onesignal-slidedown-cancel-button");
    private By callListMenu = By.xpath("//a[contains(normalize-space(),'Call List')]");

    // 1. Dashboard Popups Close करने का तरीका
    public void handlePopups() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Website Modal Banner
        try {
            WebElement closeBtn = shortWait.until(ExpectedConditions.elementToBeClickable(modalCloseBtn));
            closeBtn.click();
            System.out.println("[INFO] Website Modal Popup closed.");
        } catch (Exception e) {
            System.out.println("[INFO] Website Modal Popup not visible.");
        }

        // Push Notification Slide-down
        try {
            WebElement cancelBtn = shortWait.until(ExpectedConditions.elementToBeClickable(pushNotificationCancelBtn));
            cancelBtn.click();
            System.out.println("[INFO] Push Notification Popup closed.");
        } catch (Exception e) {
            System.out.println("[INFO] Push Notification Popup not visible.");
        }
    }

    // 2. Only Hover on Call List Menu
    public void hoverOnCallList() {
        System.out.println("[INFO] Waiting for 'Call List' menu element...");
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(callListMenu));

        System.out.println("[INFO] Performing Hover action on 'Call List'...");
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        System.out.println("[INFO] Successfully hovered over 'Call List'.");
    }
}