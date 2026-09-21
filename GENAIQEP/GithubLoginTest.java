import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GithubLoginTest {
    public void loginToGithub() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize a new WebDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            // Open the website
            driver.get("https://github.com/");

            // Click on the sign in button
            WebElement signInButton = driver.findElement(By.linkText("Sign in"));
            signInButton.click();

            // Enter Username
            WebElement usernameField = driver.findElement(By.id("login_field"));
            usernameField.sendKeys("your_username");

            // Enter Password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("your_password");

            // Click on the sign in submit button
            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
            submitButton.click();

            // Verification: Check if logged in by presence of user profile icon
            WebElement profileIcon = driver.findElement(By.cssSelector("a[aria-label='View profile']"));
            if (profileIcon.isDisplayed()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}