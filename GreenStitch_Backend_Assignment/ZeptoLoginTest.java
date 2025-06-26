import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ZeptoLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginToZepto() {
        driver.get("https://www.zepto.com/login");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("testuser");
        passwordField.sendKeys("password123");
        loginButton.click();

        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "Login failed!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}