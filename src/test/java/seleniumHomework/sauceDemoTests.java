package seleniumHomework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsHomework.*;


import java.util.logging.Level;
import java.util.logging.Logger;


@Log4j
public class sauceDemoTests {

    private final String LOCAL_FILE = "https://www.saucedemo.com/";

    ChromeDriver driver;

    LoginPage loginpage;
    InventoryPage inventorypage;
    CartPage cartpage;
    CheckoutPage checkoutpage;
    CheckoutOverviewPage checkoutoverviewpage;
    CheckoutSuccessPage checkoutsuccesspage;
    WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser () {
        log.info("Will initialize Chrome web driver");
        this.driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    }
    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    @Test
    public void openingPageTest() {
        driver.get(LOCAL_FILE);
        Assert.assertEquals(driver.getTitle(),"Swag Labs"); //Testējam, ka vispār varam atvērt mājas lapu
    }

    @Test
    public void elementTest() {
        driver.get(LOCAL_FILE);
        loginpage = new LoginPage(driver);
        loginpage.setUsername("standard_user");
        loginpage.setPassword("secret_sauce");
        loginpage.clickLoginButton();

        inventorypage = new InventoryPage(driver);
        wait.until(ExpectedConditions.visibilityOf(inventorypage.getOnesieButton()));
        Assert.assertEquals(inventorypage.getOnesieButton().isDisplayed(),true);  //te pārbauda, ka varam atrast inventory page elementu
        inventorypage.clickOnesieButton();
        inventorypage.clickCartButton();

        cartpage = new CartPage(driver);
        wait.until(ExpectedConditions.visibilityOf(cartpage.getOnesieItem()));
        Assert.assertEquals(cartpage.getOnesieItem().isDisplayed(),true);  //te pārbauda, ka varam atrast cart page pasūtīto Onesie
        cartpage.clickChecoutButton();

        checkoutpage = new CheckoutPage(driver);

        wait.until(ExpectedConditions.visibilityOf(checkoutpage.getFirstName()));
        checkoutpage.setFirstName("Janis");
        checkoutpage.setLastName("Doe");
        checkoutpage.setPostalCode("111-222");
        checkoutpage.clickContinueButton();


        checkoutoverviewpage = new CheckoutOverviewPage(driver);
        wait.until(ExpectedConditions.visibilityOf(checkoutoverviewpage.getFinishOnesie()));
        Assert.assertEquals(checkoutoverviewpage.getFinishOnesie().isDisplayed(),true);
        checkoutoverviewpage.clickFinishButton();

        checkoutsuccesspage = new CheckoutSuccessPage(driver);
        wait.until(ExpectedConditions.visibilityOf(checkoutsuccesspage.getSuccessHeader()));
        Assert.assertEquals(checkoutsuccesspage.getSuccessHeader().isDisplayed(),true);
        checkoutsuccesspage.clickFinishButton();

        System.out.println(" ");
    }

    @Test
    public void mandatoryFieldTest() {
        driver.get(LOCAL_FILE);
        loginpage = new LoginPage(driver);
        loginpage.setUsername("standard_user");
        loginpage.setPassword("secret_sauce");
        loginpage.clickLoginButton();

        inventorypage = new InventoryPage(driver);
        wait.until(ExpectedConditions.visibilityOf(inventorypage.getOnesieButton()));
        Assert.assertEquals(inventorypage.getOnesieButton().isDisplayed(), true);  //te pārbauda, ka varam atrast inventory page elementu
        inventorypage.clickOnesieButton();
        inventorypage.clickCartButton();

        cartpage = new CartPage(driver);
        wait.until(ExpectedConditions.visibilityOf(cartpage.getOnesieItem()));
        Assert.assertEquals(cartpage.getOnesieItem().isDisplayed(), true);  //te pārbauda, ka varam atrast cart page pasūtīto Onesie
        cartpage.clickChecoutButton();

        checkoutpage = new CheckoutPage(driver);

        wait.until(ExpectedConditions.visibilityOf(checkoutpage.getFirstName()));
        checkoutpage.clickContinueButton();
        wait.until(ExpectedConditions.visibilityOf(checkoutpage.getErrorFirst()));
        Assert.assertEquals(checkoutpage.getErrorFirst().isDisplayed(), true); //nočekojam ka first name ir obligāts
        checkoutpage.setFirstName("Janis");
        checkoutpage.clickContinueButton();
        wait.until(ExpectedConditions.visibilityOf(checkoutpage.getErrorSecond()));
        Assert.assertEquals(checkoutpage.getErrorSecond().isDisplayed(), true);         //nočekojam ka last name ir obligāts
        checkoutpage.setLastName("Doe");
        checkoutpage.clickContinueButton();
        wait.until(ExpectedConditions.visibilityOf(checkoutpage.getErrorThird()));
        Assert.assertEquals(checkoutpage.getErrorThird().isDisplayed(), true);         //nočekojam ka Postal code ir obligāts
        checkoutpage.setPostalCode("111-222");
        checkoutpage.clickContinueButton();
    }








    @AfterMethod(alwaysRun = true)
    public void closeBrowser (){
        log.info("We are closing web driver");
        driver.close();
        driver.quit();
    }
}
