/*
//Перейти в каталог электрических зубных щеток,
// выполнить поиск с диапазоном цен от  999 до 1999 рублей.
//Проверить что в результате отобразились щетки с ценами в этом диапазоне.
//Добавить предпоследнюю щетку в корзину
//и перейти к в нее.
 Проверить значение “До бесплатной доставки осталось”,
 убедиться что итоговая цена равна <стоимость щетки> + <доставка>,
 увеличить количество щеток (чтобы общая цена была больше 2999)
 и перепроверить все значения.*/
package Tests;

import Page.ElectricToothbrushesPage;
import Page.StartPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CatalogAndBasketTest {

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
        startPage.Catalog();
        ElectricToothbrushesPage electricToothbrushesPage = new ElectricToothbrushesPage(driver);
        electricToothbrushesPage.PriceRange(999,1999);
        electricToothbrushesPage.More();
        Assert.assertTrue(electricToothbrushesPage.RangeBrushes(999,1999));
        electricToothbrushesPage.AddPenultimate();
        electricToothbrushesPage.Basket();
        float BeforeFree = electricToothbrushesPage.BeforeFree();
        Assert.assertTrue(electricToothbrushesPage.TotalPrice());
        electricToothbrushesPage.AddProduct();
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
