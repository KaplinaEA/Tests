package Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    By CityButton =  By.cssSelector("span[data-auto='region-form-opener'].zB1fta3NQ5");
   // By CityButton =  By.cssSelector("div._1hOJdjk4Dx span.NELKq_vpT1 span.zB1fta3NQ5");
    By LoginToAccount =  By.className("_3ZGcN3lbEg");
    By MyProfile = By.cssSelector("div._2I5v9t-gmG span");
    By Profile = By.className("pFhTbV17qj");
    By End = By.cssSelector("div._3odNv2Dw2n ul.T3jKK6NbAR:nth-of-type(4) " +
            "a[href = \"/logout?retpath=https%3A%2F%2Fberu.ru%2Fmy%2Fsettings%3Ftrack%3Dmenu\"] ");
    By ElectricToothbrushes = By.cssSelector("div._2rB4CmYYJC div._1xDYs0YHLz  a[title ='Электрические зубные щетки'] ");
    By BeautyAndHygiene  = By.cssSelector("div._3JUsAgML4w a[title ='Красота и гигиена']");
    By Catalog = By.cssSelector ("div._301_b-LBxR button");

    public StartPage(WebDriver driver) {
        this.driver=driver;
    }

    @Step(value = "Сhange city")
    public void CityEnter(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(CityButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CityButton));
        driver.findElement(CityButton).click();
    }

    @Step(value = "Сity")
    public  String GetCity(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CityButton));
       // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(CityButton)));
        return driver.findElement(CityButton).getAttribute("textContent");
    }

    @Step(value = "Сity entry")
    public  void  CityInput(String city){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(CityInput)));
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

    @Step(value = "Button good")
    public  void  Ok(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(Ok));
        driver.findElement(Ok).click();
    }

    @Step(value = "Button settings")
    public  void  Settings(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(LoginToAccount)).perform();
        //wait.until(ExpectedConditions.invisibilityOf( driver.findElement(Settings)));
        wait.until(ExpectedConditions.elementToBeClickable(Settings));
        driver.findElement(Settings).click();
    }


    @Step(value = "Account or profile")
    public void AccountEnter(){
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.elementToBeClickable(LoginToAccount));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginToAccount));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(LoginToAccount)).perform();
        driver.findElement(LoginToAccount).click();

    }

    @Step(value = "Profile")
    public WebElement ProfileEnter()    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(Profile));
        return driver.findElement(Profile);
    }

    @Step(value = "Login")
    public WebElement MyLogin() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(MyProfile)));
        return driver.findElement(MyProfile);
    }

    @Step(value = "Exit from profile")
    public  void  End(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(End));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(LoginToAccount)).perform();
        driver.findElement(End).click();
    }

    @Step(value = "Go to the catalog of electric toothbrushes")
    public  void  Catalog() {
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.elementToBeClickable(Catalog));
        driver.findElement(Catalog).click();

        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(BeautyAndHygiene));
        action.moveToElement(driver.findElement(BeautyAndHygiene)).perform();

        driver.findElement(ElectricToothbrushes).click();

    }

}
