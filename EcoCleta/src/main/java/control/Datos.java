package control;
import java.util.ArrayList;
import entidades.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Datos {
    ArrayList<Transporte> vehiculos;
    ArrayList<Factura> facturas;
    
    private final String RUTA_TRANSPORTE = "Transporte.txt";
    private final String RUTA_ALQUIER = "Alquier.txt";
    public static final String SEPARADOR = "#";
    
    public Datos(){
        this.vehiculos = new ArrayList<>();
        this.cargarDatos();
    }
    
    public boolean cargarDatos(){
        try{
            cargarTransporte();
            cargarAlquiler();
            return true;
        }
        catch(NullPointerException e){
            System.err.println("NO SE ENCONTRO EL ARCHIVO Transporte.txt, se creara uno nuevo");                    
            return true;
        }
        catch(Exception e){
            System.err.print("ERROR AL LEER LOS DATOS, POSIBLE CORRUCCION DE DATOS");
            System.err.print("MENSAJE: "+e.getMessage());
            return false;
        }
        
    }
    
    private void cargarTransporte() throws Exception{
        this.vehiculos.clear();
        FileReader fr = new FileReader(RUTA_TRANSPORTE);
        Scanner entry = new Scanner(fr);
        
        while(entry.hasNext()){
            String line = entry.nextLine();
            String[] data = line.split(SEPARADOR);
            Transporte transporte = null;
            String clase = data[0];
            
            if(clase == Bicicleta.class.getSimpleName()){
                
                String codigo = data[1];
                if(!Transporte.codigoValido(codigo))throw new Exception("CODIGO INVALIDO");
                String tipo = data[2];                
                int cantidadCambios = entero(data[3]);
                transporte = new Bicicleta(codigo,tipo,cantidadCambios);                
                
            }
            else if(clase  == Scooter.class.getSimpleName()){
                
                String codigo = data[1];
                if(!Transporte.codigoValido(codigo))throw new Exception("CODIGO INVALIDO");
                String tipo = data[2];                
                String color = data[3];
                transporte = new Scooter(codigo,tipo,color);                
                
            }
            else if(clase == Patinete.class.getSimpleName()){
                
                String codigo = data[1];
                if(!Transporte.codigoValido(codigo))throw new Exception("CODIGO INVALIDO");
                String tipo = data[2];                
                int cantidadRuedas = entero(data[3]);
                transporte = new Patinete(codigo,tipo,cantidadRuedas);                
                
            }
            
            vehiculos.add(transporte);
        }
        
    }
    
    private void cargarAlquiler() throws Exception{
        
    }
    
    public int entero(String s){
        return Integer.parseInt(s);
    }
}
