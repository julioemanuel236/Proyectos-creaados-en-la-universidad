package prueba;

import control.ControlPieza;
import control.ControlJuego;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import visual.Generador;
import piezas.Pieza;
import visual.Segmento;
import visual.Tablero;

public class PruebaJuego {
    
    public static void main(String[] args){
        JFrame jf = new JFrame();
        jf.setLayout(null);
        jf.setSize(500,500);                                
        ControlPieza cp = new ControlPieza();
        Generador g = new Generador();
        Tablero t = new Tablero(20,5);
        t.setLocation(g.getWidth(),0);        
        jf.add(t);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.add(g);
        jf.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                cp.addAction(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        
        });

        ControlJuego cj = new ControlJuego();
      //  cj.gameLoop(g, t,cp, null, null, null,null);
        
        
    }
    
    public static void verMatrix(Segmento[][] matrix){
        for(int j=0;j<matrix.length;j++){
                for(int k=0;k<matrix[j].length;k++){
                    System.out.print(matrix[j][k]+" ");
                }
                    System.out.print("\n");
            }
        System.out.print("\n");
    }
}
