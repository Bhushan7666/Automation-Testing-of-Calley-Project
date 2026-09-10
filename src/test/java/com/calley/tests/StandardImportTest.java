package com.calley.tests;

import org.testng.annotations.Test;
import com.calley.base.BaseTest;
import com.calley.pages.LoginPage;
import com.calley.pages.StandardImportPage;

public class StandardImportTest extends BaseTest {

    @Test
    public void testStandardImportCompleteFlow() throws InterruptedException {

        // --- PEHLE KA CODE (Login aur Navigation) ---

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

        // Step 5: Click on Standard Import
        standardImport.clickStandardImport();
        System.out.println("[TEST STEP] Navigated to Standard Import Page Successfully.");
        
        // Naye page (Standard Import Page) ko properly load hone ke liye pause
        Thread.sleep(3000); 


        // --- NAYA CODE (Form Fill aur Upload) ---

        System.out.println("--- FORM FILLING STARTED ---");

        // Step 6: NAYA STEP - List Name dalna
        standardImport.enterListName("Test Automation List");

        // Step 7: NAYA STEP - File Choose karna
        // (isko apne PC ke hisaab se match kar lena)
        String filePath = "C:\\Users\\hp\\Downloads\\Sample File.xlsx";
        standardImport.chooseFile(filePath);

        // File attach hone ke baad 2 second ka pause taaki dikh sake
        Thread.sleep(2000);

        // Step 8: NAYA STEP - Upload Button pe click karna
        standardImport.clickUploadFile();
        System.out.println("[TEST STEP] Form submitted. File Upload process initiated.");

        // Execution khatam hone ke baad browser band hone se pehle 5 second ka pause 
        // Taaki aap dekh sakein ki file upload successful hui ya nahi
        Thread.sleep(5000); 
    }
}
