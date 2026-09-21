import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitlabLoginTest {
    public void loginToGitlab() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize a new WebDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            // Open the GitLab login page
            driver.get("https://gitlab.com/users/sign_in");

            // Enter Username
            WebElement usernameField = driver.findElement(By.id("user_username"));
            usernameField.sendKeys("your_username");

            // Enter Password
            WebElement passwordField = driver.findElement(By.id("user_password"));
            passwordField.sendKeys("your_password");

            // Click on the Login button
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();

            // Verify login success (example: check for a user-specific element)
            WebElement userProfile = driver.wait().until(driver -> driver.findElement(By.cssSelector(".js-user-nav")));
            System.out.println("Login successful!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}