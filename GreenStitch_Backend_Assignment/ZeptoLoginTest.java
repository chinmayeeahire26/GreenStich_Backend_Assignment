public class ZeptoLoginTest {
    public void loginToZepto() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.zepto.com");
        
        // Locate and fill username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("testuser");
        
        // Locate and fill password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");
        
        // Locate and click login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        
        // Assert login success
        WebElement dashboard = driver.findElement(By.id("dashboard"));
        Assert.assertTrue(dashboard.isDisplayed());
        
        // Close the driver
        driver.quit();
    }
}