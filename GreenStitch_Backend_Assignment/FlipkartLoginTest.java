import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkartLoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void loginToFlipkart() {
        // Close the login popup
        WebElement closeLoginPopup = driver.findElement(By.xpath("//button[contains(text(),'✕')]");
        closeLoginPopup.click();

        // Navigate to login page
        WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Login')]");
        loginButton.click();

        // Enter credentials
        WebElement usernameField = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
        usernameField.sendKeys("your_username");

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("your_password");

        // Submit login form
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        // Add assertions to verify successful login
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}