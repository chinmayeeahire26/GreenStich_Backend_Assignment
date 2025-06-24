import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DunzoLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public DunzoLoginTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void loginToDunzoApp(String username, String password) {
        driver.get("https://www.dunzo.com/login");

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Verify login success
        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
        if (dashboard.isDisplayed()) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }
}