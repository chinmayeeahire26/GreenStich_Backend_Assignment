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
            WebElement closeButton = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
            closeButton.click();

            // Click on the login button
            WebElement loginButton = driver.findElement(By.linkText("Login"));
            loginButton.click();

            // Enter username and password
            WebElement usernameField = driver.findElement(By.cssSelector("input._2IX_2-._2LYh3d.VJZDxU"));
            WebElement passwordField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh.VJZDxU"));
            usernameField.sendKeys("your_username");
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