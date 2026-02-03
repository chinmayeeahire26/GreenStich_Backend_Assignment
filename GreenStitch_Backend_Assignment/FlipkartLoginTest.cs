using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;

namespace MyAutomationTests {
    public class LoginTest {
        private IWebDriver driver;

        [SetUp]
        public void Setup() {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://example.com/login");
        }

        [Test]
        public void TestLogin() {
            driver.FindElement(By.Id("username")).SendKeys("testuser");
            driver.FindElement(By.Id("password")).SendKeys("password123");
            driver.FindElement(By.Id("loginButton")).Click();

            Assert.IsTrue(driver.FindElement(By.Id("welcomeMessage")).Displayed);
        }

        [TearDown]
        public void Teardown() {
            driver.Quit();
        }
    }
}