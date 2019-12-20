package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {

    public WebDriver driver;
    By CityInSettings  =By.cssSelector("div.section span._3ioN70chUh span[data-auto = \"region\"]");
    By CityInput = By.cssSelector("div._1hOJdjk4Dx span.NELKq_vpT1 span.zB1fta3NQ5");

    public SettingsPage(WebDriver driver) {
        this.driver=driver;
    }
    public String GetCity2(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(CityInput));
        return driver.findElement(CityInput).getAttribute("textContent");
    }
    public String GetCity1(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(CityInSettings));
        return driver.findElement(CityInSettings).getAttribute("textContent");
    }

}
