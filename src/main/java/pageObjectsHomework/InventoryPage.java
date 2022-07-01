package pageObjectsHomework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    private final WebDriver driver;

    public InventoryPage (WebDriver driver){
        this.driver = driver;

    }

    private final By onsieLink = By.id("item_2_title_link");
    private final By cartButton = By.id("shopping_cart_container");
    private final By onesieButton = By.id("add-to-cart-sauce-labs-onesie");


    public void clickOnesieButton(){
        driver.findElement(onesieButton).click();
    }
    public void clickCartButton(){
        driver.findElement(cartButton).click();
    }
    public WebElement getOnesieButton(){
        return driver.findElement(onesieButton);
    }

}
