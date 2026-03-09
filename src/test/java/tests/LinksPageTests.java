package tests;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.LinksPage;
import utils.AllureAttachments;

public class LinksPageTests extends BaseTest{

    private LinksPage linksPage;

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Links page UI")
    @Owner("Itzhak Levy")
    @Description("TC-12: page With Empty Section")
    public void pageWithEmptySection() {
        linksPage = new LinksPage(driver);

        linksPage.navigateToLinksPage();

        linksPage.clickLinkToPTVStore();

        linksPage.highlightEmptyPTVStoreSection();

        AllureAttachments.saveScreenshot("TC-12: page With Empty Section", driver);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Delivery page UI")
    @Owner("Itzhak Levy")
    @Description("TC-13: Verify readability of the shipping policy page and capture visual overlap issues")
    public void takeZoomedScreenshot() throws InterruptedException {
        driver.get("https://www.keflahayot.co.il/pages/38760-משלוחים");
        Thread.sleep(1000);

        // Reducing zoom by 50%
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");

        // Taking a screen shoot
        AllureAttachments.saveScreenshot("Bug Evidence: Dense Text and Overlap (50% Zoom)", driver);
        Thread.sleep(5000);

        // Return to normal mode (optional)
//        js.executeScript("document.body.style.zoom='100%'");

//        Thread.sleep(1000);
    }
}
