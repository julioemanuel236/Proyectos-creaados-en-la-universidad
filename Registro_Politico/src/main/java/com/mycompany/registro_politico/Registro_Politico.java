package com.mycompany.registro_politico;

import com.formdev.flatlaf.FlatDarkLaf;
import gui.VentanaPrincipal;
import javax.swing.UIManager;

public class Registro_Politico {
    /*
        Carlos Daniel Monge Centeno
        UNED
        118630442
        Primer cuatrimestre 
        Estructura de datos
        2024
    */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */        
        try {
            //ponerle que se vea bonito :D
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }        
    
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }    
}
