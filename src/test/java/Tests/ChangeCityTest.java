/*
Находясь на главной странице beru.ru  сменить город с Саратова на Хвалынск,
проверить что значение изменилось.
Авторизоваться на сайте,
перейти в настройки,
сравнить значение города в верхнем углу и город доставки.
 */

package Tests;
import Page.RegistrationPage;
import Page.SettingsPage;
import Page.StartPage;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class ChangeCityTest {

    private static ChromeDriver driver;
    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\apache-maven-3.6.2\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
    }

    @Test
    public void signUp() throws InterruptedException {
        driver.get("https://beru.ru/");
        driver.manage().window().maximize();
        StartPage startPage = new StartPage(driver);

        startPage.CityEnter();
        startPage.CityInput("Хвалынск");
        startPage.Ok();
        Assert.assertEquals("Хвалынск", startPage.Getcity());

        startPage.AccountEnter();
        RegistrationPage registrationPage  = new  RegistrationPage(driver);
        registrationPage.LoginEnter("huladesa");
        registrationPage.PasswordEnter("hulklagoa");
        startPage.AccountEnter();
        startPage.Settings();

        SettingsPage settingsPage  = new  SettingsPage(driver);
        Assert.assertEquals(settingsPage.GetCity1(), settingsPage.GetCity2());
    }

    @AfterClass
    public static void tearDown(){
       driver.close();
    }

}
