package gui;

import java.awt.Color;

import javax.swing.border.LineBorder;

public class SegmentoVisual extends javax.swing.JLabel{

    clases.Segmento segmento;
    
    public SegmentoVisual(clases.Segmento segmento){
        this.segmento=segmento;        
        super.setOpaque(true);
        int val = segmento.getValor();   
        setBackground(Color.red);
    }
    
    public void paridad(){
        java.awt.Color color;
        if(getValor()%2==0) color = java.awt.Color.yellow;
        else                color = java.awt.Color.black;
        super.setBackground(color);
    }
    
    
    public int getValor(){
        return segmento.getValor();
    }
    
}
