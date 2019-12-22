//package Tests;
//
//import org.junit.BeforeClass;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class WebDriverSettings {
//
//    @BeforeClass
//    public void beforeMethod() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\apache-maven-3.6.2\\chromedriver.exe");
//        chromeDriver = new ChromeDriver();
//        driver = new EventFiringWebDriver(chromeDriver);
//        listener = new SeleniumListener();
//        wait = new WebDriverWait(chromeDriver, 10);
//        driver.register(listener);
//        driver.manage().window().fullscreen();
//
//    }
//}
