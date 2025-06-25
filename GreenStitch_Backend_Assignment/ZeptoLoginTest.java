import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeptoLoginTest {

    public void loginToZepto() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Zepto login page
            driver.get("https://www.zepto.com/login");

            // Locate and fill the username field
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("yourUsername");

            // Locate and fill the password field
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("yourPassword");

            // Locate and click the login button
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            // Add assertions to verify successful login
            // Example: Check if the user is redirected to the dashboard
            WebElement dashboard = driver.findElement(By.id("dashboard"));
            assert dashboard.isDisplayed();

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}