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
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangeCityTest extends WebDriverSettings{

    @Test(dataProvider = "city", dataProviderClass = ChangeCity.class)
    public void signUp(String  City)  {
        driver.get("https://beru.ru/");
        StartPage startPage = new StartPage(driver);
        startPage.CityEnter();
        startPage.CityInput (City);
        startPage.Ok();
        Assert.assertEquals(City, startPage.GetCity());
        startPage.AccountEnter();
        RegistrationPage registrationPage  = new  RegistrationPage(driver);
        registrationPage.LoginEnter("huladesa");
        registrationPage.PasswordEnter("hulklagoa");
        startPage.AccountEnter();
        startPage.Settings();
        SettingsPage settingsPage  = new  SettingsPage(driver);
        Assert.assertEquals(settingsPage.GetCity1(), settingsPage.GetCity2());
        startPage.AccountEnter();
        startPage.End();
    }

    public static class ChangeCity{
        @DataProvider(name = "city")
        public  static Object[] dataProviderMetod(){
            return new Object[]{"Хвалынск", "Энгельс"};
        }
    }

}