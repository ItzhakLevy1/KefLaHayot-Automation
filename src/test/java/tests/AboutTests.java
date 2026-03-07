package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.components.CookieBannerComponent;
import utils.AllureAttachments;

public class AboutTests extends BaseTest{

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Registration UI") // Classification by feature
    @Owner("Itzhak Levy") // Responsible for this test case
    @Description("TC-05: Verify UI overlap - Registration button obscures Terms & Conditions text")
    public void AboutTermsAndConditionAndAcceptMailingTest() throws InterruptedException {

        AboutPage aboutPage = new AboutPage(driver);

        CookieBannerComponent cookieBannerComponent = new CookieBannerComponent(driver);

        aboutPage.navigateToAboutPage();

        cookieBannerComponent.acceptCookies();

        aboutPage.HighlightElements();

        Thread.sleep(2000);

        AllureAttachments.saveScreenshot("UI overlap - Registration button obscures Terms & Conditions text ", driver);
    }
}
