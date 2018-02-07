package diseño_modular;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Temperaturas {
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DecimalFormat df=new DecimalFormat("#.00");
		double[]temp=new double[24];
		double[]max= new double[31];
		double[]min= new double[31];
		int opc, x=-1, dia;
		boolean preg=false, cont=false, compdia;
		
		do {
			opc=Mostrarmenu();
			switch(opc) {
				case 1:
					Temperatura(temp);
					cont=true;
					x++;
					Check();
					break;
				case 2:
					if(cont==true) {
						Mostrartemp(temp);
					}
					else msstemp();
					break;
				case 3:
					if(cont==true) {
						Mostrartemp(temp);
						Modificartemp(temp);
						Check();
					}
					else msstemp();
					break;
				case 4:
					if(cont==true) {
						max[x]=Maxtemp(temp);
						min[x]=Mintemp(temp);
						cont=false;
						Check();
					}
					else msstemp();
					break; 
				case 5:
					dia=Pregdia();
					compdia=Compdia(x, dia);
					if(compdia==true) {
						mss("Máxima: " + df.format(max[x]) + ". Mínima: " + df.format(min[x]) + ".");
					}
					else msstemp();
					break;
				case 6:
					if(x!=0) Mostrarmes(x, min, max);
					else msstemp();
					break;
				case 7:
					Mostrarmes(x, min, max);
					Media(x, min, max);
					break;
				case 8:
					preg=true;
					break;
				default:
					mss("No existe esa opcion");
					break;
			}
						
		}while(preg==false);
	}
	//Fin main
	
	public static void mss(String a) {
		System.out.println(a.toString());
	}
	public static void msstemp() {
		System.out.println("No hay temperaturas");
		System.out.println(" ");
	}
	public static int Mostrarmenu() {
		int x=1; boolean check=false;
		while (check!=true){
			System.out.println("1. Introduzca temperatura");
			System.out.println("2. Listar las temperaturas del dia");
			System.out.println("3. Modificar una temperatura");
			System.out.println("4. Registrar mínimo y máximo diario");
			System.out.println("5. Mostrar temperaturas mínimas y máximas de un dia");
			System.out.println("6. Mostrar temperaturas mínimas y máximas del mes");
			System.out.println("7. Mostrar estadisticas de las temperaturas del mes");
			System.out.println("8. Salir del programa");
			mss("Escoja una opcion: ");
			try {
				x=reader.nextInt();
				if (x<0 && x>9) {
					mss("Ese valor no entra en el rango.");
					mss("");
				}
				else check=true;
			}
			catch (Exception e) {
				mss("Error en la introduccion de datos.");
				mss("");
				reader.nextLine();
			}
		}
		return x;
	}
	public static double[] Temperatura(double[] mat) {
		int x=0;
		Random rnd = new Random();
		mat[x] = -10.00 + (40.0 - (-10.0)) * rnd.nextDouble();
		x=1;
		while (x<24) { //&& mat[x] != mat[y] && (((mat[x]-mat[y])<=3) || ((mat[y]-mat[x])<=3))
			mat[x] = -10.00 + (40.0 - (-10.0)) * rnd.nextDouble();
			if (Math.abs(mat[x]-mat[x-1])<=3) {
				x++;	
			}		
		}
		return mat;
	}
	public static void Mostrartemp(double[] mat) {
		int x=0;
		DecimalFormat df=new DecimalFormat("#.00");
		while(x<24) {
			if(x<=9) {
				mss("0" +x+ ":00  " + df.format(mat[x]));
			}
			else {
				mss(x + ":00  " + df.format(mat[x]));
			}
			x++;
		}
	}
	public static double[] Modificartemp(double[] mat) {
		int x; double y; boolean check=false;
		mss("Introduzca la solo hora de la temperatura que desea modificar: ");
		while(check==false) {
			try {
				x=reader.nextInt();
				if (x<0 || x>24) {
					mss("Ese valor no entra en el rango.");
					mss("");
				}
				else {
					mss("Introduzca ahora el nuevo valor para la temperatura: ");
					y=reader.nextDouble();
					if(y<-10 || y>40) {
						mss("Ese valor no entra en el rango.");
						mss("");
					}
					else {
						mat[x]=y;
						check=true;
					}
				}
			}
			catch (Exception e) {
				mss("Error en la introduccion de datos.");
				mss("");
				reader.nextLine();
			}
		}
		return mat;
	}
	public static double Maxtemp(double[] mat) {
		int x=0; double y=0;
		while(x<24) {
			if(mat[x]>y) {
				y=mat[x];
			}
			x++;
		}
		return y;
	}
	public static double Mintemp(double[] mat) {
		int x=0; double y=40;
		while(x<24) {
			if(mat[x]<y) {
				y=mat[x];
			}
			x++;
		}
		return y;
	}
	public static int Pregdia() {
		int x=0; boolean check=false;
		while(check!=true) {
			try {
				mss("Inserte el dia que quiere comparar: ");
				x=reader.nextInt();
				if (x<0 || x>24) {
					mss("Ese valor no entra en el rango.");
					mss("");
				}
				else {
					check=true;
				}
			}
			catch(Exception e) {
				mss("Error en la introduccion de datos.");
				mss("");
				reader.nextLine();
			}
			
		}
		return x;
	}
	public static boolean Compdia(int x, int y) {
		boolean n=false;
		y--;
		if(y<=x) {
			n=true;
		}
		return n;
	}
	public static void Mostrarmes(int x, double[] min, double[] max) {
		int y=0;
		DecimalFormat df=new DecimalFormat("#.00");
		while(y<x) {
				mss("Mínimas día " + (y+1) + ":  " + df.format(min[y]) + ". Máximas día " + (y+1) + ":  " + df.format(max[y]));
			y++;
		}
	}
	public static void Media(int x, double[] min, double[]max) {
		int y=0; double aux;
		DecimalFormat df=new DecimalFormat("#.00");
		while(y<x) {
			aux=(min[y]+max[y])/2;
			mss("La media del dia " + y + " es: " + df.format(aux));
			y++;
		}
	}
	public static void Check() {
		System.out.println("Datos guardados.");
		System.out.println();
	}
}
