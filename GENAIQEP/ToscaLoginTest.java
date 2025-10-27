import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToscaLoginTest {

    public void loginToTosca() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to Tosca login page
        driver.get("https://tosca.example.com/login");

        // Locate and fill in the username field
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("yourUsername");

        // Locate and fill in the password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("yourPassword");

        // Locate and click the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Add assertions to verify successful login
        // Example: Check for presence of a logout button
        WebElement logoutButton = driver.findElement(By.id("logoutButton"));
        assert(logoutButton.isDisplayed());

        // Close the browser
        driver.quit();
    }
}