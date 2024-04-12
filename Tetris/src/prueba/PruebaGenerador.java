package prueba;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import visual.Generador;
import javax.swing.JPanel;

public class PruebaGenerador {
    
    public static void main(String[] args){
        JFrame jf = new JFrame();
        jf.setLayout(null);
        jf.setSize(1000,500);
        
        
        
        Generador g = new Generador();
        
        
        jf.setVisible(true);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.add(g);
        while(true){
            g.nextPieza(); 
            //System.out.println(g.getSize());
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                
            }
        }
        
        
        
    }
}
