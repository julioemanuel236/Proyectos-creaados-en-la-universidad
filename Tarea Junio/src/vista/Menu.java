package vista;
import java.util.Scanner;

public class Menu {
    Scanner cin = new Scanner(System.in);
    controlador.Control control = new controlador.Control(this);
    public int seleccion(int n) {
        if(n==0)return 0;
        while(true) {
            try {
                int op=entero();
                if(op<0||op>n)throw new Exception();
                return op;
            }
            catch(Exception e) {
                print("Opcion no valida\n");
            }
        }
    }

    public  int entero() {
        while(true) {
            try {
                int n=Integer.parseInt(cin.nextLine());
                return n;
            }
            catch(Exception e) {
                print("Opcion no valida\n");
            }
        }
    }

    public static void print(String txt) {
        System.out.print(txt);
    }

    private void nuevoToreno(){
        print("Nombre del torneo: ");
        String nombre = cin.nextLine();
        if(nombre == null || nombre.isBlank()){
            print("Nombre no valido\n");
            return;
        }
        if(control.agregarTorneo(nombre))print("Torneo agregado con exito\n");
        else print("Nombre ya en uso\n");
    }

    private void listaTorenos(){
        print(control.listaTorneos());
    }

    private void nuevoJugador(){
        System.out.println("Datos del jugador: ");
        String nombre = cin.nextLine();
        if(nombre == null || nombre.isBlank()){
            print("Nombre no valido\n");
            return;
        }
        if(control.agregarJugador(nombre))print("Jugador agregado con exito\n");
        else print("A ocurrido un error al agregar el jugador\n");
    }

    private void comenzarTorneo(){
        if(control.comenzarTorneo())print("Torneo Iniciado\n");
        else print("No se puede iniciar el torneo\n");
    }

    private void jugarPartido(){
        if(control.getCantidadPartidos() == 0){
            print("No hay partidos aun\n");
            return;
        }
        print(control.listaPartidos());
        while(true){
            int id = seleccion(control.getCantidadPartidos());
            if(id>0){
                control.avanzarPartido(id);
                return;
            }
        }

    }

    public static void mostrarError(String txt){
        print("Error: "+txt+"\n");
    }

    private void verEstado(){
        String estado = control.generarEstado();
        print(estado);
    }
    private void torneoMenu(){
        while(true){
            print("1- Agregar Jugador\n");
            print("2- Comenzar Torneo\n");
            print("3- Jugar Partido\n");
            print("4- Ver Estado\n");
            print("0- Salir\n");
            int op = seleccion(4);
            switch(op){
                case 1: nuevoJugador();break;
                case 2: comenzarTorneo();break;
                case 3: jugarPartido();break;
                case 4: verEstado();break;
                case 0:return;
            }
        }
    }

    private void seleccionarTorneo(){
        if(control.getCantidadTorneos() == 0){
            print("No hay torneos aun\n");
            return;
        }
        while(true){
            print("Indice del torneo: ");
            int index = seleccion(control.getCantidadTorneos());
            if(index>0){
                control.seleccionarTorneo(index-1);
                torneoMenu();
                return;
            }
        }

    }
    public Menu(){
        while(true) {
            print("1-Nuevo Torneo\n");
            print("2-Lista Torneos\n");
            print("3-Seleccionar Torneo\n");
            print("0-Salir\n");
            int op = seleccion(3);
            switch (op) {
                case 1:
                    nuevoToreno();
                    break;
                case 2:
                    listaTorenos();
                    break;
                case 3:
                    seleccionarTorneo();
                    break;
                case 0:
                    return;
            }
        }
    }

    public int ganador(modelo.Partido p){
        int c=0;
        if(p.getJugador1() != null) {
            print("1- " + p.getJugador1().toString() + "\n");
            c++;
        }
        if(p.getJugador2() != null) {
            print("2- " + p.getJugador2().toString() + "\n");
            c++;
        }
        int op;
        while(true) {
            print("Quien gano: ");
            op = seleccion(c);
            if (op >= 1)break;
            else print("Valor no valido\n");
        }
        return op;
    }

    public void finTorneo(modelo.Torneo torneo){
        print("EL torneo "+torneo.getNombre()+ " ha finaliado\n");
        control.generarEstado();
    }

    public static void main(String[] args){
        new Menu();
    }

}
