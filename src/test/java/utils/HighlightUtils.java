package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightUtils {

    public static void highlightElement(WebDriver driver, WebElement element) {

        // Create a JavascriptExecutor from the WebDriver to execute JavaScript code in the context of the browser
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Highlight the element with css parameters
        js.executeScript("arguments[0].setAttribute('style', 'border: 10px solid #0003ff;');", element);
        // Add a small delay to make the highlight visible
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void removeHighlight(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Remove the highlight by clearing the style
        js.executeScript("arguments[0].removeAttribute('style');", element);
    }
}
