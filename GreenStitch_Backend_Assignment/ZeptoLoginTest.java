import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeptoLoginTest {

    private WebDriver driver;

    public ZeptoLoginTest() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    public void loginToZepto() {
        driver.get("https://www.zepto.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("testuser");
        passwordField.sendKeys("testpassword");
        loginButton.click();

        // Add assertions here to verify successful login
        // For example: assertTrue(driver.findElement(By.id("logoutButton")).isDisplayed());
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        ZeptoLoginTest test = new ZeptoLoginTest();
        test.loginToZepto();
        test.tearDown();
    }
}