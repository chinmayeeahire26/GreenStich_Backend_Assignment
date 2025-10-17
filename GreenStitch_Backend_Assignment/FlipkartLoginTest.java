import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLoginTest {

    public void loginToFlipkart() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Flipkart
            driver.get("https://www.flipkart.com");

            // Close the initial login popup if it appears
            WebElement closeButton = driver.findElement(By.cssSelector(".\_2KpZ6l.\_2doB4z"));
            if (closeButton.isDisplayed()) {
                closeButton.click();
            }

            // Click on the login button
            WebElement loginButton = driver.findElement(By.linkText("Login"));
            loginButton.click();

            // Enter the username
            WebElement usernameField = driver.findElement(By.cssSelector("input[autocomplete='off'][type='text']"));
            usernameField.sendKeys("your-username");

            // Enter the password
            WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
            passwordField.sendKeys("your-password");

            // Submit the login form
            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
            submitButton.click();

            // Add assertions here to verify successful login

        } finally {
            // Clean up
            driver.quit();
        }
    }
}