import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    public LoginTest() {
        // Assuming ChromeDriver path is set in system properties or environment variables
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void loginToApplication(String username, String password) {
        try {
            driver.get("https://example.com/login"); // Replace with actual login URL

            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));

            usernameField.clear();
            usernameField.sendKeys(username);

            passwordField.clear();
            passwordField.sendKeys(password);

            loginButton.click();

            // Optionally, add wait or validation here to confirm login success

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        LoginTest test = new LoginTest();
        test.loginToApplication("testUser", "testPassword");
        // Add assertions or validations as needed
        test.tearDown();
    }
}