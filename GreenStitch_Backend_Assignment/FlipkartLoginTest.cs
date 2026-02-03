using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

public class AjioLoginTest {
    private IWebDriver driver;

    public void LoginTest() {
        driver = new ChromeDriver();
        driver.Navigate().GoToUrl("https://www.ajio.com");
        driver.FindElement(By.Id("username")).SendKeys("testuser");
        driver.FindElement(By.Id("password")).SendKeys("password123");
        driver.FindElement(By.Id("loginButton")).Click();
        // Add assertions here to validate successful login
        driver.Quit();
    }
}