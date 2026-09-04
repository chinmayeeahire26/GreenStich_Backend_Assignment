public class WWELoginTest {

    public void loginToWWE() {
        // Initialize WebDriver (assuming ChromeDriver and WebDriverManager are used as per blueprint)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to WWE login page
            driver.get("https://www.wwe.com/login");

            // Wait until login form is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-email")));

            // Enter username/email
            WebElement emailField = driver.findElement(By.id("login-email"));
            emailField.clear();
            emailField.sendKeys("your_email@example.com");

            // Enter password
            WebElement passwordField = driver.findElement(By.id("login-password"));
            passwordField.clear();
            passwordField.sendKeys("your_password");

            // Click login button
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();

            // Verify successful login by checking presence of user profile or logout button
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".user-profile, .logout-button")));

            System.out.println("Login to WWE successful.");

        } catch (Exception e) {
            System.err.println("Login to WWE failed: " + e.getMessage());
            throw e;
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}