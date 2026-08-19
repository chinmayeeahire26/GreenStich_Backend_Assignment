using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;

namespace AutomationTests
{
    public class SampleTestScript
    {
        private IWebDriver driver;

        [SetUp]
        public void Setup()
        {
            driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
        }

        [Test]
        public void sampleTestScript()
        {
            driver.Navigate().GoToUrl("https://example.com");
            Assert.AreEqual("Example Domain", driver.Title);
            IWebElement moreInfoLink = driver.FindElement(By.CssSelector("a[href='https://www.iana.org/domains/example']"));
            Assert.IsTrue(moreInfoLink.Displayed);
            moreInfoLink.Click();
            Assert.IsTrue(driver.Url.Contains("iana.org"));
        }

        [TearDown]
        public void TearDown()
        {
            driver.Quit();
        }
    }
}