package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.AllureAttachments;

public class RegistrationTests extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Registration UI") // Classification by feature
    @Owner("Itzhak Levy") // Responsible for this test case
    @Description("TC-05: Verify UI overlap - Registration button obscures Terms & Conditions text")
    public void testRegistrationButtonOverlap() {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.navigateTo();

        registrationPage.highlightOverlapArea();

        // Close the T&C popup
        registrationPage.cookieBanner.acceptCookies();

        utils.AllureAttachments.saveScreenshot("Overlap_Evidence", driver);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Registration Logic")
    @Owner("Itzhak Levy")
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

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Registration Logic")
    @Owner("Itzhak Levy")
    @Description("TC-07: Verify system allows registration with a phone number that already exists")
    public void testDuplicatePhoneRegistration() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.navigateTo();

        // 1. Generate a NEW unique email (to ensure the email itself isn't the blocker)
        String newEmail = "unique_tester" + System.currentTimeMillis() + "@gmail.com";

        // 2. Use a FIXED phone number that we know is already in the DB
        String existingPhone = "0501234567";

        // 3. Fill the form (excluding the manual Captcha part for now)
        registrationPage.fillRegistrationForm("Duplicate Phone Test", newEmail, existingPhone, "Pass1234!");
        registrationPage.acceptTerms();

        // 4. SEMI-AUTOMATED STEP: Solve Captcha manually
        System.out.println(">>> ACTION REQUIRED: Solve Captcha to test duplicate phone validation...");
        Thread.sleep(15000);

        // Manually capture screenshot to prove the checkbox status
        AllureAttachments.saveScreenshot("Evidence - Terms checkbox status before submission", driver);

        // 5. Submit
        registrationPage.clickRegister();
        Thread.sleep(5000);

        // 6. ASSERTION:
        // If the registration is successful (URL changes), it's a BUG.
        // A correct system should show an error message like "Phone number already exists".
        String currentUrl = driver.getCurrentUrl();

        Assert.assertFalse(currentUrl.contains("signup") == false,
                "BUG FOUND: System allowed registration with a duplicate phone number!");
    }
}