using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

public class AjioLoginTest {
    public void LoginTest() {
        IWebDriver driver = new ChromeDriver();
        driver.Navigate().GoToUrl("https://www.ajio.com");
        driver.FindElement(By.Id("username")).SendKeys("testuser");
        driver.FindElement(By.Id("password")).SendKeys("password123");
        driver.FindElement(By.Id("loginButton")).Click();
        // Add assertions to verify login success
        driver.Quit();
    }
}