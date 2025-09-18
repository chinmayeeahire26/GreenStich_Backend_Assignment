import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLoginTest {

    public void loginToFlipkart() {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Flipkart
            driver.get("https://www.flipkart.com");

            // Close the initial login pop-up
            WebElement closeButton = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
            closeButton.click();

            // Click on the login link
            WebElement loginLink = driver.findElement(By.linkText("Login"));
            loginLink.click();

            // Enter the username
            WebElement usernameField = driver.findElement(By.cssSelector("input._2IX_2-._35m_Y1"));
            usernameField.sendKeys("your_username");

            // Enter the password
            WebElement passwordField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh"));
            passwordField.sendKeys("your_password");

            // Click on the login button
            WebElement loginButton = driver.findElement(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL"));
            loginButton.click();

            // Add additional verification steps as necessary

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}