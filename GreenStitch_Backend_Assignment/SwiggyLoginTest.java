import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class SwiggyLoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.swiggy.com/");
    }

    @Test
    public void loginToSwiggy() {
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("your_mobile_number");
        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE')]")).click();
        // Handle OTP if required
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}

// Cucumber Step Definitions
public class SwiggyLoginSteps {

    private WebDriver driver;

    @Given("User is on the Swiggy login page")
    public void user_is_on_the_swiggy_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.swiggy.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
    }

    @When("User enters mobile number {string}")
    public void user_enters_mobile_number(String mobileNumber) {
        driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobileNumber);
    }

    @And("User clicks on CONTINUE button")
    public void user_clicks_on_continue_button() {
        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE')]")).click();
    }

    @Then("User should be prompted to enter OTP")
    public void user_should_be_prompted_to_enter_otp() {
        // Add assertion or verification here
    }

    @After
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}