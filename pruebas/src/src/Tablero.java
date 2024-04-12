import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    char[][] tablero;

    public Tablero() {
        tablero = new char[8][8];
        generarTablero();
    }

    Jugable personaje = null;



    public void generarTablero(){
        int porcentajePlanicie =  60;//Tendra el color blanco
        int porcentajeArbol = 25;//Tendra el color cafe
        int porcentajeAgua = 10;//Tendra el color azul
        int porcentajeLava = 5;//Tendra el color naranja

        int contadorPlanicie = 0;
        int contadorArbol = 0;
        int contadorAgua = 0;
        int contadorLava = 0;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                int numeroAleatorio = (int) (Math.random() * 100);
                if (numeroAleatorio >= 0 && numeroAleatorio <= porcentajePlanicie && contadorPlanicie < 48) {
                    tablero[i][j] = 'a';//a significa planicie, al mostrarse sera remplazado por un vacio que ocupe el mismo espacio que a.
                    contadorPlanicie++;
                } else if (numeroAleatorio > porcentajePlanicie && numeroAleatorio <= (porcentajePlanicie + porcentajeArbol) && contadorArbol < 20) {
                    tablero[i][j] = 'A';//A significa arbol
                    contadorArbol++;
                } else if (numeroAleatorio > (porcentajePlanicie + porcentajeArbol) && numeroAleatorio <= (porcentajePlanicie + porcentajeArbol + porcentajeAgua) && contadorAgua < 8) {
                    tablero[i][j] = 'W';//C significa agua
                    contadorAgua++;
                } else if (numeroAleatorio > (porcentajePlanicie + porcentajeArbol + porcentajeAgua) && numeroAleatorio <= (porcentajePlanicie + porcentajeArbol + porcentajeAgua + porcentajeLava) && contadorLava < 4) {
                    tablero[i][j] = 'E';//E significa lava
                    contadorLava++;
                }
            }
        }
    }


    public void tableroPersonalizado(int porcentajePlanicie, int porcentajeArbol, int porcentajeAgua, int porcentajeLava){
        int contadorPlanicie = 0;
        int contadorArbol = 0;
        int contadorAgua = 0;
        int contadorLava = 0;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                int numeroAleatorio = (int) (Math.random() * 100);
                if (numeroAleatorio >= 0 && numeroAleatorio <= porcentajePlanicie && contadorPlanicie < 48) {
                    tablero[i][j] = 'a';
                    contadorPlanicie++;
                } else if (numeroAleatorio > porcentajePlanicie && numeroAleatorio <= (porcentajePlanicie + porcentajeArbol) && contadorArbol < 20) {
                    tablero[i][j] = 'A';
                    contadorArbol++;
                } else if (numeroAleatorio > (porcentajePlanicie + porcentajeArbol) && numeroAleatorio <= (porcentajePlanicie + porcentajeArbol + porcentajeAgua) && contadorAgua < 8) {
                    tablero[i][j] = 'W';
                    contadorAgua++;
                } else if (numeroAleatorio > (porcentajePlanicie + porcentajeArbol + porcentajeAgua) && numeroAleatorio <= (porcentajePlanicie + porcentajeArbol + porcentajeAgua + porcentajeLava) && contadorLava < 4) {
                    tablero[i][j] = 'E';
                    contadorLava++;
                }

            }
        }
    }
    //color de los caracteres
    public void mostrarTablero() {
        System.out.print("  ");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                if(personaje!=null){
                    if(i==personaje.getPosX() && j==personaje.getPosY()){
                        tablero[i][j] = personaje.getLetra();

                    }
                }

                switch (tablero[i][j]) {

                    case 'a':
                        System.out.print("\u001B[37m" +"g " + "\u001B[0m");//blanco
                        break;
                    case 'A':
                        System.out.print("\u001B[31m" + "t " + "\u001B[0m");//cafe
                        break;
                    case 'W':
                        System.out.print("\u001B[34m" + "a " + "\u001B[0m");//azul
                        break;
                    case 'E':
                        System.out.print("\u001B[33m" + "w " + "\u001B[0m");//naranja
                        break;
                    default:
                        System.out.print("\u001B[35m" + tablero[i][j] + " " + "\u001B[0m");//morado
                        break;
                }
            }
            System.out.println();
        }
    }


    //metodo ubicar personaje en lugares vacio
    public void ubicarPeronajesEnElMapa(Jugable personaje) {//se ubica al personaje en cualquier espacio de tipo 'a'
        int x = 0;
        int y = 0;
        boolean ubicacionValida = false;

        while (!ubicacionValida) {
            x = (int) (Math.random() * tablero.length);
            y = (int) (Math.random() * tablero.length);
            if (tablero[x][y] == 'a') {
                tablero[x][y] = personaje.getInicial();
                ubicacionValida = true;
            }

        }
        personaje.setPosX(x);
        personaje.setPosY(y);
        this.personaje=personaje;
    }





    //metodo ubicar enemigos
    public void ubicarEnemigo(Enemigo enemigo){
        boolean ubicado = false;
        while (!ubicado) {
            int[] posicion = enemigo.getPosicion();
            int x = posicion[0];
            int y = posicion[1];
            if (tablero[x][y] == 'a') {//a significa planicie
                tablero[x][y] = enemigo.getLetra();
                ubicado = true;
            } else {
                posicion[0] = (int) (Math.random() * 8);
                posicion[1] = (int) (Math.random() * 8);
            }
        }
    }

    //metodo para mover personaje
    public void moverPersonaje(Jugable personaje, int x, int y) {
        int[] posicion = personaje.getPosicion();
        int xActual = posicion[0];
        int yActual = posicion[1];
        if (x >= 0 && x < tablero.length && y >= 0 && y < tablero[x].length) {
            if (tablero[x][y] == 'a') {
                tablero[xActual][yActual] = 'a';
                tablero[x][y] = personaje.getLetra();
                personaje.setPosicion(x, y);
            }
            if (personaje.getVuela()) {//atraviesa el ostaculo a menos que sea una esquina, en el caso de que sea una esquina el personaje se quedara en el ultimo sitio valido
                if (x == 0 && y == 0) {
                    tablero[xActual][yActual] = personaje.getLetra();
                    tablero[x][y] = personaje.getLetra();
                    personaje.setPosicion(x, y);
                }
                if (x == 0 && y == 7) {
                    tablero[xActual][yActual] = personaje.getLetra();
                    tablero[x][y] = personaje.getLetra();
                    personaje.setPosicion(x, y);
                }
                if (x == 7 && y == 0) {
                    tablero[xActual][yActual] = personaje.getLetra();
                    tablero[x][y] = personaje.getLetra();
                    personaje.setPosicion(x, y);
                }
                if (x == 7 && y == 7) {
                    tablero[xActual][yActual] = personaje.getLetra();
                    tablero[x][y] = personaje.getLetra();
                    personaje.setPosicion(x, y);
                } else {
                    if (tablero[x][y] == 'A' || tablero[x][y] == 'W' || tablero[x][y] == 'E') {
                        tablero[xActual][yActual] = 'a';
                        tablero[x][y] = personaje.getLetra();
                        personaje.setPosicion(x, y);
                    }
                }
            } else {
                if (tablero[x][y] == 'A' || tablero[x][y] == 'W' || tablero[x][y] == 'E') {
                    System.out.println("No puedes pasar por ese sitio");
                } else {
                    tablero[xActual][yActual] = 'a';
                    tablero[x][y] = personaje.getLetra();
                    personaje.setPosicion(x, y);
                }
            }
        } else {
            System.out.println("Ubicacion invalida");
        }
        this.personaje=personaje;
    }

    //metodo para mover enemigo
    public void moverEnemigo(Enemigo enemigo, int x, int y){
        int[] posicion = enemigo.getPosicion();
        int xActual = posicion[0];
        int yActual = posicion[1];
        if (x >= 0 && x < tablero.length && y >= 0 && y < tablero[x].length) {
            if (tablero[x][y] == 'a') {
                tablero[xActual][yActual] = 'a';
                tablero[x][y] = enemigo.getLetra();
                enemigo.setPosicion(x, y);
            } else {
                System.out.println("No se puede mover a esa posicion");
            }
        } else {
            System.out.println("No se puede mover a esa posicion");
        }
    }

    //metodo para matar enemigo
    public void matarEnemigo(Enemigo enemigo){
        int[] posicion = enemigo.getPosicion();
        int x = posicion[0];
        int y = posicion[1];
        tablero[x][y] = 'a';
    }

    //metodo para que los jugadores ataquen
    public void atacar(Jugable personaje, Enemigo enemigo){
        int[] posicionPersonaje = personaje.getPosicion();
        int xPersonaje = posicionPersonaje[0];
        int yPersonaje = posicionPersonaje[1];
        int[] posicionEnemigo = enemigo.getPosicion();
        int xEnemigo = posicionEnemigo[0];
        int yEnemigo = posicionEnemigo[1];
        if(xPersonaje==xEnemigo || yPersonaje==yEnemigo){
            enemigo.setVida(enemigo.getVida()-personaje.getAtaque());
            if(enemigo.getVida()<=0){
                System.out.println("Enemigo muerto");
                matarEnemigo(enemigo);
            }
        }else{
            System.out.println("El enemigo esta fuera de alcance");
        }
    }

    //mostrar enemigos al alcance
    public void mostrarEnemigosAlAlcance(Jugable personaje, ArrayList<Enemigo> enemigos){
        int[] posicionPersonaje = personaje.getPosicion();
        int xPersonaje = posicionPersonaje[0];
        int yPersonaje = posicionPersonaje[1];
        for (int i = 0; i < enemigos.size(); i++) {
            int[] posicionEnemigo = enemigos.get(i).getPosicion();
            int xEnemigo = posicionEnemigo[0];
            int yEnemigo = posicionEnemigo[1];
            if(xPersonaje==xEnemigo || yPersonaje==yEnemigo){
                System.out.println(enemigos.get(i));
            }
        }
    }



    public char[][] getTablero() {
        return tablero;
    }






}