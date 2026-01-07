public class ZomatoLoginTest {
    public void loginToZomatoPage() {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.zomato.com");

        // Locate and interact with login elements
        WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(), 'Log in')]"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("testuser@example.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
        submitButton.click();

        // Validate successful login
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Welcome')]")));

        // Clean up
        driver.quit();
    }
}