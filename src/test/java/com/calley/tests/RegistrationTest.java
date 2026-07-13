package com.calley.tests;

import org.testng.annotations.Test;

import com.calley.base.BaseTest;
import com.calley.pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test
    public void userRegistration() throws Exception {

        driver.get("https://app.getcalley.com/registration.aspx");

        RegistrationPage registration = new RegistrationPage(driver);

        registration.register(
                "Ria Mcconnell",
                "zasena@mailinator.com",
                "Pa$$w0rd!",
                "9876883210");

        System.out.println("Registration Form Filled");

        // Pehle CAPTCHA manually solve karo
        Thread.sleep(30000);

        // CAPTCHA ke baad Terms
        registration.acceptTerms();

        System.out.println("Terms Accepted");

        Thread.sleep(2000);

        registration.clickSignUp();

        System.out.println("Registration Submitted");

        Thread.sleep(10000);
    }

}