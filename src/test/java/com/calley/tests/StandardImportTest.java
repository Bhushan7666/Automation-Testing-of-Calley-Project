package com.calley.tests;

import org.testng.annotations.Test;
import com.calley.base.BaseTest;
import com.calley.pages.LoginPage;
import com.calley.pages.StandardImportPage;

public class StandardImportTest extends BaseTest {

    @Test
    public void testStandardImportNavigation() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("zas@mailinator.com", "Pa$$w0rd!");
        System.out.println("[TEST STEP] Logged in successfully.");

        // Step 2: Initialize Page Object
        StandardImportPage standardImport = new StandardImportPage(driver);

        // Step 3: Handle Popups
        standardImport.handlePopups();

        // Step 4: Hover on Call List
        standardImport.hoverOnCallList();
        
        // Hover hone ke baad chhota sa pause taaki dropdown theek se render ho jaye
        Thread.sleep(1000); 

        // Step 5: NAYA STEP - Click on Standard Import
        standardImport.clickStandardImport();

        System.out.println("[TEST STEP] Navigated to Standard Import Page Successfully.");
        
        // Page load dekhne ke liye rukte hain
        Thread.sleep(3000); 
    }
}