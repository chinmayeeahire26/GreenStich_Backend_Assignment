public class ZeptoLoginTest {
    public void loginToZeptoPage() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.zepto.com");

        // Locate and interact with login elements
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("testuser@example.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Validate successful login
        String expectedUrl = "https://www.zepto.com/dashboard";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

        // Close the driver
        driver.quit();
    }
}