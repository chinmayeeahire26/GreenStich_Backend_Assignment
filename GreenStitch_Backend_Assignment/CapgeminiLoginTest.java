Below is an **automation script** built from your provided **blueprint** (Selenium WebDriver + C# + NUnit + `appsettings.json` config). It **implements the given test case (Valid Login)** end-to-end, using the same configuration-driven approach, without duplicating the “blueprint text” itself.

---

## Project Structure (as implied by blueprint)

```
/YourTestProject
  appsettings.json
  TestSettings.cs
  Config.cs
  DriverFactory.cs
  LoginTests.cs
```

---

## 1) `appsettings.json`
(Ensure **Copy to Output Directory = Copy if newer**)

```json
{
  "Selenium": {
    "BaseUrl": "https://the-internet.herokuapp.com",
    "Browser": "Chrome",
    "Headless": false,
    "ImplicitWaitSeconds": 0,
    "ExplicitWaitSeconds": 10
  },
  "Credentials": {
    "Username": "tomsmith",
    "Password": "SuperSecretPassword!"
  }
}
```

---

## 2) `TestSettings.cs`
```csharp
public class TestSettings
{
    public SeleniumSettings Selenium { get; set; } = new();
    public CredentialsSettings Credentials { get; set; } = new();

    public class SeleniumSettings
    {
        public string BaseUrl { get; set; } = "";
        public string Browser { get; set; } = "Chrome";
        public bool Headless { get; set; }
        public int ImplicitWaitSeconds { get; set; }
        public int ExplicitWaitSeconds { get; set; } = 10;
    }

    public class CredentialsSettings
    {
        public string Username { get; set; } = "";
        public string Password { get; set; } = "";
    }
}
```

---

## 3) `Config.cs`
```csharp
using Microsoft.Extensions.Configuration;

public static class Config
{
    public static TestSettings Load()
    {
        var configuration = new ConfigurationBuilder()
            .SetBasePath(AppContext.BaseDirectory)
            .AddJsonFile("appsettings.json", optional: false, reloadOnChange: false)
            .Build();

        var settings = new TestSettings();
        configuration.Bind(settings);
        return settings;
    }
}
```

---

## 4) `DriverFactory.cs`
```csharp
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

public static class DriverFactory
{
    public static IWebDriver Create(TestSettings settings)
    {
        if (!settings.Selenium.Browser.Equals("Chrome", StringComparison.OrdinalIgnoreCase))
            throw new NotSupportedException("Only Chrome is implemented in this sample.");

        var options = new ChromeOptions();

        if (settings.Selenium.Headless)
        {
            options.AddArgument("--headless=new");
            options.AddArgument("--window-size=1920,1080");
        }

        options.AddArgument("--disable-gpu");
        options.AddArgument("--no-sandbox");

        var driver = new ChromeDriver(options);

        if (settings.Selenium.ImplicitWaitSeconds > 0)
            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(settings.Selenium.ImplicitWaitSeconds);

        return driver;
    }
}
```

---

## 5) `LoginTests.cs` (NUnit automation script for the provided test case)
```csharp
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using SeleniumExtras.WaitHelpers;

namespace YourTestProject;

[TestFixture]
public class LoginTests
{
    private IWebDriver _driver = null!;
    private TestSettings _settings = null!;
    private WebDriverWait _wait = null!;

    [SetUp]
    public void Setup()
    {
        _settings = Config.Load();
        _driver = DriverFactory.Create(_settings);

        _wait = new WebDriverWait(_driver, TimeSpan.FromSeconds(_settings.Selenium.ExplicitWaitSeconds));
    }

    [TearDown]
    public void TearDown()
    {
        if (_driver is null) return;
        _driver.Quit();
        _driver.Dispose();
    }

    [Test]
    public void ValidLogin_ShowsSuccessMessage()
    {
        // Step 1: Navigate to Login page
        _driver.Navigate().GoToUrl($"{_settings.Selenium.BaseUrl}/login");

        // Step 2: Enter username/password from config
        _driver.FindElement(By.Id("username")).SendKeys(_settings.Credentials.Username);
        _driver.FindElement(By.Id("password")).SendKeys(_settings.Credentials.Password);

        // Step 3: Submit
        _driver.FindElement(By.CssSelector("button[type='submit']")).Click();

        // Step 4: Validate success message
        var flash = _wait.Until(ExpectedConditions.ElementIsVisible(By.Id("flash")));
        StringAssert.Contains("You logged into a secure area!", flash.Text);
    }
}
```

---

## Notes to run (minimal)
- Install NuGet packages (per blueprint):
  - `Selenium.WebDriver`
  - `Selenium.WebDriver.ChromeDriver`
  - `DotNetSeleniumExtras.WaitHelpers`
  - `Microsoft.Extensions.Configuration`
  - `Microsoft.Extensions.Configuration.Json`
- Run via Visual Studio Test Explorer or:
  - `dotnet test`

---

If you share additional test cases (e.g., invalid login, logout, missing username/password), I can generate additional NUnit tests using the same blueprint setup without duplicating boilerplate.