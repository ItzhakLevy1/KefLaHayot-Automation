package pages;

import org.openqa.selenium.WebDriver;
import pages.components.CookieBannerComponent;


public class BasePage {

    // WebDriver is declared at the class level so it can be used across all pages that extend BasePage
    protected WebDriver driver;

    // An instance of the CookieBannerComponent is created here, so it's available on all pages that extend BasePage
    public CookieBannerComponent cookieBanner;

    // Constructor: Initializes the WebDriver and the CookieBannerComponent
    public BasePage(WebDriver driver) {
        this.driver = driver;

        // Initialize the component here
        this.cookieBanner = new CookieBannerComponent(driver);
    }
}

