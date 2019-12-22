
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
//import com.beust.jcommander.Parameterized;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//
//@RunWith(value = Parameterized.class)




public class ChangeCityTest extends WebDriverSettings{

//    //private String City;
//    public ChangeCityTest(String City){
//        this.City = City;
//    }
//    @Parameterized.Parameters
//    public  static  Object [] isCities() {
//        return  new Object [] {"Хвалынск", "Энгельс"};//, "Самара", "Санкт-Петербург"};
//    }


//    private static ChromeDriver driver;
//    @BeforeMethod
//    public static void setUp(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\apache-maven-3.6.2\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
//    }

    @Test(dataProvider = "city", dataProviderClass = ChangeCity.class)
    public void signUp(String  City)  {
        driver.get("https://beru.ru/");
        //driver.manage().window().maximize();
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
//    @AfterMethod
//    public static void tearDown(){
//        driver.close();
//    }

}