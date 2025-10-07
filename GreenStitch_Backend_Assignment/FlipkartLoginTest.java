import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLoginTest {

    public void loginToFlipkart() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Flipkart
            driver.get("https://www.flipkart.com");

            // Close the login popup if it appears
            WebElement closeButton = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
            if (closeButton.isDisplayed()) {
                closeButton.click();
            }

            // Click on the login button
            WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
            loginButton.click();

            // Enter username
            WebElement usernameField = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
            usernameField.sendKeys("your_username");

            // Enter password
            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
            passwordField.sendKeys("your_password");

            // Submit login form
            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
            submitButton.click();

            // Add assertions or further actions as needed

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}