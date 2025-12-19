using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace FlipkartAutomation
{
    public class FlipkartLoginTest
    {
        public void LoginToFlipkart()
        {
            // Set up the ChromeDriver
            IWebDriver driver = new ChromeDriver();
            try
            {
                // Navigate to Flipkart
                string baseUrl = "https://www.flipkart.com";
                driver.Navigate().GoToUrl(baseUrl);

                // Maximize the browser window
                driver.Manage().Window.Maximize();

                // Set implicit wait time
                driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(10);

                // Close the login popup
                IWebElement closeLoginPopup = driver.FindElement(By.XPath("//button[contains(text(),'✕')]"));
                closeLoginPopup.Click();

                // Example: Verify the page title
                string expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
                string actualTitle = driver.Title;
                if (actualTitle.Equals(expectedTitle))
                {
                    Console.WriteLine("Test Passed: Title is correct.");
                }
                else
                {
                    Console.WriteLine("Test Failed: Title is incorrect.");
                }
            }
            catch (NoSuchElementException ex)
            {
                Console.WriteLine("Element not found: " + ex.Message);
            }
            finally
            {
                // Close the browser
                driver.Quit();
            }
        }
    }
}