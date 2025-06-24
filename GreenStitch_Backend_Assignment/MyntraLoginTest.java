import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LenovoLoginTest {

    WebDriver driver;

    @Given("^user is on Lenovo login page$")
    public void userIsOnLenovoLoginPage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.lenovo.com/login");
    }

    @When("^user enters valid credentials$")
    public void userEntersValidCredentials() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("validUsername");
        password.sendKeys("validPassword");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("^user is logged in successfully$")
    public void userIsLoggedInSuccessfully() {
        WebElement profile = driver.findElement(By.id("profile"));
        assert profile.isDisplayed();
        driver.quit();
    }

    @Test
    public void loginToLenovo() {
        userIsOnLenovoLoginPage();
        userEntersValidCredentials();
        userIsLoggedInSuccessfully();
    }

}