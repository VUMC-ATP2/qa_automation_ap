package pageObjectsHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {

    private WebDriver driver;

    public CheckoutSuccessPage (WebDriver driver){
        this.driver = driver;

    }

    private By successHeader = By.className("header_secondary_container");
    private By backButton = By.id("back-to-products");


    public void clickFinishButton(){
        driver.findElement(backButton).click();
    }

    public WebElement getSuccessHeader(){
        return driver.findElement(successHeader);
    }
}
