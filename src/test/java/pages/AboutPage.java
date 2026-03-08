package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HighlightUtils;

import java.time.Duration;

public class AboutPage extends BasePage{

    // WebDriverWait is declared at the class level so it can be used across all methods in this component
    private WebDriverWait wait;

    /*** Locators ***/

    private By termsAndCondition = By.cssSelector("[for='terms_agree__tickets_2']");

    public AboutPage(WebDriver driver) {

        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

    @Step("Navigation to About page")
    public void navigateToAboutPage(){
        driver.get("https://www.keflahayot.co.il/about");
  }

    // This method scrolls to the specified element and highlights it using JavaScript. It waits for the element to be visible before performing the actions.
    private void scrollToAndHighlight(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        HighlightUtils.highlightElement(driver, element);
    }

    @Step("Highlighting Bug 8: Terms contrast issue")
    public void highlightTermsContrast() {
        scrollToAndHighlight(termsAndCondition);
    }

}
