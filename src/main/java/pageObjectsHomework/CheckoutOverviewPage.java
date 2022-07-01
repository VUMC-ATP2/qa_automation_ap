package pageObjectsHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutOverviewPage {

    private WebDriver driver;

    public CheckoutOverviewPage (WebDriver driver){
        this.driver = driver;

    }


    private By finishOnesie = By.xpath("//div[contains(@class, 'inventory_item_name') and contains(., 'Sauce Labs Onesie')]");
    private By finishButton = By.id("finish");


    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

    public WebElement getFinishOnesie(){
        return driver.findElement(finishOnesie);
    }
}
