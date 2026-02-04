using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

public class LoginTest {
    private IWebDriver driver;

    public void LoginUser(string username, string password) {
        driver = new ChromeDriver();
        driver.Navigate().GoToUrl("https://example.com/login");

        var usernameField = driver.FindElement(By.Id("username"));
        var passwordField = driver.FindElement(By.Id("password"));
        var loginButton = driver.FindElement(By.Id("loginButton"));

        usernameField.SendKeys(username);
        passwordField.SendKeys(password);
        loginButton.Click();

        // Add assertions here to verify successful login
        // Example: Assert.AreEqual("Welcome", driver.FindElement(By.Id("welcomeMessage")).Text);

        driver.Quit();
    }
}