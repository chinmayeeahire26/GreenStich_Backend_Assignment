import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutTest {
    private WebDriver driver;

    public void logoutUser() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        
        // Initialize a new WebDriver instance
        driver = new ChromeDriver();
        
        try {
            // Open the website
            driver.get("https://kairos-capgemini.azurewebsites.net/login");
            
            // Click on user profile or settings icon
            WebElement profileIcon = driver.findElement(By.xpath("//body/app-root[1]/app-login[1]/div[1]/div[2]/div[1]/img[1]"));
            profileIcon.click();
            
            // Select 'Logout' from the dropdown menu
            WebElement logoutOption = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
            logoutOption.click();
            
            // Confirm logout if prompted
            try {
                WebElement confirmLogout = driver.findElement(By.xpath("//button[contains(text(), 'Yes')]"));
                confirmLogout.click();
            } catch (Exception e) {
                // Logout confirmation not prompted
            }
            
            // Verify that the login screen is displayed
            WebElement loginTitle = driver.findElement(By.xpath("//h1[contains(text(), 'Login')]"));
            if (loginTitle.isDisplayed()) {
                System.out.println("User successfully logged out and login screen is displayed.");
            } else {
                System.out.println("Logout failed: Login screen not displayed.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}