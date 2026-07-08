package com.calley.tests;

import org.testng.annotations.Test;

import com.calley.base.BaseTest;
import com.calley.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void openLoginPage() {

        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.login("wertyu", "sdfghj");

        System.out.println(driver.getTitle());

        // Abhi login mat karna
        // Sirf Page Object create hua hai
    }
}