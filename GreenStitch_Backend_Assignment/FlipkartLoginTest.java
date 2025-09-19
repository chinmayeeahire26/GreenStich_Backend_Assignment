import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartLoginTest {

    private WebDriver driver;
    private String baseUrl = "https://www.flipkart.com";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFlipkartLogin() {
        driver.get(baseUrl);
        WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        emailField.sendKeys("your-email@example.com");
        passwordField.sendKeys("your-password");
        submitButton.click();

        WebElement profileName = driver.findElement(By.xpath("//div[contains(text(),'Your Name')]"));
        Assert.assertTrue(profileName.isDisplayed(), "Login failed!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}