package com.calley.tests;

import org.testng.annotations.Test;

import com.calley.base.BaseTest;
import com.calley.pages.LoginPage;
import com.calley.pages.StandardImportPage;

public class StandardImportTest extends BaseTest {

    @Test
    public void openStandardImport() {
    	
    	//for loging
    	
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.login("zas@mailinator.com", "Pa$$w0rd!");
    	
    	System.out.println(" Login Successful ");
    	
    	// Standard import
    	
        StandardImportPage standardImport = new StandardImportPage(driver);

        standardImport.PopUp();
        
        standardImport.ClickStandardImport();
        
        System.out.println("Standard Import Page Test Started");
        
        //Enter List Name
        standardImport.enterListName("Test List");
        
        System.out.println(" List Name Entered");

        // Upload File
        standardImport.uploadFile(
                "C:\\Users\\hp\\Downloads\\Sample File.xlsx"
        );

        System.out.println("File Selected");
    }
}