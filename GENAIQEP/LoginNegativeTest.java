methodName: testInvalidLoginShowsErrorMessage

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginNegativeTest {

    @Test
    public void testInvalidLoginShowsErrorMessage() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to the login page
            driver.get("https://your-app-url.com/login");

            // Enter invalid credentials
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            usernameField.clear();
            usernameField.sendKeys("invalidUser");

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.clear();
            passwordField.sendKeys("wrongPassword");

            // Click login button
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            // Verify error message is displayed
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message")));
            String actualMessage = errorMessage.getText();

            Assertions.assertTrue(
                    actualMessage.toLowerCase().contains("invalid") || actualMessage.toLowerCase().contains("incorrect"),
                    "Expected an invalid credentials error message, but got: " + actualMessage
            );
        } finally {
            driver.quit();
        }
    }
}
