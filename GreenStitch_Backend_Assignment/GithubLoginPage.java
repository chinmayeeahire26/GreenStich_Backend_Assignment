package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GithubLoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By signInLink = By.linkText("Sign in");
    private final By usernameInput = By.id("login_field");
    private final By passwordInput = By.id("password");
    private final By signInButton = By.name("commit");

    public GithubLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // methodName: loginToGithub
    public void loginToGithub(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).clear();
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(signInButton).click();
    }
}
