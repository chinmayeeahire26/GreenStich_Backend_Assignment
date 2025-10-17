import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartLoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void loginToFlipkart() {
        // Close the initial login popup if it appears
        try {
            WebElement closeButton = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
            closeButton.click();
        } catch (Exception e) {
            // Popup not present
        }

        // Click on the login button
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

        // Enter username
        WebElement usernameField = driver.findElement(By.cssSelector("input._2IX_2-._35m_Y1"));
        usernameField.sendKeys("your-username");

        // Enter password
        WebElement passwordField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh"));
        passwordField.sendKeys("your-password");

        // Submit login form
        WebElement submitButton = driver.findElement(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL"));
        submitButton.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}