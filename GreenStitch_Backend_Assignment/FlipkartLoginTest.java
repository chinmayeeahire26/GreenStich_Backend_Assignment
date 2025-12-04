public class FlipkartLoginTest {
    public void loginToFlipkart() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");

        // Close the login popup if it appears
        try {
            WebElement closeButton = driver.findElement(By.xpath("//button[text()='✕']"));
            closeButton.click();
        } catch (NoSuchElementException e) {
            // No popup appeared, continue
        }

        // Locate the username and password fields
        WebElement usernameField = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));

        // Enter credentials
        usernameField.sendKeys("your_username");
        passwordField.sendKeys("your_password");

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Add assertions to verify successful login
        // Example: Assert.assertTrue(driver.getCurrentUrl().contains("/account"));

        // Close the driver
        driver.quit();
    }
}