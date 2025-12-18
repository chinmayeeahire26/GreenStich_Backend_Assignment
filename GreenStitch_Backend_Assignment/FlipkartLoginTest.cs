using System;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace SeleniumTest {
    [TestFixture]
    public class FlipkartLoginTest {
        private IWebDriver driver;

        [SetUp]
        public void Setup() {
            // Initialize the ChromeDriver
            driver = new ChromeDriver();
            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(10);
        }

        [Test]
        public void LoginToFlipkart() {
            // Navigate to Flipkart
            driver.Navigate().GoToUrl("https://www.flipkart.com");

            // Close the login popup if it appears
            try {
                IWebElement closeButton = driver.FindElement(By.XPath("//button[contains(text(), '✕')]"));
                closeButton.Click();
            } catch (NoSuchElementException) {
                // Do nothing if the popup does not appear
            }

            // Find the login button and click it
            IWebElement loginButton = driver.FindElement(By.XPath("//a[contains(text(), 'Login')]"));
            loginButton.Click();

            // Enter username and password
            IWebElement usernameField = driver.FindElement(By.XPath("//input[@class='_2IX_2- VJZDxU']"));
            usernameField.SendKeys("your_username"); // Replace with valid username

            IWebElement passwordField = driver.FindElement(By.XPath("//input[@type='password']"));
            passwordField.SendKeys("your_password"); // Replace with valid password

            // Click the login button
            IWebElement submitButton = driver.FindElement(By.XPath("//button[@type='submit']"));
            submitButton.Click();

            // Wait for the login to complete and verify successful login
            System.Threading.Thread.Sleep(2000);
            Assert.IsTrue(driver.Title.Contains("Flipkart"), "Login failed or title does not match.");
        }

        [TearDown]
        public void Teardown() {
            // Close the browser
            driver.Quit();
        }
    }
}