package practice;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_object.MainPage;

import java.util.logging.Level;
import java.util.logging.Logger;


@Log4j
public class BrowserTest {

    private final String LOCAL_FILE = "file://" + this.getClass().getResource("/elements.html").getPath();

    ChromeDriver driver;

    MainPage mainpage;

    WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser (){
        log.info("Will initialize Chrome web driver");
        this.driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, 20);
    }
    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }


    @Test
    public void elementTest() {
    driver.get(LOCAL_FILE);
    mainpage = new MainPage(driver);
    mainpage.setFirstelement("John");
    mainpage.setLastelement("Doe");
    mainpage.setAboutMeField("Viss ir OK");
    mainpage.clickCheckDataField();
    mainpage.selectCheckBox();


    wait.until(ExpectedConditions.visibilityOf(mainpage.getCheckDataResult()));
    Assert.assertEquals(mainpage.getCheckDataResult().isDisplayed(),true);
    Assert.assertEquals(mainpage.getCheckBOXField().isSelected(), true);

    System.out.println(" ");

    for (WebElement element : mainpage.getAllUniversities()){
        System.out.println(element.getText());
    }
    mainpage.getUniversities().selectByValue("RSU");
        Assert.assertEquals(mainpage.getUniversities().getFirstSelectedOption().getText(), "Rīgas Stradiņa universitāte");


        for (WebElement element : mainpage.getAllColors()){
            System.out.println(element.getText());
        }
        mainpage.getColors().selectByValue("Pink");
        Assert.assertEquals(mainpage.getColors().getFirstSelectedOption().getText(), "Roza");


        mainpage.selectValoda();


    }




    @AfterMethod(alwaysRun = true)
    public void closeBrowser (){
        log.info("We are closing web driver");
        driver.close();
        driver.quit();
    }

}
