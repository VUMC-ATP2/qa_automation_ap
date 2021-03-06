package pageObjectsHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {

    private final WebDriver driver;

    public CheckoutOverviewPage (WebDriver driver){
        this.driver = driver;

    }


    private final By finishOnesie = By.xpath("//div[contains(@class, 'inventory_item_name') and contains(., 'Sauce Labs Onesie')]");
    private final By finishButton = By.id("finish");


    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

    public WebElement getFinishOnesie(){
        return driver.findElement(finishOnesie);
    }
}
