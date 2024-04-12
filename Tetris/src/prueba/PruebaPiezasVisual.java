package prueba;
import java.awt.Container;
import javax.swing.*;
import piezas.*;
import visual.Segmento;
import visual.Tablero;

public class PruebaPiezasVisual {
    static Segmento matrix[][] = new Segmento[29][29];
    
    public static void main(String[] args){
        JFrame jf = new JFrame();
        Container jp = jf.getContentPane();
        //jp.setLayout(null);
        jf.setSize(1000,500);
        
        Tablero t = new Tablero(20,20);
        
        Pieza[] piezas = new Pieza[7];
        
        piezas[0] = new PiezaI(matrix,20);                
        t.add(piezas[0]);        
        piezas[0].setMatrixLocation(0,0);
        
        piezas[1] = new PiezaL(matrix,20);
        t.add(piezas[1]);
        piezas[1].setMatrixLocation(4,0);
        
        piezas[2] = new PiezaRL(matrix,20);
        t.add(piezas[2]);
        piezas[2].setMatrixLocation(8,0);
        
        piezas[3] = new PiezaO(matrix,20);
        t.add(piezas[3]);
        piezas[3].setMatrixLocation(12,0);
        
        piezas[4] = new PiezaRZ(matrix,20);
        piezas[4].setMatrixLocation(16,0);
        t.add(piezas[4]);
        
        piezas[5] = new PiezaZ(matrix,20);
        piezas[5].setMatrixLocation(20,0);
        t.add(piezas[5]);
        
        piezas[6] = new PiezaT(matrix,20);
        piezas[6].setMatrixLocation(24,0);
        t.add(piezas[6]);
        
        jp.add(t);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        piezas[1].moveLeft();
        jf.repaint();
        int i = 0;
        //verMatrix();
        while(true){
            i++;
            
            //verSegmentos(p.getSegmentos());
            for(Pieza p : piezas){
                p.rotateLeft();
                p.moveLeft();
                //p.moveDown();
                //p.moveRight();
                
          
                    
            }
            jf.repaint();
            try {
                    Thread.sleep(500);
            } catch (InterruptedException ex) {                
            }     
            //verMatrix();  
            //p.rotateRight();
            //p.moveDown();
            //p.moveRight();
            //System.out.println(p.getMatrixLocation());
            
            
        }
    }
    
    public static void verMatrix(){
        for(int j=0;j<matrix.length;j++){
                for(int k=0;k<matrix[j].length;k++){
                    System.out.print(matrix[j][k]+" ");
                }
                    System.out.print("\n");
            }
        System.out.print("\n");
    }
    
    static void verSegmentos(Segmento[] segmentos){
        for(Segmento s:segmentos){
            System.out.println(s.getLocation());
            System.out.println(s.getSize());
        }
            
    }
}
