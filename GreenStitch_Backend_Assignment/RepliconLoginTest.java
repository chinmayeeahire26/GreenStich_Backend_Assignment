public class RepliconLoginTest {

    public void loginToReplicon() {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://replicon.com");

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
        String expectedUrl = "https://replicon.com/dashboard";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

        // Close the driver
        driver.quit();
    }
}