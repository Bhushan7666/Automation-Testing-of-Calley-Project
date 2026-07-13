package com.calley.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.calley.base.BaseTest;
import com.calley.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void openLoginPage() {

        LoginPage loginPage = new LoginPage(driver);

        // Invalid Login
        loginPage.login("feqoza@mailinator.com", "Pa$$w0rd!");

        // Read Error Message
        String actualMessage = loginPage.getErrorMessage();

        System.out.println("Page Title : " + driver.getTitle());
        System.out.println("Error Message : " + actualMessage);

        // Validation
        Assert.assertEquals(actualMessage, "Invalid username or password.");

        System.out.println("Login Validation Passed");

    }

}