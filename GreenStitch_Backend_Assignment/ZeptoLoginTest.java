public class ZeptoLoginTest {
 public void loginToZepto() {
 // Setup WebDriver
 WebDriver driver = new ChromeDriver();
 driver.get("https://www.zepto.com/login");
 
 // Locate and fill in the username
 WebElement usernameField = driver.findElement(By.id("username"));
 usernameField.sendKeys("testUser");
 
 // Locate and fill in the password
 WebElement passwordField = driver.findElement(By.id("password"));
 passwordField.sendKeys("securePassword");
 
 // Click the login button
 WebElement loginButton = driver.findElement(By.id("loginButton"));
 loginButton.click();
 
 // Verify login success
 WebElement dashboard = driver.findElement(By.id("dashboard"));
 Assert.assertTrue(dashboard.isDisplayed());
 
 // Close the driver
 driver.quit();
 }
}