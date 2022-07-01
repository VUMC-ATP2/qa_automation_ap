package pageObjectsHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage {
    private final WebDriver driver;

    public CartPage (WebDriver driver){
        this.driver = driver;

    }

    private final By cartOnesie = By.xpath("//div[contains(@class, 'inventory_item_name') and contains(., 'Sauce Labs Onesie')]");
    private final By checkout = By.id("checkout");

    public void clickChecoutButton(){
        driver.findElement(checkout).click();
    }

    public WebElement getOnesieItem(){
        return driver.findElement(cartOnesie);
    }

}
