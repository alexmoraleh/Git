package diseño_modular;

import java.util.Random;
import java.util.Scanner;

public class Ahorcado {//Lol, otro comentario donde tengo que explicar cosas

	public static int MAX=4;
	public static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char fin='s';
		boolean sefini=false;
		while(fin!='n'&&fin!='N') {
			sefini=Jugar(fin);
			fin=Fin(sefini);
		}
	}
//Este lo pongo aqui porque quiero tt
	private static boolean Jugar(char fin) {
		// TODO Auto-generated method stub
		String [] words = {"pantalla","teclado","laberinto","autista","deprimido","soledad","melancolia","transtorno","ludopata","sumiso","desesperado","tablero","laringitis","fuego",""};
		//Aqui se guardaran todas las palabras
		String wrd = new String(); //Aqui se guarda la palabra escogida
		char usr = 0; //Aqui se guarda el carácter del usuario
		int contwrd = 0; //Aqui se cuenta cuantos carácteres tiene la palabra escojida
		boolean end=false; //Boleano que marca el final del juego
		char [] pal;
		int [] cont = new int[1];
		boolean sefini =true;
		wrd=Escojer(words);
		pal = wrd.toCharArray();
		contwrd=wrd.length();
		char [] inter = new char[contwrd]; //Vector donde se guarda las incognitas
		Generarinter(inter, contwrd);
		while(end==false&&cont[0]<12) {
			System.out.println("Quedan " + (12-cont[0]) + " intentos.");
			Mostrarinter(inter, contwrd);
			System.out.print(" ");
			usr=Preguntar(usr);
			Comprovar(pal, usr, inter, contwrd, cont);
			end=Completado(inter, contwrd);
		}
		if(cont[0]==12) {
			System.out.println("Se ha quedado sin intentos :(");
			sefini=false;
		}
		Mostrarinter(inter, contwrd);
		System.out.println();
		return sefini;
	}

	public static char Fin(boolean fi) {
		// TODO Auto-generated method stub
		char x='s'; boolean check=false;
		if(fi==true) {
			System.out.println("     Bien echo!!");
		}
		while(check==false) {
			System.out.print("Desea volver a jugar (s para si o n para no)? ");
			x=reader.next().charAt(0);
			if(x!='s'&&x!='S'&&x!='n'&&x!='N') {
				System.out.print("Respuesta no válida.");
			}
			else check=true;
		}
		return x;
	}
	public static String Escojer (String[] mat){
		Random rnd = new Random();
		String wrd;
		int x;
		x=rnd.nextInt(13);
		wrd=mat[x];
		return wrd;
	}
	public static char[] Generarinter(char[] mat, int y) {
		int x=0;
		while(x<y) { //no llega a entrar, mirar la y
			mat[x]='_';
			x++;
		}
		return mat;
	}
	public static void Mostrarinter(char[] mat, int y) {
		int x=0;
		while(x<y) {
			System.out.print(mat[x] + " ");
			x++;
		}
		
	}
	public static char Preguntar (char x) {
		boolean check=false;
		while(check!=true) {
			try {
				System.out.print("Inserte la letra que desea comprovar: ");
				x=reader.next().charAt(0);
				if (x>'A'&&x<'Z') {
					x=(char) (x+32);
					check=true;
				}
				else {
					if(x>'z') {
						System.out.println("El valor introducido no es una letra.");
					}
					else check=true;
				}
			}
			catch(Exception e) {
				System.out.println("El valor introducido no válido.");
				reader.nextLine();
			}
		}
		return x;	
	}
	public static char[] Comprovar(char[] pal, char usr, char[] inter, int y, int[] cont) {
		int x=0;boolean check=false;
		System.out.println(usr);
		while(x<y) {
			if(pal[x]==usr) {
				inter[x]=usr;
				check=true;
			}
				x++;
		}
		if(check==false) {
			cont[0]=cont[0]+1;
		}
		return inter;
	}
	public static boolean Completado(char[] vec, int y) {
		boolean check=true; int x=0;
		while(x<y) {
			if(vec[x]=='_') {
				check=false;
			}
			x++;
		}
		return check;
	}

}
