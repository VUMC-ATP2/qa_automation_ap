package pageObjectsHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private final WebDriver driver;

    public CheckoutPage (WebDriver driver){
        this.driver = driver;

    }
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By errorMessageFirst = By.xpath("//h3[contains(@data-test, 'error') and contains(., 'Error: First Name is required')]");
    private final By errorMessageSecond = By.xpath("//h3[contains(@data-test, 'error') and contains(., 'Error: Last Name is required')]");
    private final By errorMessageThird = By.xpath("//h3[contains(@data-test, 'error') and contains(., 'Error: Postal Code is required')]");

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public WebElement getFirstName(){
        return driver.findElement(firstName);
    }


    public WebElement getErrorFirst(){
        return driver.findElement(errorMessageFirst);
    }
    public WebElement getErrorSecond(){
        return driver.findElement(errorMessageSecond);
    }
    public WebElement getErrorThird(){
        return driver.findElement(errorMessageThird);
    }

    public void setFirstName(String name){
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(name);
    }

    public void setLastName(String name){
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(name);
    }

    public void setPostalCode(String name){
        driver.findElement(postalCode).clear();
        driver.findElement(postalCode).sendKeys(name);
    }




}
