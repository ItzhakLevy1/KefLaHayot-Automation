package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class CookiesBannerTests extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Global UI Components")
    @Owner("Itzhak Levy")
    @Description("TC-01: Verify cookie banner persistence across page navigation")
    public void testCookieBannerPersistence() {
        HomePage homePage = new HomePage(driver);

        // 1. Click accept
        homePage.cookieBanner.acceptCookies();

        // 2. Wait for it to disappear from the UI
        homePage.cookieBanner.waitForBannerToDisappear();

        // 3. Verify it's gone (Current page)
        Assert.assertFalse(homePage.cookieBanner.isCookieBannerVisible(),
                "Banner should be closed on current page after click");

        // 4. Navigate away/Refresh
        driver.navigate().refresh();

        // 5. Check if it reappears (The bug)
        Assert.assertFalse(homePage.cookieBanner.isCookieBannerVisible(),
                "Bug Found: Cookie banner reappeared after page refresh!");
    }
}