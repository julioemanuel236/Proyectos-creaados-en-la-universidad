package modelo;
import java.util.ArrayList;
import java.util.Arrays;

public class Torneo {

    private String nombre;
    private boolean iniciado = false;
    private ArrayList<Jugador> jugadores = new ArrayList<>();

    private Partido[][] partidos;
    public Torneo(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public int getCantidadParticipantes(){
        return jugadores.size();
    }

    public void agregarJugador(Jugador j){
        jugadores.add(j);
    }

    public boolean crearPartidos(){
        int n = jugadores.size();
        int size = (int)(Math.log(n) / Math.log(2));
        //System.err.println("NIVELES: "+size);
        int p = 2;
        while(p<jugadores.size()){
            p*=2;
        }
        if(p != jugadores.size()){
           // System.err.println(p+"/"+jugadores.size());
            return false;
        }
        //System.err.println(p+"/"+jugadores.size());
        partidos = new Partido[size][];
        n/=2;
        int i=0;
        while(n>0){
            //System.err.println("NIVEL: "+i+" TAMAÑO: "+n);
            partidos[i] = new Partido[n];
            n/=2;
            i++;
        }
        int id=1;
        for(int j=0;j<partidos[0].length;j++){
            partidos[0][j] = new Partido(jugadores.get(j*2),jugadores.get((j*2)+1),id);
            id++;
        }
        for(int j=1;j<partidos.length;j++){
            for(int k=0;k<partidos[j].length;k++){
                partidos[j][k] = new Partido(id);
                id++;
            }
        }
        /*for(int j=partidos.length-1;j>=0;j--){
            for(int k=0;k<partidos[j].length;k++){
                System.err.print(partidos[j][k].getId());
            }
            System.err.println();
        }*/
        iniciado = true;
        return true;
    }

    public boolean isRunning(){
        return iniciado;
    }

    public Partido[][] getPartidos(){
        return partidos;
    }


}
