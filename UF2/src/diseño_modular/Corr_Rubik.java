package diseño_modular;

import java.util.Random;
import java.util.Scanner;

public class Corr_Rubik {
	
	final static int MAX=3;
	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char col1, col2, col3, filcol;
		char [][] tau = new char [MAX][MAX];
		boolean cont=false;
		
		do {
			System.out.println("Quedan 3");
			col1=leercol(); System.out.println("Quedan 2");
			col2=leercol();	System.out.println("Queda 1");
			col3=leercol();
			if (col1!=col2 && col1!=col3 && col2!=col3) {
				cont=true;
			}
		}while(cont==false);
		tau=rellenar(tau, col1, col2, col3);
		do {
			mostrarmat(tau);
			filcol=leerfilcol();
			if (filcol=='f'|| filcol=='F') tau=filas(tau);
			else tau=columnas(tau);
			cont=comprovacion(tau);
			
		}while(cont==false);
		
		
	}
	//Fin del main
		
	

	public static char leercol() {
		char a;boolean b;
		b=false;
		do {
			System.out.print("Inserte una letra correspondiente a un color en mayúscula:");
			System.out.println();
			a=reader.next().charAt(0);
			if(a>'Z'||a<'A') {
				System.out.println("Letra no válida");
			}
			else { 
				b=true;
			}
		}while(b==false);
		return a;
	}
	public static char[][] rellenar(char [][] mat, char a, char b, char c) {
		int x, y, j, rand;
		Random rnd = new Random();
		x=0;y=0;
		while(x<MAX) {
			while(y<MAX) {
				rand= rnd.nextInt(3);
				if(rand==1) {
					mat[x][y]=a;
				}
				else {
					if(rand==2) {
						mat[x][y]=b;
					}
					else {
						if(rand==3) {
							mat[x][y]=c;
						}
					}
				}
				j=y-1;
				while (j>=0 && mat[x][y] != mat[x][j]) {
					j--;		
				}
				
				if (j<0) {
					y++;
				}
			}
			x++;
			y=0;
		}
		return mat;
	}
	public static void mostrarmat(char[][] a) {
		int x,y;
		System.out.println("La seva combinació és: ");
		x=0;y=0;
		while(x<MAX) {
			while(y<MAX) {
				System.out.print(a[x][y]);
				
				if(y!=(MAX-1)) {
					System.out.print("-");
				}
				y++;
				
			}
			x++;y=0;
			System.out.println();
		}
	}
	public static char leerfilcol() {
		char a=0;boolean b=false;
		while(b==false) {
			System.out.print("Indiqui amb una 'f' si vol desplaçar les files, o amb una 'c' les col·lumnes: ");
			a=reader.next().charAt(0);
			if(a!='f'&& a!='c') {
				System.out.println();
				System.out.println("Aquest valor no és correcte.");
			}
			else b=true;
		}
		return a;
	}
	public static char[][] filas(char[][]mat) {
		int a=0,x=0,num=0;boolean cont=false;
		char aux;
		while(cont==false) {
				try {
					System.out.print("Ara indiqui el número de la fila que vol moure: ");
					a=reader.nextInt();
					if(a>MAX||a<=0) {
						System.out.println("Dada incorrecte");
					}
					else {
						x=a-1;
						System.out.println();
						System.out.print("Indiqui amb un 1 si vol moure's cap a la dreta, o amb un -1 cap a l'esquerra: ");
						num=reader.nextInt();
						if(num!=1 && num!=-1) {
							System.out.println("Dada incorrecte");
						}
						else {
							cont=true;
						}
						
					}
				}
				catch(Exception e) {
					System.out.println("La dada és incorrecte.");
				}
			}
			
			
			if(num==-1) {
				aux=mat[x][0];
				mat[x][0]=mat[x][1];
				mat[x][1]=mat[x][2];
				mat[x][2]=aux;
			}
			else {
				aux=mat[x][1];
				mat[x][1]=mat[x][0];
				mat[x][0]=mat[x][2];
				mat[x][2]=aux;		
			}
			return mat;
	}
	public static char[][] columnas(char[][]mat) {
		int a=0,y=0,num=0;boolean cont=false;
		char aux;
		while(cont==false) {
			try {
				System.out.print("Ara indiqui el número de la columna que vol moure: ");
				a=reader.nextInt();
				if(a>MAX||a<=0) {
					System.out.println("Dada incorrecte");
				}
				else {
					y=a-1;
					System.out.println();
					System.out.print("Indiqui amb un 1 si vol moure's cap a la baix, o amb un -1 cap a dalt: ");
					num=reader.nextInt();
					if(num!=1 && num!=-1) {
						System.out.println("Dada incorrecte");
					}
					else {
						cont=true;
					}
					
				}
			}
			catch(Exception e) {
				System.out.println("La dada és incorrecte.");
			}
		}
		
		
		if(num==-1) {
			aux=mat[0][y];
			mat[0][y]=mat[1][y];
			mat[1][y]=mat[2][y];
			mat[2][y]=aux;
		}
		else {
			aux=mat[1][y];
			mat[1][y]=mat[0][y];
			mat[0][y]=mat[2][y];
			mat[2][y]=aux;						
		}
	return mat;
	}
	public static boolean comprovacion(char[][] mat) {
		int x,y,j;
		boolean preg=false, trying=false;
		char a;
		x=0;y=0;
		trying=true;
		while(x<MAX&&trying!=false) {
			while(y<MAX&&trying!=false) {
				j=y+1;
				if(mat[x][y]==mat[j][y]&&trying!=false) {
					j++;
					if(mat[x][y]==mat[j][y]) {
						trying=true;
					}
					else {
						trying=false;
					}
				}
				else {
					trying=false;
				}
				y++;
			}
			x++;
			y=0;
		}
		if(trying==true) {
			System.out.println("Ha resolt el quadrat de Rubik!!");
			preg=true;
		}
		else {
			trying=true;
			while(y<MAX) {
				while(x<MAX&&trying!=false) {
					j=x+1;
					if(mat[x][y]==mat[x][j]&&trying!=false) {
						j++;
						if(mat[x][y]==mat[x][j]) {
							trying=true;
						}
						else {
							trying=false;
						}
					}
					else {
						trying=false;
					}
					x++;
				}
				y++;
				x=0;
			}
		}
		if(trying==true) {
			System.out.println("Ha resolt el quadrat de Rubik!!");
			preg=true;
		}
		else {
			System.out.println("Encara no l'ha resolt. Continüi intentant-ho!!");
			System.out.print("Desitja continuar intentant-ho? 's' per si, o 'n' per no: ");
			a=reader.next().charAt(0);
			if(a!='s'&& a!='n') {
				System.out.println();
				System.out.println("Aquest valor no és correcte.");
				
			}
			else {
				if(a=='n') {
				preg=true;
				}
			}
		
		}
		return preg;
	}
	
}
