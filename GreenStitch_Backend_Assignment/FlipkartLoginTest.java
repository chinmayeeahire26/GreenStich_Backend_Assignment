import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FlipkartLoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Assuming ChromeDriver path is set in system properties
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFlipkartLogin() {
        driver.get("https://www.flipkart.com");

        // Close initial login popup
        WebElement closeLoginPopup = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
        closeLoginPopup.click();

        // Navigate to login
        WebElement loginButton = driver.findElement(By.cssSelector("a._1_3w1N"));
        loginButton.click();

        // Enter login credentials
        WebElement emailField = driver.findElement(By.cssSelector("input._2IX_2-._2LYh3d.VJZDxU"));
        WebElement passwordField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh.VJZDxU"));
        WebElement submitButton = driver.findElement(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL"));

        emailField.sendKeys("your-email@example.com");
        passwordField.sendKeys("your-password");
        submitButton.click();

        // Validate login success by checking user profile presence
        WebElement userProfile = driver.findElement(By.cssSelector("div._1ruvv2"));
        assertEquals("Your Name", userProfile.getText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
