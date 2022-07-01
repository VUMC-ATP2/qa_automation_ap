package pageObjectsHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LoginPage {

    private WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver;

    }

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By login_button = By.id("login-button");


    public void setUsername(String name){
        driver.findElement(usernameField).sendKeys(name);
    }

    public void setPassword(String name){
        driver.findElement(passwordField).sendKeys(name);
    }
    public void clickLoginButton(){
        driver.findElement(login_button).click();
    }
}
