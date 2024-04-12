package prueba;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import visual.Generador;
import piezas.Pieza;
import visual.Segmento;
import visual.Tablero;

public class PruebaTraslado {
    
    public static void main(String[] args){
        JFrame jf = new JFrame();
        jf.setLayout(null);
        jf.setSize(1000,500);                        
        Generador g = new Generador();
        
        Tablero t = new Tablero(20,3);
        t.setLocation(g.getWidth(),0);
    
        jf.add(t);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.add(g);
        while(true){
            g.nextPieza();
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                
            }
            Pieza p = g.getPiezaMostando();
            
            t.add(p);
            p.moverAlTablero(t);
            p.setMatrixLocation(0, 0);
            if(!p.updateState())break;
            
            while(p.moveDown()){
                verMatrix(t.getMatrix());
                p.rotateLeft();
                try{
                    Thread.sleep(100);                                                           
                }
                catch(Exception e){
                
                }                
                jf.repaint();                    
            }
            t.lineasCompletadas();
            //System.out.println(g.getSize());
            
        }
        
        
        
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
