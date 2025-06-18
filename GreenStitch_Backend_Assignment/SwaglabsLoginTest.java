import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwaglabsLoginTest {

    public void loginToSwaglabs() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Swaglabs login page
            driver.get("https://www.saucedemo.com/");

            // Locate username and password fields
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));

            // Enter credentials
            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");

            // Click login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Verify login success
            WebElement inventoryPage = driver.findElement(By.id("inventory_container"));
            if (inventoryPage.isDisplayed()) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}