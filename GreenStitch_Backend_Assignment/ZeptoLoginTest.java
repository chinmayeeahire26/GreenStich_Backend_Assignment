public class ZeptoLoginTest {
    public void logInToZepto() {
        // Navigate to Zepto login page
        driver.get("https://www.zepto.com/login");

        // Locate and interact with username field
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("testUser");

        // Locate and interact with password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("testPassword123");

        // Locate and click the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Validate successful login
        WebElement dashboard = driver.findElement(By.id("dashboard"));
        Assert.assertTrue(dashboard.isDisplayed(), "Login failed or dashboard not displayed.");
    }
}