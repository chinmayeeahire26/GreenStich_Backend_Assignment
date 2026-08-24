public class CapgeminiLoginTest {
    // Method to automate login to Capgemini portal
    public void loginToCapgemini() {
        // Initialize WebDriver (assuming ChromeDriver and WebDriverManager are used as per blueprint)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            // Maximize browser window
            driver.manage().window().maximize();
            // Navigate to Capgemini login page
            driver.get("https://www.capgemini.com/login");

            // Locate username field and enter username
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("your_username"); // Replace with valid username or fetch from config

            // Locate password field and enter password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("your_password"); // Replace with valid password or fetch from config

            // Locate and click login button
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            // Wait for login to complete and verify successful login
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("dashboard"));

            // Optionally assert login success by checking presence of a dashboard element
            WebElement dashboardElement = driver.findElement(By.id("dashboard"));
            if (dashboardElement.isDisplayed()) {
                System.out.println("Login successful.");
            } else {
                System.out.println("Login failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}