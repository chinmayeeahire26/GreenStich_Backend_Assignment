package tests.prompts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PromptEditNegativeTest {

    private final WebDriver driver;

    // NOTE: Replace this constructor with your Blueprint's BaseTest/WebDriverManager pattern.
    public PromptEditNegativeTest() {
        this.driver = DriverFactory.getDriver();
    }

    /**
     * methodName: editPromptWithInvalidData_showsErrorSnackbar
     * Test Case: Attempt to edit a prompt with invalid data that causes an error.
     * Expected: An error message is displayed in the snackbar indicating the edit failure.
     */
    @Test
    public void editPromptWithInvalidData_showsErrorSnackbar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // --- Navigation / preconditions (adapt to your app) ---
        driver.get(System.getProperty("app.baseUrl", "https://your-app-url"));

        // Example locators - replace with stable data-testid selectors from your app
        By promptsNav = By.cssSelector("[data-testid='nav-prompts']");
        By firstPromptRow = By.cssSelector("[data-testid='prompt-row-0']");
        By editButton = By.cssSelector("[data-testid='prompt-edit-button']");
        By promptNameInput = By.cssSelector("[data-testid='prompt-name-input']");
        By saveButton = By.cssSelector("[data-testid='prompt-save-button']");

        // Snackbar locators
        By snackbar = By.cssSelector("[role='alert'], [data-testid='snackbar']");
        By snackbarMessage = By.cssSelector("[role='alert'] .message, [data-testid='snackbar-message']");

        // --- Steps ---
        wait.until(ExpectedConditions.elementToBeClickable(promptsNav)).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstPromptRow)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();

        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(promptNameInput));
        nameInput.clear();

        // Provide invalid data (example: empty name). Adjust to your real validation rule.
        nameInput.sendKeys("");

        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();

        // --- Validation ---
        WebElement snack = wait.until(ExpectedConditions.visibilityOfElementLocated(snackbar));
        Assert.assertTrue(snack.isDisplayed(), "Expected snackbar to be visible after failed edit.");

        // If snackbar text is accessible, validate it contains failure wording
        try {
            WebElement msg = driver.findElement(snackbarMessage);
            String text = msg.getText();
            Assert.assertTrue(
                    text.toLowerCase().contains("error") || text.toLowerCase().contains("failed"),
                    "Expected snackbar message to indicate failure. Actual: " + text
            );
        } catch (Exception ignored) {
            // Some snackbars do not expose a separate message element; visibility check is still enforced.
        }
    }
}
