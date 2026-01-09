public class OktaLoginTest {
    public void loginToOkta() {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://your-okta-domain.com");

        // Locate username field and enter username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("your-username");

        // Locate password field and enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("your-password");

        // Locate and click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Add assertions to verify successful login
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("dashboard"));

        // Clean up
        driver.quit();
    }
}