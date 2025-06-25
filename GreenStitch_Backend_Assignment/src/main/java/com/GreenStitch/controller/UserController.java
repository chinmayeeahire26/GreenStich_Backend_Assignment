import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLoginTest {

    public void loginToFlipkart() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");

        // Close the login popup if it appears
        try {
            WebElement closeButton = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
            closeButton.click();
        } catch (Exception e) {
            System.out.println("Login popup not displayed");
        }

        // Click on the login button
        WebElement loginButton = driver.findElement(By.cssSelector("a._1_3w1N"));
        loginButton.click();

        // Enter username and password
        WebElement usernameField = driver.findElement(By.cssSelector("input._2IX_2-._2LYh3d"));
        usernameField.sendKeys("your_username");

        WebElement passwordField = driver.findElement(By.cssSelector("input._2IX_2-._3mctLh"));
        passwordField.sendKeys("your_password");

        // Submit the login form
        WebElement submitButton = driver.findElement(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL"));
        submitButton.click();

        // Verify login success
        // Add verification logic here

        driver.quit();
    }
}