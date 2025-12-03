public class ZeptoLoginTest {
    public void loginToZepto(String username, String password) {
        // Navigate to Zepto login page
        driver.get("https://www.zepto.com/login");
        // Enter username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
        // Enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        // Click login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        // Validate login success
        WebElement dashboard = driver.findElement(By.id("dashboard"));
        assertTrue(dashboard.isDisplayed(), "Login failed, dashboard not displayed.");
    }
}