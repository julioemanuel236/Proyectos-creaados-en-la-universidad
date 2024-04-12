package control;

import entidad.Puntaje;
import java.awt.Container;
import ventana.*;
import visual.*;

public class ControlVentana {
    
    //todas las ventanas/paneles que se usaran
    //para no tener que crear varias instancais separadas
    
    private final MenuPanel menu = new MenuPanel(this);
    private final PartidaPanel partida = new PartidaPanel(this);
    private final PausaPanel pausa = new PausaPanel(this);
    private final Tetris tetris = new Tetris();
    private final ControlPuntaje controlPuntaje = new ControlPuntaje();
    private final RegistroNombrePanel registro = new RegistroNombrePanel(this);
    
    private Container viendo ;
    
    public ControlVentana(){        
        iniComponents();    
        
    }
    
    private void iniComponents(){
        //agregar todos los componentes donde deben ir
        //y dar las dimensiones correspondientes
        tetris.add(menu);
        tetris.add(partida);
        
        partida.getTablero().add(pausa,0);
        pausa.setSize(partida.getTablero().getWidth(),partida.getTablero().getHeight()/2);
        menu.setVisible(false);
        partida.setVisible(false);
        pausa.setVisible(false);
                        
        registro.setLocation((menu.getWidth()/2)-(registro.getWidth()/2),(menu.getHeight()/2)-(registro.getHeight()/2));
        mostrarMenu();
        
        tetris.setVisible(true);
    }
    
    
    /*
    
        en todas las opcionesde mostrarAlgo
        lo que se hace es hacer invisible el Container viendo
        asignar a viendo el que vamos a mostrar y hacerlo visible
        en algunos se modifican variables de la clase VARIABLESGLOBALES
    */
    public void mostrarMenu(){
        VARIABLESGLOBALES.BACK_TO_MENU = true;
        menu.actualizarTablaPuntajes(controlPuntaje.getPuntajes());
        if(viendo!=null)
            viendo.setVisible(false);
        viendo = menu;        
        viendo.setVisible(true);
        viendo.repaint();
    }
    
    public void mostrarPartida(){
        VARIABLESGLOBALES.BACK_TO_MENU = false;
        if(viendo!=null)
            viendo.setVisible(false);
        viendo = partida;
        viendo.setVisible(true);
        viendo.repaint();
        while(!tetris.isFocused())tetris.transferFocus();
        tetris.requestFocus();
        partida.jugar();
    }
    
    public void mostrarPausa(){        
        pausa.setVisible(true);
        partida.getTablero().add(pausa,0);
        System.out.println(pausa.getSize());
        pausa.repaint();
        while(VARIABLESGLOBALES.PAUSA){
            try{
                Thread.sleep(1);
            }
            catch(Exception e){
                
            }
        }
    }
    
    public void quitarPausa(){
        pausa.setVisible(false);
        VARIABLESGLOBALES.PAUSA = false;
        
                
    }

    public void mostrarRegistro(){
        VARIABLESGLOBALES.PIDIENDO_REGISTRO = true;                
        tetris.add(registro,0);
        registro.setVisible(true);
        registro.repaint();        
        (new Thread(){
            public void run(){
            while(VARIABLESGLOBALES.PIDIENDO_REGISTRO){
            try{
                Thread.sleep(1);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        quitarRegistro();
            }
        }).start();
        
    }
    
    public void quitarRegistro(){
        registro.setVisible(false);
        registro.reset();
        VARIABLESGLOBALES.PIDIENDO_REGISTRO = false;
        mostrarMenu();
    }
    
    public void registrarPuntaje(String nombre){
        int puntaje = partida.getTablero().getPuntaje();
        controlPuntaje.agregar(new Puntaje(nombre,puntaje));
        quitarRegistro();
    }

    public MenuPanel getMenu() {
        return menu;
    }

    public PartidaPanel getPartida() {
        return partida;
    }

    public PausaPanel getPausa() {
        return pausa;
    }

    public Tetris getTetris() {
        return tetris;
    }

    public ControlPuntaje getControlPuntaje() {
        return controlPuntaje;
    }

    public RegistroNombrePanel getRegistro() {
        return registro;
    }

    public Container getViendo() {
        return viendo;
    }
    
    
}
