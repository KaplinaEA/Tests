package Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ElectricToothbrushesPage {

    public WebDriver driver;
    public float component1 = 0;
    public float discount =0;

    By MinPrice = By.cssSelector("div._22Ur0s3rzX fieldset div[data-auto = \"filter-range-glprice\"] " +
            "span[data-auto =\"filter-range-min\"] input ");
    By MaxPrice = By.cssSelector("div._22Ur0s3rzX fieldset div[data-auto = 'filter-range-glprice'] " +
            "span[data-auto ='filter-range-max'] input");
    By ShowMore = By.cssSelector("div [data-zone-name = \"SearchPager\"] button");
    By AllToothbrushesPrice = By.cssSelector("div._1uhsh_io8o div._1RjY7YIluf a div._rcv168PjI div._1u3j_pk1db span span:nth-child(1)");
    By AllToothbrushesButton = By.cssSelector("div._1uhsh_io8o div._1RjY7YIluf button");
    By Basket = By.cssSelector("a[href=\"/my/cart\"] button");
    By Update = By.cssSelector("div._YgMDoJ6pG");
    By BeforeFreeDelivery = By.cssSelector("span._3e5zCA3HUO span");
    By GoToFormalization = By.cssSelector("div.bLjj5ddV9I button");
    By Courier = By.cssSelector("div[data-auto='DELIVERY']");
    By ComponentPrices = By.cssSelector("span[data-auto=\"value\"]");
    By Discount = By.cssSelector("div[data-auto = \"total-discount\"] span._3l-uEDOaBN");
    By Price = By.cssSelector("span._1oBlNqVHPq");
    By Change = By.cssSelector("div [data-zone-name='ITEMS-CHANGE'] a");
    By Plus = By.cssSelector("div[data-tid = '2f0be108'] button._3hWhO4rvmA");


    public ElectricToothbrushesPage(WebDriver driver) {
        this.driver=driver;
    }

    @Step(value = "Set price range")
    public void PriceRange(int min, int max)    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(MinPrice));
        driver.findElement(MinPrice).sendKeys(min+"");
        wait.until(ExpectedConditions.elementToBeClickable(MaxPrice));
        driver.findElement(MaxPrice).sendKeys(max+"");

    }

    @Step(value = "Display all toothbrushes")
    public  void  More (){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until((ExpectedConditions.visibilityOfElementLocated(Update)));
        wait.until(ExpectedConditions.elementToBeClickable(ShowMore));
        driver.findElement(ShowMore).click();
    }

    @Step(value = "Sorting check")
    public  boolean  RangeBrushes(int min, int max){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(AllToothbrushesPrice));
        boolean Pr = true;
        for (WebElement item:driver.findElements(AllToothbrushesPrice)) {
            wait.until(ExpectedConditions.elementToBeClickable(item));
            String str = item.getText().replaceAll(" ", "");
            if (!(min <= Float.parseFloat(str)  &&  Float.parseFloat(str)<= max)) Pr=false;
        }
        return  Pr;
    }

    @Step(value = "Adding penultimate toothbrush")
    public  void   AddPenultimate(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(AllToothbrushesButton));
        List<WebElement> buttons = driver.findElements(AllToothbrushesButton);
        wait.until(ExpectedConditions.elementToBeClickable(buttons.remove(buttons.size()-1)));
        buttons.remove(buttons.size()-1).click();

    }

    @Step(value = "Go to basket")
    public  void   Basket(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(Basket));
        driver.findElement(Basket).click();
    }

    @Step(value = "Before free delivery")
    public  float   BeforeFree () {
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.elementToBeClickable(GoToFormalization));
        String beforeFree = driver.findElement(BeforeFreeDelivery).getText();
        return Float.parseFloat(beforeFree.replaceAll("₽", "").replaceAll(" ", ""));

    }

    @Step(value = "Brush cost+ shipping")
    public  boolean TotalPrice()  {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oVTSBGkD1W"))));

        wait.until(ExpectedConditions.elementToBeClickable(GoToFormalization));
        driver.findElement(GoToFormalization).click();
        wait.until(ExpectedConditions.elementToBeClickable(Courier));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div [class='section _3yiPi47kNr _2xwcHVtjcy']")));
        driver.findElement(Courier).click();
        List<WebElement> componentPrices = driver.findElements(ComponentPrices);
        component1 = Float.parseFloat(componentPrices.get(0).getText().replaceAll(" ", "").replaceAll("₽",""));
        String st= componentPrices.get(1).getText().replaceAll(" ", "").replaceAll("₽", "");
        float component2 =0;
        try {
             component2 = Float.parseFloat(st);
        }catch (Exception e){}
        float price = Float.parseFloat(driver.findElement(Price).getText().replaceAll(" ", "").replaceAll("₽",""));
        if(driver.findElements(Discount).size() !=0) {
            discount = Float.parseFloat(driver.findElement(Discount).getText().replaceAll(" ", "").replaceAll("₽", "").replaceAll("−", "-"));
            return (price == component1 + component2 + discount);
        } else return price == component1 + component2;
    }

    @Step(value = "Increase the quantity  product")
    public  void AddProduct()  {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(Change));
        driver.findElement(Change).click();

        int count =(int)Math.ceil(2999/(component1+discount));

        wait.until(ExpectedConditions.elementToBeClickable(Plus));
        for(int i=0;i<count-1;++i)   driver.findElement(Plus).click();
        TotalPrice();

    }
}

