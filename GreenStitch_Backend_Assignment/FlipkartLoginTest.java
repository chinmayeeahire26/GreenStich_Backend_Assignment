import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLoginTest {

    public void loginToFlipkart() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.flipkart.com");

            // Close the initial login popup
            WebElement closeLoginPopup = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
            closeLoginPopup.click();

            // Click on the login link
            WebElement loginLink = driver.findElement(By.cssSelector("a._1_3w1N"));
            loginLink.click();

            // Enter username
            WebElement usernameField = driver.findElement(By.cssSelector("input._2IX_2-._1mYB_4"));
            usernameField.sendKeys("your-username");

            // Enter password
            WebElement passwordField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh"));
            passwordField.sendKeys("your-password");

            // Click login button
            WebElement loginButton = driver.findElement(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL"));
            loginButton.click();

            // Add assertions to verify successful login
            // Example: Assert the presence of a user-specific element

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}