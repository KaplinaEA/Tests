package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StartPage {

    int i =0;
    public WebDriver driver;

    By Ok = By.cssSelector("div.A6Py--JRNc button._4qhIn2-ESi.Pjv3h3YbYr.THqSbzx07u");
    By Equal = By.cssSelector("#react-autowhatever-region--item-0 > div > div > div._229JDbp_Z8");
    By Settings =   By.cssSelector( "div._3gVpo2i2jf a[ href=\"/my/settings?track=menu\"]");
    By CityInput = By.cssSelector("div[class =\"LVfMs-qeRX tOTC_Mrer- _38DKtrKp3V nczD08OBdF _2jnB2KZa7v _1WIxduPIjW\"] input");
    By CityButton =  By.cssSelector("div._1hOJdjk4Dx span.NELKq_vpT1 span.zB1fta3NQ5");
    By LoginToAccount =  By.className("_3ZGcN3lbEg");
    By MyProfile = By.cssSelector("div._2I5v9t-gmG span");
    By Profile = By.className("pFhTbV17qj");
    By End = By.cssSelector("div._3odNv2Dw2n ul.T3jKK6NbAR:nth-of-type(4) " +
            "a[href = \"/logout?retpath=https%3A%2F%2Fberu.ru%2Fmy%2Fsettings%3Ftrack%3Dmenu\"] ");


    public StartPage(WebDriver driver) {
        this.driver=driver;
    }

    public void CityEnter(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(CityButton));
        driver.findElement(CityButton).click();
    }

    public  String GetCity(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(CityButton));
        return driver.findElement(CityButton).getAttribute("textContent");
    }

    public  void  CityInput(String city){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(CityInput));
        WebElement web =    driver.findElement(CityInput);
        web.click();
        web.sendKeys(Keys.chord(Keys.CONTROL,"a")+ Keys.DELETE);


        char[] charArray =  city.toCharArray();
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) driver1 -> {
            web.sendKeys(charArray[i] + "");
            i++;
            return driver.findElement(Equal).getText().split("\n")[0].equals(city);
        });
        driver.findElement(Equal).click();
    }

    public  void  Ok(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(Ok));
        driver.findElement(Ok).click();
    }

    public  void  Settings(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        //wait.until(ExpectedConditions.invisibilityOf( driver.findElement(Settings)));
        wait.until(ExpectedConditions.elementToBeClickable(Settings));
        driver.findElement(Settings).click();
    }

    public void AccountEnter(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(LoginToAccount));
        driver.findElement(LoginToAccount).click();
    }

    public WebElement ProfileEnter()    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(Profile));
        return driver.findElement(Profile);
    }

    public WebElement MyProfileEnter() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(MyProfile)));
        return driver.findElement(MyProfile);
    }

    public  void  End(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(End));
        driver.findElement(End).click();
    }
}
