package Torneo_PKG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CompetenciaPersistencia implements Serializable{

    private Competencia compe;

    /*
     * Constructor recibe Competencia y lo inicializa
     */
    public CompetenciaPersistencia(Competencia compe){
        this.compe = compe;
    }


    /*
     * Metodo escribir
     * Recibe Competencia y la escribe en .bin
     */
    public void escribir(Competencia compe){
        ObjectOutputStream oos = null;

        try{
            oos = new ObjectOutputStream(new FileOutputStream("Competencia.bin"));
            oos.writeObject(compe);
        } catch (IOException ioe) { //Exception
            System.out.println("Error de entrada o salida: " + ioe);
        }

        //Cierra el archivo despues de su escritura
        finally{
            if(oos != null){
                try{
                    oos.close();
                } catch (IOException ioe){ //Exception
                    System.out.println("Error al cerrar: " + ioe);
                }
            }
        }

        //Verificacion de que se termino la escritura con exito
        System.out.println("Escritura Terminada");
    }


    /*
     * Metodo escribir
     * Busca el archivo .bin y lo almacena como un objeto Competencia
     */
    public Competencia leer(){
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("Competencia.bin"));
            compe = (Competencia) ois.readObject();
        } catch (IOException ioe) { //Exception
            System.out.println("Error de entrada o salida: " + ioe);
        } catch (ClassNotFoundException cnfe) { //Exception
            System.out.println("Error al encontrar clase: " + cnfe);
        } 

        //Cierra el archivo despues de su lectura
        finally{
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException ioe){ //Exception
                    System.out.println("Se presentó un error: " + ioe);
                }
            }
        }

        //Verificacion de que se termino la lectura con exito
        System.out.println("Lectura Terminada\n");
        return compe;
    }
}
