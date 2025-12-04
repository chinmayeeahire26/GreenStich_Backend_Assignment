package com.zepto.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.zepto.pages.LoginPage;

public class ZeptoLoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver and navigate to the Zepto login page
        driver = // Code to initialize WebDriver
        driver.get("https://www.zepto.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginToZepto() {
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        // Verify login success
        WebElement dashboardElement = driver.findElement(By.id("dashboard"));
        assert dashboardElement.isDisplayed();
    }
}