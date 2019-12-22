/*
Авторизоваться на сайте,
после авторизации проверить что на главной странице отображается логин.
Убедиться что кнопка “Войти в аккаунт” сменилась на “Мой профиль”
 */
package Tests;
import Page.RegistrationPage;
import Page.StartPage;
//import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class LogInTest  extends WebDriverSettings {
    //        private static ChromeDriver driver;
//        @BeforeMethod
//        public static void setUp(){
//            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\apache-maven-3.6.2\\chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
//        }
    @Test
    public void signUp() throws InterruptedException {
        driver.get("https://beru.ru/");
        driver.manage().window().maximize();
        StartPage startPage = new StartPage(driver);

        RegistrationPage registrationPage  = new  RegistrationPage(driver);

        startPage.AccountEnter();
        registrationPage.LoginEnter("huladesa");
        registrationPage.PasswordEnter("hulklagoa");
        Assert.assertEquals("Мой профиль", startPage.ProfileEnter().getAttribute("textContent"));
        Assert.assertEquals( "К К", startPage.MyLogin().getAttribute("textContent"));
    }
//        @AfterMethod
//        public static void tearDown(){
//            driver.close();
//        }

}