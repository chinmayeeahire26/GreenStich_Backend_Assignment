using System;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace SeleniumTest {
    [TestFixture]
    public class AmazonLoginTest {
        private IWebDriver driver;

        [SetUp]
        public void Setup() {
            // Initialize the ChromeDriver
            driver = new ChromeDriver();
        }

        [Test]
        public void LoginToAmazon() {
            // Navigate to Amazon login page
            driver.Navigate().GoToUrl("https://www.amazon.com/ap/signin");

            // Find the email input field and enter the email
            IWebElement emailInput = driver.FindElement(By.Id("ap_email"));
            emailInput.SendKeys("your-email@example.com");

            // Click on continue button
            IWebElement continueButton = driver.FindElement(By.Id("continue"));
            continueButton.Click();

            // Find the password input field and enter the password
            IWebElement passwordInput = driver.FindElement(By.Id("ap_password"));
            passwordInput.SendKeys("your-password");

            // Click on login button
            IWebElement loginButton = driver.FindElement(By.Id("signInSubmit"));
            loginButton.Click();

            // Wait for a moment to ensure the login process is complete
            System.Threading.Thread.Sleep(2000);

            // Assert that the login was successful by checking for a logout link or user name
            Assert.IsTrue(driver.PageSource.Contains("Account & Lists"));
        }

        [TearDown]
        public void Teardown() {
            // Close the browser
            driver.Quit();
        }
    }
}