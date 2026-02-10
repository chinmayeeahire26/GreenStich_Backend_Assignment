using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;

namespace WebAppTests
{
    public class LoginTests
    {
        private IWebDriver driver;

        [SetUp]
        public void Setup()
        {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://example.com/login");
        }

        [Test]
        public void LoginTest()
        {
            var usernameField = driver.FindElement(By.Id("username"));
            var passwordField = driver.FindElement(By.Id("password"));
            var loginButton = driver.FindElement(By.Id("loginButton"));

            usernameField.SendKeys("testuser");
            passwordField.SendKeys("password123");
            loginButton.Click();

            var welcomeMessage = driver.FindElement(By.Id("welcomeMessage"));
            Assert.AreEqual("Welcome, testuser!", welcomeMessage.Text);
        }

        [TearDown]
        public void Teardown()
        {
            driver.Quit();
        }
    }
}