package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.ContactPage;

public class ContactCaptchaTest extends BaseTest{

    private ContactPage contactPage;

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Contact page UI")
    @Owner("Itzhak Levy")
    @Description("TC-11: Verify reCAPTCHA positioning to ensure no visual overlap with footer links")
    public void verifyCaptcha(){
        contactPage = new ContactPage(driver);

        contactPage.navigateToContactsPage();
        contactPage.highlightCaptchaIssue();
    }
}
