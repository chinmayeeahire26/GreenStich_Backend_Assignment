using System;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace SeleniumTest {
    [TestFixture]
    public class SampleTest {
        private IWebDriver driver;

        [SetUp]
        public void Setup() {
            // Initialize the ChromeDriver
            driver = new ChromeDriver();
        }

        [Test]
        public void OpenGoogleTest() {
            // Navigate to Google
            driver.Navigate().GoToUrl("https://www.google.com");
            // Find the search box using its name attribute
            IWebElement searchBox = driver.FindElement(By.Name("q"));
            // Enter text into the search box
            searchBox.SendKeys("Selenium WebDriver");
            // Submit the search form
            searchBox.Submit();
            // Wait for the results to appear
            System.Threading.Thread.Sleep(2000);
            // Assert that the title contains "Selenium WebDriver"
            Assert.IsTrue(driver.Title.Contains("Selenium WebDriver"));
        }

        [TearDown]
        public void Teardown() {
            // Close the browser
            driver.Quit();
        }
    }
}