Based on the provided blueprint and test script, here is a consolidated automation script in C# using Selenium WebDriver. This script includes all necessary setup steps, variable configurations, and a sample test case without repeating test scripts. It uses NUnit as the test framework for better structure and maintainability.

---

### Complete Automation Script with NUnit and Selenium WebDriver (Chrome)

```csharp
using System;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace SeleniumSample
{
    [TestFixture]
    public class GoogleSearchTests
    {
        private IWebDriver driver;
        private WebDriverWait wait;

        // Variables / Settings
        private readonly string url = "https://www.google.com";
        private readonly string searchBoxName = "q";
        private readonly string searchTerm = "Selenium WebDriver C#";

        [SetUp]
        public void Setup()
        {
            // Initialize Chrome Driver
            driver = new ChromeDriver();

            // Initialize explicit wait (up to 10 seconds)
            wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));

            // Maximize browser window (optional)
            driver.Manage().Window.Maximize();
        }

        [Test]
        public void GoogleSearch_ShouldDisplayResults()
        {
            try
            {
                // Navigate to URL
                driver.Navigate().GoToUrl(url);

                // Wait until the search box is visible and enabled
                wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(By.Name(searchBoxName)));

                // Find the search box element by name
                IWebElement searchBox = driver.FindElement(By.Name(searchBoxName));

                // Enter search term
                searchBox.SendKeys(searchTerm);

                // Submit the search form
                searchBox.Submit();

                // Wait for the results page title to contain the search term
                wait.Until(d => d.Title.ToLower().Contains(searchTerm.ToLower()));

                // Assert that the page title contains the search term
                Assert.IsTrue(driver.Title.ToLower().Contains(searchTerm.ToLower()), "Page title does not contain the search term.");

                // Print the page title to the console
                Console.WriteLine("Page Title is: " + driver.Title);
            }
            catch (Exception e)
            {
                Assert.Fail("Test failed with exception: " + e.Message);
            }
        }

        [TearDown]
        public void TearDown()
        {
            // Close the browser and quit the driver
            if (driver != null)
            {
                driver.Quit();
            }
        }
    }
}
```

---

### Explanation & Notes:

- **Project Setup**:  
  - Create a new NUnit Test Project in Visual Studio.  
  - Install NuGet packages:  
    - `Selenium.WebDriver`  
    - `Selenium.WebDriver.ChromeDriver`  
    - `Selenium.Support` (for WebDriverWait and ExpectedConditions)  
    - `NUnit` and `NUnit3TestAdapter` (if not already included)

- **Test Structure**:  
  - `[SetUp]` method initializes the ChromeDriver and WebDriverWait before each test.  
  - `[Test]` method contains the actual test steps.  
  - `[TearDown]` method ensures the browser closes after each test.

- **Explicit Waits**:  
  - Replaces `Thread.Sleep` with `WebDriverWait` for more reliable synchronization.

- **Assertions**:  
  - Validates that the page title contains the search term to confirm the search was successful.

- **Console Output**:  
  - Prints the page title for visibility when running tests.

- **Browser Driver**:  
  - Uses `ChromeDriver` by default; can be replaced with other drivers like `FirefoxDriver` if needed.

---

If you want me to help with additional test cases, other browsers, or integration with CI/CD pipelines, just let me know!