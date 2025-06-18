public class MyntraLoginTest {
 public void loginToMyntra() {
 // Initialize WebDriver
 WebDriver driver = new ChromeDriver();
 // Navigate to Myntra login page
 driver.get("https://www.myntra.com/login");
 // Locate username field and enter username
 WebElement usernameField = driver.findElement(By.id("username"));
 usernameField.sendKeys("yourUsername");
 // Locate password field and enter password
 WebElement passwordField = driver.findElement(By.id("password"));
 passwordField.sendKeys("yourPassword");
 // Locate and click login button
 WebElement loginButton = driver.findElement(By.id("loginButton"));
 loginButton.click();
 // Verify login success
 WebElement accountElement = driver.findElement(By.id("account"));
 assertTrue(accountElement.isDisplayed());
 // Close the browser
 driver.quit();
 }
}