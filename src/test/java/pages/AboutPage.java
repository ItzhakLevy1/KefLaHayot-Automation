package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutPage extends BasePage{

    /*** Locators ***/
    private By termsAndCondition = By.cssSelector("[for='terms_agree__tickets_2']");
    private By astriskEmailField = By.cssSelector("#ticket_customer_email");
    private By newsLetterField = By.cssSelector("[class='newsletter_field']");

    public AboutPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

    @Step("Navigation to About page")
    public void navigateToAboutPage(){
        driver.get("https://www.keflahayot.co.il/about");
  }

    @Step("Highlighting Bug 8: Terms contrast issue")
    public void highlightTermsContrast() {
        scrollToAndHighlight(termsAndCondition);
    }

    @Step("Highlighting Bug 9: Terms contrast issue")
    public void highlightEmailAsteriskPositionTest() {
        scrollToAndHighlight(astriskEmailField);
    }

    @Step("Highlighting Bug 10: Terms contrast issue")
    public void highlightNewsLetterTest() {
        scrollToAndHighlight(newsLetterField);
    }

}
