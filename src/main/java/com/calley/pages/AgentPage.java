package com.calley.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AgentPage {

    WebDriver driver;

    public AgentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By agentMenu = By.cssSelector("");
    By addAgent = By.cssSelector("");

    By agentName = By.cssSelector("");
    By agentEmail = By.cssSelector("");
    By agentMobile = By.cssSelector("");
    By agentPassword = By.cssSelector("");

    By saveButton = By.cssSelector("");

    // Actions

    public void clickAgentMenu() {
        driver.findElement(agentMenu).click();
    }

    public void clickAddAgent() {
        driver.findElement(addAgent).click();
    }

    public void enterAgentName(String name) {
        driver.findElement(agentName).sendKeys(name);
    }

    public void enterAgentEmail(String email) {
        driver.findElement(agentEmail).sendKeys(email);
    }

    public void enterAgentMobile(String mobile) {
        driver.findElement(agentMobile).sendKeys(mobile);
    }

    public void enterAgentPassword(String password) {
        driver.findElement(agentPassword).sendKeys(password);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }

}