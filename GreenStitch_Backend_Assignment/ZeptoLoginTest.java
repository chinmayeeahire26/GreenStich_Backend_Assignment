public class ZeptoLoginTest {
 public void loginToZepto() {
 // Set up WebDriver and navigate to Zepto login page
 WebDriver driver = new ChromeDriver();
 driver.get("https://www.zepto.com/login");

 // Locate and fill in login form fields
 WebElement usernameField = driver.findElement(By.id("username"));
 WebElement passwordField = driver.findElement(By.id("password"));
 usernameField.sendKeys("your_username");
 passwordField.sendKeys("your_password");

 // Submit the login form
 WebElement loginButton = driver.findElement(By.id("loginButton"));
 loginButton.click();

 // Verify login success
 WebElement successMessage = driver.findElement(By.id("successMessage"));
 Assert.assertTrue(successMessage.isDisplayed());

 // Clean up
 driver.quit();
 }
}