package pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CookieBannerComponent {

    // WebDriver and WebDriverWait are declared at the class level so they can be used across all methods in this component
    private WebDriver driver;
    private WebDriverWait wait;

     /*** The cookie banner element ***/
    // div[class*='cookiesPopup'] means: search for a div which has a class that contains both "cookiesPopup" and "wrapper"
    private By cookieBanner = By.cssSelector("div[class*='cookiesPopup'][class*='wrapper']");

    // The button within the cookie banner element
    private By cookieAcceptBtn = By.xpath("//a[contains(text(), 'מאשר')]");

    // Constructor: Initializes the WebDriver and WebDriverWait for this component
    public CookieBannerComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to accept cookies by clicking the accept button on the banner
    @Step("Accepting cookies and waiting for banner to disappear")
    public void acceptCookies() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptBtn));
            button.click();
        } catch (Exception e) {
            System.out.println("Cookie banner not found or already closed");
        }
    }

    // Method to check if the cookie banner is currently visible on the page
    @Step("Checking if cookie banner is visible")
    public boolean isCookieBannerVisible() {
        try {
            return driver.findElement(cookieBanner).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to wait for the cookie banner to disappear from the UI after accepting cookies
    public void waitForBannerToDisappear() {
        try {
            // Wait until the banner is either invisible or not present in the DOM
            wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieBanner));
        } catch (Exception e) {
            System.out.println("Banner did not disappear within the timeout");
        }
    }
}