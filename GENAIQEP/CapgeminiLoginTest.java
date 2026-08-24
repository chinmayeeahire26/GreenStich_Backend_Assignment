import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CapgeminiLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public CapgeminiLoginTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loginToCapgemini10(String username, String password) {
        // Navigate to the Capgemini10 login page
        driver.get("https://capgemini10.example.com/login");

        // Wait for username field to be visible and enter username
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.clear();
        usernameField.sendKeys(username);

        // Wait for password field to be visible and enter password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.clear();
        passwordField.sendKeys(password);

        // Click the login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));
        loginButton.click();

        // Wait for successful login indicator (e.g., dashboard or logout button)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
    }
}
