using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;

namespace AutomationTests
{
    public class LoginTest
    {
        private IWebDriver driver;

        [SetUp]
        public void Setup()
        {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://example.com/login");
        }

        [Test]
        public void TestLogin()
        {
            var usernameField = driver.FindElement(By.Id("username"));
            var passwordField = driver.FindElement(By.Id("password"));
            var loginButton = driver.FindElement(By.Id("loginButton"));

            usernameField.SendKeys("testuser");
            passwordField.SendKeys("password123");
            loginButton.Click();

            Assert.IsTrue(driver.Url.Contains("dashboard"));
        }

        [TearDown]
        public void Teardown()
        {
            driver.Quit();
        }
    }
}