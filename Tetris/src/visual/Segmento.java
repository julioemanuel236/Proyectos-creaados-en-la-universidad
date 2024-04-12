package visual;

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
        setLocation(x*getWidth(), y*getHeight());
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
}
