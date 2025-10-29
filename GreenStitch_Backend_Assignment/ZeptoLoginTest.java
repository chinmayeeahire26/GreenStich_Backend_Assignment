import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeptoLoginTest {

    public void loginToZepto() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Zepto login page
            driver.get("https://www.zepto.com/login");

            // Locate username and password fields
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));

            // Enter credentials
            usernameField.sendKeys("yourUsername");
            passwordField.sendKeys("yourPassword");

            // Locate and click login button
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            // Add assertions to verify successful login
            // Example: Check if user is redirected to the dashboard
            WebElement dashboardElement = driver.findElement(By.id("dashboard"));
            assert dashboardElement.isDisplayed();

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}