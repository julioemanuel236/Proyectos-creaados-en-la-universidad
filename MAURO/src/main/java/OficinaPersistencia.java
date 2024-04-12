import java.io.*;

public class OficinaPersistencia {
    private Oficina oficina;
    public OficinaPersistencia(Oficina oficina){
        this.oficina = oficina;
    }
    public String Leer(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("ListaUsuario.bin"));
            oficina = (Oficina) (ois.readObject());
        }catch (ClassNotFoundException cnfe){
            System.out.println("Error al encontrar la clase");
        }catch (IOException ioe){
            System.out.println("Error de entrada y salida");
        }
        if (ois != null)
            try {
                ois.close();
            }catch (IOException ioe){
                System.out.println("Error al cerrar el archivo");
            }
        return ""+oficina;
    }
    public void Escribir(Oficina oficina) {
        ObjectOutputStream ois = null;
        try {
            ois = new ObjectOutputStream(new FileOutputStream("Oficina.bin"));
            ois.writeObject(oficina);
        } catch (IOException ioe) {
            System.out.println("Error de entrada y salida "+ioe);
        }
        if (ois != null)
            try {
                ois.close();
            }catch (IOException ioe){
                System.out.println("Error al cerrar el archivo "+ioe);
            }
    }
}