public class ZeptoLoginTest {
    public void loginToZepto() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.zepto.com/login");

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
        String expectedUrl = "https://www.zepto.com/dashboard";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

        // Close the driver
        driver.quit();
    }
}