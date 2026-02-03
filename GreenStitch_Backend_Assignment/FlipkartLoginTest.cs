using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;

namespace AutomationTests {
    public class LoginTests {
        private IWebDriver driver;

        [SetUp]
        public void Setup() {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("http://example.com/login");
        }

        [Test]
        public void LoginTest() {
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