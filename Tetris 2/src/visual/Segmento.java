package visual;

import control.VARIABLESGLOBALES;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import piezas.Pieza;

public class Segmento extends JLabel{
   
    /*
        esta clase hereda del JLabel
        se usa para preresentar los segmentos de 
        las pieza del tetris
        presenta un color y una ubacion en el trablero
        y una pieza a la cual pertenece
    */
    public final static long TIEMPO_MOVIMIENTO = 100;
    private Color color;
    private Point matrixLocation = new Point(-1,-1);
    private Border border = new LineBorder(Color.black);
    private final Pieza pieza;
    
    public Segmento(Color color,Pieza pieza,int size){        
        this.pieza = pieza;
        this.color = color;        
        setSize(size,size);
        setOpaque(true);
        setBackground(color);
        setBorder(border);
    }    

    public Point getMatrixLocation() {
        return matrixLocation;
    }

    public void setMatrixLocation(Point MatrixLocation) {
        this.matrixLocation = MatrixLocation;
    }
    
    public void setMatrixLocation(int x,int y) {
        matrixLocation.x = x;
        matrixLocation.y = y;
        //aqui se multiplica por el ancho y el largo
        //debido a que todas las piezas son iguales
        //de esta manera se calcula donde esta en la pantalla
        //setLocation(x*getWidth(), y*getHeight());
        repaint();
    }
    

/*
    @Override
    public void paint(Graphics g){
        g.setColor(new Color(0,0,0,1));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(color);
        g.fillOval(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        g.drawOval(0, 0, getWidth(), getHeight());
    }
 
*/
    public Pieza getPieza() {
        return pieza;
    }
    
    public static void actualizarUI(Segmento segmentos[]){
        VARIABLESGLOBALES.MOVIENDO = true;
        int n = segmentos.length;
        int iniX[] = new int[n];
        int iniY[] = new int[n];
        int recorridoX[] = new int[n];
        int recorridoY[] = new int[n];
        int finX[] = new int[n];
        int finY[] = new int[n];
        int cont = 0;
        for(int i=0;i<n;i++){            
            Segmento segmento = segmentos[i];
            iniX[i] = segmento.getX();
            iniY[i] = segmento.getY();
            finX[i] = segmento.getMatrixLocation().x * segmento.getWidth();
            finY[i] = segmento.getMatrixLocation().y * segmento.getHeight();
            recorridoX[i] = finX[i] - iniX[i];
            recorridoY[i] = finY[i] - iniY[i];
            if(recorridoX[i] == 0 && recorridoY[i] == 0)cont++;
            //System.out.println(finX[i]+"/"+iniX[i]);
            //System.out.println(finY[i]+"/"+iniY[i]);
        }
        if(cont == n){
            for(Segmento s:segmentos){
                if(s!=null)
                    s.repaint();
            }
            VARIABLESGLOBALES.MOVIENDO = false;
            return;
        }
        long start = System.currentTimeMillis();
        long finish = start + Segmento.TIEMPO_MOVIMIENTO;
        long now = start;
        
        while(now < finish){            
            double porcentaje = ((double)(now-start)/(double)Segmento.TIEMPO_MOVIMIENTO);
            porcentaje = Math.min(1d, porcentaje);
            //System.out.println(porcentaje);
            
            for(int i=0;i<n;i++){
                Segmento segmento = segmentos[i];
                double dx = (porcentaje * (double)recorridoX[i]);
                double dy = (porcentaje * (double)recorridoY[i]);
                int tempX = iniX[i] + (int)dx;
                int tempY = iniY[i] + (int)dy;
                segmento.setLocation(tempX, tempY);                                
                segmento.repaint();
              //System.out.println(dx + " " + dy);
            
            }                        
            now = System.currentTimeMillis();
            try{
                Thread.sleep(1);
            }
            catch(Exception e){
                
            }
        }
        for(int i=0;i<n;i++){
            Segmento segmento = segmentos[i];
            segmento.setLocation(finX[i],finY[i]);            
        }
        for(Segmento s:segmentos){
            s.repaint();
        }
        VARIABLESGLOBALES.MOVIENDO = false;
    }

    public static void actualizarUI(Segmento segmentos[],int n){        
        VARIABLESGLOBALES.MOVIENDO = true;
        int iniX[] = new int[n];
        int iniY[] = new int[n];
        int recorridoX[] = new int[n];
        int recorridoY[] = new int[n];
        int finX[] = new int[n];
        int finY[] = new int[n];
        int cont = 0;
        for(int i=0;i<n;i++){            
            Segmento segmento = segmentos[i];
            iniX[i] = segmento.getX();
            iniY[i] = segmento.getY();
            finX[i] = segmento.getMatrixLocation().x * segmento.getWidth();
            finY[i] = segmento.getMatrixLocation().y * segmento.getHeight();
            recorridoX[i] = finX[i] - iniX[i];
            recorridoY[i] = finY[i] - iniY[i];
            if(recorridoX[i] == 0 && recorridoY[i] == 0)cont++;
            //System.out.println(finX[i]+"/"+iniX[i]);
            //System.out.println(finY[i]+"/"+iniY[i]);
        }
        if(cont == n){            
            for(int i=0;i<n;i++){
                if(segmentos[i]!=null)
                    segmentos[i].repaint();
            }
            VARIABLESGLOBALES.MOVIENDO = false;
            return;
        }
        long start = System.currentTimeMillis();
        long finish = start + Segmento.TIEMPO_MOVIMIENTO;
        long now = start;
        
        while(now < finish){            
            double porcentaje = ((double)(now-start)/(double)Segmento.TIEMPO_MOVIMIENTO);
            porcentaje = Math.min(1d, porcentaje);
            //System.out.println(porcentaje);
            
            for(int i=0;i<n;i++){
                Segmento segmento = segmentos[i];
                double dx = (porcentaje * (double)recorridoX[i]);
                double dy = (porcentaje * (double)recorridoY[i]);
                int tempX = iniX[i] + (int)dx;
                int tempY = iniY[i] + (int)dy;
                segmento.setLocation(tempX, tempY);                                
                segmento.repaint();
              //System.out.println(dx + " " + dy);
            
            }                        
            now = System.currentTimeMillis();
            try{
                Thread.sleep(1);
            }
            catch(Exception e){
                
            }
        }
        for(int i=0;i<n;i++){
            Segmento segmento = segmentos[i];
            segmento.setLocation(finX[i],finY[i]);            
        }
        for(Segmento s:segmentos){
            if(s!=null)
                s.repaint();
        }
        VARIABLESGLOBALES.MOVIENDO = false;
    }
    @Override
    public String toString(){
        return "*";
    }
}
