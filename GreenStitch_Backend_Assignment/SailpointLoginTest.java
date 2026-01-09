public class SailpointLoginTest {
    public void loginToSailpoint() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://sailpoint.example.com");

        // Locate username and password fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter credentials
        usernameField.sendKeys("testUser");
        passwordField.sendKeys("testPassword");

        // Click login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Validate login success
        String expectedUrl = "https://sailpoint.example.com/home";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

        // Close the driver
        driver.quit();
    }
}