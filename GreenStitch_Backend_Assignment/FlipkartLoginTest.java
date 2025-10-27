import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLoginTest {

    public void loginToFlipkart() {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Flipkart
            driver.get("https://www.flipkart.com");

            // Close the initial login popup if present
            WebElement closeButton = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
            closeButton.click();

            // Click on the login button
            WebElement loginButton = driver.findElement(By.linkText("Login"));
            loginButton.click();

            // Enter username
            WebElement usernameField = driver.findElement(By.cssSelector("input._2IX_2-._35m_Y1"));
            usernameField.sendKeys("your_username");

            // Enter password
            WebElement passwordField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh"));
            passwordField.sendKeys("your_password");

            // Submit the login form
            WebElement submitButton = driver.findElement(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL"));
            submitButton.click();

            // Add assertions here to verify successful login

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}