package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private final WebDriver driver;
    By LoginLocator = By.id("passp-field-login");
    By Next = By.cssSelector("div.passp-button button[type = 'submit']");
    By PasswordLocator = By.id("passp-field-passwd");

    public RegistrationPage(WebDriver driver) {
        this.driver=driver;
    }

    public void LoginEnter(String Login){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(Next));
            if(driver.findElements( PasswordLocator ).size() == 0) {
                driver.findElement(LoginLocator).sendKeys(Login);
                driver.findElement(Next).click();
            }
    }

    public void PasswordEnter(String Password){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(Next));
        driver.findElement(PasswordLocator).sendKeys(Password);
        driver.findElement(Next).click();
    }

}
