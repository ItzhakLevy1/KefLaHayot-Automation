package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.components.CookieBannerComponent;
import utils.AllureAttachments;

public class AboutTests extends BaseTest{

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("About Page UI") // Classification by feature
    @Owner("Itzhak Levy") // Responsible for this test case
    @Description("TC-08: Verify T&C label has poor color contrast against newsletter background image")
    public void AboutTermsAndConditionsTest() throws InterruptedException {

        AboutPage aboutPage = new AboutPage(driver);
        CookieBannerComponent cookieBannerComponent = new CookieBannerComponent(driver);
        aboutPage.navigateToAboutPage();
        cookieBannerComponent.acceptCookies();
        aboutPage.highlightTermsContrast();

        Thread.sleep(2000);

        AllureAttachments.saveScreenshot("About Page UI - Verify T&C label has poor color contrast against newsletter background image", driver);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("About Page UI") // Classification by feature
    @Owner("Itzhak Levy") // Responsible for this test case
    @Description("TC-09: Verify mandatory asterisk position for Email field")
    public void AboutEmailAsteriskPositionTest() throws InterruptedException {

        AboutPage aboutPage = new AboutPage(driver);
        CookieBannerComponent cookieBannerComponent = new CookieBannerComponent(driver);
        aboutPage.navigateToAboutPage();
        cookieBannerComponent.acceptCookies();
        aboutPage.highlightEmailAsteriskPositionTest();

        Thread.sleep(2000);

        AllureAttachments.saveScreenshot("About Page UI - Verify mandatory asterisk position for Email field", driver);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("About Page UI") // Classification by feature
    @Owner("Itzhak Levy") // Responsible for this test case
    @Description("TC-10: Verify newsletter field is covered")
    public void AboutNewsLetterTest() throws InterruptedException {

        AboutPage aboutPage = new AboutPage(driver);
        CookieBannerComponent cookieBannerComponent = new CookieBannerComponent(driver);
        aboutPage.navigateToAboutPage();
        cookieBannerComponent.acceptCookies();
        aboutPage.highlightNewsLetterTest();

        Thread.sleep(2000);

        AllureAttachments.saveScreenshot("About Page UI - Verify newsletter field is covered", driver);
    }
}
