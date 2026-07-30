import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to chromedriver executable as per your local setup
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginApplication() {
        driver.get("https://example.com/login"); // Replace with actual login URL

        // Locate username and password fields and login button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));

        // Enter credentials - replace with valid test credentials or parameterize
        usernameField.sendKeys("testuser");
        passwordField.sendKeys("testpassword");

        // Click login
        loginButton.click();

        // Add assertion to verify successful login
        // For example, check presence of logout button or user profile
        boolean isLoggedIn = driver.findElements(By.id("logoutBtn")).size() > 0;
        assert isLoggedIn : "Login failed - logout button not found";
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
