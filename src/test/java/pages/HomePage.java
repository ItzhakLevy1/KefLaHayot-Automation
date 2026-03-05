package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utils.HighlightUtils;

public class HomePage extends BasePage {

    private By logoutBtn1 = By.xpath("//a[contains(text(), 'התנתק')]");
    private By logoutBtn2 = By.xpath("//a[contains(text(), 'יציאה מהמערכת')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking if 'Logout' button is displayed")
    public boolean isLogoutBtn1Displayed() {
        // 1. First, find the element
        WebElement element = driver.findElement(logoutBtn1);
        // 2. Then, highlight it
        HighlightUtils.highlightElement(driver, element);
        return element.isDisplayed();
    }

    @Step("Checking if 'Exit System' button is displayed")
    public boolean isLogoutBtn2Displayed() {
        // 1. First, find the element
        WebElement element = driver.findElement(logoutBtn2);
        // 2. Then, highlight it
        HighlightUtils.highlightElement(driver, element);
        return element.isDisplayed();
    }
}