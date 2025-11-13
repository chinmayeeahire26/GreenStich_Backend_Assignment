public class ZeptoLoginTest {
    public void loginToZeptoPage() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.zepto.com");

        // Locate and fill in the username field
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("testUser");

        // Locate and fill in the password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("testPassword");

        // Locate and click the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Validate successful login
        String expectedUrl = "https://www.zepto.com/dashboard";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        // Close the driver
        driver.quit();
    }
}