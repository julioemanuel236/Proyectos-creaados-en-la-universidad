package control;
import entidad.Puntaje;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;

public class ControlPuntaje {
    
    private int nuevo = 0;
    
    private Puntaje[] puntajes = new Puntaje[10];
    
    private final String RUTA_PUNTAJE = "PUNTAJE.txt";
    public ControlPuntaje(){
        cargar();
    }
    public void agregar(Puntaje puntajeNuevo){
        /*
            para agregar un puntaje nuevo lo que hacemos es
            tener el puntaje que queremos agregar
            e ir recorriendo el arreglo
            cada que haya un puntaje menor que lo guardado en
            puntajeNuevo lo intercambiamos
        
            al terminar si no llenamos el arreglo completo
            agregamos el puntaje que quedo en la posicion 
            correspondiente
        */
        for(int i=0;i<nuevo;i++){
            if(puntajes[i].getPuntaje()<puntajeNuevo.getPuntaje()){
                //intercambiar nombres
                String temp = puntajeNuevo.getNombre();
                puntajeNuevo.setNombre(puntajes[i].getNombre());
                puntajes[i].setNombre(temp);
                
                //intercambiar puntos
                int tempP = puntajeNuevo.getPuntaje();
                puntajeNuevo.setPuntaje(puntajes[i].getPuntaje());
                puntajes[i].setPuntaje(tempP);
            }
        }
        if(nuevo<10)puntajes[nuevo++] = puntajeNuevo;        
        //guardar
        guardar();
    }
    
    
    
    private void cargar(){
        /*
            para cargar se abre un el fichero en la ruta_puntaje
            cargamos un sacanner de ese fichero
            y leemos linea por linea
            la primera linea es cuantos datos tenemos
            luego de eso viene el nombre y el puntaje en lineas separadas
        */
        try{
            FileReader file = new FileReader(RUTA_PUNTAJE);
            Scanner entry = new Scanner(file);
            
            nuevo = Integer.parseInt(entry.nextLine());
            for(int i=0 ; i< nuevo;i++){
                String nombre = entry.nextLine();
                int puntaje = Integer.parseInt(entry.nextLine());
                Puntaje p = new Puntaje(nombre,puntaje);
                puntajes[i] = p;
            }
            entry.close();
            file.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void guardar(){
        /*
            para guardar se abre un fichero en modo escritura
            en la ruta puntaje
            se escribe la variable nuevo que representa la cantidad
            de puntajes, luego se va puntaje por puntaje escribiendo
            en una linea el nombre, y en otra la puntuacion
        */
        try{
            FileWriter file = new FileWriter(RUTA_PUNTAJE);
            file.write(nuevo+"\n");
            for(int i=0;i<nuevo;i++){
                Puntaje p = puntajes[i];
                file.write(p.getNombre()+"\n"+p.getPuntaje()+"\n");
            }
            file.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Puntaje[] getPuntajes() {
        return puntajes;
    }
    
    
}
