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
            // Navigate to Flipkart login page
            driver.get("https://www.flipkart.com/account/login");
            
            // Find the username and password fields
            WebElement usernameField = driver.findElement(By.cssSelector("input[type='text']"));
            WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
            
            // Enter username and password
            usernameField.sendKeys("your-username");
            passwordField.sendKeys("your-password");
            
            // Click on the login button
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
            
            // Add assertions here to verify successful login
            // For example, check if the user profile icon is displayed
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}