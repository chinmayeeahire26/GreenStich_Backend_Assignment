using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

public class GoogleSearchTest
{
    public void SearchGoogle()
    {
        // Initialize ChromeDriver with default options
        using (IWebDriver driver = new ChromeDriver())
        {
            try
            {
                // Navigate to Google homepage
                driver.Navigate().GoToUrl("https://www.google.com");

                // Wait until the search box is present and visible
                WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
                IWebElement searchBox = wait.Until(drv => drv.FindElement(By.Name("q")));

                // Enter search query
                searchBox.SendKeys("Selenium WebDriver with C#");

                // Submit the search form
                searchBox.Submit();

                // Wait until search results are loaded (wait for results stats element)
                wait.Until(drv => drv.FindElement(By.Id("result-stats")));
            }
            finally
            {
                // Close the browser
                driver.Quit();
            }
        }
    }
}