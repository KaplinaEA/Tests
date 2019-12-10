/*
1.	Авторизоваться на сайте,
после авторизации проверить что на главной странице отображается логин.
Убедиться что кнопка “Войти в аккаунт” сменилась на “Мой профиль”
 */
package Tests;
import Page.RegistrationPage;
import Page.StartPage;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class Testing {

        private static ChromeDriver driver;
        //protected static WebDriver driver;
        @BeforeClass
        public static void setUp(){
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\apache-maven-3.6.2\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
        }

        @Test
        public void signUp() throws InterruptedException {

            driver.get("https://beru.ru/");

            StartPage startPage = new StartPage(driver);
            //assertTrue(startPage.isInitialized());

            RegistrationPage registrationPage  = new  RegistrationPage(driver);
            //assertTrue(registrationPage.isInitialized());


            startPage.AccountEnter();//перейти в профиль
            registrationPage.LoginEnter("huladesa");//ввод логина
            registrationPage.PasswordEnter("hulklagoa");//ввод пароля
            Thread.sleep(400);
            Assert.assertEquals("Мой профиль", startPage.ProfileEnter().getAttribute("textContent"));
            //Убедиться что кнопка “Войти в аккаунт” сменилась на “Мой профиль”
            Assert.assertEquals( "К К", startPage.MyProfileEnter().getAttribute("textContent"));
            //проверить что на главной странице отображается логин


        }



        @AfterClass
        public static void tearDown(){
            driver.close();
        }



}
