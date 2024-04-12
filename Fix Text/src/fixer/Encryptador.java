
package fixer;
import java.util.Scanner;
import java.util.TreeMap;
public class Encryptador {

	static 	final int mod = 29;
	static 	TreeMap<Character,Integer>tabla = new TreeMap<>();
	static 	char toC[] = new char[35];

	class matrix{
		int mat[][] = {{0,0},{0,0}};
		
		public matrix multiply(final matrix a) {
			matrix c = new matrix();
			for(int i=0;i<2;i++){
	            for(int j=0;j<2;j++){
	                for(int k=0;k<2;k++){
	                    c.mat[i][j] += (mat[i][k] * a.mat[k][j])%mod;
	                    c.mat[i][j] %= mod;
	                }
	            }
	        }
			return c;
		}			   

	    int calc_inverse_det(){
	        int mult = mat[0][0] * mat[1][1];
	        mult -= (mat[0][1] * mat[1][0]);
	        mult = (mult + mod) % mod;
	
	        int inv=0;
	        for(int i=0;i<mod;i++){
	            int c = (mult * i) % mod;
	            if(c == 1){
	                inv = i;
	                break;
	            }
	        }
	
	        return inv;
	    }
	
	    matrix inverse(){
	        matrix c = new matrix();
	        matrix adj = new matrix();

	        adj.mat[0][0] = mat[1][1];
	        adj.mat[1][1] = mat[0][0];
	        adj.mat[0][1] = (-mat[0][1] + mod)%mod;
	        adj.mat[1][0] = (-mat[1][0] + mod)%mod;

	        int inverse = calc_inverse_det();

	        for(int i=0;i<2;i++){
	            for(int j=0;j<2;j++){
	                c.mat[i][j] = (adj.mat[i][j] * inverse)%mod;
	            }
	        }
	        return c;
	    }

	    void imprime(){
	        System.out.println("Matrix :");
	        for(int i=0;i<2;i++){
	            for(int j=0;j<2;j++){
	                System.out.print(mat[i][j]+" ");
	            }
	        }
	        System.out.println();
	    }
	
		}
	
	public Encryptador(){

	    Build_Dictionary();
	    String s;
	    /// para cifrar
	    Scanner entry = new Scanner(System.in);
	    System.out.println("Frase a cifrar");
	    s = entry.nextLine().toUpperCase();

	    matrix clave = new matrix();
	    for(int i=0;i<2;i++){
	        for(int j=0;j<2;j++){
	        	System.out.println("Clave en ["+i+"]["+j+"]");
	            int x;
	            x = entry.nextInt();
	            clave.mat[i][j] = x;
	        }
	    }

	    String d = Cipher(s,clave);
	    System.out.println("el cifrado es :"+d.substring(0, s.length()));
	    																///SUBString PORQUE PUEDE DARSE EL CASO DE QUE SEA DE LONGITUD IMPAR Y LOS BLOQUES PARA CIFRAR SON DE LONGITUD 2
	    String cyphr = Decipher(d+" ",clave).substring(0,s.length());     /// ENTONCES AGREGAMOS UN CARACTER AL FINAL PARA PODER CIFRAR , Y DESPUES LA RESPUESTA SERIA DE LA LONGITUD INICIAL SOLAMENTE
	    
	    System.out.println("decifrado :"+cyphr);
	}
	
	String Cipher(String s,matrix clave){
	    int m = 2;
	    int n = s.length();

	    String ans="";
	    for(int i=0;i<n;i+=2){
	        int fn = (tabla.get(s.charAt(i))==null?0:tabla.get(s.charAt(i)));
	        int fn1 = 0;
	        if(i+1 < n){
	            fn1 = (tabla.get(s.charAt(i+1))==null?0:tabla.get(s.charAt(i+1)));
	        }
	        matrix Vector = new matrix();
	        Vector.mat[0][0] = fn;
	        Vector.mat[1][0] = fn1;
	        matrix mult = clave.multiply(Vector);

	        ans += toC[(mult.mat[0][0])%mod];

	        ans += toC[(mult.mat[1][0])%mod];

	    }
	    return ans;
	}

	String Decipher(String s,matrix clave){
	    int m = 2;
	    int n = s.length();
	    String ans="";

	    int determinante = clave.calc_inverse_det();
	    if(determinante == 0) ///--> no existe una matrix inversa por lo que no se puede descifrar FAIL
	    {
	        return "FAIL";
	    }
	    matrix inv = clave.inverse();

	    for(int i=0;i<n;i+=2){
	        int fn = tabla.get(s.charAt(i));
	        int fn1 = 0;
	        if(i+1 < n){
	            fn1 = tabla.get(s.charAt(i+1));
	        }
	        matrix Vector = new matrix();
	        Vector.mat[0][0] = fn;
	        Vector.mat[1][0] = fn1;
	        matrix mult = inv.multiply(Vector);

	        ans += toC[(mult.mat[0][0])%mod];
	        if(i+1 < n){
	            ans += toC[(mult.mat[1][0])%mod];
	        }
	    }

	    return ans;
	}
	
	static void Build_Dictionary(){
	    int cur = 1;
	    for(int i='A';i<='N';i++){
	        tabla.put((char)i, cur);
	        toC[cur] = (char)(i);
	        cur++;
	    }

	    tabla.put('�',cur);
	    toC[cur] = '�';

	    cur++;

	    for(int i='O';i<='Z';i++){
	    	tabla.put((char)i, cur);
	        toC[cur] = (char)(i);
	        cur++;
	    }

	    tabla.put(' ',cur);
	    toC[cur] = ' ';
	    cur++;
	    cur %= mod;
	    tabla.put('*',cur);
	    toC[cur] = '*';
	}

	public static void main(String[] args){
		new Encryptador();
	    /*
	    ABCD
	    1 2
	    3 4

	    */

	}
}
