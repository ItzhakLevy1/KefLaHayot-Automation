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

    /*** The About elemtnts ***/

    private By termsAndCondition = By.cssSelector("[for='terms_agree__tickets_2']");
    private By acceptMailing = By.cssSelector("span.newsletter_field");

    public AboutPage(WebDriver driver) {

        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

    @Step("Navigation to About page")
    public void navigateToAboutPage(){
        driver.get("https://www.keflahayot.co.il/about");
  }

  public void HighlightElements(){
      WebElement tac = wait.until(ExpectedConditions.visibilityOfElementLocated(termsAndCondition));
      WebElement am = wait.until(ExpectedConditions.elementToBeClickable(acceptMailing));

      ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", am);

      HighlightUtils.highlightElement(driver, tac);
      HighlightUtils.highlightElement(driver, am);
  }

}
