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
        // Click on login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        // Validate login success
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        assertTrue(welcomeMessage.isDisplayed(), "Login failed: Welcome message not displayed.");
    }
}