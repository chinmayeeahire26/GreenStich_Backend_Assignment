import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HPLoginTest {

    @Test
    public void loginToHP() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("yourUsername");
        passwordField.sendKeys("yourPassword");
        loginButton.click();

        // Add assertions to verify successful login
        // Example: Assert.assertTrue(driver.findElement(By.id("logoutButton")).isDisplayed());

        driver.quit();
    }

}