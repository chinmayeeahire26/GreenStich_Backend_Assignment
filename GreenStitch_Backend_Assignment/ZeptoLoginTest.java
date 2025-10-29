import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ZeptoLoginTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void loginToZepto() {
        driver.get("https://www.zepto.com/login");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("your_username");
        passwordField.sendKeys("your_password");
        loginButton.click();

        WebElement homepageElement = driver.findElement(By.id("homepageElement"));
        Assert.assertTrue(homepageElement.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}