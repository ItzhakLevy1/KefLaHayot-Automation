package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

// This TestListener class implements the ITestListener interface from TestNG to listen for test events,
// specifically to capture screenshots when a test fails and attach them to Allure reports for better debugging and reporting.
public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Test Failed: " + result.getName() + " - Taking Screenshot... *****");

        // Get the driver from the failed test class
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        if (driver != null) {

            // Take the screenshot and attach to Allure
            AllureAttachments.saveScreenshot(result.getName() + "_failure", driver);

            System.out.println("***** Screenshot attached to Allure! *****");
        } else {
            System.out.println("***** Driver is NULL! Cannot take screenshot. *****");
        }
    }
}