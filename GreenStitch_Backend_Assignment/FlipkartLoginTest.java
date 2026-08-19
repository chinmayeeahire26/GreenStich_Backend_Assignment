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
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login");
    }

    @Test
    public void verifyLoginFunctionality() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));

        usernameField.sendKeys("testuser");
        passwordField.sendKeys("testpassword");
        loginButton.click();

        WebElement profileIcon = driver.findElement(By.id("profileIcon"));
        Assert.assertTrue(profileIcon.isDisplayed(), "Login failed - Profile icon not displayed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
