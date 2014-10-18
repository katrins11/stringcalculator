package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[])throws NegativeNumbException {
      		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    	}

	@Test
	public void testEmptyString()throws NegativeNumbException{
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber()throws NegativeNumbException{
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers()throws NegativeNumbException{
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
   	public void testMultipleNumbers()throws NegativeNumbException{
    		assertEquals(6, Calculator.add("1,2,3"));
    	}

   	@Test
    	public void testNewLineAsDelimiter()throws NegativeNumbException{
    		assertEquals(6, Calculator.add("1\n2,3"));
    	}

	@Test
	public void testChangeTheDelimiter()throws NegativeNumbException{
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testNvegativesNotAllowed()throws NegativeNumbException{
		try{
			calculator.add("-1,2");
			fail();
		}
		catch(NegativeNumbException x)
		{
			assertEquals("Negatives not allowed: -1", NegativeNumbException.getmessage(x));
		}
	}

	@Test
	public void testNumberBiggerThen1000()throws NegativeNumbException{
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
        public void testDelimitersAtAnyLength()throws NegativeNumbException{
                assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}

	@Test
	public void testDelimitersAtAnyLength()throws NegativeNumbException{
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));

	}
}
