public class AjioLoginTest {
    public void loginToAjio() {
        // Initialize WebDriver (assuming ChromeDriver and WebDriverManager are used as per blueprint)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            // Navigate to Ajio login page
            driver.get("https://www.ajio.com/shop/sale");

            // Click on the login button to open login form
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sign In / Join AJIO']")));
            loginButton.click();

            // Switch to login iframe if present (some sites use iframe for login)
            // If not applicable, this can be removed
            // driver.switchTo().frame("loginIframe");

            // Enter username/email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-email")));
            emailField.sendKeys("testuser@example.com");

            // Enter password
            WebElement passwordField = driver.findElement(By.id("login-password"));
            passwordField.sendKeys("TestPassword123");

            // Click on submit/login button
            WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
            submitButton.click();

            // Wait for login to complete, e.g., wait for user profile element
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'My Account')]")));

            // Optionally assert login success
            System.out.println("Login successful");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}