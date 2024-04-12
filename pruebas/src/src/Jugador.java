import java.util.LinkedList;

public class Jugador {
    private String nombre;
    private int oro;
    //Inventario de objetos del jugador
    private LinkedList<Objetos> objetos;
    private LinkedList<Jugable> personajes;

    public Jugador(String nombre, int oro, LinkedList<Jugable> personajes) {
        this.nombre = nombre;
        this.oro = oro;
        this.personajes = personajes;
        objetos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getOro() {
        return oro;
    }

    public LinkedList<Objetos> getObjetos() {
        return objetos;
    }

    public LinkedList<Jugable> getPersonajes() {
        return personajes;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public void añadirPersonaje(Jugable personaje){
        personajes.add(personaje);
    }

    public void añadirObjeto(Objetos objeto){
        objetos.add(objeto);
    }

    public void mostrarInventario(){
        System.out.println("Objetos:");
        for(Objetos objeto: objetos){
            System.out.println(objeto.getNombre() + " $" + objeto.getPrecio());
        }
        System.out.println("Personajes:");
        for(Jugable personaje: personajes){
            System.out.println(personaje.getNombre() + " Vida: " + personaje.getVida() + "/" + personaje.getVidaMaxima());
        }
    }
}