package visual;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Marcador extends JLabel{
    
    /*
        esta clase es un label hecho
        para representar un valor numero
        se puede aumentar en una cantidad especifico
        o asignar un valor directamente
    */
    
    public int dato = 0;
    
    public Marcador(){
        setHorizontalAlignment(CENTER);
        setForeground(Color.white);
        setBackground(Color.darkGray);
        setOpaque(true);
        setFocusable(false);
        setFont(new Font("ARIAL",Font.BOLD,20));
        update();        
    }
    
    public void aumentarEn(int dato){
        this.dato+=dato;
        update();
    }
    
    public void update(){
        setText(String.valueOf(dato));
        repaint();
    }
    
    public void reset(){
        this.dato = 0;
    }
    
    public void setDato(int dato){
        this.dato = dato;
        update();
    }
    
}
