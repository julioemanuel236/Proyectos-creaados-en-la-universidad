package prueba;
import piezas.PiezaRL;
import piezas.PiezaO;
import piezas.PiezaT;
import piezas.PiezaL;
import piezas.Pieza;
import piezas.PiezaZ;
import piezas.PiezaRZ;
import piezas.PiezaI;
import java.util.logging.Level;
import java.util.logging.Logger;
import visual.Segmento;

public class PruebaPiezas {

    public static void main(String[] args){
        Segmento[][] matrix = new Segmento[10][10];
        Pieza f;        
        f = new PiezaI(matrix,20);        
        ver(f);
        f = new PiezaT(matrix,20);        
        ver(f);
        f = new PiezaO(matrix,20);        
        ver(f);
        f = new PiezaL(matrix,20);        
        ver(f);
        f = new PiezaRL(matrix,20);                        
        ver(f);
        f = new PiezaZ(matrix,20);                        
        ver(f);
        f = new PiezaRZ(matrix,20);                        
        ver(f);
        
        for(int i=0;i<4;i++){
            System.out.println(i);
            try {
                f.rotateRight();
                verActual(f);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PruebaPiezas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for(int i=0;i<4;i++){
            System.out.println(i);
            try {
                f.rotateLeft();
                verActual(f);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PruebaPiezas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    private static void verActual(Pieza f){
        boolean estados[][] = f.getEstado(f.getEstadoIndex());
        
        
            for(int i=0;i<estados.length;i++){
                for(int j=0;j<estados[i].length;j++){
                    if(estados[i][j])
                        System.out.print("1");
                    else System.out.print("0");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        
    }
    
    private static void ver(Pieza f){
        boolean estados[][][] = f.getEstados();
        
        for(int k=0;k<estados.length;k++){
            for(int i=0;i<estados[k].length;i++){
                for(int j=0;j<estados[k][i].length;j++){
                    if(estados[k][i][j])
                        System.out.print("1");
                    else System.out.print("0");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
        
    }
            
}
