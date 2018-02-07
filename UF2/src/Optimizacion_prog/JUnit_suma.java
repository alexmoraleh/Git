package Optimizacion_prog;

import java.util.Scanner;

public class JUnit_suma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		System.out.print("Inserte sumandos: ");
		int a=reader.nextInt();
		int b=reader.nextInt();
		int res = a + b;
		System.out.print("La solucion es: " +res);
		reader.close();
	}

}
