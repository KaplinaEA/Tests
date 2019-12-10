package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class StartPage {

    public WebDriver driver;

    By LoginToAccount =  By.className("_3odNv2Dw2n");
    By MyProfile = By.cssSelector("div._2I5v9t-gmG " +
            "span[class = \"_3l-uEDOaBN tdrs43E7Xn _3HJsMt3YC_ QDV8hKAp1G\"]");
    By Profile = By.className("pFhTbV17qj");



    public StartPage(WebDriver driver) {
        this.driver=driver;
    }

    public boolean isInitialized() {
        return driver.findElement(LoginToAccount).isDisplayed() &&
                driver.findElement(MyProfile).isDisplayed() &&
                driver.findElement(Profile).isDisplayed();
    }

    public void AccountEnter(){
        driver.findElement(LoginToAccount).click();
    }

    public WebElement ProfileEnter()
    {
        return driver.findElement(Profile);

    }

    public WebElement MyProfileEnter()
    {
        return driver.findElement(MyProfile);
    }


}
