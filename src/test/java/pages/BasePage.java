package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.CookieBannerComponent;
import utils.HighlightUtils;

import java.time.Duration;


public class BasePage {

    // WebDriver is declared at the class level so it can be used across all pages that extend BasePage
    protected WebDriver driver;
    protected WebDriverWait wait;


    // An instance of the CookieBannerComponent is created here, so it's available on all pages that extend BasePage
    public CookieBannerComponent cookieBanner;

    // Constructor: Initializes the WebDriver and the CookieBannerComponent
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize the component here
        this.cookieBanner = new CookieBannerComponent(driver);
    }

    // This method scrolls to the specified element and highlights it using JavaScript. It waits for the element to be visible before performing the actions.
    protected void scrollToBottomOfPageAndHighlight(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        HighlightUtils.highlightElement(driver, element);
    }

    protected void scrollToAndHighlight(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        // Scroll to the element with a smooth animation and center it in the viewport
        String scrollScript = "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});";
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(scrollScript, element);

        // Wait for the scrolling to complete before highlighting
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }

        HighlightUtils.highlightElement(driver, element);
    }
}

