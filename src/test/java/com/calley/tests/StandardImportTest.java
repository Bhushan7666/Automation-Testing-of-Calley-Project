package com.calley.tests;

import org.testng.annotations.Test;
import com.calley.base.BaseTest;
import com.calley.pages.LoginPage;
import com.calley.pages.StandardImportPage;

public class StandardImportTest extends BaseTest {

    @Test
    public void testCallListHover() throws InterruptedException {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("zas@mailinator.com", "Pa$$w0rd!");
        System.out.println("[TEST STEP] Logged in successfully.");

        // Step 2: Initialize StandardImportPage
        StandardImportPage standardImport = new StandardImportPage(driver);

        // Step 3: Handle Popups
        standardImport.handlePopups();

        // Step 4: Hover on Call List
        standardImport.hoverOnCallList();

        // Screen par dropdown dikhne ke liye 5 second ka pause
        Thread.sleep(5000);
        
        System.out.println("[TEST STEP] Call List Hover Test Execution Finished.");
    }
}