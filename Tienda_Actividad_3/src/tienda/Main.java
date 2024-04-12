package tienda;

import java.util.Scanner;


public class Main {
    
    public static Scanner entry = new Scanner(System.in);
    public static Producto[] productos = new Producto[15];
    public static int cantidadProductos = 0;
            

    public static void menu()throws Exception{
        int opcion = 0;
        
        while(opcion != 4){            
            System.out.println("1- Vender");
            System.out.println("2- Abastecer");
            System.out.println("3- Calcular Estadisticas");
            System.out.println("4- Salir");
            opcion = Metodo.leerOpcion(1, 4);
            try{
                switch(opcion){
                    case 1: Metodo.vender();break;
                    case 2: Metodo.abastecer();break;
                    case 3: Metodo.calcularEstadisticas();break;
                    default: break;
                }
            }
            catch(Exception e){                
                System.out.println(e.getMessage());
            }
        }
        
    }
    
    public static void main(String[] args) throws Exception {        
        menu();               
    }
    
    
}
