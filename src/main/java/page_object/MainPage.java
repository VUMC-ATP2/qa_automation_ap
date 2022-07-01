package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainPage {

    private final WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver = driver;

    }

    private final By firstNameField = By.id("fNameID");
    private final By lastNameField = By.id("lNameID");
    private final By aboutMe = By.id("aboutMeID");
    private final By checkData = By.id("checkDataID");
    private final By checkBox = By.xpath("//input[@id='studentID']");
    //input[@id="studentID"]
    private final By universities = By.id("universitiesID");
    private final By color = By.id("colorsID");
    private final By valoda = By.id("javaID");
    private final By vissIrOk = By.id("checkDataResultID");



    public WebElement getFirstNameField(){
        return driver.findElement(firstNameField);
    }
    public void setFirstelement(String name){
        driver.findElement(firstNameField).sendKeys(name);
    }


    public WebElement getLastNameField(){
        return driver.findElement(lastNameField);
    }
    public void setLastelement(String name){
        driver.findElement(lastNameField).sendKeys(name);
    }


    public WebElement getAboutMeField(){
        return driver.findElement(aboutMe);
    }
    public void setAboutMeField(String name){
        driver.findElement(aboutMe).clear();
        driver.findElement(aboutMe).sendKeys(name);
    }

    //input[@id="studentID"]
    public WebElement getCheckDataField(){
        return driver.findElement(checkData);
    }

    public WebElement getCheckDataResult(){
        return driver.findElement(vissIrOk);
    }
    public void clickCheckDataField(){
        driver.findElement(checkData).click();
    }

    public WebElement getCheckBOXField(){
        return driver.findElement(checkBox);
    }
    public void selectCheckBox () {
        driver.findElement(checkBox).click();
    }

    public List<WebElement> getAllUniversities(){
        return new Select(driver.findElement(universities)).getOptions();

    }

    public Select getUniversities(){
        return new Select(driver.findElement(universities));
    }


    public List<WebElement> getAllColors(){
        return new Select(driver.findElement(color)).getOptions();

    }

    public Select getColors(){
        return new Select(driver.findElement(color));
    }

    public void selectValoda () {
        driver.findElement(valoda).click();
    }
}
