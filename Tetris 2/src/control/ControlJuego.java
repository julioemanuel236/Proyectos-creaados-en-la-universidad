package control;

import entidad.Puntaje;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JLabel;
import piezas.Pieza;
import visual.*;

public class ControlJuego {
    
    //en esta lista se guardan las teclas que presion el usuario para hacer las
    //acciones como mover una ficha o girarla en el orden de entrada
    LinkedList<KeyEvent> eventos = new LinkedList<>();
    
    KeyListener detector = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            //si al presionar una tecla no se esta en pausa
            //agregarla a la lista de acciones por procesar
            
            if (!VARIABLESGLOBALES.PAUSA) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE && !VARIABLESGLOBALES.GIRANDO)
                    eventos.add(e);
                else if(e.getKeyCode() != KeyEvent.VK_SPACE && !VARIABLESGLOBALES.MOVIENDO)
                        eventos.add(e);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    };

    //el hilo donde se ejecutara la partida
    Thread gameThread;

    //la fucion que controla el ciclo del juego
    //recibe como parametro el generador para la proxima pieza en salir
    //el tablero donde se ponen las piezas
    //la clase que controla las piezas
    //las etiquetas nivel, puntaje, lineas que pertenecen a la clase marcador
    //que sirven para brindar informacion del juego
    //ademas de otras etiquetas como el puntaje siguiente a superar
    //y la posicion que se ocupa en la tabla
    //ademas se recibe unn arreglo con los 10 mejores puntajes
    public void gameLoop(Generador generador, Tablero tablero, ControlPieza controlPieza,
            Marcador nivel, Marcador puntaje, Marcador lineas, ControlVentana controlVentana,
            Puntaje[] puntajes,JLabel posLabel,JLabel siguientePuntajeLabel) {
                        
        //al iniciar si habia un hilo de juego ejecutandoce lo interumpimos
        //para que termine
        if (gameThread != null) {
            gameThread.interrupt();
        }
        //en un primer momento damos los valores iniciales a las
        //etiquetas de informacion
        puntaje.setDato(tablero.getPuntaje());
        nivel.setDato(tablero.getNivel());
        lineas.setDato(tablero.getLineasCompletadas());
        //establecemos que la etiquta nivel sera la que nos detecte
        //las pulsaciones del teclado
        establecerDeteccionTeclado(nivel);
        //asignamos nuevamente el hilo de ejecucion
        gameThread = new Thread() {
            public void run() {
                //inicialmente mi posicion va a ser 11
                //seria el pero caso en que la tabla ya estuviera llena
                int miPosicion = 11;
                //luego recorro los puntajes de izquierda a derecha
                //y donde sea null me pongo yo                
                for(int i=0;i<puntajes.length;i++){
                    if(puntajes[i] == null){
                        //se le suma 1 pq los arreglos empiezan en 0
                        miPosicion = i+1;
                        break;
                    }
                }
                //actualizo la etiqueta de posicion
                posLabel.setText(""+miPosicion);
                //y si no estoy en primer lugar cogo el puntaje del lugar siguiente
                //seria miPosicion - 1, pero como mi posicion tiene un + 1 es -2
                
                if(miPosicion>1)            
                    siguientePuntajeLabel.setText(puntajes[miPosicion-2].getPuntaje()+"");

                //si estoy en primero es un nuevo RECORD
                else         
                    siguientePuntajeLabel.setText("RECORD");
                //genero la primera pieza
                generador.nextPieza();
                
                while (true) {
                    //de manera constante repetir                    
                    //tablero.printMatrix();
                    //si el juego ya termino 
                    if (VARIABLESGLOBALES.GAME_OVER) {
                        System.out.println("GAME OVER");
                        //se pido el nombre del jugador
                        controlVentana.mostrarRegistro();
                        //y se termina la funcion
                        return;
                    }
                    //se obtiene la pieza del generador
                    Pieza p = generador.getPiezaMostando();
                    //se establece esta pieza en el controlador de piezas
                    controlPieza.setPieza(p);
                    //se pone en el tablero la pieza
                    p.moverAlTablero(tablero);
                    //y se pone en el centro horizontalmente
                    p.setMatrixLocation(tablero.getColumnas() / 2 - 1, 0);

                    //si no se puede poner la pieza en el tablero
                    //pq no tiene espacio
                    //System.out.println("VOY A COMPROBAR QUE PUEDA PONER LA FICHA");
                    if (!p.updateState()) {
                        //System.out.println("NO ES POSIBLE COLOCAR LA FICHA");
                        //se mueve al tablero generador                        
                        p.moverAlTablero(generador.getTablero());                        
                        //se actualizan los 
                        generador.getTablero().repaint();
                        p.repaint();
                        //establecer que el juego termino
                        VARIABLESGLOBALES.GAME_OVER = true;
                        //continue para no procesar este ciclo
                        continue;
                    }
                    //System.out.println("LA PUSE");
                    //agregar al tablero la pieza generada
                    tablero.add(p);
                    p.repaint();
                    //generar la proxima pieza que toca
                    generador.nextPieza();
                    
                    //estas dos variables nos sirven para llevar el tiempo que se
                    //demora cada accion en hacerse, en este caso cuanto tiempo
                    //esta la pieza detenida
                    long now;
                    long finish;

                    do {
                        //obtenemos el tiempo actual del sistema
                        now = System.currentTimeMillis();
                        //calculamos el tiempo final sumando la espera del tablero
                        //esta espera varia segun el nivel
                        finish = System.currentTimeMillis() + tablero.getTiempoEspera();
                        
                        //mientras que aun no haya llegado al tiempo final
                        while (now < finish) {
                            //System.out.println(finish-now);
                            //si etoy volviendo al menu principal
                            //muestro para pedir nombre y termino la funcion
                            if (VARIABLESGLOBALES.BACK_TO_MENU) {                                
                                controlVentana.mostrarRegistro();                                
                                return;
                            } 
                            
                            else {
                                KeyEvent evento = null;
                                //si tengo algun evento en la lista cogerlo
                                
                                if (!eventos.isEmpty()) {
                                    evento = eventos.poll();
                                }
                                
                                //si se presiona escape pausar la partida
                                if (evento != null && evento.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                    System.out.println("PAUSA");
                                    VARIABLESGLOBALES.PAUSA = true;
                                    //mostrar un menu con las opciones continuar o salir al menu
                                    controlVentana.mostrarPausa();
                                } else if (evento != null) {
                                    //si el vento no es vacio mandar a la pieza
                                    //a agregarlo a las cosas por hacer
                                    controlPieza.addAction(evento);
                                }
                                //si no se puede realizar la accion
                                //que en este caso se refiere a poder bajar                                
                                if (!controlPieza.nextAction()) {
                                    //terminar con esa pieza y pasar a la siguiente
                                    break;
                                    
                                }
                                if(evento != null && evento.getKeyCode() == KeyEvent.VK_DOWN){
                                    now = System.currentTimeMillis();
                                    //calculamos el tiempo final sumando la espera del tablero
                                    //esta espera varia segun el nivel
                                    finish = System.currentTimeMillis() + tablero.getTiempoEspera();
                                }
                            }
                            try {

                                Thread.sleep(1);
                            } 
                            catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            //actualizar el tiempo
                            now = System.currentTimeMillis();
                        }
                      //mover la pieza abajo
                    } while (p.moveDown());

                    //revisar las lineas que se completaron
                    //esto tambien actualiza las piezas que deben bajar
                    //una vez las piezas bajan se vuelve a comprobar
                    //mientras haya lineas completadas
                    while (tablero.lineasCompletadas());
                    //luego actualizar los datos de los labels de informacion
                    puntaje.setDato(tablero.getPuntaje());
                    nivel.setDato(tablero.getNivel());
                    lineas.setDato(tablero.getLineasCompletadas());
                    //mientras que supere al siguiente puntaje disminuir mi lugar en la tabla
                    while(miPosicion>1 && puntajes[miPosicion-2].getPuntaje()<tablero.getPuntaje())miPosicion--;
                    posLabel.setText(""+miPosicion);
                    //en caso de no ser el primero actualizar el record siguiente
                    if(miPosicion>1)            
                        siguientePuntajeLabel.setText(puntajes[miPosicion-2].getPuntaje()+"");        
                    else         
                        siguientePuntajeLabel.setText("RECORD");
                }
            }
        };
        
        //iniciar el juego
        gameThread.start();
    }

    public void establecerDeteccionTeclado(Container c) {
        //cogemes el padre mayor
        //que en este caso siempre sera la ventana
        while (c.getParent() != null) {
            c = c.getParent();
        }
        
        boolean ok = true;
        //revisamos los listeners que tiene
        //y si no tiene el que vamos a poner se lo agregamos
        for (KeyListener k : c.getKeyListeners()) {
            if (k == detector) {
                ok = false;
            }
        }
        if (ok) {
            c.addKeyListener(detector);
        }

    }

    public Thread getGameThread() {
        return gameThread;
    }

}
