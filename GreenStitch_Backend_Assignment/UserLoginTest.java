public class UserLoginTest {
    public void loginUser() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");
        // Locate username and password fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        // Input credentials
        usernameField.sendKeys("testUser");
        passwordField.sendKeys("testPassword");
        // Click login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        // Validate login success
        String expectedUrl = "https://example.com/dashboard";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        // Close the driver
        driver.quit();
    }
}