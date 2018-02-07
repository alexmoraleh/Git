package Optimizacion_prog;

import java.util.Scanner;

public class JUnit_resta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		System.out.print("Inserte minuendo: ");
		int a=reader.nextInt();
		System.out.print("Inserte substraendo: ");
		int b=reader.nextInt();
		int res = a - b;
		System.out.print("La solucion es: " +res);
		reader.close();
	}

}
