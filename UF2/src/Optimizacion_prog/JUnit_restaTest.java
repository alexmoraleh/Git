package Optimizacion_prog;

import static org.junit.Assert.*;


import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;


import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JUnit_restaTest {


	private int num1;
	private int num2;
	private int resul;
	
	public JUnit_restaTest (int num1, int num2, int resul) {
		this.num1 = num1;
		this.num2 = num2;
		this.resul = resul;
	}
	
	@Parameters
	public static Collection<Object[]> numeros() {
		return Arrays.asList(new Object[][] {
			{20, 10, 30},
			{30, -2, 28},
			{5, 2, 7}
		});
		
	}
	@Test
	public void testResta() {
		int res = JUnit.suma(num1,  num2);
		assertEquals(resul,  res);
	}
}