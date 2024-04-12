package control;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import piezas.*;

public class ControlPieza {
    //pieza que esto controlando    
    private Pieza pieza;
    //acciones por hacer de esa pieza
    private LinkedList<KeyEvent> acciones = new LinkedList<>();
        
    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    
    public boolean nextAction(){
        //esto procesa la siguiente accion
        //segun lo presionado se le dice
        //a la pieza que hacer
        //siempre se retorna verdadero
        //excepto en el caso de mover hacia abajo
        //en ese caso se retorna lo que retorne
        //el movimiento de la pieza hacia abajo
        if(acciones.isEmpty())return true;        
        KeyEvent ke = acciones.poll();
        if(pieza == null)return false;
        if(ke.getKeyCode() == KeyEvent.VK_LEFT)pieza.moveLeft();
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT)pieza.moveRight();
        if(ke.getKeyCode() == KeyEvent.VK_SPACE)pieza.rotateRight();
        if(ke.getKeyCode() == KeyEvent.VK_DOWN)return pieza.moveDown();
        pieza.repaint();
        return true;
    }
    
    public void addAction(KeyEvent e){
        acciones.add(e);
    }
}
