import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;

public class FlipkartLoginTest {

    @Test
    public void loginToFlipkart() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Flipkart login page
            driver.get("https://www.flipkart.com");

            // Locate and interact with login elements
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

            // Enter credentials
            usernameField.sendKeys("your_username");
            passwordField.sendKeys("your_password");

            // Click login button
            loginButton.click();

            // Verify login success
            WebElement accountName = driver.findElement(By.id("accountName"));
            Assert.assertTrue(accountName.isDisplayed());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}