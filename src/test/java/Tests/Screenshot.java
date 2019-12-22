//package Tests;
//
//import io.qameta.allure.Attachment;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//public class Screenshot {
//
//
//    static WebDriver webDriver;
//
//    public Screenshot(WebDriver webDriver) {
//        Screenshot.webDriver = webDriver;
//    }
//
//    @Attachment(value = "{screenshotName}", type = "image/png")
//    public byte[] takesScreenshot(String screenshotName) {
//        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
//    }
//}
