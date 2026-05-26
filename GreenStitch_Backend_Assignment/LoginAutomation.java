public class LoginAutomation {
    public void loginToApplicationWithValidCredentials() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://kairos-capgemini.azurewebsites.net/login");

            driver.findElement(By.xpath("//body/app-root[1]/app-login[1]/div[1]/div[2]/div[1]/img[1]")).click();
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/app-header[1]/div[1]/div[1]/nav[1]/a[4]/img[1]")).click();

            driver.findElement(By.xpath("//input[@id='username']")).sendKeys("shaik-raghiba.sulthana@capgemini-test.com");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@1234");

            driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/div[1]/div[1]/app-login-register-modal[1]/div[1]/div[1]/div[1]/form[1]/div[1]/button[1]/span[2]/img[1]")).click();

            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/mat-form-field[1]/div[1]/div[2]/div[1]")).click();
            driver.findElement(By.xpath("//mat-option[@id='mat-option-4']")).click();

            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/mat-form-field[1]/div[1]/div[2]/div[1]/mat-select[1]/div[1]/div[1]/span[1]")).click();
            driver.findElement(By.xpath("//span[contains(text(), 'Requirements Analysis')]")).click();

            driver.findElement(By.xpath("//a[@id='mat-tab-link-6']")).click();
            driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}