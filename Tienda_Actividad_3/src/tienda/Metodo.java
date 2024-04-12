package tienda;

import excepciones.AlmacenLlenoException;
import excepciones.CantidadNoValidaException;
import excepciones.NoCantidadSuficienteException;
import excepciones.ProductoNoExistenteException;
import excepciones.SeleccionFueraDeRangoExcepction;
import static tienda.Main.cantidadProductos;
import static tienda.Main.entry;
import static tienda.Main.productos;

public class Metodo {

    public static int leerOpcion(int a,int b)throws SeleccionFueraDeRangoExcepction{
        String line = entry.nextLine();
        int opcion = Integer.parseInt(line);
        
        if(opcion<a || opcion>b)throw new SeleccionFueraDeRangoExcepction(opcion,a,b);
        return opcion;
        
    }
    
    public static void vender()throws ProductoNoExistenteException, CantidadNoValidaException,NoCantidadSuficienteException{
        if(cantidadProductos == 0){
            System.out.println("No hay productos para vender");
        }
        else{
            String nombre;
            System.out.print("Nombre del producto a vender: ");
            nombre = entry.nextLine();
            boolean existe = false;
            int index = 0;
            
            for(int i=0;i<cantidadProductos;i++){
                if(productos[i].getNombre().equalsIgnoreCase(nombre)){
                   existe = true;
                   index = i;
                   break;
                }
            }
            
            if(existe){
                System.out.print("Cuanto desea vender: ");
                int cantidad = Integer.parseInt(entry.nextLine());
                if(cantidad <= 0)throw new CantidadNoValidaException(cantidad);
                productos[index].vender(cantidad);
            }
            
            else throw new ProductoNoExistenteException(nombre);
        }
    }
    
    public static void abastecer()throws SeleccionFueraDeRangoExcepction,CantidadNoValidaException,AlmacenLlenoException{
        String nombre;
        String tipo = "";
        
        int cantidad;
        int cantidadMinima;
        double precioBase;
        
        System.out.print("Nombre del producto: ");
        nombre = entry.nextLine();
        
        System.out.print("Cantidad: ");
        cantidad = Integer.parseInt(entry.nextLine());
        if(cantidad<=0)throw new CantidadNoValidaException(cantidad);
        
        int index = 0;
        boolean existe = false;
        
        for(int i=0;i<cantidadProductos;i++){
            if(productos[i].getNombre().equalsIgnoreCase(nombre)){
                existe = true;
                index = i;
                break;
            }
        }
        if(existe){
            productos[index].abastecer(cantidad);
            System.out.println("Se ha abastecido el producto "+nombre+" con "+cantidad+" unidades");
            return;
        }
        
        if(cantidadProductos == productos.length)throw new AlmacenLlenoException();
            
        
        
        System.out.println("TIPOS DISPONIBLES:");
        System.out.println("1- Papeleria:");
        System.out.println("2- Medicamento:");
        System.out.println("3- Supermercado:");
        int seleccion = leerOpcion(1, 3);
        switch(seleccion){
            case 1: tipo = "Papeleria";break;
            case 2: tipo = "Medicamento";break;
            case 3: tipo = "Supermercado";break;
            default: break;
        }                
        
        System.out.print("Cantidad Minima: ");
        cantidadMinima = Integer.parseInt(entry.nextLine());
        if(cantidadMinima<0)throw new CantidadNoValidaException(cantidadMinima);
        
        System.out.print("Precio Base: ");
        precioBase = Integer.parseInt(entry.nextLine());
        if(precioBase<=0)throw new CantidadNoValidaException(precioBase);
        
        Producto p = null;
        
        switch(tipo){
            case "Papeleria":p = new Papeleria(nombre, cantidad, cantidadMinima, precioBase); break;
            case "Medicamento":p = new Medicamento(nombre, cantidad, cantidadMinima, precioBase);break;
            case "Supermercado":p = new Supermercado(nombre, cantidad, cantidadMinima, precioBase); break;
        }
        
        productos[cantidadProductos++] = p;
        System.out.println("Se ha abastecido la tienda de un nuevo producto");
        System.out.println(nombre+" con "+cantidad+" unidades");
    }
    
    public static String centrarTexto(String texto, int ancho) {
        int espaciosIzquierda = (ancho - texto.length()) / 2;
        int espaciosDerecha = ancho - texto.length() - espaciosIzquierda;

        String espaciosIzq = String.format("%" + espaciosIzquierda + "s", "");
        String espaciosDer = String.format("%" + espaciosDerecha + "s", "");
        return espaciosIzq + texto + espaciosDer;
    }
        
    public static void calcularEstadisticas(){
        String[] encabezado = {"Producto","Tipo","Cantidad Actual","Cantidad Minima","Precio Base","Precio Final","Venta Acumulada"};
        int[]    espacios =   {20,         15,        20,               20,              15,           15,             20};
        
        String linea = "";
        linea+="|";
        for(int i=0;i<encabezado.length;i++){
            
            linea+=centrarTexto(encabezado[i], espacios[i]);
            linea+="|";
        }
        System.out.println(linea);
        for(int i=0;i<linea.length();i++)
            System.out.print("-");
        System.out.println();
        linea = "";
        
        String nombreMasVendido = "";
        String nombreMenosVendido = "";
        int mayorVentas = -1;
        int menorVentas = -1;
        double ventasTotal = 0;
        int cantidadVentas = 0;
        for(int i=0;i<cantidadProductos;i++){
            Producto p = productos[i];
            
            ventasTotal += p.calcularPrecio()*p.getCantidadVendida();
            cantidadVentas += p.getCantidadVendida();
            
            if(mayorVentas == -1){
                mayorVentas = p.getCantidadVendida();
                nombreMasVendido = p.getNombre();
            }
            else if(p.getCantidad()>mayorVentas){
                mayorVentas = p.getCantidadVendida();
                nombreMasVendido = p.getNombre();
            }
            if(menorVentas == -1){
                menorVentas = p.getCantidadVendida();
                nombreMenosVendido = p.getNombre();
            }
            else if(p.getCantidadVendida()<menorVentas){
                menorVentas = p.getCantidadVendida();
                nombreMenosVendido = p.getNombre();
            }
            
            linea+="|";
            linea+=centrarTexto(p.getNombre(), espacios[0]);
            linea+="|";
            linea+=centrarTexto(p.getTipo(), espacios[1]);
            linea+="|";
            linea+=centrarTexto(p.getCantidad()+"", espacios[2]);
            linea+="|";
            linea+=centrarTexto(p.getCantidadMinima()+"", espacios[3]);
            linea+="|";
            linea+=centrarTexto(p.getPrecioBase()+"", espacios[4]);
            linea+="|";
            linea+=centrarTexto(p.calcularPrecio()+"", espacios[5]);
            linea+="|";
            linea+=centrarTexto(p.getCantidadVendida()+"", espacios[6]);
            linea+="|";
            System.out.println(linea);
            for(int j=0;j<linea.length();j++)
                System.out.print("-");    
            System.out.println();
            linea = "";
        }
        
        if(cantidadVentas == 0){
            System.out.println("No se han realizado ventas");
            return;
        }
        System.out.println("Mas Vendido: "+ nombreMasVendido + " con "+mayorVentas);
        System.out.println("Menos Vendido: "+ nombreMenosVendido + " con "+menorVentas);
        System.out.println("Ventas Totales: "+ventasTotal + " en "+cantidadVentas + " productos");
        System.out.println("Promedio de ventas: "+(double)ventasTotal/cantidadVentas + " por producto");
    }
    
}
