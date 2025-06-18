import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public MobileLoginTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void loginToMobileApp(String username, String password) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usernameFieldId")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordFieldId")));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButtonId")));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Add assertions or further steps as needed
    }
}