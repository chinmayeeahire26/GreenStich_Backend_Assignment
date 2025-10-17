import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FlipkartLoginTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginToFlipkart() {
        driver.get("https://www.flipkart.com");
        WebElement closeLoginPopup = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
        closeLoginPopup.click();
        WebElement loginButton = driver.findElement(By.cssSelector("a._1_3w1N"));
        loginButton.click();
        WebElement usernameField = driver.findElement(By.cssSelector("input._2IX_2-._2LYh3d.VJZDxU"));
        WebElement passwordField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh.VJZDxU"));
        WebElement submitButton = driver.findElement(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL"));
        usernameField.sendKeys("your_username");
        passwordField.sendKeys("your_password");
        submitButton.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}