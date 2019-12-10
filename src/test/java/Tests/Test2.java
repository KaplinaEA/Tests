/*
2.	Находясь на главной странице beru.ru
 сменить город с Саратова на Хвалынск,
 проверить что значение изменилось.
Авторизоваться на сайте,
перейти в настройки,
сравнить значение города в верхнем углу и город доставки.

 */
package Tests;
import Page.StartPage;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class Test2 {

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

        StartPage startPage = new StartPage(driver);




    }



    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
