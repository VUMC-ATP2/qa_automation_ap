package pageObjectsHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
    private WebDriver driver;

    public CartPage (WebDriver driver){
        this.driver = driver;

    }

    private By cartOnesie = By.xpath("//div[contains(@class, 'inventory_item_name') and contains(., 'Sauce Labs Onesie')]");
    private By checkout = By.id("checkout");

    public void clickChecoutButton(){
        driver.findElement(checkout).click();
    }

    public WebElement getOnesieItem(){
        return driver.findElement(cartOnesie);
    }

}
