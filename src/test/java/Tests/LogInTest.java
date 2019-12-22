/*
Авторизоваться на сайте,
после авторизации проверить что на главной странице отображается логин.
Убедиться что кнопка “Войти в аккаунт” сменилась на “Мой профиль”
 */
package Tests;
import Page.RegistrationPage;
import Page.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest  extends WebDriverSettings {
    @Test
    public void signUp() throws InterruptedException {
        driver.get("https://beru.ru/");
        StartPage startPage = new StartPage(driver);

        RegistrationPage registrationPage  = new  RegistrationPage(driver);

        startPage.AccountEnter();
        registrationPage.LoginEnter("huladesa");
        registrationPage.PasswordEnter("hulklagoa");
        Assert.assertEquals("Мой профиль", startPage.ProfileEnter().getAttribute("textContent"));
        Assert.assertEquals( "К К", startPage.MyLogin().getAttribute("textContent"));
    }

}