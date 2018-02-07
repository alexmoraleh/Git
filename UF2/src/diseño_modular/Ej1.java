package diseño_modular;

import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);
		int op1 = 0;
		float res=0;
		char opcio=0;
		boolean control=false, oper=false;
		
		
		
		do {
			MostrarMenu();
			opcio=leercar();
			switch(opcio) {
			case'o':
			case'O':
				try {
				oper=false;
					if(control==false) {
						System.out.print("Inserte el primer valor: ");
						res=leerval();
						System.out.print("Inserte el segundo valor: ");
						op1=leerval();
						control=true;
						
					}
					else {
						System.out.print("Inserte el nuevo valor: ");
						op1=leerval();
					}
				}
				catch(Exception e) {
					reader.nextLine();
					System.out.println("El valor no es correcto");
					System.out.println();
				}
				break;
			case'+':
				if(control==true) {
					res=Suma(res, op1);
					oper=true;
				}
				else {
					System.out.println("Aún no ha insertado los valores.");
					System.out.println();
				}
				break;
			case'-':
				if(control==true) {
					res=Resta(res, op1);
					oper=true;
				}
				else {
					System.out.println("Aún no ha insertado los valores.");
					System.out.println();
				}
				break;
			case'*':
				if(control==true) {
					res=Mult(res, op1);
					oper=true;
				}
				else {
					System.out.println("Aún no ha insertado los valores.");
					System.out.println();
				}
				break;
			case'/':
				if(control==true) {
					res=Div(res, op1);
					oper=true;
				}
				else {
					System.out.println("Aún no ha insertado los valores.");
					System.out.println();
				}
				break;
			case's':
			case'S':
				oper=false;
				break;
			case'c':
			case'C':
				res=0;
				control=false;
				System.out.println("Reseteado");
			}
			if(control==true) {
				if(oper==true) {
					System.out.println("El resultado es: " +res);
					System.out.println();
				}
				
			}
			
		}while(opcio!='s'&&opcio!='S');
		
		reader.close();
	}
	public static void MostrarMenu() {
		System.out.println("o. Introducir valor");
		System.out.println("+. Sumar");
		System.out.println("-. Restar");
		System.out.println("*. Multiplicar");
		System.out.println("/. Dividir");
		System.out.println("c. Resetear");
		System.out.println("s. Salir");
		
	}
	public static int leerval() {
		int x=0;boolean d=false;
		while(d==false) {
			try {
				Scanner reader = new Scanner(System.in);
				x=reader.nextInt();
				d=true;
			}
			catch(Exception e) {
				System.out.print("Valor no válido, vuelva a intentarlo: ");
				
			}
		}
		return x;
	}
	public static char leercar() {
		char car;
		Scanner reader = new Scanner(System.in);
		System.out.println("Introduzca una opcion:");
		car=reader.next().charAt(0);
		return car;
		
	}
	public static float Suma(float a, float b) {
		float res;
		res=a+b;
		return res;
	}
	public static float Resta(float a, float b) {
		float res;
		res=(a)-(b);
		return res;
	}
	public static float Mult(float a, float b) {
		float res;
		res=(a)*(b);
		return res;
	}
	public static float Div(float a, float b) {
		float res=0;
		if(a==0 || b==0) {
			System.out.print("Syntax error");
		}
		else {
			res=(a)/(b);
		}
		return res;
	}
}
