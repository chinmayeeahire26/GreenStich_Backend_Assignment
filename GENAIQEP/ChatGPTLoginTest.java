import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ChatGPTLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public ChatGPTLoginTest() {
        // Assuming blueprint specifies ChromeDriver and WebDriverManager is configured
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    public void loginToChatGPT() {
        // Navigate to ChatGPT login page
        driver.get("https://chat.openai.com/auth/login");

        // Wait for email input to be visible and enter email
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        emailInput.clear();
        emailInput.sendKeys(System.getenv("CHATGPT_EMAIL"));

        // Click next or continue button
        WebElement nextButton = driver.findElement(By.xpath("//button[contains(text(),'Next') or contains(text(),'Continue')]");
        nextButton.click();

        // Wait for password input to be visible and enter password
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordInput.clear();
        passwordInput.sendKeys(System.getenv("CHATGPT_PASSWORD"));

        // Click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in') or contains(text(),'Sign in')]");
        loginButton.click();

        // Wait until logged in - e.g., wait for main chat interface to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[placeholder='Send a message.']")));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        ChatGPTLoginTest test = new ChatGPTLoginTest();
        try {
            test.loginToChatGPT();
            System.out.println("Login successful");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            test.tearDown();
        }
    }
}
