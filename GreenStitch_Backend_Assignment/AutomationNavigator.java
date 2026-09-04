public class AutomationNavigator {
    /**
     * Navigates to the automation screen of a given Epic or Feature.
     * Assumes usage of Selenium WebDriver as per blueprint dependencies.
     * 
     * @param driver WebDriver instance
     * @param epicOrFeatureName Name of the Epic or Feature to navigate to
     */
    public void navigateToAutomationScreen(WebDriver driver, String epicOrFeatureName) {
        // Wait until the main dashboard is loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));

        // Locate the search or navigation input for Epics/Features
        WebElement searchInput = driver.findElement(By.id("epicFeatureSearch"));
        searchInput.clear();
        searchInput.sendKeys(epicOrFeatureName);

        // Wait for the search results to appear and select the correct Epic/Feature
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'search-result') and text()='" + epicOrFeatureName + "']")));
        WebElement epicFeatureElement = driver.findElement(By.xpath("//div[contains(@class,'search-result') and text()='" + epicOrFeatureName + "']"));
        epicFeatureElement.click();

        // Wait for the Epic/Feature detail page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("epicFeatureDetail")));

        // Click on the Automation tab or button
        WebElement automationTab = driver.findElement(By.id("automationTab"));
        automationTab.click();

        // Confirm the automation screen is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("automationScreen")));
    }
}