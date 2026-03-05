package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class LoginPage extends BasePage {

    private By emailField = By.cssSelector(".contact #customer_session_username");
    private By passwordField = By.cssSelector(".contact #customer_session_password");
    private By loginBtn = By.cssSelector("[href='#customer']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigating to Login Page")
    public void navigateTo() {
        driver.get("https://www.keflahayot.co.il/customer_login");
    }

    @Step("Logging in with email: {email} and password")
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}