package diseño_modular;

import java.util.Random;
import java.util.Scanner;

/**
 * <h2>Clase Buscaminas, es la recreación del mítico juego del buscaminas</h2>
 * @version 2-2018
 * @author Alex Morales
 * @since 20-1-2018
 *
 */
public class Buscaminas {
	/**
	 * @param MAX Se usa para asignar el tamaño de las matrices 
	 */

	static Scanner reader = new Scanner(System.in);
	static int MAX=8;
	/**
	 * 
	 * El main se usa como launcher
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char fin='s';
		while(fin!='n'&&fin!='N') {
			Jugar(fin);
			fin=Fin();
		}
	}
	/**
	 * 
	 * @see Jugar Aqui esta lo que es el juego en si con sus funciones que llaman a cada funcion del juego
	 * @param minas Es la matriz donde se almacena la posicion de todas las minas y los números
	 * @param inter Es la matriz que se va a mostrar al usuario y donde se guardarán las tiradas
	 * @param usr Este vector se usa para preguntar al usuario la poscicion que desa voltear o marcar
	 */
	public static void Jugar(char fin) {
		int [][] minas = new int[MAX][MAX];
		char [][] inter=new char [MAX][MAX];
		int [] usr = new int [2];
		boolean mark =false, end=false;   //Demomento esta puesto para que Jugar acabe cuando se coma una mina, arreglar mas adelante!!!!!!!!!!!!!!!!!!!!
		int cont=0;
		
		
		Rellenarinter(inter);
		Rellenarminas(minas);
		Rellenarnums(minas);
		do {
			Mostrarmat(inter);
			Mostrarminas(minas);/**@see Mostrarminas Temporal, solo para comprovaciones*/
			mark=Preguntar(usr);
			if(mark==true) {
				Marcar(inter, usr);
			}
			Darvuelta(inter, minas, usr);
			end=Comprovar(inter, end);
			cont++;
		}while(cont>=1&&end==false);
		
		
	}
	/**
	 * Esta funcion se usara para determinar que se le devuelve al launcher
	 * 
	 */
	public static char Fin() {
		return 0;
	}
	/**
	 * Bucle para mostrar la matriz de las minas (temporal hasta arreglar errores)
	 * @param mat
	 */
	public static void Mostrarminas(int[][]mat) {
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
	/**
	 * Aqui se rellena la matriz que se muestra al usuario con el caracter que se desee
	 * @param mat
	 * @return matriz de incognitas
	 */
	public static char[][] Rellenarinter (char[][] mat){
		int x=0, y=0;
		while(x<MAX) {
			while(y<MAX) {
				mat[x][y]=(char)1;
				y++;
			}
			x++;y=0;
		}
		return mat;
	}
	/**
	 * Esta funcion rellena la matriz de minas (dependiendo del tamaño del tablero habrá mas o menos) en posiciones aleatoras.
	 * @param mat Matriz de las bombas
	 * @return Matriz de las bombas
	 */
	public static int[][] Rellenarminas (int[][] mat){
		int x=0, y=0, cont=0;
		Random rnd=new Random();
		while (cont<(MAX*2)) {
			x=rnd.nextInt(MAX);
			y=rnd.nextInt(MAX);
			if(mat[x][y]!=9) {
				mat[x][y]=9;
				cont++;
			}
		}
		return mat;
	}
	/**
	 * Esta funcion genera los numeros al rededor de las bombas (aun por terminar)
	 * @param mat Matriz de las bombas
	 * @return Matriz con las bombas aleatorias y las casillas con el número de bombas al rededor
	 */
	public static int[][] Rellenarnums(int[][]mat){ //Algo falla, voto por hacerlo de nuevo. Preguntar a la profe
		int x=0, y=0, auxx=0, auxy=0, xx=0, yy=0; 
		while(auxx<MAX) {
			while(auxy<MAX) {
				if(mat[auxx][auxy]==9) {
					x=auxx;
					y=auxy;
					x--;y--;
					xx=0;yy=0;
					while(xx<3) {
						while(yy<3) {
							if(y>=0) {
								if(x>=0) {
									if(y<MAX) {
										if(x<MAX) {
											if(mat[x][y]!=9) {
												mat[x][y]=mat[x][y]+1;
												y++;
												yy++;
											}
											else {
												y++;
												yy++;
											}
										}
										else {
											y++;
											yy++;
										}
									}
									else {
										y++;
										yy++;
									}
								}
								else {
									y++;
									yy++;
								}
							}
							else {
								y++;
								yy++;
							}
						}
						x=x-xx;xx++;x++;y=auxy;yy=0;
					}
				}
				auxy++;
			}
			auxx++;auxy=0;
		}
		return mat;
	}
	/**
	 * Esto se usa para mostrar la matriz al usuario
	 * @param mat Matriz de incognitas
	 */
	public static void Mostrarmat(char[][] mat) {
		int x=0, y=0;
		while(x<MAX) {
			while(y<MAX) {
				System.out.print(mat[x][y] + " ");
				y++;
			}
			y=0;
			while(y<MAX) {
				y++;
			}
			System.out.println();
			x++;y=0;
		}
	}
	/**
	 * Esta funcion pregunta al usuario que posicion del tablero desea voltear o marcar (en el caso de que crea que contiene una bomba)
	 * @param vec Vector de dos posiciones que almacena la posicion a voltear
	 * @return Se retorna un boleano para saber si se desea voltear o marcar
	 */
	public static boolean Preguntar(int[] vec) { //Revisar si me dejo algo (me he quedado empanado xd)
		char x;boolean mark=false, check=false;
		/**
		 * @param x <ul>
		 * 				<li>M: marcar la casilla porque se cree que contiene una bomba</li>
		 * 				<li>D: destapar la casilla para ver que contiene</li>
		 * 			</ul>
		 */
		System.out.print("Indique si desea destapar o marcar la casilla: ");
		x=reader.next().charAt(0);
		if(x=='m'||x=='M') {
			mark=true;
			System.out.println("(Se mostrará con un !)");
		}
		while (check==false) {
			/**
			 * En el cualquier caso, el usuario deve escojer una posicion
			 */
			try {
				System.out.println("Inserte las coordenadas donde se encuentra la casilla que desea utilizar.");
				System.out.print("Fila: ");
				vec[0]= reader.nextInt();
				vec[0]--;
				System.out.print("Columna: ");
				vec[1]= reader.nextInt();
				vec[1]--;
				if(vec[0]<MAX && vec[0]>=0) {
					if(vec[1]<MAX && vec[1]>=0) {
				check=true;
					}
				}
				else System.out.println("Algún valor no esta dentro del rango.");
			}
			catch(Exception e) {
				System.out.println("Valor no válido.");
				reader.nextLine();
			}
		}
		return mark;
	}
	/**
	 * Esta funcion marca la casilla que ha escojido el usuario en la matriz de incognitas
	 * @param mat Matriz de incognitas
	 * @param vec Posicion del usuario
	 * @return Matriz donde en la posicion deseada ahora aparece un '!'
	 */
	public static char[][] Marcar(char[][] mat, int[] vec){
		if(mat[vec[0]][vec[1]]=='!') {
			System.out.println("Se va a desmarcar...");
			mat[vec[0]][vec[1]]=(char)1;
		}
		else {
			mat[vec[0]][vec[1]]='!';
		}
		
		return mat;
	}
	/**
	 * Aqui será donde se "destapará" la posicion que el usuario desee
	 * @param inter Matriz que se muestra al usuario
	 * @param minas Matriz con las minas y los números
	 * @param usr Vector con la posicion a dar la vuelta
	 * @return
	 */
	public static char[][] Darvuelta(char[][]inter, int[][]minas, int[]usr) {
		
		return inter;
	}
	/**
	 * Aqui se comprueba que la matriz que se muestra al usuario aún no muestra ninguna mina
	 * @param mat Matriz interrogante
	 * @param end Boleano que informa a @see Juego si deve acabar el juego
	 * @return
	 */
	public static boolean Comprovar(char[][]mat, boolean end) {
		int x=0, y=0;
		while(x<MAX&&end==false) {
			while(y<MAX&&end==false) {
				if(mat[x][y]=='*') {
					System.out.println("Vaya, te has comido una mina xd");
					end=true;
				}
				y++;
			}
			x++;y=0;
		}
		return end;
	}

}
