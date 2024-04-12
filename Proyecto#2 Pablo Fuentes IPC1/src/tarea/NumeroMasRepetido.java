package tarea;

import java.util.Scanner;

public class NumeroMasRepetido {

    int[] numeros;
    int[] repeticiones;

    NumeroMasRepetido(int cantidad){
        numeros = new int[cantidad];
        repeticiones = new int[cantidad];
        for(int i=0;i<cantidad;i++)
            repeticiones[i]=-1;
    }

    public void agregarNumero(int num) {
        for(int i=0;i<numeros.length;i++) {			
            if(repeticiones[i]==-1) {
                numeros[i]=num;
                repeticiones[i]=1;
                return;
            }
            if(numeros[i]==num) {
                repeticiones[i]++;
                return;
            }
        }
    }

    public void numeroMasRepetido() {
        int index=0,rep=repeticiones[0];
        for(int i=1;i<repeticiones.length;i++) {
            if(repeticiones[i]>rep) {
                rep=repeticiones[i];
                index=i;
            }
        }
        System.out.println("El numero que mas se reptie es el "+numeros[index]+" que se encuentra en la posicion " + index + "y se repite "+repeticiones[index]+" veces.");
    }
    
    public int[] getNumeros(){
        return numeros;
    }

    public static void main(String[] args) {
        NumeroMasRepetido comprobante = new NumeroMasRepetido(15);
        Scanner entry = new Scanner(System.in);
         System.out.println("Introduzca los 15 numeros");
        for(int i=0;i<15;i++) {          
            int num = entry.nextInt();
            comprobante.agregarNumero(num);
        }
        System.out.print("Contenido: "); 
        for(int i=0;i<15;i++)
            System.out.print(comprobante.getNumeros()[i]+"\t");
        System.out.println("");
        System.out.print("Indice: ");         
        for(int i=0;i<15;i++)
           System.out.print((i+1)+"\t"); 
        
        System.out.println("");
        comprobante.numeroMasRepetido();
    }
}
