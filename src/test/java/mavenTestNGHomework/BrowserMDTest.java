package mavenTestNGHomework;


import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;


@Log4j
public class BrowserMDTest {

    ChromeDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser (){
        log.info("Will initialize Chrome web driver");
        this.driver = new ChromeDriver();
        driver.get("https://www.tvnet.lv");
    }
    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }


    @Test
    public void chromeDriverTest(){
        Assert.assertEquals(driver.getTitle(), "TVNET - Īstas ziņas");
    }




    @AfterMethod(alwaysRun = true)
    public void ocloseBrowser (){
        log.info("We are closing web driver");
        driver.close();
    }

}
