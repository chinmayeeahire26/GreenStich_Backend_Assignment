public class MouseLoginTest {
    // Method to automate login to Mouse application
    public void loginToMouse() {
        // Initialize WebDriver (assuming ChromeDriver and WebDriverManager are configured as per blueprint)
        WebDriver driver = new ChromeDriver();
        try {
            // Navigate to Mouse application login page
            driver.get("https://mouseapp.example.com/login");

            // Locate username field and enter username
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("testuser");

            // Locate password field and enter password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("password123");

            // Locate and click login button
            WebElement loginButton = driver.findElement(By.id("loginBtn"));
            loginButton.click();

            // Wait for login to complete and verify successful login
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("dashboard"));

            // Optionally assert login success by checking presence of logout button
            WebElement logoutButton = driver.findElement(By.id("logoutBtn"));
            if (!logoutButton.isDisplayed()) {
                throw new AssertionError("Login failed: Logout button not displayed.");
            }

        } finally {
            // Clean up and close browser
            driver.quit();
        }
    }
}