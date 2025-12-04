public class FlickcartLoginTest {
    public void loginToFlickcart() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flickcart.com");

        // Locate and fill in the username field
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("testuser");

        // Locate and fill in the password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");

        // Locate and click the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Validate successful login
        String expectedUrl = "https://www.flickcart.com/home";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

        // Close the driver
        driver.quit();
    }
}