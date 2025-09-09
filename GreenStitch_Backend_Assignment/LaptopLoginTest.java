public class LaptopLoginTest {
    public void loginToLaptop() {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
        // Navigate to the login page
        driver.get("http://example.com/login");
        // Enter username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("testUser");
        // Enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("testPassword");
        // Click login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        // Verify login success
        WebElement successMessage = driver.findElement(By.id("successMessage"));
        assert successMessage.isDisplayed();
        // Close the browser
        driver.quit();
    }
}