package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

// This utility class provides methods to create attachments for Allure reports,
// such as screenshots and converting the screenshots into a format that Allure understands
public class AllureAttachments {

    @Attachment(value = "{name}", type = "image/png")
    public static byte[] saveScreenshot(String name, WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}