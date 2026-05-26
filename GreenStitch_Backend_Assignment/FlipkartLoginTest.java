import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SwagLabsLoginTest {

    private WebDriver driver;

    @Test
    public void loginToSwagLabs() {
        // Locate username field and enter "standard_user"
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameField.clear();
        usernameField.sendKeys("standard_user");

        // Locate password field and enter "secret_sauce"
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.clear();
        passwordField.sendKeys("secret_sauce");

        // Locate login button and click
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
    }
}