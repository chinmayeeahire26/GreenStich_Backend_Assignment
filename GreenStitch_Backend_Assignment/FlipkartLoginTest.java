import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        // Close initial login pop-up if it appears
        try {
            WebElement closeButton = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
            closeButton.click();
        } catch (Exception e) {
            // Ignore if pop-up does not appear
        }

        // Navigate to login page
        driver.findElement(By.linkText("Login")).click();

        // Enter username and password
        WebElement usernameField = driver.findElement(By.cssSelector("input._2IX_2-._2LYh3d.VJZDxU"));
        WebElement passwordField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh.VJZDxU"));
        usernameField.sendKeys("your_username");
        passwordField.sendKeys("your_password");

        // Click login button
        driver.findElement(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL"));

        // Verify login
        WebElement profileIcon = driver.findElement(By.cssSelector("div._1ruvv2"));
        Assert.assertTrue(profileIcon.isDisplayed(), "Login was not successful");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}