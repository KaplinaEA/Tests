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
import org.testng.Assert;
import org.testng.annotations.Test;


public class CatalogAndBasketTest extends WebDriverSettings{
    @Test
    public void signUp() throws InterruptedException {
        driver.get("https://beru.ru/");//driver.manage().window().maximize();

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
        Assert.assertTrue(electricToothbrushesPage.TotalPrice());
    }
}