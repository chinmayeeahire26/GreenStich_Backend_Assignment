using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;

namespace AutomationTests {
    public class LoginTest {
        private IWebDriver driver;

        [SetUp]
        public void Setup() {
            driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
        }

        [Test]
        public void Login() {
            driver.Navigate().GoToUrl("https://example.com/login");
            driver.FindElement(By.Id("username")).SendKeys("testuser");
            driver.FindElement(By.Id("password")).SendKeys("password123");
            driver.FindElement(By.Id("loginButton")).Click();
            Assert.IsTrue(driver.FindElement(By.Id("welcomeMessage")).Displayed);
        }

        [TearDown]
        public void TearDown() {
            driver.Quit();
        }
    }
}