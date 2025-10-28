import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ZeptoLoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up the WebDriver and navigate to the login page
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.zepto.com/login");
    }

    @Test
    public void loginToZepto() {
        // Locate the username and password fields and login button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        // Enter credentials and submit the form
        usernameField.sendKeys("yourUsername");
        passwordField.sendKeys("yourPassword");
        loginButton.click();

        // Add assertions to verify successful login
        // Example: Assert that the user is redirected to the dashboard
        // Assert.assertEquals("https://www.zepto.com/dashboard", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}