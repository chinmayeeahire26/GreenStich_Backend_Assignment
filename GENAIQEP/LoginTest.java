import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to chromedriver executable if not set in system PATH
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginApplication() {
        driver.get("https://example.com/login");

        // Locate username field and enter username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();
        usernameField.sendKeys("testuser");

        // Locate password field and enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("password123");

        // Locate and click login button
        WebElement loginButton = driver.findElement(By.id("loginBtn"));
        loginButton.click();

        // Verify successful login by checking presence of logout button or user profile
        WebElement logoutButton = driver.findElement(By.id("logoutBtn"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button should be displayed after login");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
