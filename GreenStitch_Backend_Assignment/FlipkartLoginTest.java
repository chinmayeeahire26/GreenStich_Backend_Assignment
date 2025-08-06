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
    }

    @Test
    public void loginToFlipkart() {
        driver.get("https://www.flipkart.com");
        WebElement closeLoginPopup = driver.findElement(By.xpath("//button[contains(text(),'✕')]");
        closeLoginPopup.click();
        WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Login')]");
        loginButton.click();
        WebElement usernameField = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']");
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']");
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']");
        usernameField.sendKeys("your_username");
        passwordField.sendKeys("your_password");
        submitButton.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}