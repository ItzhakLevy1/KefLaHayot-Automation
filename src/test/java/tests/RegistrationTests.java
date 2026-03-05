package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import io.qameta.allure.Description;

public class RegistrationTests extends BaseTest {

    @Test
    @Description("TC-06: Verify registration validation bug - system allows signup without accepting terms")
    public void testRegistrationWithoutTerms() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        // 1. Navigate to the signup / Registration page
        registrationPage.navigateTo();

        // 2. Generate a unique email to avoid "Email already exists" error
        String uniqueEmail = "auto_tester" + System.currentTimeMillis() + "@gmail.com";

        // 3. Fill out the registration form via the Page Object
        // This method fills all text fields but DOES NOT click the 'Terms and Conditions' checkbox
        registrationPage.fillRegistrationForm(
                "Automation Tester",
                uniqueEmail,
                "0501234567",
                "TestPass123!"
        );

        // 4. SEMI-AUTOMATED STEP: Manual Captcha solving
        // We pause the execution to allow the human tester to solve the reCAPTCHA visually.
        System.out.println(">>> ACTION REQUIRED: Please solve the Captcha in the browser window now...");
        Thread.sleep(15000);

        // 5. Submit the form using the Page Object method
        // This method also handles the UI highlighting internally
        registrationPage.clickRegister();

        // 6. Wait for the server to process the registration attempt
        Thread.sleep(5000);

        // 7. ASSERTION: Check if registration succeeded despite the missing terms agreement
        // Redirection away from 'signup' URL indicates a successful (but buggy) registration
        String currentUrl = driver.getCurrentUrl();

        Assert.assertFalse(currentUrl.contains("signup"),
                "BUG FOUND: The system allowed registration without accepting the mandatory Terms and Conditions!");

        System.out.println("Test Completed. Current URL: " + currentUrl);
    }
}