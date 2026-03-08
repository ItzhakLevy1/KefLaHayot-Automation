package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactPage extends BasePage{

    // Locators
    private By termsAndConditions = By.xpath("//a[contains(normalize-space(), 'תקנון האתר')]");
    private By shipmentPolicy = By.xpath("//a[contains(normalize-space(), 'מדיניות המשלוחים')]");

    // A constructor
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    // A navigation method to the contact page
    @Step
    public void navigateToContactsPage(){
        driver.get("https://www.keflahayot.co.il/contact");
    }

    @Step("Highlighting Bug 11: Captcha visibility issue")
    public void highlightCaptchaIssue(){
        scrollToAndHighlight(termsAndConditions);
        scrollToAndHighlight(shipmentPolicy);
    }
}
