import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class MobileLoginTest {

    private AppiumDriver<MobileElement> driver;

    public void loginToMobileApplication() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("appPackage", "com.example.app");
            capabilities.setCapability("appActivity", "com.example.app.MainActivity");

            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            MobileElement usernameField = driver.findElementById("com.example.app:id/username");
            MobileElement passwordField = driver.findElementById("com.example.app:id/password");
            MobileElement loginButton = driver.findElementById("com.example.app:id/loginButton");

            usernameField.sendKeys("testuser");
            passwordField.sendKeys("password123");
            loginButton.click();

            // Add assertions to verify successful login
            MobileElement homeScreen = driver.findElementById("com.example.app:id/homeScreen");
            assert homeScreen.isDisplayed();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}