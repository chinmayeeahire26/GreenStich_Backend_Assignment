import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartLoginTest {

    private WebDriver driver;
    private final String baseUrl = "https://www.flipkart.com";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginToFlipkart() {
        driver.get(baseUrl);
        WebElement loginCloseButton = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
        loginCloseButton.click();

        WebElement loginButton = driver.findElement(By.cssSelector("a._1_3w1N"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.cssSelector("input._2IX_2-._2LYh3d.VJZDxU"));
        emailField.sendKeys("your-email@example.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh.VJZDxU"));
        passwordField.sendKeys("your-password");

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
