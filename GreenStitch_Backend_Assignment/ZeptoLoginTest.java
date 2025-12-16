public class ZeptoLoginTest {
    public void loginToZepto() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.zepto.com/login");

        // Locate and fill in the username field
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("testUser");

        // Locate and fill in the password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("testPassword");

        // Locate and click the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Add assertions to verify successful login
        String expectedUrl = "https://www.zepto.com/dashboard";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

        // Close the driver
        driver.quit();
    }
}