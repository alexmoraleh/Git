package Optimizacion_prog;

import java.util.Scanner;

public class JUnit_division {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner reader = new Scanner(System.in);
		System.out.print("Inserte dividendo: ");
		int a=reader.nextInt();
		System.out.print("Inserte divisor: ");
		int b=reader.nextInt();
		int res = a / b;
		System.out.print("El cociente es: " +res);
		reader.close();
	}

}
