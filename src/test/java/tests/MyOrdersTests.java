package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.AllureAttachments;
import utils.HighlightUtils;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.time.Duration;

public class MyOrdersTests extends BaseTest {

    @Test
    @Description("TC-02: Verify 'My Orders' button is intercepted by Dropdown menu after login")
    public void testMyOrdersClickIntercepted() {

        LoginPage loginPage = new LoginPage(driver);

        // Navigate to login page and perform login with valid credentials
        loginPage.navigateTo();
        loginPage.login("aaa@gmail.com", "aaa@gmail.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Identify the "My Orders" button
        WebElement myOrders = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".element_general_login_logout #customer_login")
        ));

        // Highlight it the myOrders button
        HighlightUtils.highlightElement(driver, myOrders);

        // Save a screenshot of the highlighted element while clicking, this will be attached to the allure report
        AllureAttachments.saveScreenshot("Element_Highlighted_While_Clicked", driver);

        try {
            // This action will trigger an 'ElementClickInterceptedException' because the button is obstructed.
            // Since the test fails here, the TestListener will automatically capture a failure screenshot for Allure.
            myOrders.click();
        } finally {
            // Reverts CSS changes regardless of whether the click succeeded or failed.
            HighlightUtils.removeHighlight(driver, myOrders);
            System.out.println("***** Highlight removed successfully in finally block *****");
        }
    }
}