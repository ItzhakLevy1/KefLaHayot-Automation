package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import io.qameta.allure.Description;

public class LogoutTests extends BaseTest {

    @Test
    @Description("TC-04: Verify UI inconsistency - multiple logout options with different labels")
    public void testDuplicateLogoutButtons() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // 1. Login to the system
        loginPage.navigateTo();
        loginPage.login("aaa@gmail.com", "aaa@gmail.com");

        // 2. Verify that BOTH logout buttons are present simultaneously
        boolean isLogoutVisible = homePage.isLogoutBtn1Displayed();
        boolean isExitSystemVisible = homePage.isLogoutBtn2Displayed();

        System.out.println("DEBUG: 'Logout' button visible: " + isLogoutVisible);
        System.out.println("DEBUG: 'Exit System' button visible: " + isExitSystemVisible);

        // 3. Assertion: If both are true, it confirms the bug of UI redundancy/inconsistency
        // In a perfect UI, we expect only one of them to exist.
        Assert.assertFalse(isLogoutVisible && isExitSystemVisible,
                "BUG: Found inconsistent logout options! Both 'התנתק' and 'יציאה מהמערכת' are visible.");
    }
}