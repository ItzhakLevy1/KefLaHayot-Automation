package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize Chrome driver using WebDriverManager, "clearDriverCache" Forces WebDriverManager to download the latest matching driver
        WebDriverManager.chromedriver().clearDriverCache().setup();

        // Configure Chrome options (e.g., start maximized)
        ChromeOptions options = new ChromeOptions();

        // Opens the browser window in full-screen mode upon startup
        options.addArguments("--start-maximized");

        // Bypasses CORS policy issues (common in Chrome 111+ to allow communication with the driver)
        options.addArguments("--remote-allow-origins=*");

        // Runs the browser in Incognito mode (private browsing, no cookies/history saved)
        options.addArguments("--incognito");

        // Block web push notification pop-ups from websites
        options.addArguments("--disable-notifications");

        // Prevents Chrome from showing the "Save Password" prompt
        options.addArguments("--disable-save-password-bubble");

        // Disables the feature that checks if your passwords were part of a data leak
        options.addArguments("--disable-features=PasswordLeakDetection");

        // Removes the "Chrome is being controlled by automated test software" notification bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // Disables the automation extension that Chrome normally loads during testing
        options.setExperimentalOption("useAutomationExtension", false);


        driver = new ChromeDriver(options);

        // Navigate to the target website
        driver.get("https://www.keflahayot.co.il/");
    }

    // Getter method to provide access to the WebDriver instance for test classes that extend BaseTest
    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser session after each test
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}