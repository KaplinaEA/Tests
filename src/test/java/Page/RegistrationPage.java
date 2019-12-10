package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {


    private final WebDriver driver;
    By LoginLocator = By.id("passp-field-login");
    By LoginNextButtonLocator = By.cssSelector("#root > div > div > div.passp-flex-wrapper > div > div.passp-auth " +
            "> div.passp-auth-content > div:nth-child(2) > div > div > div.passp-login-form > form > div.passp-button." +
            "passp-sign-in-button > button.control.button2.button2_view_classic.button2_size_l.button2_theme_" +
            "action.button2_width_max.button2_type_submit.passp-form-button");
    By passwordLocator = By.id("passp-field-passwd");
    By passwordNextButtonLocator = By.cssSelector("#root > div > div > div.passp-flex-wrapper > div > div.passp-auth > " +
            "div.passp-auth-content > div.passp-route-forward > div > div.passp-password-form > form > " +
            "div.passp-button.passp-sign-in-button > button.control.button2.button2_view_classic.button2_" +
            "size_l.button2_theme_action.button2_width_max.button2_type_submit.passp-form-button");

    public boolean isInitialized() {
        return driver.findElement(LoginLocator).isDisplayed();
    }

    public RegistrationPage(WebDriver driver) {
        this.driver=driver;
    }

    public void LoginEnter(String Login){
        driver.findElement(LoginLocator).sendKeys(Login);
        driver.findElement(LoginNextButtonLocator).click();
    }

    public void PasswordEnter(String Passwor){
        driver.findElement(passwordLocator).sendKeys(Passwor);
        driver.findElement(passwordNextButtonLocator).click();
    }


}
