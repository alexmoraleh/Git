package diseño_modular;

import java.util.Random;
import java.util.Scanner;

public class Corr_Rubic_prof {

	final static int MAX=3;
	static Scanner reader=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char col1,col2,col3;
		char[][]mat=new char[MAX][MAX];
		char preg='s', desp;
		int num,sent;
		
		do {
			mss("Quedan 3");
			mss(" ");
			col1=preguntcol();
			mss("Quedan 2");
			mss(" ");
			col2=preguntcol();
			mss("Queda 1");
			mss(" ");
			col3=preguntcol();
		}while(diferentes(col1,col2,col3));
        
        Rellenar(mat, col1,col2,col3);
        
        do {
            mostrarMat(mat);
            desp=PregDesp();
            num=PregNum(desp);
            sent=PregSent(desp);
            aplicarDesp(mat,desp,num,sent);
            if (MatOk(mat)) {
                mss("¡¡Ha formado el cubo de Rubik!!");
            }
            else {
                mss ("Continue jugando, aún no has acabado");
                mss(" ");
                mss("¿Desea continuar jugando? Use s para si, o n para no: ");
                preg = PedirRes();
            }
        }while (preg=='s'||preg=='S');
	}
	//FIn MAin
	
	public static void mss(String a) {
		System.out.print(a.toString());
	}
	public static char preguntcol() {
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
			reader.nextLine();
		}while(b==false);
		
	return a;
	}
	public static boolean diferentes (char a, char b, char c){
		boolean cont;
		if (a!=b && a!=c && b!=c) {
			cont=false;
		}
		else cont=true;
		return cont;
	}
	public static char[][] Rellenar(char[][] mat, char a, char b, char c){

		int x, y, j, rand;
		Random rnd = new Random();
		x=0;y=0;
		while(x<MAX) {
			while(y<MAX) {
				rand= rnd.nextInt(3);
				if(rand==0) {
					mat[x][y]=a;
				}
				else {
					if(rand==1) {
						mat[x][y]=b;
					}
					else {
						if(rand==2) {
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
	public static void mostrarMat(char[][]mat){
		int x,y;
		System.out.println("La seva combinació és: ");
		x=0;y=0;
		while(x<MAX) {
			while(y<MAX) {
				System.out.print(mat[x][y]);
				
				if(y!=(MAX-1)) {
					System.out.print("-");
				}
				y++;
				
			}
			x++;y=0;
			System.out.println();
		}
	
	}
	public static char PregDesp() {
		char x=0;boolean cont=false;
		while(cont==false) {
			try {
				mss("Indique con una f para desplazar las filas, o con una c las columnas: ");
				x=reader.next().charAt(0);
				if(x!='f'&&x!='F'&&x!='c'&&x!='C') {
					mss("Valor no válido.");
					mss(" ");
				}
				else cont=true;
			}
			catch(Exception e) {
				mss("Error. Valor no válido.");
				mss(" ");
			}
		}
		return x;
	}
	public static int PregNum(char a) {
		int num=0;boolean cont=false;
		while(cont==false) {
			try {
				if(a=='c'||a=='C') {
					mss("Indique la columna que desea desplazar: ");
					num=reader.nextInt();
					if(num<MAX||num>0) {
						cont=true;
						num--;
					}
					else {mss("Dato erroneo.");
						mss(" ");
					}
				}
				else {
					mss("Indique la fila que desea desplazar: ");
					num=reader.nextInt();
					if(num<MAX||num>0) {
						cont=true;
						num--;
					}
					else {mss("Dato erroneo.");
						mss(" ");
					}
				}
				cont=true;
			}
			catch(Exception e) {
				mss("Dato erroneo.");
				mss(" ");
			}
		}
		return num;
	}
	public static int PregSent(char a) {
		int num=0;boolean cont=false;
		while(cont==false) {
			try {
				if(a=='c'||a=='C') {
					mss("Indique con un 1 para bajar o con un -1 para subir la columna: ");
					num=reader.nextInt();
					if(num!=1 && num!=-1) {
						mss("Dato erroneo.");
						mss(" ");
					}
					else {
						cont=true;
					}
				}
				else {
					mss("Indique con un 1 para mover la columna a la derecha o con un -1 para la izquierda: ");
					num=reader.nextInt();
					if(num!=1 && num!=-1) {
						mss("Dato erroneo.");
						mss(" ");
					}
					else {
						cont=true;
					}
				}
			}
			catch(Exception e) {
				mss("Dato erroneo.");
				mss(" ");
			}
		}
		return num;
		
	}
	public static char[][] aplicarDesp(char[][]mat, char d, int y, int num){
		char aux;
		if(d=='c'||d=='C') {
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
		}
		else {
			if(num==-1) {
				aux=mat[y][0];
				mat[y][0]=mat[y][1];
				mat[y][1]=mat[y][2];
				mat[y][2]=aux;
			}
			else {
				aux=mat[y][1];
				mat[y][1]=mat[y][0];
				mat[y][0]=mat[y][2];
				mat[y][2]=aux;		
			}
		}
		return mat;
	}
	public static boolean MatOk (char[][]mat){
		int x,y,j=0;
		boolean trying=false;
		x=0;y=0;
		trying=true;
		while(x<MAX&&trying!=false) {
			while(y<MAX&&trying!=false&&j<MAX) {
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
		return trying;
	}
	public static char PedirRes() {
		char a=0; boolean cont=false;
		while(cont==false) {
			try {
				a=reader.next().charAt(0);
				cont=true;
			}
			catch(Exception e) {
				mss("Valor no válido.");
				mss(" ");
			}
		}
		return a;
	}
}
