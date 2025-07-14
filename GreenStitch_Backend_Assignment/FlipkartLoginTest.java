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

            // Close the initial login popup
            WebElement closeLoginPopup = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
            closeLoginPopup.click();

            // Click on the login button
            WebElement loginButton = driver.findElement(By.cssSelector("a._1_3w1N"));
            loginButton.click();

            // Enter username
            WebElement usernameField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh"));
            usernameField.sendKeys("your_username");

            // Enter password
            WebElement passwordField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh._3mctLh"));
            passwordField.sendKeys("your_password");

            // Submit login form
            WebElement submitButton = driver.findElement(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL"));
            submitButton.click();

            // Add assertions or further actions as needed

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}