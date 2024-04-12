package control;
import java.util.ArrayList;
import entidades.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Datos {
    /*
        Esta clase maneja la información
        las listas de transportes y facturas están aqui
        presenta metodos para guardar y cargar la información en el disco duro
    */
    
    //Listas de datos
    private ArrayList<Transporte> transportes;
    private ArrayList<Factura> facturas;
    
    //Rutas de los ficheros y regex separador de datos
    private final String RUTA_TRANSPORTE = "Transporte.txt";
    private final String RUTA_ALQUIER = "Alquiler.txt";
    public static final String SEPARADOR = "#";
    
    public Datos(){
        //Inicializar los arreglos y cargar los datos
        this.transportes = new ArrayList<>();
        this.facturas = new ArrayList<>();
        this.cargarDatos();
    }
    
    public boolean cargarDatos(){
        try{
            cargarTransporte();                        
        }
        catch(java.io.FileNotFoundException e){
            System.err.println(e.getMessage());                    
            System.err.println("se creara uno nuevo archivo");                    
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR AL LEER LOS DATOS DE TRANSPORTE\nPOSIBLE CORRUCCION DE DATOS");
            System.err.println("MENSAJE: "+e.getMessage());
            return false;
        }
        try{
            cargarAlquiler();                        
        }
        catch(java.io.FileNotFoundException e){
            System.err.println(e.getMessage());                    
            System.err.println("se creara uno nuevo archivo");                    
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR AL LEER LOS DATOS DE ALQUILER\nPOSIBLE CORRUCCION DE DATOS");
            System.err.println("MENSAJE: "+e.getMessage());
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    private void cargarTransporte() throws Exception{
        //limpiar la lista de transportes solo en caso de que la carga se haga
        //una segunda vez luego de iniciada la aplicacion
        this.transportes.clear();
        //Abrir el fichero y el scanner para leer los datos
        FileReader fr = new FileReader(RUTA_TRANSPORTE);
        Scanner entry = new Scanner(fr);
        //mientras que hayan lineas por leer
        while(entry.hasNext()){
            //leer una linea
            String line = entry.nextLine();
            //separarla en los diferentes datos por el regex predefinido
            String[] data = line.split(SEPARADOR);
            //crear el transporte que vamos a agregar
            Transporte transporte = null;
            //en el formato que definimos lo primero que tenemos el que transporte es
            String clase = data[0];
            String codigo = data[1];
            String tipo = data[2];                
            if(!Transporte.codigoValido(codigo))throw new Exception("CODIGO INVALIDO");                
            //segun el tipo que sea leemos los datos correspondientes
            
            if(clase.equals( Bicicleta.class.getSimpleName() ) ){
                                                
                int cantidadCambios = entero(data[3]);
                transporte = new Bicicleta(codigo,tipo,cantidadCambios);                
                
            }
            else if(clase.equals( Scooter.class.getSimpleName() ) ){
                                
                String color = data[3];
                transporte = new Scooter(codigo,tipo,color);                
                
            }
            else if(clase.equals( Patinete.class.getSimpleName() ) ){
                
                int cantidadRuedas = entero(data[3]);
                transporte = new Patinete(codigo,tipo,cantidadRuedas);                
                
            }
            //agregamos el transporte a la lista
            transportes.add(transporte);
        }
        
        //cerramos el fichero y el scanner
        entry.close();
        fr.close();
        
    }

    private void cargarAlquiler() throws Exception{
        //limpiar la lista de facturas en caso de una segunda carga
        //luego de iniciada la aplicacion
        this.facturas.clear();
        
        //abrimos el fichero de datos y el scanner
        FileReader fr = new FileReader(RUTA_ALQUIER);
        Scanner entry = new Scanner(fr);
        
        //mientras que hayan lineas
        while(entry.hasNext()){
            
           //leemos una linea
            String line = entry.nextLine();
            //dividirla en los datos por el regex predefinido
            String[] data = line.split(SEPARADOR);
            //asignar valores siguiendo el orden predefinido en la clase factura
            String idFactura = data[0];
            String codigoTransporte = data[1];
            String categoria = data[2];
            String nombreCliente = data[3];
            String idCliente = data[4];
            String direccionCliente = data[5];
            int edadCliente = entero(data[6]);
            Cliente cliente = new Cliente(nombreCliente,idCliente,direccionCliente,edadCliente);
            int distancia = entero(data[7]);
            float monto = flotante(data[8]);
            long time = largo(data[9]);
            
            //crear la factura y agregarla a la lista
            Factura f = new Factura(idFactura,codigoTransporte,categoria,cliente,distancia,monto,time);
            facturas.add(f);
            
        } 
        
        //cerrar la entrada
        entry.close();
        fr.close();
    }

    public boolean guardarDatos(){
        try{
            guardarTransporte();
            guardarAlquiler();
            return true;
        }
        catch(java.io.FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR\nFICHEROS DE DATOS NO CREADOS");                    
            System.err.println(e.getMessage());                    
            return true;
        }
        catch(Exception e){
            System.err.print("ERROR AL ESCRIBIR LOS DATOS");
            System.err.print("MENSAJE: "+e.getMessage());
            return false;
        }
    }

    private void guardarTransporte() throws Exception{
        //Abrir fichero de datos
        FileWriter fw = new FileWriter(RUTA_TRANSPORTE);
        //recorrer la lista de transportes
        for(Transporte i: transportes){
            if(i == null)continue;
            //escribir la informacion del transporte
            fw.write(i.getInfo()+"\n");
        }
        //cerrar el fichero para guardar la informacion
        fw.close();
    }

    private void guardarAlquiler() throws Exception{
        //abrir el fichero con los datos de las facturas
        FileWriter fw = new FileWriter(RUTA_ALQUIER);
        //recorrer las facturas
        for(Factura i: facturas){
            if(i == null)continue;
            //escribir la informacion
            fw.write(i.getInfo()+"\n");
        }
        //cerrar el fichero para guardar la informacion
        fw.close();
    }    

    public long largo(String s){
        //convertir cadena a long
        return Long.parseLong(s);
    }
    
    public float flotante(String s){
        //convertir cadena a float
        return Float.parseFloat(s);
    }

    public int entero(String s){
        //convertir cadena a int
        return Integer.parseInt(s);
    }
    
    public int agregarTransporte(Transporte t){
        //verificar que el transporte tenga un codigo valido
        //y que no exista otro con el mismo codigo
        //return 1 en caso de que eso pase para identificar
        //a que se debe el error
        if(!nuevoCodigoValido(t.getCodigo(), t))return 1;
        
        //si todo bien agregarlo a la lista y guardar
        this.transportes.add(t);
        try {
            guardarTransporte();            
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
        //retornar 0 si todo fue bien
        return 0;
    }
    
    public void agregarFactura(Factura f){
        //agregar a la lista de facturas y guardar
        this.facturas.add(f);
        try {
            guardarAlquiler();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminarTransporte(String id){
        //buscar en la lista de transportes 
        //uno que tenga el mismo id
        //y borrarlo de la lista
        //guardar en dicho caso y terminar la funcion
        for(int i=0;i<transportes.size();i++){
            Transporte t = transportes.get(i);
            if(t.getCodigo().equals(id)){
                transportes.remove(i);
                try{
                    guardarTransporte();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                return;
            }
        }
            
    }
    
    public void eliminarTransporte(int[] filas){
        //recibiendo una lista de posiciones a eliminar
        //las cuales estan ordenadas de manera creciente
        //ir desde la ultima hasta la primera eliminando
        //se hace de esta forma y no normal para no afectar los 
        //indices que se analizaran luego
        for(int i = transportes.size()-1, j = filas.length-1; i >= 0 && j >= 0; i--){
            if(filas[j] == i){
                j--;
                transportes.remove(i);                        
            }
        }
        //guardar al terminar
        guardarDatos();
    }
    
    public boolean editarTransporte(Transporte t,Object[] data){
        //recibir el tranporte a editar
        //y los datos que se pondran
        //se recibien todos los datos
        //los que no hayan cambiado 
        //tambien se reciben como lo que eran
        
        //codigo nuevo y tipo de vehiculo que es
        String codigo = (String)data[0];       
        String tipo = (String)data[1];
        
        //revisar si el codigo nuevo se puede asignar
        if(!nuevoCodigoValido(codigo,t))return false;
        
        //en caso de que el codigo sea diferente
        //modificar el codigo de transporte de las 
        //facturas asociadas al codigo anterior
        if(!codigo.equals(t.getCodigo())){
            for(int i=0;i<this.facturas.size();i++){
                Factura factura = facturas.get(i);
                if(factura.getCodigoTransporte().equals(t.getCodigo()))
                    factura.setCodigoTransporte(codigo);
            }
        }
        
        //modificar los valores
        t.setCodigo(codigo);
        t.setTipo(tipo);
        
        if(t.getClass() == Bicicleta.class){
            ((Bicicleta)t).setCantidadCambios((Integer)data[2]);
        }
        else if(t.getClass() == Scooter.class){
            ((Scooter)t).setColor((String)data[2]);
        }
        else if(t.getClass() == Patinete.class){
            ((Patinete)t).setCantidadRuedas((Integer)data[2]);
        }                
        
        //guardar
        try {
            guardarDatos();
        } 
        catch (Exception ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean nuevoCodigoValido(String codigo,Transporte t){
        //para revisar la validez de un codigo
        //se usa el verificador de la clase transporte
        //si este falla se retorna falose
        if(!Transporte.codigoValido(codigo))return false;
        
        //luego se revisa en los transportes existentes
        //si alguno tiene el mismo codigo se retorna falso
        for(int i=0;i<transportes.size();i++)
            //obviamos por supuesto el transporte
            //el cual estamos revisando
            if(transportes.get(i) == t)continue;
            else if(transportes.get(i).getCodigo().equals(codigo))return false;
        
        //si no hay problema retornamos verdadero
        return true;
    }
    
    public Transporte getTransporte(String codigo){
        //retorna un transporte con el codigo
        //pasado por parametror
        //en caso de no existir retorna null
        for(int i=0;i<transportes.size();i++){
            Transporte t = transportes.get(i);
            if(t.getCodigo().equals(codigo))return t;
        }
            
        return null;
    }
    
    public ArrayList<Transporte> getTransporte(){
        //obtener la lista de transporte
        return this.transportes;
    }
    
    public ArrayList<Factura> getFacturas(){
        //obtener la lista de facturas
        return this.facturas;
    }
}
