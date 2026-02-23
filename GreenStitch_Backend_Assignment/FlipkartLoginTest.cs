using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;

namespace SeleniumWebDriverExample
{
    public class GoogleSearchTest
    {
        public void PerformGoogleSearch()
        {
            // Set up the ChromeDriver (make sure you have the ChromeDriver executable in your PATH or project directory)
            IWebDriver driver = new ChromeDriver();

            try
            {
                // Navigate to Google
                driver.Navigate().GoToUrl("https://www.google.com");

                // Maximize the browser window
                driver.Manage().Window.Maximize();

                // Find the search box using its name attribute
                IWebElement searchBox = driver.FindElement(By.Name("q"));

                // Enter text into the search box
                searchBox.SendKeys("Selenium WebDriver C# example");

                // Submit the search form
                searchBox.Submit();

                // Wait for a few seconds to see the results (optional)
                System.Threading.Thread.Sleep(3000);

                // Print the title of the page
                Console.WriteLine("Page Title: " + driver.Title);
            }
            catch (Exception ex)
            {
                // Print any exceptions that occur
                Console.WriteLine("An error occurred: " + ex.Message);
            }
            finally
            {
                // Close the browser
                driver.Quit();
            }
        }
    }
}