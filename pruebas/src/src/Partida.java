import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
    private Jugador jugador;
    private Jugable principal;
    private Jugable secundario;
    private Tablero tablero;
    private ArrayList<Enemigo> enemigos;
    private int turno;
    private int oro;
    private boolean terminado;

    private int actual=0;


    public Partida(Jugador jugador, Jugable principal, Jugable secundario, Tablero tablero, ArrayList<Enemigo> enemigos, int turno, int oro, boolean terminado) {
        this.jugador = jugador;
        this.principal = principal;
        this.secundario = secundario;
        this.tablero = tablero;
        this.enemigos = enemigos;
        this.turno = turno;
        this.oro = oro;
        this.terminado = terminado;
    }

    public void iniciarPartida(){
        tablero.mostrarTablero();
        System.out.println("Es tu turno "+jugador.getNombre());

        elegirPersonaje();
        elegirAccion();
    }

    //El jugador elige que personaje quiere usar
    //El jugador elige que personaje quiere usar
    private void elegirPersonaje(){
        boolean eleccionValida = false;
        Scanner scanner = new Scanner(System.in);
        while(!eleccionValida){
            System.out.println("Elige el personaje que quieres usar (1. "+principal.getNombre()+"  2. "+secundario.getNombre()+")");
            int eleccion = scanner.nextInt();
            if(eleccion == 1){
                eleccionValida = true;
                tablero.ubicarPeronajesEnElMapa(principal);
                tablero.mostrarTablero();
                actual=1;
            }else if(eleccion == 2){
                tablero.ubicarPeronajesEnElMapa(secundario);
                tablero.mostrarTablero();
                actual=2;

                eleccionValida = true;
            }else{
                System.out.println("Eleccion invalida");
            }
        }

    }

    private void elegirAccion(){
        boolean eleccionValida = false;
        Scanner scanner = new Scanner(System.in);
        while (!eleccionValida){
            System.out.println("Elige una accion (1. Atacar 2. Mover 3. Informacion 4. Salir)");
            int eleccion = scanner.nextInt();
            if(eleccion == 1){
                atacar();
            }else if(eleccion == 2){
                mover();
            }else if(eleccion == 3){
                mostrarInformacion();
                tablero.mostrarTablero();
                if (actual==1){
                    System.out.println("El personaje se encuentra en: "+(principal.getPosX()+1)+","+(principal.getPosY()+1));
                }
                if (actual==2){
                    System.out.println("El personaje se encuentra en: "+(secundario.getPosX()+1)+","+(secundario.getPosY()+1));
                }



            }else if(eleccion == 4){
                terminado = true;
            }else {
                System.out.println("Eleccion incorrecta");
            }
        }
    }

    public void atacar(){
        int[] posicionPrincipal = principal.getPosicion();
        int xPrincipal = posicionPrincipal[0];
        int yPrincipal = posicionPrincipal[1];
        boolean hayEnemigos = false;
        for (int i = 0; i < enemigos.size(); i++) {
            int[] posicionEnemigo = enemigos.get(i).getPosicion();
            int xEnemigo = posicionEnemigo[0];
            int yEnemigo = posicionEnemigo[1];
            if(xPrincipal==xEnemigo || yPrincipal==yEnemigo){
                hayEnemigos = true;
                System.out.println(enemigos.get(i));
            }
        }
        if(hayEnemigos){
            boolean eleccionValida = false;
            Scanner scanner = new Scanner(System.in);
            while(!eleccionValida){
                System.out.println("Elige el enemigo que quieres atacar");
                int eleccion = scanner.nextInt();
                if(eleccion>0 && eleccion<=enemigos.size()){
                    tablero.atacar(principal,enemigos.get(eleccion-1));
                    turno++;
                    eleccionValida = true;
                }else{
                    System.out.println("Eleccion invalida");
                }
            }

        }else{
            System.out.println("No hay enemigos al alcance");
        }
    }

    public void mover(){
        boolean eleccionValida = false;
        Scanner scanner = new Scanner(System.in);
        while(!eleccionValida){
            System.out.println("Ingresa la posicion a la que quieres mover tu personaje 1 para arriba, 2 para abajo, 3 para izquierda, 4 para derecha");
            int eleccion = scanner.nextInt();
            int[] posicionPrincipal = principal.getPosicion();
            int xPrincipal = posicionPrincipal[0];
            int yPrincipal = posicionPrincipal[1];
            if(eleccion == 1){
                tablero.moverPersonaje(principal, xPrincipal-1, yPrincipal);
                turno++;
                eleccionValida = true;
            }else if(eleccion == 2){
                tablero.moverPersonaje(principal, xPrincipal+1, yPrincipal);
                turno++;
                eleccionValida = true;
            }else if(eleccion == 3){
                tablero.moverPersonaje(principal, xPrincipal, yPrincipal-1);
                turno++;
                eleccionValida = true;
            }else if(eleccion == 4){
                tablero.moverPersonaje(principal, xPrincipal, yPrincipal+1);
                turno++;
                eleccionValida = true;
            }else{
                System.out.println("Eleccion incorrecta");
            }
        }
    }

    public void mostrarInformacion(){
        System.out.println("Turno: "+turno+"\nOro: "+oro+"\n");
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }



}