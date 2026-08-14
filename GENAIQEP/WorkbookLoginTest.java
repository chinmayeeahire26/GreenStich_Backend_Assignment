public class WorkbookLoginTest {

    public void loginToWorkbook() {
        // Initialize WebDriver (assuming ChromeDriver and WebDriverManager are used as per blueprint)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            // Navigate to the Workbook login page
            driver.get("https://workbook.example.com/login");

            // Locate username and password fields and login button
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginBtn"));

            // Enter credentials (assuming test credentials from blueprint or config)
            usernameField.sendKeys("testuser");
            passwordField.sendKeys("testpassword");

            // Click login
            loginButton.click();

            // Wait for successful login indication (e.g., presence of dashboard element)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));

            // Assert login success (could be enhanced with a test framework assert)
            System.out.println("Login successful: Dashboard is visible.");

        } catch (Exception e) {
            System.err.println("Login failed: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}