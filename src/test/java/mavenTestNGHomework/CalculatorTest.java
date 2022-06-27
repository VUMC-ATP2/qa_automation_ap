package mavenTestNGHomework;


import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


@Log4j
public class CalculatorTest {

    Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void startTest (){
        log.info("Sākam testus");

    }

    @Test
    public void testSum(){
        this.calculator = new Calculator();
        Assert.assertEquals(this.calculator.add(25,30), 55);
    }
    @Test
    public void testMultiply(){
        this.calculator = new Calculator();
        Assert.assertEquals(this.calculator.multiply(5,30), 150);
    }
    @Test
    public void testDivide(){
        this.calculator = new Calculator();
        Assert.assertEquals(this.calculator.divide(25,5), 5);
    }
    @Test
    public void tesMinus(){
        this.calculator = new Calculator();
        Assert.assertEquals(this.calculator.substract(35,30), 5);
    }


    @AfterMethod(alwaysRun = true)
    public void endTest (){
        log.info("Beidzam testus");

    }
}
