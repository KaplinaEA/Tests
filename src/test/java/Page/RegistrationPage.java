package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private final WebDriver driver;
    By LoginLocator = By.id("passp-field-login");
    By LoginNextButtonLocator = By.cssSelector("div.passp-button button[type = 'submit']");
    By passwordLocator = By.id("passp-field-passwd");
    By passwordNextButtonLocator = By.cssSelector("div.passp-button button[type = 'submit']");


    public RegistrationPage(WebDriver driver) {
        this.driver=driver;
    }

    public void LoginEnter(String Login){
        driver.findElement(LoginLocator).sendKeys(Login);
        driver.findElement(LoginNextButtonLocator).click();
    }

    public void PasswordEnter(String Password){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
        driver.findElement(passwordLocator).sendKeys(Password);
        driver.findElement(passwordNextButtonLocator).click();
    }


}
