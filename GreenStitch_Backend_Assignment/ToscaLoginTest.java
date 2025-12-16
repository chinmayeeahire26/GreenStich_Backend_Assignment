public class ToscaLoginTest {
    public void loginToTosca() {
        // Initialize the Tosca environment
        ToscaEnvironment env = new ToscaEnvironment();
        env.setup();

        // Navigate to the login page
        WebDriver driver = env.getDriver();
        driver.get("https://example.com/login");

        // Enter username and password
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("testUser");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("testPassword");

        // Click the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Validate successful login
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        assertTrue(welcomeMessage.isDisplayed(), "Login failed: Welcome message not displayed.");
    }
}