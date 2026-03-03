package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // English comment: Initialize Chrome driver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // English comment: Configure Chrome options (e.g., start maximized)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        // English comment: Define implicit wait for general element discovery
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // English comment: Navigate to the target website
        driver.get("https://www.keflahayot.co.il/");
    }

    @AfterMethod
    public void tearDown() {
        // English comment: Close the browser session after each test
        if (driver != null) {
            driver.quit();
        }
    }
}