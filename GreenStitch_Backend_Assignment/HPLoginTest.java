Certainly! Below is a strictly automated test script created from your provided test-script details, using C# with Selenium WebDriver and NUnit framework for better structure and maintainability. The variables are configurable, and explicit waits replace the simple `Thread.Sleep` for robustness.

---

### Automated Test Script (C# with Selenium WebDriver and NUnit)

```csharp
using System;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace SeleniumAutomation
{
    [TestFixture]
    public class GoogleSearchTest
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
            // Initialize ChromeDriver
            driver = new ChromeDriver();

            // Initialize WebDriverWait with timeout of 10 seconds
            wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));

            // Maximize browser window (optional)
            driver.Manage().Window.Maximize();
        }

        [Test]
        public void SearchGoogleAndVerifyTitle()
        {
            try
            {
                // Navigate to URL
                driver.Navigate().GoToUrl(url);

                // Wait until the search box is visible and enabled
                IWebElement searchBox = wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(By.Name(searchBoxName)));

                // Enter search term
                searchBox.SendKeys(searchTerm);

                // Submit the search form
                searchBox.Submit();

                // Wait until the title contains the search term (indicating results loaded)
                wait.Until(d => d.Title.ToLower().Contains("selenium webdriver c#"));

                // Output the page title to the console
                Console.WriteLine("Page Title is: " + driver.Title);

                // Assert that the title contains the search term (basic verification)
                Assert.IsTrue(driver.Title.ToLower().Contains("selenium webdriver c#"), "Page title does not contain the search term.");
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

### Explanation:

- **NUnit Framework**: The test is wrapped inside NUnit `[TestFixture]` and `[Test]` attributes for proper test execution.
- **Setup and TearDown**: `Setup()` initializes the driver and wait before each test; `TearDown()` ensures cleanup.
- **Explicit Waits**: Uses `WebDriverWait` and SeleniumExtras ExpectedConditions to wait for elements and page title instead of `Thread.Sleep`.
- **Assertions**: Verifies that the page title contains the search term to confirm the search worked.
- **Console Output**: Prints the page title for visibility during test runs.
- **Configurable Variables**: URL, search box name, and search term are defined as readonly fields for easy modification.

---

### How to Run:

1. Create a new NUnit Test Project in Visual Studio.
2. Add NuGet packages:
   - Selenium.WebDriver
   - Selenium.WebDriver.ChromeDriver
   - Selenium.Support
   - NUnit
   - NUnit3TestAdapter (for running tests inside Visual Studio)
3. Replace the default test class with the above code.
4. Build and run tests via Test Explorer.

---

If you want the script adapted for MSTest, XUnit, or with additional features like logging or screenshots on failure, just let me know!