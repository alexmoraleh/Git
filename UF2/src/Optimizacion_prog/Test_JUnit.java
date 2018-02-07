package Optimizacion_prog;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_JUnit {

	@Test
	public void testSuma() {
		int res = JUnit.suma(10,20);
		assertEquals(30, res);
		//fail("Not yet implemented");
	}

	@Test
	public void testResta() {
		int res = JUnit.resta(50,20);
		assertEquals(30, res);
		//fail("Not yet implemented");
	}

	@Test
	public void testMultiplicacio() {
		int res = JUnit.multiplicacio(20,30);
		assertEquals(600, res);
		//fail("Not yet implemented");
	}

	@Test
	public void testDivisio() {
		int res = JUnit.divisio(600,20);
		assertEquals(30, res);
		//fail("Not yet implemented");
	}
	@Test
	public void testException() {
		int res=0;
		try {
			res=JUnit.divisio(10,0);
			//assertEquals(30,res);
			fail("Fail: It goes over here if don't throws the exception ArithmeticException");
		}
		catch (ArithmeticException e) {
			//La prueba chuta
		}
	}
	@Test (expected = java.lang.ArithmeticException.class)
    public void testDivideix() {
        int res = JUnit.divisio(10, 0);
        assertEquals("Ha fallat el método divideix", 2,  res);
    }	

}

