package diseño_modular;

import java.util.Random;
import java.util.Scanner;

public class Memory {
	
	public static Scanner reader = new Scanner(System.in);
	public static int MAX=4;
	public static void main(String[] args) { //Dos jugadores, si acierta la tirada vuelve a tirar.
		// TODO Auto-generated method stub     Volver a hacer una partida, 

		char fin='s';
		while(fin!='n'&&fin!='N') {
			Jugar(fin);
			fin=Fin();
		}
	}
	public static void Jugar(char fin) {
		char[][] matin = new char [MAX][MAX];
		char[][] matlet = new char [MAX][MAX];
		int [] score=new int[2];
		int [] first=new int[2];
		int [] last=new int [2];
		boolean [] coin=new boolean[2];
		int p=1, x=0;
		boolean end=false;
		while(end==false) {
			if(fin=='s'||fin=='S') {
				Tablainterrog(matin);
				Generartabla(matlet);
				Mezclartabla(matlet);
				p=1;
				fin='n';
			}
			System.out.println("Turno de Player" + p);
			Mostrartabla(matin);
			first=Pregcollin("Primera");
			last=Pregcollin("Segunda");
			Darvuelta(matin, matlet, first, last, x);
			x++;
			Mostrartabla(matin);
			coin=Coinciden(matin, first, last, matlet);
			if(coin[0]==true) {
				score[p-1]++;
				System.out.println("Bien echo, Player" + p + " ha ganado 1 punto");
				System.out.println("Player1=" + score[0] + " Player2=" + score[1]);
			}
			else {
				if(coin[1]==true) {
					System.out.println("Player"+p+", ha perdido 1 punto.");
					score[p-1]--;
				}
				else {
					System.out.println("Lo siento Player" + p + ", las dos fichas no son iguales");
					System.out.println();
				}
			}
			if(p==1) {
				p++;
			}
			else p--;
			end=Completado(matin);
			if(end==true) {
				System.out.println("Enhorabuena, se ha resuelto el tablero");
				System.out.println("La puntuación final ha sido:");
				System.out.println("Player1=" + score[0]);
				System.out.println("Player2=" + score[1]);
				Mostrartabla(matin);
			}
		}
	}
	private static char[][] Tablainterrog(char[][] mat) {
		// TODO Auto-generated method stub
		int x=0, y=0;
		while(x<MAX) {
			while(y<MAX) {
				mat[x][y]='?';
				y++;
			}
			x++; y=0;
		}
		return mat;
	}
	private static char[][] Generartabla(char[][] mat) {
		// TODO Auto-generated method stub
		int x=0, y=0;
		char c='A';
		while(x<MAX) {
			while(y<MAX) {
				mat[x][y]=c;
				y++;
				if(y%2==0) {
					c++;	
				}
			}
			x++; y=0;
		}
		return mat;
	}
	private static char[][] Mezclartabla(char[][] mat) {
		// TODO Auto-generated method stub
		int x=0,y=0,cont=0, y2=0, x2=0; char aux=0;
		Random rnd = new Random();
		while(cont<(MAX*MAX*1.5)) {
			y=rnd.nextInt(MAX);
			x=rnd.nextInt(MAX);
			aux=mat[x][y];
			y2=rnd.nextInt(MAX);
			x2=rnd.nextInt(MAX);
			mat[x][y]=mat[x2][y2];
			mat[x2][y2]=aux;
			cont++;
		}
		return mat;
	}
	private static int[] Pregcollin(String a) {
		// TODO Auto-generated method stub
		int cont=0;
		String[] col = new String [2];
		col[0]="fila"; col[1]="columna";
		int[] x = new int[2];
		System.out.print(a.toString() + " ficha.");
		while (cont<2) {
			try {
				System.out.println();
				System.out.print("Indique la " + col[cont] + " donde se encuentra la posición que desea voltear: ");
				x[cont]=reader.nextInt();
				if(x[cont]<1 || x[cont]>MAX) {
					System.out.println("Valor fuera del rango");
				}
				else {
					x[cont]--;
					cont++;
				}
			}
			catch(Exception e) {
				System.out.println("Valor no válido");
				reader.nextLine();
			}
		}
		return x;
	}
	private static char[][] Darvuelta(char[][] in, char[][] let, int[] first, int[] last, int x){	
		if((in[first[0]][first[1]]=='?' && in[last[0]][last[1]]=='?') || x==0) {
			in[first[0]][first[1]]=let[first[0]][first[1]];
			in[last[0]][last[1]]=let[last[0]][last[1]];
		}
		else {
			if(in[first[0]][first[1]]!='?') in[first[0]][first[1]]='?';
			else {
				if(in[last[0]][last[1]]!='?') in[last[0]][last[1]]='?';
			}
				
		}
		return in;
	}
	private static void Mostrartabla(char[][] mat) {
		// TODO Auto-generated method stub
		int x=0, y=0;
		while(x<MAX) {
			while(y<MAX) {
				System.out.print(mat[x][y] + " ");
				y++;
			}
			System.out.println();
			x++;y=0;
		}
	}
	private static boolean[] Coinciden(char[][] mat, int[] x, int[] y, char [][] let) {
		// TODO Auto-generated method stub
		boolean[] yep=new boolean[2];
		yep[0]=false; yep[1]=false;
		if(mat[x[0]][x[1]]=='?' || mat[y[0]][y[1]]=='?') {
			System.out.println("Alguna de las fichas que ha elegido ya se han usado.");
			if(mat[x[0]][x[1]]=='?')mat[x[0]][x[1]]=let[x[0]][x[1]];
			else {
				if(mat[y[0]][y[1]]=='?')mat[y[0]][y[1]]=let[y[0]][y[1]];
			}
			yep[1]=true;
		}
		else {
			if(mat[x[0]][x[1]]==mat[y[0]][y[1]]) {
				yep[0]=true;
			}
			else {
				mat[x[0]][x[1]]='?';
				mat[y[0]][y[1]]='?';
			}
		}
		return yep;
	}
	private static boolean Completado(char[][] mat) {
		// TODO Auto-generated method stub
		boolean check=true; int x=0, y=0;
		while(x<MAX&&check==true) {
			while(y<MAX&&check==true) {
				if(mat[x][y]=='?') {
					check=false;
				}
				y++;
			}
			x++;y=0;
		}
		return check;
	}
	public static char Fin() {
		char x=0; boolean check=false;
		while(check==false) {
			System.out.print("Desea volver a hacer una partida?, S para si o N para no: ");
			x=reader.next().charAt(0);
			if(x!='S' || x!='s'||x!='n'||x!='N') {
				System.out.println("Valor inválido");
			}
			else {
				check=true;
			}
		}
		return x;
	}

}
