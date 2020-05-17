package calculator;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
	public Calculator c;

	@BeforeClass
	public void InstantiateCalculator() {
		c = new Calculator();
	}

	@Test
	public void addTest() {
		double value1 = c.getValue();
		c.add(100.35);
		double value2 = c.getValue();
		Assert.assertEquals(value2, value1 + 100.35);

	}

	@Test
	public void divTest() {
		double value1 = c.getValue();
		c.div(2.00);
		double value2 = c.getValue();
		Assert.assertEquals(value2, value1 / 2.00);
		//new calculator value should be equals to previous value divide by 2

		boolean b = false;
		try {
			c.div(0);
			fail("Expected exception was not occurred.");
		} catch (Exception e) {
			b = true;
		}
		Assert.assertTrue(b);
		//if b is true, program was is catch block and 
		//there was an exception thrown (for dividing by zero)
		//otherwise, method is not working properly
	}
	
	@Test
	public void setValueTest() {
		c.setValue(100.25);
		Assert.assertEquals(c.getValue(), 100.25);
	}
	

}
