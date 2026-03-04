package pages;

import org.openqa.selenium.WebDriver;

// HomePage class extends BasePage, meaning it inherits all the properties and methods of BasePage, including the WebDriver and the CookieBannerComponent
public class HomePage extends BasePage {

    // Constructor: Calls the parent constructor (super) to initialize WebDriver and components
    public HomePage(WebDriver driver) {
        super(driver);
    }
}