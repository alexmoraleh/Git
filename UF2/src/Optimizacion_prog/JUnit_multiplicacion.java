package Optimizacion_prog;

import java.util.Scanner;

public class JUnit_multiplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		System.out.print("Inserte multiplicando: ");
		int a=reader.nextInt();
		System.out.print("Inserte multiplicador: ");
		int b=reader.nextInt();
		int res = a * b;
		System.out.print("El producto es: " +res);
		reader.close();
		
	}

}
