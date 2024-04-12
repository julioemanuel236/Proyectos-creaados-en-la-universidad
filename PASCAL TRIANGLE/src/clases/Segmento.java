package clases;

import gui.SegmentoVisual;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class Segmento {
	
    private int index;
    private int fila;
    private int valor;

    private gui.SegmentoVisual visual;
    
    public Segmento(int fila,int index,int valor) {
            this.fila=fila;
            this.index=index;
            this.valor=valor;    
    }

    public void setVisual(gui.SegmentoVisual visual){
        this.visual=visual;
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValor() {
        return valor;
    }

    public int getFila(){
        return fila;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void pintar(Dimension size,Dimension panel,int xi,int yi){
        //System.out.println("Pintando: "+fila+" "+index+" = "+valor);
        visual.setText(""+valor);
        visual.setBackground(Color.white);
        visual.setForeground(Color.black);
        visual.setHorizontalAlignment(visual.CENTER);
        visual.setBorder(new EtchedBorder());
        visual.setSize(size);
        int x=((int)panel.getWidth()/2)-(((int)size.getWidth()/2))-(((int)size.getWidth()/2)*fila)+((int)size.getWidth()*index)-(index);
        int y=((((int)panel.getHeight())-((int)panel.getHeight()/(int)size.getHeight())*(int)size.getHeight())/2)+(this.fila*(int)size.getHeight())-fila;
       // System.out.println(x+","+y);        
        visual.setLocation(xi+x,yi+y);
       // g.drawRect(x, y,(int) size.getWidth(),(int) size.getHeight());
        //char data[] = String.valueOf(valor).toCharArray();
        //g.drawChars(data, 0, data.length ,(x+(x+(int)size.getWidth()))/2, (y+(y+(int)size.getHeight()))/2);
        visual.repaint();
    }
    
    public void pintar(Dimension size,int x,int y) {
    	visual.setText(""+valor);
        visual.setBackground(Color.white);
        visual.setForeground(Color.black);
        visual.setHorizontalAlignment(visual.CENTER);
        visual.setBorder(new EtchedBorder());
        visual.setSize(size);
        visual.setLocation(x,y);
        visual.repaint();
    }

    public void paridad(Color colores[]){
        if(visual==null)return;
        //Color color;
        //if(valor%2==1)color = Color.red;
        //else color=Color.yellow;
        int v = valor;
        if(v<0)v=-v;
        visual.setBackground(colores[v%2]);
        visual.setForeground(colores[(v+1)%2]);
    }
    
    public void simetria(Color color){
        if(visual==null)return;
        //Color color = new Color((valor*valor)%255,(200+valor)%255,(valor+valor)%255);                
        visual.setBackground(color);
        visual.setForeground(Color.blue);
    }
    
    public void color(Color color){
        visual.setBackground(color);        
    }
    
    public SegmentoVisual getVisual(){
        return visual;
    }
}
