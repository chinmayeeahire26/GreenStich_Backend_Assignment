package com.flipkart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void loginToFlipkart() {
        // Close initial login pop-up if present
        try {
            WebElement closeButton = driver.findElement(By.cssSelector(".\_2KpZ6l.\_2doB4z"));
            closeButton.click();
        } catch (Exception e) {
            System.out.println("Login pop-up not present");
        }

        // Click on login button
        WebElement loginButton = driver.findElement(By.cssSelector(".\_1_3w1N"));
        loginButton.click();

        // Enter username
        WebElement usernameField = driver.findElement(By.cssSelector("input[type='text']"));
        usernameField.sendKeys("your_username");

        // Enter password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("your_password");

        // Submit login form
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}