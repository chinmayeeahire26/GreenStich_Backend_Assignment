import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLoginTest {

    public void loginToFlipkart() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Flipkart
        driver.get("https://www.flipkart.com");

        // Close the login popup
        WebElement closeLoginPopup = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
        closeLoginPopup.click();

        // Click on the login link
        WebElement loginLink = driver.findElement(By.xpath("//a[text()='Login']"));
        loginLink.click();

        // Enter username
        WebElement usernameField = driver.findElement(By.cssSelector("input._2IX_2-._2LYh3d"));
        usernameField.sendKeys("your-username");

        // Enter password
        WebElement passwordField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh"));
        passwordField.sendKeys("your-password");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL"));
        loginButton.click();

        // Validate login
        // Add assertions or checks here

        // Close the browser
        driver.quit();
    }
}