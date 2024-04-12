package actividad.pkg3;
import java.util.Scanner;
import excepciones.*;

public class Main {
    
    private static Scanner entry = new Scanner(System.in);
    
    public static int leerOpcion(int a,int b)throws SeleccionFueraDeRangoExcepction{
        String line = entry.nextLine();
        int opcion = Integer.parseInt(line);
        
        if(opcion<a || opcion>b)throw new SeleccionFueraDeRangoExcepction(opcion,a,b);
        return opcion;
        
    }
    
    public static void mostrarCampannasActivas(){
        System.out.println("___________________________________________________________________");
        System.out.println("| Artículos vendido | Descuento | Monto total de pedido| Descuento|");
        System.out.println("|___________________|___________|______________________|__________|");
        System.out.println("|      1 a 99       |     1%    |       1 a 10000      |     1%   |");
        System.out.println("|___________________|___________|______________________|__________|");
        System.out.println("|    100 a 999      |     5%    |        >10000        |     3%   |");
        System.out.println("|___________________|___________|______________________|__________|");
        System.out.println("|       >1000       |    10%    |                      |          |");
        System.out.println("|___________________|___________|______________________|__________|");
        
        System.out.println("Presiona Enter para volver al menu");
        entry.nextLine();
    }
    
    
    private static void comprobarNombre(String nombre)throws NombreNoValidoException{
        for(int i=0;i<nombre.length();i++){
            char c = nombre.charAt(i);
            if(!Character.isAlphabetic(c) && c != ' '){
                throw new NombreNoValidoException(nombre);
            }
        }
    }
    
    public static boolean solicitarDescuento()throws Exception{
        System.out.print("Nombre del Cliente: ");
        String nombre = entry.nextLine();
        comprobarNombre(nombre);
        System.out.print("Cantidad de articulos: ");
        int cantidad = Integer.parseInt(entry.nextLine());
        if(cantidad<1)throw new CantidadNoValidaException(cantidad);
        System.out.print("Monto Total: ");
        int monto = Integer.parseInt(entry.nextLine());        
        if(monto<1)throw new CantidadNoValidaException(monto);
        
        int porcentajePago = 100;        
        int rebajaCantidad = 0;
        int rebajaMonto = 0;
        if(cantidad>0 && cantidad < 100)rebajaCantidad = 1;
        else if(cantidad>=100 && cantidad<1000)rebajaCantidad = 5;
        else rebajaCantidad = 10;
        
        if(monto>0 && monto <=10000)rebajaMonto = 1;
        else rebajaMonto = 3;
        
        porcentajePago-=(rebajaCantidad+rebajaMonto);
        mostrarLogo();
        
        System.out.println("El cliente: "+nombre);
        System.out.println("Adquirio la cantidad de "+cantidad+" articulos, obteniendo un "+rebajaCantidad+"% de descuento.");
        System.out.println("El monto total de su compra es de $"+monto+", obteniendo un "+rebajaMonto+"% de descuento.\n");
        System.out.println("Monto total original: $"+monto);
        System.out.println("Descuento total: %"+(rebajaCantidad+rebajaMonto));
        System.out.println("Monto total a pagar: $"+(monto*porcentajePago/100));
        System.out.println("\n");
        System.out.println("1 - Regresar al menu principal");
        System.out.println("2 - salir");
               
        if(leerOpcion(1, 2) == 1)return true;
        else return false;
               
    }
    
    public static void mostrarLogo(){
        System.out.println("                \"OFFICE FAST\"");
        System.out.println("        Sistema de Capannas Promocionales\n");
    }
    
    public static boolean menu()throws Exception{        
        mostrarLogo();
        System.out.println("Selecciona la opcion deseada\n");
        System.out.println("1 - Solicitar descuento");
        System.out.println("2 - Mostrar campannas activas");
        System.out.println("3 - Salir");
        
        int opcion = leerOpcion(1,3);
        
        switch(opcion){
            case 1:if(!solicitarDescuento())return false; break;
            case 2:mostrarCampannasActivas(); break;
            case 3:return false;
        }
        
        return true;
        
    }
    
    public static void main(String[] args) throws Exception {
        while(menu());                    
    }
    
}
