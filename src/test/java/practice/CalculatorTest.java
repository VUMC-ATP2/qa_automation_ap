//package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {


    @Test
    public void testSum(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.sum(25,30), 55);
    }
    @Test
    public void testMultiply(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(5,30), 150);
    }
    @Test
    public void testDivide(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(25,5), 5);
    }
    @Test
    public void tesMinus(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.minus(35,30), 5);
    }
}
