public class ZeptoLoginTest {
    public void loginToZepto(String username, String password) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.zepto.com/login");

        // Locate username and password fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter credentials
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Click on login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Validate login success
        String expectedUrl = "https://www.zepto.com/dashboard";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

        // Close the driver
        driver.quit();
    }
}