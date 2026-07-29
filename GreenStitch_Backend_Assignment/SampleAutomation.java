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
        // Set the path to chromedriver executable if needed
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginFunctionality() {
        driver.get("https://example.com/login");

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));

        usernameInput.sendKeys("testuser");
        passwordInput.sendKeys("testpassword");
        loginButton.click();

        // Wait for page to load or use explicit wait here if needed

        String expectedUrl = "https://example.com/dashboard";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User should be redirected to dashboard after login");

        WebElement welcomeMessage = driver.findElement(By.id("welcomeMsg"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "Welcome message should be displayed after login");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}