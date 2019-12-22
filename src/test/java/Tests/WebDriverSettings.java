package Tests;
import io.qameta.allure.Attachment;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverSettings {

    public static ChromeDriver chromeDriver;
    public static EventFiringWebDriver driver;
    public static WebDriverWait wait;
    public static Screenshot listener;

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\apache-maven-3.6.2\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        driver = new EventFiringWebDriver(chromeDriver);
        listener = new Screenshot();
        wait = new WebDriverWait(chromeDriver, 10);
        driver.register(listener);
        driver.manage().window().fullscreen();

    }

    @AfterMethod
    protected void TearDown() {
        driver.close();
        //driver.quit();
    }

    @AfterMethod
    public void catchFailure(ITestResult result) {
        if (!result.isSuccess()) {
            TakeAScreenshot();
        }
    }

    @Attachment(value = "Screenshot")
    public byte[] TakeAScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

